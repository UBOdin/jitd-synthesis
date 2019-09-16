package jitd.rewrite

import jitd.spec._

object InlineVars
{
  def apply(
    expression: Expression, 
    replacements:Map[String,Expression]
  ): Expression =
  {
    expression match {
      case Var(v) if replacements contains v => replacements(v)
      case _ => expression.rebuild { apply(_, replacements) }
    }
  }
  def apply(
    statement: Statement, 
    replacements:Map[String,Expression]
  ): Statement =
  {
    statement.rebuildExpression(apply(_, replacements))
             .rebuildStatement(apply(_, replacements))
              match {
                case Assign(v, e, isAtomic) if replacements contains v =>
                  replacements(v) match {
                    case Var(r) => Assign(r, e, isAtomic)
                    case _ => throw new Exception(s"Invalid Inline (replacing assign of '$v' with $e)")
                  }
                case Declare(v, t, e) if replacements contains v =>
                  replacements(v) match {
                    case Var(r) => Declare(r, t, e)
                    case _ => throw new Exception(s"Invalid Inline (replacing declare of '$v' with $e)")
                  }
                case x => x
              }
            
  }
}

object InlineFunctions
{
  def apply(
    expression: Expression, 
    replacements:Map[String,(Seq[String],Expression)]
  ): Expression =
  {
    expression match {
      case FunctionCall(fname, args) if replacements contains fname => {
        val (argNames, expr) = replacements(fname)
        val inlinedArgs = args.map { _.rebuild { apply(_, replacements) } }
        InlineVars(expr, argNames.zip(inlinedArgs).toMap)
      }
      case _ => expression.rebuild { apply(_, replacements) }
    }
  }
  def apply(
    statement: Statement, 
    replacements:Map[String,(Seq[String],Expression)]
  ): Statement =
  {
    statement.rebuildExpression(apply(_, replacements))
             .rebuildStatement(apply(_, replacements))
            
  }
}
