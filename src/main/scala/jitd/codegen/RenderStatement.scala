package jitd.codegen

import jitd.spec._

class RenderStatement(
  ctx: Render, 
  renderFunction: Map[String, (Seq[Expression], RenderExpression) => String] = Map()
){

  def renderExpression = new RenderExpression(ctx, renderFunction)

  def apply(target: Statement, indent:String = ""): String = 
  {
    val recur = (nested:Statement) => apply(nested, indent+"  ")

    target match {
      case IfThenElse(condition, ifTrue, ifFalse:IfThenElse) => {
          indent+"if("+renderExpression(condition)+")\n"+
            recur(ifTrue)+
          indent+"else\n"+
            apply(ifFalse, indent)
        }
      case IfThenElse(condition, ifTrue, ifFalse) => {
          indent+"if("+renderExpression(condition)+")\n"+
            recur(ifTrue)+
          indent+"else\n"+
            recur(ifFalse)
        }
      case Declare(name, Some(t), v) => {
          indent+ctx.cType(t)+" "+name+" = "+renderExpression(v)+";\n"
        }
      case Declare(name, None, v) => {
          indent+"auto "+name+" = "+renderExpression(v)+";\n"
        }
      case ExtractNode(name, v, nodeType, onSuccess, onFail) => {
          val node = ctx.definition.nodesByName(nodeType)
          indent+s"${ctx.cType(TNodeRef())} "+name+"_lock = std::atomic_load(&("+renderExpression(v)+"));\n"+
          indent+"if( ("+renderExpression(v)+")->type == "+node.enumName+"){\n"+
            indent+"  "+node.renderName+" *"+name+" = ("+node.renderName+" *)("+name+"_lock).get();\n"+
            recur(onSuccess)+
          indent+s"} else { //${name} is **not** a ${nodeType}\n"+
            recur(onFail)+
          indent+"}\n"

        }
      case Void(v) => {
          indent + renderExpression(v)+";\n"
        }
      case Assign(name, v, false) => {
          indent+name+" = "+renderExpression(v)+";\n"
        }
      case Assign(name, v, true) => {
          indent+"std::atomic_store(&("+name+"), "+renderExpression(v)+");\n"
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