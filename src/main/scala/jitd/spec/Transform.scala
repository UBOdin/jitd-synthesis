package jitd.spec

import jitd.rewrite.Inline

case class Transform(
  name: String, 
  from: MatchNode, 
  to: ConstructorPattern
) {

  def invertAs(newName: String): Transform = 
    Transform(newName, to.asInstanceOf[ConstructNode].toMatchPattern, from.toConstructorPattern)

  def enumName = "JITD_TRANSFORM_"+name

  override def toString =
    s"transform $name matches $from\n{\n${to.toString("  ")}\n}"
}