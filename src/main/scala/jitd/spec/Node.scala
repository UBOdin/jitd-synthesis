package jitd.spec;

case class Node(val name:String, val fields:Seq[Field])
{
  def renderName = name+"Node"
  def enumName = name+"NodeType"
  def scope = fields.map { f => f.name -> f.t }.toMap
}