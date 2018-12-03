package jitd.rewrite

import jitd.spec._

object Inline 
{
  def apply(expression: Expression, replacements:Map[String,Expression]): Expression =
  {
    expression match {
      case Var(v) if replacements contains v => replacements(v)
      case _ => expression.rebuild { apply(_, replacements) }
    }
  }
  def apply(statement: Statement, replacements:Map[String,Expression]): Statement =
  {
    statement.rebuildExpression(apply(_, replacements))
  }
}