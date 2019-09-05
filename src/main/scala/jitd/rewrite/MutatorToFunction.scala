package jitd.rewrite

import jitd.spec._
import jitd.typecheck._

object MutatorToFunction
{
  def apply(definition: Definition, mutator: Mutator, prefix: String): FunctionDefinition =
  {
    val renderName = prefix + mutator.name
    val args = mutator.args.map { field => (field.name, field.t, 
          if(field.t.isInstanceOf[PrimType]) { FunctionArgType.Input } else { FunctionArgType.ConstInputRef }
        )
      }

    val (constructor, new_root) = 
      MatchToStatement(
        definition,
        mutator.rewrite,
        "new_root"
      )

    definition.typechecker.check("&root" -> THandleRef(), "root" -> TNodeRef()) {
      FunctionDefinition(
        renderName,
        None,
        args,
        constructor ++ Assign("&root", new_root, true)
      )
    }
  }
}