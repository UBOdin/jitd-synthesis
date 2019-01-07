package jitd.codegen

import jitd.spec._
import jitd.rewrite.InlineVars

object RenderAccessor
{

  def declaration(accessor:Accessor, ctx:Render, prefix: String = "", root: Boolean = false): String =
  {
    val fields = (
      (if(root){ Seq[String]() } else {
        Seq(
          ctx.fieldDefn(Field("jitd_node", TNodeRef()), passByRef = true, isConst = true)
        )
      })++
      accessor.args.map { ctx.fieldDefn(_) } ++ 
      accessor.ret.map  { ctx.fieldDefn(_, passByRef = true) }
    )
    s"${ctx.cType(accessor.returnType)} ${prefix}${accessor.name}(${fields.mkString(", ")})"
  }

  def renderCall(accessor: Accessor, ctx: Render, target: String, prefix:String = ""): String = 
  {
    val args = (
      Seq(target)++
      accessor.args.map { _.name }++
      accessor.ret.map { _.name }
    )
    s"${prefix+accessor.name}(${args.mkString(", ")})"    
  }

  def body(accessor: Accessor, ctx:Render): String = 
  {
    def renderDelegate = (to: Seq[Expression], renderExpression: RenderExpression) => { 
      renderCall( accessor, ctx, renderExpression(to(0)))
    }
    def render = new RenderStatement(ctx, Map("delegate" -> renderDelegate))
    s"\n    switch(jitd_node->type){\n"+
    accessor.lookups.map { case (nodeName, statement) => {
      val node = ctx.definition.nodesByName(nodeName)
      val fieldMap = node.fields.map { f => f.name -> StructSubscript(Var("(*jitd_node_real)"), f.name) }.toMap
      s"      /////////////////// $nodeName Node ///////////////////\n"+
      s"      case ${node.enumName}: {\n"+
              (if(ctx.debug){ 
       "        std::cerr << \""+node.enumName+"->"+accessor.name+"\" << std::endl;\n"
              } else { "" })+
      s"        ${node.renderName} *jitd_node_real = (${node.renderName} *)jitd_node.get();\n"+
                render(InlineVars(statement, fieldMap), "        ")+
       "      } break;\n"
    }}.mkString("\n")+
    s"    }"
  }

}