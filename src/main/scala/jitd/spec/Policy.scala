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

  override def toString =
    s"policy $name(${parameters.zip(defaults).map { case (param, default) => s"$param = $default" }.mkString(", ")}) {\n$rule\n}"
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
{
  override def toString = tiers.mkString("\n  andThen\n")
}
case class TransformPolicy(
  transform:String, 
  constraint:Expression = BoolConstant(true),
  scoreFn:Expression = IntConstant(0)
) extends PolicyRule
{
  def onlyIf(newConstraint:Expression) = {
    println(s"$constraint && $newConstraint -> ${constraint and newConstraint}")
    TransformPolicy(transform, constraint and newConstraint, scoreFn)
  }
  def scoreBy(newScoreFn:Expression) = TransformPolicy(transform, constraint, newScoreFn)

  override def toString = 
    transform + (constraint match {
      case BoolConstant(true) => ""
      case _ => s" onlyIf { $constraint }"
    }) + s" scoreBy { $scoreFn }"

}
