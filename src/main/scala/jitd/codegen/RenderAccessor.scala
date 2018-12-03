package jitd.codegen

import jitd.spec._

object RenderAccessor
{

  def declaration(name:String, accessor:Accessor, ctx:Render): String =
  {
    val fields = (
      Seq(
        ctx.fieldDefn(Field("jitd_node", TNode()))
      )++
      accessor.args.map { ctx.fieldDefn(_) } ++ 
      accessor.ret.map  { ctx.fieldDefn(_, passByRef = true) }
    )
    s"bool $name(${fields.mkString(", ")})"
  }

  def body(name: String, accessor: Accessor, ctx:Render): String = 
  {
    def renderDelegate = (to: Expression, renderExpression: RenderExpression) => { 
      val args = (
        Seq(renderExpression(to))++
        accessor.args.map { _.name }++
        accessor.ret.map { _.name }
      )
      s"${name}(${args.mkString(", ")})"
    }
    def render = new RenderStatement(ctx, renderDelegate)
    "\n"+accessor.lookups.map { case (nodeName, statement) => {
      val node = ctx.definition.nodesByName(nodeName)
      s"    /////////////////// $nodeName Node ///////////////////\n"+
      s"    if(jitd_node->type == ${node.enumName}){\n"+
      s"      ${node.renderName} *jitd_node_real = (${node.renderName} *)jitd_node;\n"+
              render(statement, "      ")+
       "    }\n"
    }}.mkString("\n")
  }

}