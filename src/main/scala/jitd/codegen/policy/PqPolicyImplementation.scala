package jitd.codegen.policy

import jitd.codegen.Render
import jitd.spec._
import jitd.codegen.policy.txt._
import jitd.rewrite._
import util.control.Breaks._
object PqPolicyImplementation extends PolicyImplementation
{
  // Render field definitions for the JITD object
  def state(ctx:Render): String = "//std::cout<<\"STATE CALLED\"<<std::endl;"
  def init(ctx:Render,rule:PolicyRule,root:String): String = 
    {
      
      rule match {
      case TieredPolicy(Seq()) => ""
      case TieredPolicy(policies) => 
        {
          init(ctx, policies.head,root)
        }
      case TransformPolicy(name, _, scoreFn) => 
        {
            //println(scoreFn)
            //println("T: "+ ctx.definition.transform(name).from)
            val pattern = ctx.definition.transform(name).from 
            //val pattern_to = ctx.definition.transform(name).from
            pattern match{
              case MatchNode(nodeType, fields, _) =>
              {
                fields.zip(ctx.definition.node(nodeType).fields).flatMap{
                  case(fieldPattern:MatchNode,fieldDefinition) => {"std::shared_ptr<JITDNode> *root_handle = &"++root++";setInit(root_handle,true);"}
                  case(fieldPattern:MatchAny,fieldDefinition) =>  {"std::shared_ptr<JITDNode> *root_handle = &"++root++";pqInit(root_handle,true);"}
                    }.mkString

                }
              }  
            }
            
        }
        
      }
    

  // Render two blocks of code to be run just before/after a JITD rewrite
  // happens.  [from] is replaced by [to].
  // setRemove(definition,handlerefbool,from,fromTarget) 
  def onRewriteSet(ctx:Render, 
    definition:Definition,
    mutator: Boolean,
    handlerefbool:Boolean,
    from:MatchPattern, 
    to:ConstructorPattern, 
    fromTarget:String, 
    toTarget:String): (Statement, Statement) =(pqRemove(definition,handlerefbool,from,fromTarget,mutator), pqAdd(definition,handlerefbool,to,toTarget,mutator))
  
  def pqAdd(definition:Definition,handlerefbool:Boolean,to:ConstructorPattern,toNodeVar:String,mutator:Boolean):Statement = 
  { 
    val target = if (mutator == true) "root" else "target"
    
    val extract = 
      if(handlerefbool == true)
        {MatchToStatement.unrollSet(definition,to.toMatchPattern,toNodeVar,(Var(target)))}
      else
        {MatchToStatement.unrollSet(definition,to.toMatchPattern,toNodeVar,WrapNodeRef(Var(target)))}

    val eachVarName = extract.map(getVarNameandType => (getVarNameandType._1,getVarNameandType._2,getVarNameandType._3)) 
   
    val seqStmt = eachVarName.map(vnnt => PqAddFunction(vnnt._1.toString,vnnt._2.toString,vnnt._3))

    
    return Block(seqStmt)

  }
  def pqRemove(definition:Definition,handlerefbool:Boolean,fromNode:MatchPattern,fromNodeVar:String,mutator:Boolean):Statement = 
  {
    //val (constructor, accessor) = MatchToStatement.constructorWithoutVarMapping(definition,to,"to_ptr")
    //println("SRA"+constructor)
    //val fromMapping = MatchToStatement.varMappings(definition, fromNode, fromNodeVar+"_root") 
    val extract = 
      if(handlerefbool == true)
        {MatchToStatement.unrollSet(definition,fromNode,fromNodeVar+"_root",Var("target"))}
      else
        {MatchToStatement.unrollSet(definition,fromNode,fromNodeVar+"_root",WrapNodeRef(Var("target")))}
    
    //println("IN UNROLL SET: "+extract.map(_._3))
    val eachVarName = extract.map(getVarNameandType => (getVarNameandType._1,getVarNameandType._2,getVarNameandType._3))
    //println(eachVarName.lift(2)) 
    //ExtractNodeNameForSet(s"setRemovalCode")
    val seqStmt = eachVarName.map(vnnt => PqRemoveFunction(vnnt._1.toString,vnnt._3))
    return Block(seqStmt)
    

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
        // println(name)
        // UsePqPolicySearch(  // Generated via Twirl template
        //   ctx, 
        //   ctx.definition.transform(name), 
        //   constraint, 
        //   scoreFn
        // ).toString
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
