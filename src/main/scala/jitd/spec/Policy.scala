package jitd.spec

case class Policy(
  name:String,
  parameters:Seq[Field],
  defaults:Seq[Expression],
  rule:PolicyRule
)
{
  def varMapping:Map[String,Expression] = 
    parameters.zip(defaults).map {
      case (p, d) => p.name -> d
    }.toMap
}

sealed abstract class PolicyRule
{
  def andThen(next:PolicyRule): TieredPolicy =
  {
    next match {
      case TieredPolicy(steps) => TieredPolicy(Seq(this) ++ steps)
      case _ => TieredPolicy(Seq(this, next))
    }
  }
}

case class TieredPolicy(tiers:Seq[PolicyRule]) extends PolicyRule
case class TransformPolicy(
  transform:String, 
  constraint:Expression = BoolConstant(true),
  scoreFn:Expression = IntConstant(0)
) extends PolicyRule
{
  def onlyIf(newConstraint:Expression) = TransformPolicy(transform, constraint and newConstraint, scoreFn)
  def scoreBy(newScoreFn:Expression) = TransformPolicy(transform, constraint, newScoreFn)
}
