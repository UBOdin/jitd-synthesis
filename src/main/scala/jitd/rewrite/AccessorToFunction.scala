package jitd.rewrite

import jitd.spec._
import jitd.typecheck._

object AccessorToFunction
{
  def apply(definition: Definition, accessor: Accessor, prefix: String = ""): FunctionDefinition =
  {
    val fname = prefix+accessor.name


    FunctionDefinition(
      fname,
      accessor.retType,
      Seq(
        ("jitd_node_ref", NodeRef, FunctionArgType.ConstInput)
      ) ++ accessor.args.map { field => (field.name, field.t, 
          if(field.t.isInstanceOf[PrimType]) { FunctionArgType.Input } else { FunctionArgType.ConstInput }
        )
      } ++ accessor.ret.map { field => (field.name, field.t, FunctionArgType.Output) },
      ExtractNode(
        "jitd_node",
        Var("jtid_node_ref"),
        accessor.lookups.map { case (nodeType, handler) =>
          val fieldMap= definition.node(nodeType).map { field => 
                          field.name -> 
                        }
          nodeType -> Inline()
        }

      )
    )
  }
}