package jitd.spec;

case class Node(val name:String, val fields:Seq[Field])
{
  def renderName = name+"Node"
  def enumName = "JITD_NODE_"+name
  def scope = fields.map { f => f.name -> f.t }.toMap

  override def toString =
    name + "(" + fields.map { _.toString }.mkString(", ") + ")"

}