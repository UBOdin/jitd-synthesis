package jitd.spec

import jitd.typecheck.FunctionSignature

class Accessor(
  val name:String,
  val args:Seq[Field],
  val ret:Seq[Field],
  val lookups: Map[String, Statement],
  val returnType:Type = TBool()
) {

  def scope = (args ++ ret).map { f => f.name -> f.t }.toMap

  override def toString: String = 
    "accessor "+name+"("+args.map(_.toString).mkString(", ")+
      (if(ret.isEmpty) { "" } else { " -> "+ret.map(_.toString).mkString(", ")})+
  s") -> ${Type.toString(returnType)} {\n"+lookups.map { case (node, statement) => 
    s"  ON $node:\n"+statement.toString("    ")
  }.mkString("\n")+"\n}"

}

object Accessor
{
  def delegate = 
    "delegate" -> FunctionSignature("delegate", Seq(TNodeRef()), TBool())
}