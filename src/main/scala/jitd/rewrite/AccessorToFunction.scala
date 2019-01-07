package jitd.rewrite

import jitd.spec._
import jitd.typecheck._

object AccessorToFunction
{
  def apply(definition: Definition, accessor: Accessor, prefix:String): FunctionDefinition =
  {
    val args = Seq(
        ("jitd_node_ref", TNodeRef(), FunctionArgType.ConstInputRef)
      ) ++ accessor.args.map { field => (field.name, field.t, 
          if(field.t.isInstanceOf[PrimType]) { FunctionArgType.Input } else { FunctionArgType.ConstInputRef }
        )
      } ++ accessor.ret.map { field => (field.name, field.t, FunctionArgType.OutputRef) }

    FunctionDefinition(
      prefix+accessor.name,
      accessor.returnType,
      args,
      ExtractNode(
        "jitd_node",
        Var("jitd_node_ref"),
        accessor.lookups.toSeq.map { case (nodeType, handler) =>
          val fieldMap = definition.node(nodeType).fields.map { field => 
                            field.name -> NodeSubscript(Var("jitd_node"), field.name)
                         }.toMap
          nodeType -> InlineFunctions(
            InlineVars(handler, fieldMap),
            Map[String,(Seq[String],Expression)](
              ("delegate", (
                Seq("delegate_jitd_node"),
                FunctionCall(prefix+accessor.name, 
                  Seq(Var("delegate_jitd_node"))++
                    (accessor.args ++ accessor.ret).map { _.name }.map { Var(_) }
                )
              ))
            )
          )
        },
        Error(s"Unhandled Node Type in ${accessor.name}")
      )
    )
  }
}