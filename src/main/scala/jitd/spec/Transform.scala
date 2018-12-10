package jitd.spec

import jitd.rewrite.Inline

case class Transform(
  name: String, 
  from: MatchPattern, 
  to: MatchPattern, 
  initializers: Map[String, Expression] = Map(),
  body: Statement = Block(Seq())
) {

  def unifiedInitializers(varMapping: Map[String, Var]): Map[String,Expression] =
  {
    initializers.map { case (v, r) => v -> Inline(r, varMapping) } ++ varMapping
  }

  def invertAs(newName: String): Transform =
    Transform(newName, to, from, initializers, body)
}