package jitd.spec

class Accessor(
  val args:Seq[Field],
  val ret:Seq[Field],
  val lookups: Map[String, Statement]
) {

  def scope = (args ++ ret).map { f => f.name -> f.t }.toMap
}