package jitd.rewrite

import jitd.spec._
import jitd.typecheck._
import jitd.codegen.Render
import jitd.codegen.policy._
object MutatorToFunction
{
  def apply(definition: Definition, mutator: Mutator, prefix: String): FunctionDefinition =
  {
    var ctx = Render(definition) 
    var handlerefbool = false
    var (stmt1,stmt2) = ctx.policyImplementation.onRewriteSet(ctx,definition,true,handlerefbool,mutator.rewrite.toMatchPattern,mutator.rewrite,"target","new_root")
    val renderName = prefix + mutator.name
    val args = mutator.args.map { field => (field.name, field.t, 
          if(field.t.isInstanceOf[PrimType]) { FunctionArgType.Input } else { FunctionArgType.ConstInputRef }
        )
      }
    var stmt = PqPolicyImplementation.PQinit(ctx,ctx.policy.rule,"erase",WrapNodeRef(Var("root")))
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
        stmt++constructor ++ Assign("&root", new_root, true) ++ stmt2
      )
    }
  }
}