package jitd.codegen

import jitd.spec._

class RenderExpression(ctx: Render, renderFunction: Map[String, (Seq[Expression], RenderExpression) => String])
{

  def apply(expression: Expression): String = 
  {
    expression match { 
      case c:Constant => c.toString
      case Var(n) => n
      case FunctionCall(name, args) if renderFunction contains name => renderFunction(name)(args, this)
      case FunctionCall(name, args) => s"${name}(${args.map{apply(_)}.mkString(", ")})"
      case Cmp(op, lhs, rhs) => s"(${apply(lhs)}) ${CmpTypes.opString(op)} (${apply(rhs)})"
      case Arith(op, lhs, rhs) => s"(${apply(lhs)}) ${ArithTypes.opString(op)} (${apply(rhs)})"
      case StructSubscript(target, field) => s"${apply(target)}.${field}"
      case ArraySubscript(target, index) => s"${apply(target)}[${index}]"
      case NodeSubscript(target, field) => s"${apply(target)}->${field}"
      case FunctionalIfThenElse(condition, thenCase, elseCase) => s"(${apply(condition)}) ? (${apply(thenCase)}) : (${elseCase})"       
      case MakeNode(nodeType, fields) => "new "+ctx.definition.node(nodeType).renderName+"("+fields.map { apply(_) }.mkString(", ")+")"
      case WrapNode(target) => "std::shared_ptr<JITDNode>("+apply(target)+")"
      case WrapNodeRef(target) => "&("+apply(target)+")"   
      case UnWrapHandle(target) => " *("+apply(target)+")"  
      case NodeCast(nodeType,target,field) => s"((${nodeType}Node *)("+s"${apply(target)}))->${field}"  
    }
  }
}