package jitd.codegen

import jitd.spec._

class RenderExpression(renderDelegate: (Expression, RenderExpression) => String)
{

  def apply(expression: Expression): String = 
  {
    expression match { 
      case c:Constant => c.toString
      case Var(n) => n
      case FunctionCall(name, args) => s"${name}(${args.map{apply(_)}.mkString(", ")})"
      case Delegate(to) => renderDelegate(to, this)
      case Cmp(op, lhs, rhs) => s"(${apply(lhs)}) ${CmpTypes.opString(op)} (${apply(rhs)})"
      case StructSubscript(target, field) => s"${apply(target)}.${field}"
      case ArraySubscript(target, index) => s"${apply(target)}[${index}]"
      case FunctionalIfThenElse(condition, thenCase, elseCase) => s"(${apply(condition)}) ? (${apply(thenCase)}) : (${elseCase})"
    }
  }
}