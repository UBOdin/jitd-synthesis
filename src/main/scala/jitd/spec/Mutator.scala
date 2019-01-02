package jitd.spec

import jitd.rewrite.Inline

case class Mutator(
  name: String,
  args: Seq[Field],
  rewrite: ConstructNode
) {
  override def toString =
    s"mutator $name(${args.map { _.toString }.mkString(", ")}) {\n${rewrite.toString("  ")}\n}"
}