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
            indent+s"// Extract ${renderExpression(v)} into ${matchers.map { _._1 }.mkString(" or ")}\n"+  
            indent+s"${ctx.cType(TNodeRef())} "+name+"_lock = std::atomic_load(("+renderExpression(v)+"));\n"+
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
      
      case SetRemoveFunction(name,nodeType,v) => {
        val here = "\"Remove from "+nodeType+"Set : "+renderExpression(v)+"\""
        //indent+"//std::cout<<"+here+"<<std::endl;\n"
        indent+"JITD_NODE_"+nodeType+"_set.erase("+renderExpression(v)+");\n"
        //indent+s"check_set();\n"
      }
      case SetAddFunction(name,nodeType,v) => {
        //indent+s"std::cout<<Addr:<<"+renderExpression(v)+";\n"

        
          indent+"JITD_NODE_"+nodeType+"_set.emplace("+renderExpression(v)+");\n"
        
        
      
      }
      case Void(v) => {
          indent + renderExpression(v)+";\n"
        }
      case Assign(name, v, false) => {
          indent+name+" = "+renderExpression(v)+";\n"
        }
      
      case Assign(name, v, true) => {
          //indent+s"${ctx.cType(THandleRef())} " +name+"_ptr"+ ";\n"+ 
         
          indent+"std::atomic_store("+name+", "+renderExpression(v)+");\n"
          
          
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
      
    }
  }

}