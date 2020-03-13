package jitd.rewrite

import jitd.spec._
import jitd.typecheck._
import jitd.codegen.Render
import jitd.codegen.policy._
object MutatorToFunctionAfter
{
  def apply(definition: Definition, mutator: Mutator, prefix: String): FunctionDefinition =
  {
    var ctx = Render(definition) 
    var handlerefbool = false
    var (stmt1,stmt_maintenance_new_root) = ctx.policyImplementation.onRewriteSet(ctx,definition,true,handlerefbool,mutator.rewrite.toMatchPattern,mutator.rewrite,"target","cast_root")
    val renderName = prefix + mutator.name
    val args = mutator.args.map { field => (field.name, field.t, 
          if(field.t.isInstanceOf[PrimType]) { FunctionArgType.Input } else { FunctionArgType.ConstInputRef }
        )
      }

    val stmt_node_cast = mutator.rewrite match {
        case ConstructNode(node, fields, nameOption) => 
          {
            //println(node)
            val nodeDefinition = definition.node(node)
            val nodeName = nameOption.getOrElse("cast_root")
            //println(nodeDefinition.renderName)
            //println(nodeName)
            val string_rhs = s"(${nodeDefinition.renderName}*)((cq_elem.second)->get()"
            //val string  = nodeDefinition.renderName + "* node = " + "(${"nodeDefinition.renderName"})" 
            val string_lhs = s"${nodeDefinition.renderName} *cast_root"
            //val string =  string_lhs + " = " + string_rhs
            commonFunction(string_lhs+" = ",Var(string_rhs),Var(""))

          }

    }
  
    //val cq_element_declare = Void(Var("std::pair<std::shared_ptr<std::shared_ptr<JITDNode>>,std::shared_ptr<std::shared_ptr<JITDNode>>> cq_elem")) ++ commonFunction(mutator.name+"_cq.pop(cq_elem",Var(""),Var(""))
    val stmt_maintenance_old_root = Macro("#ifdef DEBUG")++commonFunction("assert(",UnWrapHandle(Var("cq_elem.first")),Var("!=NULL"))++Macro("#endif")++
                                    commonFunction("SetPqErase(",Var(""),WrapNodeRef(UnWrapHandle(Var("cq_elem.first"))))
    
    definition.typechecker.check("&(*jitd_root)" -> THandleRef(), "(*jitd_root)" -> TNodeRef()) {
      FunctionDefinition(
        renderName,
        None,
        args,
        stmt_maintenance_old_root ++ stmt_node_cast ++ stmt_maintenance_new_root
        
      )
      
    } 
  }
}
//FunctionDefinition("JITD::before_insert",None,Seq(),stmt)