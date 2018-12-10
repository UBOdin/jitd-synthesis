package jitd.spec

import jitd.rewrite.Inline

case class Mutator(
  name: String,
  args: Seq[Field],
  rewrite: MatchPattern,
  initializers: Map[String, Expression] = Map(),
  body: Statement = Block(Seq())
)