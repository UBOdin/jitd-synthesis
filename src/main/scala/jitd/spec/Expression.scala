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
  val Add, Sub, Mul, Div, And, Or = Value

  def opString(op:T):String = 
  {
    op match {
      case Add => "+"
      case Sub => "-"
      case Mul => "*"
      case Div => "/"
      case And => "&&"
      case Or  => "||"
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

  def and(other:Expression) = 
  {
    (this, other) match { 
      case (BoolConstant(true), _)  => other
      case (BoolConstant(false), _) => this
      case (_, BoolConstant(true))  => this
      case (_, BoolConstant(false)) => other
      case _ => Arith(ArithTypes.And, this, other)
    }
  }
  def or(other:Expression) = 
  {
    (this, other) match { 
      case (BoolConstant(false), _)  => other
      case (BoolConstant(true), _) => this
      case (_, BoolConstant(false))  => this
      case (_, BoolConstant(true)) => other
      case _ => Arith(ArithTypes.Or, this, other)
    }
  }

  def plus(other:Expression)      = Arith(ArithTypes.Add, this, other)
  def minus(other:Expression)     = Arith(ArithTypes.Sub, this, other)
  def times(other:Expression)     = Arith(ArithTypes.Mul, this, other)
  def dividedBy(other:Expression) = Arith(ArithTypes.Div, this, other)

  def get(field:String) = StructSubscript(this, field)
  def get(index:Int)    = ArraySubscript(this, index)

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
  override def toString = v.toString
}
case class Cmp(t: CmpTypes.T, lhs:Expression, rhs:Expression) extends Expression
{
  def disassemble = Seq[Expression](lhs, rhs)
  def reassemble(in: Seq[Expression]): Expression = Cmp(t, in(0), in(1))
  override def toString = s"($lhs) ${CmpTypes.opString(t)} ($rhs)"
}
case class Arith(t: ArithTypes.T, lhs:Expression, rhs:Expression) extends Expression
{
  def disassemble = Seq[Expression](lhs, rhs)
  def reassemble(in: Seq[Expression]): Expression = Arith(t, in(0), in(1))
  override def toString = s"($lhs) ${ArithTypes.opString(t)} ($rhs)"
}
case class FunctionalIfThenElse(condition:Expression, ifTrue:Expression, ifFalse:Expression) extends Expression
{
  def disassemble = Seq[Expression](condition, ifTrue, ifFalse)
  def reassemble(in: Seq[Expression]): Expression = FunctionalIfThenElse(in(0), in(1), in(2))
  override def toString = s"($condition) ? ($ifTrue) : ($ifFalse)"
}
case class ArraySubscript(target:Expression, index:Integer) extends Expression
{
  def disassemble = Seq[Expression](target)
  def reassemble(in: Seq[Expression]): Expression = ArraySubscript(in(0), index)
  override def toString = s"$target[$index]"
}
case class StructSubscript(target:Expression, field:String) extends Expression
{
  def disassemble = Seq[Expression](target)
  def reassemble(in: Seq[Expression]): Expression = StructSubscript(in(0), field)
  override def toString = s"$target.$field"
}
case class NodeSubscript(target:Expression, field:String) extends Expression
{
  def disassemble = Seq[Expression](target)
  def reassemble(in: Seq[Expression]): Expression = NodeSubscript(in(0), field)
  override def toString = s"$target->$field"
}
case class FunctionCall(name:String, args:Seq[Expression]) extends Expression
{
  def disassemble = args
  def reassemble(in: Seq[Expression]): Expression = FunctionCall(name, in)
  override def toString = s"$name(${args.mkString(", ")})"
}
case class WrapNode(target: Expression) extends Expression
{
  def disassemble = Seq(target)
  def reassemble(in: Seq[Expression]): Expression = WrapNode(in(0))
  override def toString = s"wrap ${target.toString}"
}
case class UnWrapHandle(target: Expression) extends Expression
{
  def disassemble = Seq(target)
  def reassemble(in: Seq[Expression]): Expression = UnWrapHandle(in(0))
  override def toString = s"unwraphandleref ${target.toString}"
}
case class WrapNodeRef(target: Expression) extends Expression
{
  def disassemble = Seq(target)
  def reassemble(in: Seq[Expression]): Expression = WrapNodeRef(in(0))
  override def toString = s"wrapnoderef ${target.toString}"
}

case class MakeNode(nodeType: String, fields: Seq[Expression]) extends Expression
{
  def disassemble = fields
  def reassemble(in: Seq[Expression]): Expression = MakeNode(nodeType, in)
  override def toString = s"allocate ${nodeType}(${fields.mkString(",")})"  
}