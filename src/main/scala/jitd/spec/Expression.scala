package jitd.spec


object CmpTypes extends Enumeration {
  type T = Value
  val Eq, Neq, Lt, Lte, Gt, Gte = Value

  def opString(op:T):String = 
  {
    op match {
      case Eq  => "=="
      case Neq => "!="
      case Lt  => "<"
      case Lte => "<="
      case Gt  => ">"
      case Gte => ">="
    }
  }
}

object ArithTypes extends Enumeration {
  type T = Value
  val Add, Sub, Mul, Div = Value

  def opString(op:T):String = 
  {
    op match {
      case Add => "+"
      case Sub => "-"
      case Mul => "*"
      case Div => "/"
    }
  }
}

sealed abstract class Expression
{
  def eq(other:Expression)  = Cmp(CmpTypes.Eq,  this, other)
  def neq(other:Expression) = Cmp(CmpTypes.Neq, this, other)
  def lt(other:Expression)  = Cmp(CmpTypes.Lt,  this, other)
  def lte(other:Expression) = Cmp(CmpTypes.Lte, this, other)
  def gt(other:Expression)  = Cmp(CmpTypes.Gt,  this, other)
  def gte(other:Expression) = Cmp(CmpTypes.Gte, this, other)


  def disassemble: Seq[Expression]
  def reassemble(in: Seq[Expression]): Expression
  def rebuild(fn:(Expression => Expression)): Expression = 
    reassemble(disassemble.map { fn(_) })
}

sealed abstract class Constant(val t:Type) extends Expression
{
  def disassemble = Seq[Expression]()
  def reassemble(in: Seq[Expression]): Expression = this
}
case class IntConstant(i:Integer) extends Constant(TInt())
{
  override def toString:String = i.toString
}
case class FloatConstant(f:Double) extends Constant(TFloat())
{
  override def toString:String = f.toString
}
case class BoolConstant(b:Boolean) extends Constant(TBool())
{
  override def toString:String = if(b){ "true" } else { "false" }
}

case class Var(v:String) extends Expression
{
  def disassemble = Seq[Expression]()
  def reassemble(in: Seq[Expression]): Expression = this
}
case class Cmp(t: CmpTypes.T, lhs:Expression, rhs:Expression) extends Expression
{
  def disassemble = Seq[Expression](lhs, rhs)
  def reassemble(in: Seq[Expression]): Expression = Cmp(t, in(0), in(1))
}
case class Arith(t: ArithTypes.T, lhs:Expression, rhs:Expression) extends Expression
{
  def disassemble = Seq[Expression](lhs, rhs)
  def reassemble(in: Seq[Expression]): Expression = Arith(t, in(0), in(1))
}
case class FunctionalIfThenElse(condition:Expression, ifTrue:Expression, ifFalse:Expression) extends Expression
{
  def disassemble = Seq[Expression](condition, ifTrue, ifFalse)
  def reassemble(in: Seq[Expression]): Expression = FunctionalIfThenElse(in(0), in(1), in(2))
}
case class ArraySubscript(target:Expression, index:Integer) extends Expression
{
  def disassemble = Seq[Expression](target)
  def reassemble(in: Seq[Expression]): Expression = ArraySubscript(in(0), index)
}
case class StructSubscript(target:Expression, field:String) extends Expression
{
  def disassemble = Seq[Expression](target)
  def reassemble(in: Seq[Expression]): Expression = StructSubscript(in(0), field)
}
case class FunctionCall(name:String, args:Seq[Expression]) extends Expression
{
  def disassemble = args
  def reassemble(in: Seq[Expression]): Expression = FunctionCall(name, in)
}
