package jitd.codegen

import jitd.spec._
import jitd.rewrite.Inline

object RenderAccessor
{

  def declaration(name:String, accessor:Accessor, ctx:Render, root: Boolean = false): String =
  {
    val fields = (
      (if(root){ Seq[String]() } else {
        Seq(
          ctx.fieldDefn(Field("jitd_node", TNode()))
        )
      })++
      accessor.args.map { ctx.fieldDefn(_) } ++ 
      accessor.ret.map  { ctx.fieldDefn(_, passByRef = true) }
    )
    s"bool $name(${fields.mkString(", ")})"
  }

  def renderCall(name: String, accessor: Accessor, ctx: Render, target: String): String = 
  {
    val args = (
      Seq(target)++
      accessor.args.map { _.name }++
      accessor.ret.map { _.name }
    )
    s"${name}(${args.mkString(", ")})"    
  }

  def body(name: String, accessor: Accessor, ctx:Render): String = 
  {
    def renderDelegate = (to: Expression, renderExpression: RenderExpression) => { 
      renderCall(name, accessor, ctx, renderExpression(to))
    }
    def render = new RenderStatement(ctx, renderDelegate)
    s"\n    switch(jitd_node->type){\n"+
    accessor.lookups.map { case (nodeName, statement) => {
      val node = ctx.definition.nodesByName(nodeName)
      val fieldMap = node.fields.map { f => f.name -> StructSubscript(Var("(*jitd_node_real)"), f.name) }.toMap
      s"      /////////////////// $nodeName Node ///////////////////\n"+
      s"      case ${node.enumName}: {\n"+
      s"        ${node.renderName} *jitd_node_real = (${node.renderName} *)jitd_node.get();\n"+
                render(Inline(statement, fieldMap), "        ")+
       "      } break;\n"
    }}.mkString("\n")+
    s"    }"
  }

}