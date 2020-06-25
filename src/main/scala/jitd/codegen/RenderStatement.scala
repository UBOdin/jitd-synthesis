package jitd.codegen

import jitd.spec._
import jitd.typecheck._
class RenderStatement(
  ctx: Render, 
  renderFunction: Map[String, (Seq[Expression], RenderExpression) => String] = Map()
){

  def renderExpression = new RenderExpression(ctx, renderFunction)
  def apply(target: Statement, indent:String = ""): String = 
  {
    val recur = (nested:Statement) => apply(nested, indent+"  ")
    val recurWithIndent = (nested:Statement, addendum:String) => apply(nested, indent+addendum)

    target match {
      case IfThenElse(condition, ifTrue, ifFalse:IfThenElse) => {
          indent+"if("+renderExpression(condition)+")\n"+
            recur(ifTrue)+
          indent+"else\n"+
            apply(ifFalse, indent)
        }
      case IfThenElse(condition, ifTrue, ifFalse) => {
          indent+"if("+renderExpression(condition)+")\n"+
            recur(ifTrue)+
          indent+"else\n"+
            recur(ifFalse)
        }  
      case Declare(name, Some(t), v) => {
          indent+ctx.cType(t)+" "+name+" = "+renderExpression(v)+";\n"
          //indent+"std::cout<<\"Found a node:"+ctx.cType(t)+"\"<<std::endl;\n"
        }
      case Declare(name, None, v) => {
          indent+"auto "+name+"  =  "+renderExpression(v)+";\n"
        }
      
      case ExtractNode(name, v, matchers, onFail) => {
        //indent+s"check_set();\n"+
            // indent+s"#ifdef DEBUG\n"+
            // indent+s"check_pq();\n"+
            // indent+s"#endif\n"+
            indent+s"${ctx.cType(TNodeRef())} "+name+"_lock;\n"+
            indent+s"// Extract ${renderExpression(v)} into ${matchers.map { _._1 }.mkString(" or ")}\n"+ 
            indent+"#ifdef ATOMIC_LOAD\n"+
            indent+name+s"_lock = std::atomic_load(("+renderExpression(v)+"));\n"+
            indent+"#endif\n"+
            indent+"#ifdef ATOMIC_LOAD_CONSUME\n"+
            indent+name+s"_lock = std::atomic_load_explicit("+renderExpression(v)+",std::memory_order_consume);\n"+
            indent+"#endif\n"+ 
            indent+"#ifdef ATOMIC_LOAD_ACQUIRE\n"+
            indent+name+s"_lock = std::atomic_load_explicit("+renderExpression(v)+",std::memory_order_acquire);\n"+
            indent+"#endif\n"+ 
            //indent+s"std::cout<<"+here+"<<"+name+"_lock.get()->type<<std::endl;\n"+   
            indent+"switch(("+name+"_lock)->type){ \n"+
            matchers.map { case (nodeType, handler) => 
              val node = ctx.definition.nodesByName(nodeType)
              indent+"  case "+node.enumName+":{\n"+
              indent+"    "+node.renderName+" *"+name+" = ("+node.renderName+" *)("+name+"_lock).get();\n"+
              recurWithIndent(handler, "    ")+
              indent+"  }; break;\n"
            }.mkString+
            indent+s"  default: { //${name} is not ${matchers.map { "a " + _._1 }.mkString(" or ")}\n"+
              recurWithIndent(onFail, "    ")+
            indent+"  }; break;\n"+
          indent+"}\n"

        }   
      
      case commonFunction(function,op,v) =>{
        
        //s"gettimeofday(&start,NULL);\n"+
      
        indent+function+renderExpression(op)+renderExpression(v)+");\n"
        //s"gettimeofday(&end,NULL);\n"+
        //s"totalTime = (end.tv_sec - start.tv_sec) * 1000000.0 + (end.tv_usec - start.tv_usec);\n"+
        //s"CrackArray_emplace.push_back(totalTime);"
      }
      case commonFunctionSpecial(function,op,Some(v)) =>{
        
        //s"gettimeofday(&start,NULL);\n"+
      
        indent+function+renderExpression(op)+","+renderExpression(v)+");\n"
        //s"gettimeofday(&end,NULL);\n"+
        //s"totalTime = (end.tv_sec - start.tv_sec) * 1000000.0 + (end.tv_usec - start.tv_usec);\n"+
        //s"CrackArray_emplace.push_back(totalTime);"
      }
      case commonFunctionSpecial(function,op,None) =>{
        
        //s"gettimeofday(&start,NULL);\n"+
      
        indent+function+renderExpression(op)+");\n"
        //s"gettimeofday(&end,NULL);\n"+
        //s"totalTime = (end.tv_sec - start.tv_sec) * 1000000.0 + (end.tv_usec - start.tv_usec);\n"+
        //s"CrackArray_emplace.push_back(totalTime);"
      }
      
      case Void(v) => {
          indent + renderExpression(v)+";\n"
        }
      case Assign(name, v, false) => {
          indent+name+" = "+renderExpression(v)+";\n"
        }
      
      case Assign(name, v, true) => {
          //indent+s"${ctx.cType(THandleRef())} " +name+"_ptr"+ ";\n"+ 
          indent+"#ifdef ATOMIC_STORE\n"+
          indent+"std::atomic_store("+name+", "+renderExpression(v)+");\n"+
          indent+"#endif\n"+
          indent+"#ifdef ATOMIC_STORE_RELEASE\n"+
          indent+"std::atomic_store_explicit("+name+", "+renderExpression(v)+",std::memory_order_release);\n"+
          indent+"#endif\n"
          
          
        }
      case Block(nested) => {
          indent+"{\n"+
            nested.map { recur(_) }.mkString+
          indent+"}\n"
        }
      case ForEach(loopvar, over, body) => ???
      case Return(v) => {
          indent+"return "+renderExpression(v)+";\n"
        }
      case Error(msg) => {
          indent+"std::cerr << \""+msg+"\" << std::endl;\n"+indent+"exit(-1);\n"
        }
      case Comment(msg) => {
          indent+"/*** "+msg+" ***/\n"
        }
      case Macro(msg) => {
        "\n"+indent+msg+"\n"
      }
      case RDTSC_Start_Logging() =>{
        "VIEW_START;\n"

      }
      case RDTSC_End_Logging() =>{
        "VIEW_END;\n"

      }

        
      
    }
  }

}
