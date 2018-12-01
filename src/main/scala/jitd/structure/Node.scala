package jitd.structure;

case class Node(val name:String, val fields:Seq[Field])
{
  def renderName = name+"Node"
  def enumName = name+"NodeType"
}