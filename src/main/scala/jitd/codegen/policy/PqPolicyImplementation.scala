package jitd.codegen.policy

import jitd.codegen.Render
import jitd.spec._
import jitd.codegen.policy.txt._
import jitd.rewrite._
import jitd.codegen.RenderPattern
import util.control.Breaks._

object PqPolicyImplementation extends PolicyImplementation
{
  var trackable = RenderPattern.trackablesets//try making this immuatble
  //var trackable = Set("Array","SortedArray","Concat","Delete","BTree","DeleteElements")
  // Render field definitions for the JITD object
  def state(ctx:Render): String = "//std::cout<<\"STATE CALLED\"<<std::endl;"
  //Pre-conditoin: All support structures are empty
  def init(ctx:Render,rule:PolicyRule,root:String):String = 
  {
    s"std::shared_ptr<JITDNode> *root_handle = &"++root++";"+
    s"initialize_struts(root_handle);"
    //PQ_init(ctx,rule,"emplace(",Var("root_handle"),Var("root_handle")).toString
    //setpqAdd(ctx,definition,handlerefbool,to,toTarget,mutator)

  }
  //Post-condition: support structures correctly ref root and all its decendents appear in the sets corresponding to theeir type.
  //every node reachable from root and its desendants is a part of all PQs that it is eligible for.
  //LIMITATION:THE PQ INIT CODE ONLY LOOKS AT ROOTS OF TYPE ARRAY.
  def eligible(pattern:MatchPattern):Boolean = 
  {
     pattern match{
              case MatchNode(nodeType, fields, _) =>
              {
                  //println(nodeType)
                  if (fields.forall{_.isInstanceOf[MatchAny]}) 
                  {
                      true
                  }
                  else
                  {
                    false
                  }
              }
              case MatchAny(_) => false

            }
  }
 
  


//Only supports an initial Array/SortedArray Node
  def PQ_init(ctx:Render,rule:PolicyRule,op:String,root:Expression,unwraproot:Expression,rootpattern:Option[MatchPattern]=None): Statement = 
    {
      rule match {
      case TieredPolicy(Seq()) => Comment(s"")
      case TieredPolicy(policies) => Block(policies.map{PQ_init(ctx,_,op,root,unwraproot,rootpattern)}) 
      case TransformPolicy(unique_name,name, _, scoreFn) => 
        {
            val transform_name = unique_name
            val pattern = ctx.definition.transform(name).from 
            val compatible = Pattern.compatible(pattern,rootpattern.getOrElse{MatchAny()})
            
            val eligibility = eligible(pattern)
            if(compatible ==true)
            {   

                  if (eligibility == true) 
                  {
                      //Macro("#ifdef DEBUG")++commonFunction("assert(",unwraproot,Var("!=NULL"))++Macro("#endif")++
                      commonFunction("this->"+transform_name+"_PQ.",Var(op),root)//The Statement that transalates to Eg:CrackArray_PQ.emplace(&target)
                      //Void(FunctionCall("this->"+transform_name+"_PQ."+op,Seq(root)))
                  }
                  else
                  {
                    Block(Seq())
                  }
            }
            else
            {
              Block(Seq())
            }        
        }
        
      }
    }
    
   
  def onRewriteSet(ctx:Render, 
    definition:Definition,
    mutator: Boolean,
    handlerefbool:Boolean,
    from:MatchPattern, 
    to:ConstructorPattern, 
    fromTarget:String, 
    toTarget:String): (Statement, Statement) =(setpqRemove(ctx,definition,handlerefbool,from,fromTarget,mutator), setpqAdd(ctx,definition,handlerefbool,to,toTarget,mutator))
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
  //Post-condition:Every matched Node apprears in every PQ thats its eligible for and in appropriate sets.
  def setpqAdd(ctx:Render,definition:Definition,handlerefbool:Boolean,to:ConstructorPattern,toNodeVar:String,mutator:Boolean):Statement = 
  { 
    val target = if (mutator == true) "*(cq_elem.second)" else "target"
    val rule = ctx.policy.rule

    val extract = 
      if(handlerefbool == true)//UnrollSet has been modified to return (varName,NodeType,Expression,MatchPattern)
        {MatchToStatement.unrollSet(definition,to.toMatchPattern,toNodeVar,(Var(target)),(Var(target)))}
      else
        {MatchToStatement.unrollSet(definition,to.toMatchPattern,toNodeVar,WrapNodeRef(Var(target)),(Var(target)))}

    val eachVarName = extract.map(getVarNameandType => (getVarNameandType._1,getVarNameandType._2,getVarNameandType._3,getVarNameandType._4,getVarNameandType._5)) 
    val setseqStmt = eachVarName.map(vnnt => 
                                      vnnt._4 match{
                                              case MatchNode(nodeType, fields, _) =>
                                              {
                                                val hasSet = trackable(vnnt._2.toString)
                                                if(hasSet == true)
                                                {
                                                  //Macro("#ifdef DEBUG")++commonFunction("assert(",vnnt._5,Var("!=NULL"))++Macro("#endif")++
                                                  commonFunction("this->JITD_NODE_"+vnnt._2+"_set.",Var("emplace("),vnnt._3)
                                                  //Void(FunctionCall("this->JITD_NODE_"+vnnt._2+"_set.emplace",Seq(vnnt._3)))
                                                }
                                                else
                                                {
                                                  Block(Seq())
                                                }
                                                  
                                              }
                                              case MatchAny(_) => 
                                                {
                                                  if(mutator == true)
                                                  {

                                                    //Macro("#ifdef DEBUG")++commonFunction("assert(",vnnt._5,Var("!=NULL"))++Macro("#endif")++
                                                    commonFunction("std::atomic_store(",vnnt._3,Var(", *(cq_elem.first)"))++commonFunction("SetPqAdd(",Var(""),vnnt._3)
                                                
                                                  }
                                                  else
                                                  {
                                                    //Macro("#ifdef DEBUG")++commonFunction("assert(",vnnt._5,Var("!=NULL"))++Macro("#endif")++
                                                    commonFunction("SetPqAdd(",Var(""),vnnt._3)
                                                //Void(FunctionCall("SetPqAdd",Seq(vnnt._3)))

                                                  }
                                                }
                                              })
    val pqseqStmt = eachVarName.map(vnnt => 
                                      vnnt._4 match{
                                              case MatchNode(nodeType, fields, _) =>
                                              {
                                                if (fields.forall{_.isInstanceOf[MatchAny]}) //lets call nodes without decendents as standalone.This condition is to make sure only standalone
                                                {
                                                    PQ_init(ctx,rule,"emplace(",vnnt._3,vnnt._5,Some(vnnt._4))//Function to populate what all PQs are there in the JITD structure based on the ctx.policy.rule 
                                                                                                      //and what operation is invoked on the PQ on what expression(expression for the node).
                                                }
                                                else
                                                {
                                                  Block(Seq())
                                                }
                                                  
                                              }
                                              case MatchAny(_) => Block(Seq()) //commonFunction("","SetPqAdd(",vnnt._3)
                                              })

      






   
          return {Block(pqseqStmt) ++ Block(setseqStmt)}
         
  }
  //Pre-condition: The existing support structures are correct.
  //Post-condition: Every matched Node apprearing in a Match Pattern doesnot appear in any sets and PQs.
  def setpqRemove(ctx:Render,definition:Definition,handlerefbool:Boolean,fromNode:MatchPattern,fromNodeVar:String,mutator:Boolean):Statement = 
  {
    //println(trackable)
    val rule = ctx.policy.rule
    val extract = 
      if(handlerefbool == true)
        {MatchToStatement.unrollSet(definition,fromNode,fromNodeVar+"_root",Var("target"),Var("target"))}
      else
        {MatchToStatement.unrollSet(definition,fromNode,fromNodeVar+"_root",WrapNodeRef(Var("target")),Var("target"))}
    
    val eachVarName = extract.map(getVarNameandType => (getVarNameandType._1,getVarNameandType._2,getVarNameandType._3,getVarNameandType._4,getVarNameandType._5))
    //val setseqStmt = eachVarName.map(vnnt => commonFunction("//SetPqErase( "+vnnt._2,"->",vnnt._3))
    //val setseqStmt = eachVarName.map(vnnt => commonFunction("","SetPqErase(",vnnt._3)
    val setseqStmt = eachVarName.map(vnnt => 
                                      vnnt._4 match{
                                              case MatchNode(nodeType, fields, _) =>
                                              {
                                                val hasSet = trackable(vnnt._2.toString)
                                                if(hasSet == true)
                                                {
                                                  //Comment(s"SET Remove")
                                                  //Macro("#ifdef DEBUG")++commonFunction("assert(",vnnt._5,Var("!=NULL"))++Macro("#endif")++
                                                  commonFunction("this->JITD_NODE_"+vnnt._2+"_set.",Var("erase("),vnnt._3)
                                                  //Void(FunctionCall("this->JITD_NODE_"+vnnt._2+"_set.erase",Seq(vnnt._3)))
                                                }
                                                else
                                                {
                                                  Block(Seq())
                                                }
                                                  
                                              }
                                              case MatchAny(_) => 
                                                {
                                                    //Macro("#ifdef DEBUG")++commonFunction("assert(",vnnt._5,Var("!=NULL"))++Macro("#endif")++
                                                    commonFunction("SetPqErase(",Var(""),vnnt._3)
                                                  
                                                }
                                               
                                              })
    val pqseqStmt = eachVarName.map(vnnt => 
                                      vnnt._4 match{
                                              case MatchNode(nodeType, fields, _) =>
                                              {
                                                if (fields.forall{_.isInstanceOf[MatchAny]}) //lets call nodes without decendents as standalone.This condition is to make sure only standalone
                                                {
                                                    PQ_init(ctx,rule,"erase(",vnnt._3,vnnt._5,Some(vnnt._4))//Function to populate what all PQs are there in the JITD structure based on the ctx.policy.rule 
                                                                                                      //and what operation is invoked on the PQ on what expression(expression for the node).
                                                }
                                                else
                                                {
                                                  Block(Seq())
                                                }
                                                  
                                              }
                                              case MatchAny(_) => Block(Seq()) //commonFunction("","SetPqAdd(",vnnt._3)
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
      case TransformPolicy(unique_name,name, constraint, scoreFn) =>
        
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
      case TransformPolicy(unique_name,name, _, _) => 
        UsePqPolicyTryTransform(ctx, root, name, onSuccess, onFail).toString
    }

  // Render a block of code to be run when an idle cycle is available.
  def doOrganize(ctx:Render, root:String): String = 
  {
    //println(ctx.definition.transforms.to)
    doOrganize(ctx, root, ctx.policy.rule, "return true;\n", "return false;\n")+"\n"
    
    
  }
    
}
