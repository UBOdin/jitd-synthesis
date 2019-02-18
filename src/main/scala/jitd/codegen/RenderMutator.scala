package jitd.codegen

import jitd.spec.Mutator

object RenderMutator {
  
  def declaration(mutator:Mutator, ctx:Render, prefix:String = ""): String =
  {
    val fields = mutator.args.map { ctx.fieldDefn(_, passByRef = true, isConst = true) } 
    s"void ${prefix}${mutator.name}(${fields.mkString(", ")})"
  }
}