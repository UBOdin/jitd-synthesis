package jitd.spec


object CmpTypes extends Enumeration {
  type T = Value
  val Eq, Neq, Lt, Lte, Gt, Gte = Value
}

sealed abstract class Expression

sealed abstract class Constant extends Expression
case class IntConstant(i:Integer) extends Constant
case class FloatConstant(f:Double) extends Constant

case class Var(v:String) extends Expression
case class Cmp(t: CmpTypes.T, lhs:Expression, rhs:Expression) extends Expression
case class FunctionalIfThenElse(condition:Expression, ifTrue:Expression, ifFalse:Expression) extends Expression
case class ArraySubscript(target:Expression, index:Integer) extends Expression
case class RecordSubscript(target:Expression, field:String) extends Expression
case class FunctionCall(name:Expression, args:Seq[Expression]) extends Expression
case class Dereference(target:Expression) extends Expression