package jitd.codegen.policy

import jitd.codegen.Render
import jitd.spec._
import jitd.codegen.policy.txt._

object NaivePolicyImplementation extends PolicyImplementation
{
  // Render field definitions for the JITD object
  def state(ctx:Render): String = ""

  // Render a block of code to be run when the JITD is initialized
  def init(ctx:Render, root:String): String = ""

  // Render two blocks of code to be run just before/after a JITD rewrite
  // happens.  [from] is replaced by [to].  
  def onRewrite(
    ctx:Render, 
    from:MatchPattern, 
    to:ConstructorPattern, 
    fromTarget:String, 
    toTarget:String
  ): (String, String) = ("", "")


  def utilityFunctions(ctx:Render, rule:PolicyRule): String = 
  {
    rule match {
      case TieredPolicy(policies) => policies.map { utilityFunctions(ctx, _) }.mkString
      case TransformPolicy(name, constraint, scoreFn) =>
        NaivePolicySearch(
          ctx, 
          ctx.definition.transform(name), 
          constraint, 
          scoreFn
        ).toString
    }
  }

  def utilityFunctions(ctx:Render): String =
    utilityFunctions(ctx, ctx.policy.rule)

  // Render a block of code to be run when an idle cycle is available.
  def doOrganize(ctx:Render, root:String): String = ""
}
