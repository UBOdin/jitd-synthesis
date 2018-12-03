package jitd.codegen

import jitd.spec._

class RenderStatement(
  ctx: Render, 
  renderDelegate: (Expression, RenderExpression) => String
){

  def renderExpression = new RenderExpression(renderDelegate)

  def apply(target: Statement, indent:String = ""): String = 
  {
    val recur = (nested:Statement) => apply(nested, indent+"  ")

    target match {
      case IfThenElse(condition, ifTrue, ifFalse) => {
          indent+"if("+renderExpression(condition)+")\n"+
            recur(ifTrue)+
          indent+"else\n"+
            recur(ifFalse)
        }
      case Declare(name, Some(t), v) => {
          indent+ctx.cType(t)+" name"+" = "+renderExpression(v)+";\n"
        }
      case Declare(name, None, v) => {
          indent+"auto name"+" = "+renderExpression(v)+";\n"
        }
      case Assign(name, v) => {
          indent+name+" = "+renderExpression(v)+";\n"
        }
      case Block(nested) => {
          indent+"{\n"+
            nested.map { recur(_) }.mkString+
          indent+"}\n"
        }
      case ForEach(loopvar, over, body) => ???
      case Return(v) => {
          indent+"return "+renderExpression(v)+";\n"
        }

    }
  }

}