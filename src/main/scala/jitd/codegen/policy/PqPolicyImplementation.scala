package jitd.codegen.policy

import jitd.codegen.Render
import jitd.spec._
import jitd.codegen.policy.txt._
import jitd.rewrite._
import jitd.codegen.RenderPattern
import util.control.Breaks._
object PqPolicyImplementation extends PolicyImplementation
{
  // Render field definitions for the JITD object
  def state(ctx:Render): String = "//std::cout<<\"STATE CALLED\"<<std::endl;"
  def init(ctx:Render,rule:PolicyRule,root:String):String = 
  {
    s"std::shared_ptr<JITDNode> *root_handle = &"++root++";setInit(root_handle);"+
    PQinit(ctx,rule,"emplace",Var("root_handle")).toString
  }

  def PQinit(ctx:Render,rule:PolicyRule,op:String,root:Expression): Statement = 
    {
      rule match {
      case TieredPolicy(Seq()) => Comment(s"")
      case TieredPolicy(policies) => Block(policies.map{PQinit(ctx,_,op,root)}) 
      case TransformPolicy(name, _, scoreFn) => 
        {
            val transform_name = name
            val pattern = ctx.definition.transform(name).from 
            
            pattern match{
              case MatchNode(nodeType, fields, _) =>
              {
                  if (fields.forall{_.isInstanceOf[MatchAny]}) 
                  {
                      PQStatement(transform_name,op,root)//The Statement that transalates to Eg:CrackArray_PQ.emplace(&target)
                  }
                  else
                  {
                    Block(Seq())
                  }
              }
            }  
            
        }
        
      }
    }
   
  def onRewriteSet(ctx:Render, 
    definition:Definition,
    mutator: Boolean,
    handlerefbool:Boolean,
    transform_name:String,
    from:MatchPattern, 
    to:ConstructorPattern, 
    fromTarget:String, 
    toTarget:String): (Statement, Statement) =(pqRemove(ctx,definition,handlerefbool,transform_name,from,fromTarget,mutator), pqAdd(ctx,definition,handlerefbool,transform_name,to,toTarget,mutator))
  //Eg: of what OnRewriteSet should return

  //array(data) -> Btree(Array1,sep,Array2) 
  //CrackArray_PQ.erase(array)
  //SortArray_PQ.erase(array)
  //CrackArray_PQ.emplace(Array1)
  //CrackArray_PQ.emplace(Array2)
  //SortArray_PQ.emplace(Array1)
  //SortArray_PQ.emplace(Array1)

  //array(data) ->SortedArray(data)
  //CrackArray_PQ.erase(array)
  //SortArray_PQ.erase(array)
  //No PQ.emplace should happen since there is no transform that works on a sorted array. 
  //PROBLEM: But with the current logic there is a CrackArray_PQ.emplace(SortedArray) and SortArray_PQ.emplace(SortArray)

  //This function takes in the MatchPattern and adds that node to all possible PQs.
  def pqAdd(ctx:Render,definition:Definition,handlerefbool:Boolean,transform_name:String,to:ConstructorPattern,toNodeVar:String,mutator:Boolean):Statement = 
  { 
    val target = if (mutator == true) "root" else "target"
    val rule = ctx.policy.rule

    val extract = 
      if(handlerefbool == true)//UnrollSet has been modified to return (varName,NodeType,Expression,MatchPattern)
        {MatchToStatement.unrollSet(definition,to.toMatchPattern,toNodeVar,(Var(target)))}
      else
        {MatchToStatement.unrollSet(definition,to.toMatchPattern,toNodeVar,WrapNodeRef(Var(target)))}

    val eachVarName = extract.map(getVarNameandType => (getVarNameandType._1,getVarNameandType._2,getVarNameandType._3,getVarNameandType._4)) 
    val setseqStmt = eachVarName.map(vnnt => SetAddFunction(vnnt._1.toString,vnnt._3)) 
    val pqseqStmt = eachVarName.map(vnnt =>
          {
            vnnt._4 match
            {
              case MatchNode(nodeType, fields, _) =>
              {
                  if (fields.forall{_.isInstanceOf[MatchAny]})//lets call nodes without decendents as standalone.This condition is to make sure only standalone
                  {                                           //nodes get put into a PQ.
                    PQinit(ctx,rule,"emplace",vnnt._3)//Function to populate what all PQs are there in the JITD structure based on the ctx.policy.rule 
                  }                                   //and what operation is invoked on the PQ on what expression(expression for the node).
                  else
                  {
                    Block(Seq())
                  }
              }
            case MatchAny(_) => Block(Seq())
            }
            
          })
          return {Block(pqseqStmt) ++ Block(setseqStmt)}
    

  }
  
  def pqRemove(ctx:Render,definition:Definition,handlerefbool:Boolean,transform_name:String,fromNode:MatchPattern,fromNodeVar:String,mutator:Boolean):Statement = 
  {
    val rule = ctx.policy.rule
    val extract = 
      if(handlerefbool == true)
        {MatchToStatement.unrollSet(definition,fromNode,fromNodeVar+"_root",Var("target"))}
      else
        {MatchToStatement.unrollSet(definition,fromNode,fromNodeVar+"_root",WrapNodeRef(Var("target")))}
    
    
    //println(extract(0)._4)  
    val eachVarName = extract.map(getVarNameandType => (getVarNameandType._1,getVarNameandType._2,getVarNameandType._3,getVarNameandType._4))
    val setseqStmt = eachVarName.map(vnnt => SetRemoveFunction(vnnt._1,vnnt._3))
    
          val pqseqStmt = eachVarName.map(vnnt =>
          {
            vnnt._4 match
            {
              case MatchNode(nodeType, fields, _) =>
              {
                  if (fields.forall{_.isInstanceOf[MatchAny]}) 
                  {
                    PQinit(ctx,rule,"erase",vnnt._3) 
                  }
                  else
                  {
                    Comment(s"")
                  }
              }
            case MatchAny(_) => Comment(s"")
            }
          })
          return {Block(pqseqStmt) ++ Block(setseqStmt)}
       
  }

  def onRewrite(ctx:Render,
    from:MatchPattern, 
    to:ConstructorPattern, 
    fromTarget:String, 
    toTarget:String
    
  ): (Statement, Statement) = (Comment(s"onRewrite1"), Comment(s"onRewrite2"))


  def utilityFunctions(ctx:Render, rule:PolicyRule): String = 
  {
    
      rule match {
      case TieredPolicy(policies) => policies.map { utilityFunctions(ctx, _) }.mkString
      case TransformPolicy(name, constraint, scoreFn) =>
        
        val pattern_from = ctx.definition.transform(name).from
        //println(pattern_from)
        pattern_from match{
          case MatchNode(nodeType, fields, _) =>
          {
            if (fields.forall{_.isInstanceOf[MatchAny]})
            {
              UsePqPolicySearch(  // Generated via Twirl template
                    ctx, 
                    ctx.definition.transform(name), 
                    constraint, 
                    scoreFn
                    ).toString
            }
            else
            {
              UseSetPolicySearch(  // Generated via Twirl template
                    ctx, 
                    ctx.definition.transform(name), 
                    constraint, 
                    scoreFn
                    ).toString
            }

          } 
        }
        
    }

  
    
  }

  def utilityFunctions(ctx:Render): String =
    utilityFunctions(ctx, ctx.policy.rule)


  def doOrganize(ctx:Render, root:String, rule:PolicyRule, onSuccess:String, onFail:String): String =
    rule match {
      case TieredPolicy(Seq()) => onFail
      case TieredPolicy(policies) => 
        doOrganize(ctx, root, policies.head, onSuccess, "")+"  "+
          doOrganize(ctx, root, TieredPolicy(policies.tail), onSuccess, onFail)
      case TransformPolicy(name, _, _) => 
        UsePqPolicyTryTransform(ctx, root, name, onSuccess, onFail).toString
    }

  // Render a block of code to be run when an idle cycle is available.
  def doOrganize(ctx:Render, root:String): String = 
  {
    //println(ctx.definition.transforms.to)
    doOrganize(ctx, root, ctx.policy.rule, "return true;\n", "return false;\n")+"\n"
    
    
  }
    
}
