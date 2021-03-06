package jitd.codegen.policy

import jitd.codegen.Render
import jitd.spec._
import jitd.codegen.policy.txt._
import jitd.rewrite._
object SetPolicyImplementation extends PolicyImplementation
{
  // Render field definitions for the JITD object
  def state(ctx:Render): String = ""

  // Render a block of code to be run when the JITD is initialized
  def init(ctx:Render, root:String): String = ""

  // Render two blocks of code to be run just before/after a JITD rewrite
  // happens.  [from] is replaced by [to].  
  def onRewriteSet(ctx:Render, 
    definition:Definition,
    mutator: Boolean,
    handlerefbool:Boolean,
    from:MatchPattern, 
    to:ConstructorPattern, 
    fromTarget:String, 
    toTarget:String): (Statement, Statement) =(setRemove(definition,handlerefbool,from,fromTarget), setAdd(definition,handlerefbool,to,toTarget,mutator))
  def setRemove(definition:Definition,handlerefbool:Boolean,fromNode:MatchPattern,fromNodeVar:String):Statement = 
  {
    //val (constructor, accessor) = MatchToStatement.constructorWithoutVarMapping(definition,to,"to_ptr")
    //println("SRA"+constructor)
    //val fromMapping = MatchToStatement.varMappings(definition, fromNode, fromNodeVar+"_root") 
    val extract = 
      if(handlerefbool == true)
        {MatchToStatement.unroll(definition,fromNode,fromNodeVar+"_root",(Var("target")),false)}
      else
        {MatchToStatement.unroll(definition,fromNode,fromNodeVar+"_root",WrapNodeRef(Var("target")),false)}
    
    //println("IN UNROLL SET: "+extract.map(_._1))
    val eachVarName = extract.map(getVarNameandType => (getVarNameandType._1,getVarNameandType._2,getVarNameandType._3)) 
    //ExtractNodeNameForSet(s"setRemovalCode")
    val seqStmt = eachVarName.map(vnnt => SetRemoveFunction(vnnt._1.toString,vnnt._2.toString,vnnt._3))
    return Block(seqStmt)
    

  }
  def setAdd(definition:Definition,handlerefbool:Boolean,to:ConstructorPattern,toNodeVar:String,mutator:Boolean):Statement = 
  { 
    val target = if (mutator == true) "root" else "target"
    
    val extract = 
      if(handlerefbool == true)
        {MatchToStatement.unroll(definition,to.toMatchPattern,toNodeVar,(Var(target)),false)}
      else
        {MatchToStatement.unroll(definition,to.toMatchPattern,toNodeVar,WrapNodeRef(Var(target)),false)}

    val eachVarName = extract.map(getVarNameandType => (getVarNameandType._1,getVarNameandType._2,getVarNameandType._3)) 
   
    val seqStmt = eachVarName.map(vnnt => SetAddFunction(vnnt._1.toString,vnnt._2.toString,vnnt._3))

    
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
        SetPolicySearch(  // Generated via Twirl template
          ctx, 
          ctx.definition.transform(name), 
          constraint, 
          scoreFn
        ).toString
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
        SetPolicyTryTransform(ctx, root, name, onSuccess, onFail).toString
    }

  // Render a block of code to be run when an idle cycle is available.
  def doOrganize(ctx:Render, root:String): String = 
  {
    //println(ctx.definition.transforms.to)
    doOrganize(ctx, root, ctx.policy.rule, "return true;\n", "return false;\n")+"\n"
    
    
  }
    
}
