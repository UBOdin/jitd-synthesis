package jitd.spec

import jitd.typecheck.FunctionDefinition

class Accessor(
  val name:String,
  val args:Seq[Field],
  val ret:Seq[Field],
  val lookups: Map[String, Statement]
) {

  def scope = (args ++ ret).map { f => f.name -> f.t }.toMap

}

object Accessor
{
  def delegate = 
    "delegate" -> FunctionDefinition("delegate", Seq(TNode()), TBool())
}