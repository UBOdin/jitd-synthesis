package jitd.spec

import jitd.rewrite.Inline

case class Mutator(
  name: String,
  args: Seq[Field],
  rewrite: ConstructNode
)