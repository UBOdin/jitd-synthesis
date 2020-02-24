package jitd.codegen

import jitd.spec.Mutator

object RenderMutator {
  
  def declaration(mutator:Mutator, ctx:Render, prefix:String = ""): String =
  {
    val fields = mutator.args.map { ctx.fieldDefn(_, passByRef = true, isConst = true) } 
    //s"void ${prefix}before_${mutator.name}(${fields.mkString(", ")});\n"+
    s"void ${prefix}${mutator.name}(${fields.mkString(", ")});\n"+
    s"void ${prefix}after_${mutator.name}(std::pair<std::shared_ptr<std::shared_ptr<JITDNode>>,std::shared_ptr<std::shared_ptr<JITDNode>>> &cq_elem);\n"
    
  }
  
}