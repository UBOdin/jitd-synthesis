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
             .rebuildStatement( _ match {
                case Assign(v, e) if replacements contains v =>
                  replacements(v) match {
                    case Var(r) => Assign(r, e)
                    case _ => throw new Exception("Invalid Inline")
                  }
                case Declare(v, t, e) if replacements contains v =>
                  replacements(v) match {
                    case Var(r) => Declare(r, t, e)
                    case _ => throw new Exception("Invalid Inline")
                  }
                case x => x
              }
            )
  }
}