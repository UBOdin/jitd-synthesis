package jitd.spec

import jitd.spec._
import scala.language.implicitConversions

object StatementConversions {
  implicit def seq2block(s:Seq[Statement]): Block = Block(s)
}

sealed abstract class Statement
{
  def disasssembleStatement: Seq[Statement]
  def reassembleStatement(in: Seq[Statement]): Statement 
  def rebuildStatement(fn: Statement => Statement): Statement =
    reassembleStatement(disasssembleStatement.map { fn(_) })
  def disasssembleExpression: Seq[Expression]
  def reassembleExpression(in: Seq[Expression]): Statement
  def rebuildExpression(fn: Expression => Expression): Statement = 
    reassembleExpression(disasssembleExpression.map { fn(_) })
      .rebuildStatement { _.rebuildExpression(fn) }
  
}

case class IfThenElse(condition:Expression, ifTrue:Statement, ifFalse:Statement = Block(Seq())) extends Statement
{
  def disasssembleStatement: Seq[Statement] = Seq(ifTrue, ifFalse)
  def reassembleStatement(in: Seq[Statement]): Statement = IfThenElse(condition, in(0), in(1))
  def disasssembleExpression: Seq[Expression] = Seq(condition)
  def reassembleExpression(in: Seq[Expression]): Statement = IfThenElse(in(0), ifTrue, ifFalse)
}
case class Declare(name:String, t:Option[Type], v:Expression) extends Statement
{
  def disasssembleStatement: Seq[Statement] = Seq()
  def reassembleStatement(in: Seq[Statement]): Statement = this
  def disasssembleExpression: Seq[Expression] = Seq(v)
  def reassembleExpression(in: Seq[Expression]): Statement = Declare(name, t, in(0))
}
case class Assign(name:String, v:Expression) extends Statement
{
  def disasssembleStatement: Seq[Statement] = Seq()
  def reassembleStatement(in: Seq[Statement]): Statement = this
  def disasssembleExpression: Seq[Expression] = Seq(v)
  def reassembleExpression(in: Seq[Expression]): Statement = Assign(name, in(0))
}
case class Block(statements:Seq[Statement]) extends Statement
{
  def disasssembleStatement: Seq[Statement] = statements
  def reassembleStatement(in: Seq[Statement]): Statement = Block(statements)
  def disasssembleExpression: Seq[Expression] = Seq()
  def reassembleExpression(in: Seq[Expression]): Statement = this
}
case class ForEach(loopvar:String, over:Expression, body:Statement) extends Statement
{
  def disasssembleStatement: Seq[Statement] = Seq(body)
  def reassembleStatement(in: Seq[Statement]): Statement = ForEach(loopvar, over, in(0))
  def disasssembleExpression: Seq[Expression] = Seq(over)
  def reassembleExpression(in: Seq[Expression]): Statement = ForEach(loopvar, in(0), body)
}
case class Return(v:Expression) extends Statement
{
  def disasssembleStatement: Seq[Statement] = Seq()
  def reassembleStatement(in: Seq[Statement]): Statement = this
  def disasssembleExpression: Seq[Expression] = Seq(v)
  def reassembleExpression(in: Seq[Expression]): Statement = Return(in(0))
}


