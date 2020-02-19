package jitd.codegen

import jitd.spec.Mutator

object RenderMutator {
  
  def declaration(mutator:Mutator, ctx:Render, prefix:String = ""): String =
  {
    val fields = mutator.args.map { ctx.fieldDefn(_, passByRef = true, isConst = true) } 
    //s"void ${prefix}before_${mutator.name}(${fields.mkString(", ")});\n"+
    s"void ${prefix}${mutator.name}(${fields.mkString(", ")});\n"+
    s"void ${prefix}after_${mutator.name}(${fields.mkString(", ")});\n"
    
  }
  def concurrent_queue_declaration(mutator:Mutator,ctx:Render,prefix:String = ""):String = 
  {
  	s"tbb::concurrent_bounded_queue<std::pair<std::shared_ptr<std::shared_ptr<JITDNode>>,std::shared_ptr<std::shared_ptr<JITDNode>>>> ${prefix}${mutator.name}_cq;"
  	//s"tbb::concurrent_bounded_queue<std::shared_ptr<JITDNode>> ${prefix}${mutator.name}before_cq;"
  	//s"tbb::concurrent_bounded_queue<std::shared_ptr<JITDNode>> ${prefix}${mutator.name}after_cq;"
  }
}