package jitd.codegen

import jitd.spec._

object RenderFunction
{

  def body(ctx: Render, fn: FunctionDefinition, indent: String = ""): String =
  {
    indent+s"${fn.ret.map { ctx.cType(_) }.getOrElse("void")} ${fn.name}("+
      fn.args.map { case (name, t, inout) =>
        val const = FunctionArgType.isConst(inout)
        val byRef = FunctionArgType.isByRef(inout)
        s"${if(const){"const "}else{""}}${ctx.cType(t)} ${if(byRef){"&"}else{""}}${name} "
    }.mkString(",")+")\n"+indent+"{\n"+ "/***std::cout<<\" The transform applied is:"+s"${fn.name}"+"\""+"<<std::endl;***/"+ "\n"+ 
    //s"timeval start,end;\n" + "float totalTime;\n"+
      ctx.statement(fn.body, indent+"  ")+
    "\n"+indent+"}"
  }


}