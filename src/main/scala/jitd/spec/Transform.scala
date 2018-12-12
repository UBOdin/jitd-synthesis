package jitd.spec

import jitd.rewrite.Inline

case class Transform(
  name: String, 
  from: MatchNode, 
  to: ConstructNode
) {

  def invertAs(newName: String): Transform = 
    Transform(newName, to.toMatchPattern, from.toConstructorPattern)
}