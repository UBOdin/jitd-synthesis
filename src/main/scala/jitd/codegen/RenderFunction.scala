package jitd.codegen

import jitd.spec._

object RenderFunction
{

  def body(ctx: Render, fn: FunctionDefinition,mutator:Boolean, indent: String = ""): String =
  {
    //println(fn)
    indent+s"${fn.ret.map { ctx.cType(_) }.getOrElse("void")} ${fn.name}("+
      fn.args.map { case (name, t, inout) =>
        val const = FunctionArgType.isConst(inout)
        val byRef = FunctionArgType.isByRef(inout)
        if(mutator == false){s"${if(const){"const "}else{""}}${ctx.cType(t)} ${if(byRef){"&"}else{""}}${name} " }else{s"std::pair<std::shared_ptr<std::shared_ptr<JITDNode>>,std::shared_ptr<std::shared_ptr<JITDNode>>> &cq_elem"}   
    }.mkString(",")+")\n"+indent+"{\n"+ "/*std::cout<<\" The transform applied is:"+s"${fn.name}"+"\""+"<<std::endl;*/"+ "\n"+ 
    //s"timeval start,end;\n" + "float totalTime;\n"+
      ctx.statement(fn.body, indent+"  ")+ 
    "\n"+indent+"}"
  }


}