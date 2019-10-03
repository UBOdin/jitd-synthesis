package jitd.codegen.policy

import jitd.codegen.Render
import jitd.spec._

abstract class PolicyImplementation
{
  // Render field definitions for the JITD object
  def state(ctx:Render): String
  // Render a block of code to be run when the JITD is initialized
  def init(ctx:Render,rule:PolicyRule,root:String): String
  
  // Render two blocks of code to be run just before/after a JITD rewrite
  // happens.  [from] is replaced by [to].  
  def onRewriteSet(ctx:Render, 
    definition:Definition,
    mutator: Boolean,
    handlerefbool:Boolean,
    from:MatchPattern, 
    to:ConstructorPattern, 
    fromTarget:String, 
    toTarget:String
    
  ): (Statement, Statement)
  def onRewrite(ctx:Render, 
    from:MatchPattern, 
    to:ConstructorPattern, 
    fromTarget:String, 
    toTarget:String
    
  ): (Statement, Statement)
  // Render a block of code to be run when an idle cycle is available.
  def utilityFunctions(ctx:Render): String

  // Render a block of code to be run when an idle cycle is available.
  def doOrganize(ctx:Render, root:String): String
}
