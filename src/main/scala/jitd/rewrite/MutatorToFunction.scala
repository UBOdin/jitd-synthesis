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
    //var (stmt1,stmt2) = ctx.policyImplementation.onRewriteSet(ctx,definition,true,handlerefbool,mutator.rewrite.toMatchPattern,mutator.rewrite,"target","new_root")
    val renderName = prefix + mutator.name
    //println(mutator.name)
    val args = mutator.args.map { field => (field.name, field.t, FunctionArgType.ConstInputRef
          //if(field.t.isInstanceOf[PrimType]) { FunctionArgType.Input } else { FunctionArgType.ConstInputRef }
        )
      }
     
    //var stmt = commonFunction("SetPqErase(",Var(""),WrapNodeRef(Var("root")))
    
    val (constructor, new_root) = 
      MatchToStatement(
        definition,
        mutator.rewrite,
        "new_root",true
      )

   
    val ptr_ptr_construct = Void(Var("std::shared_ptr<std::shared_ptr<JITDNode>> new_root_ptr = std::shared_ptr<std::shared_ptr<JITDNode>>(std::make_shared<std::shared_ptr<JITDNode>>(std::shared_ptr<JITDNode>(new_root)))"))
    
    // val falg_setter = if(mutator.name contains "insert"){Void(Var("mce.flag = INSERT"))}else{Void(Var("mce.flag = REMOVE"))}
    // val common_cq_element_declare = Void(Var("mutatorCqElement mce"))
    // val common_cq_element_assign = Void(Var("(mce.element).first = jitd_root")) ++ Void(Var("(mce.element).second = new_root_ptr"))//std::make_pair((jitd_root),(new_root_ptr))"))
    // val common_cq_populate = Void(Var("this->work_queue.emplace(mce)"))
    
    val common_cq_populate_emplace = 
    {
      
      Void(Var("this->work_queue.emplace(FLAG_"+mutator.name+",jitd_root,new_root_ptr)"))
    }
    definition.typechecker.check("&(*jitd_root)" -> THandleRef(), "(*jitd_root)" -> TNodeRef()) {
      FunctionDefinition(
        renderName,
        None,
        args,
        //constructor ++ Assign("&root", new_root, true) ++ cq_element_declare ++ cq_populate
        //Macro("#ifdef DEBUG")++ Void(Var("check_pq()"))++ Macro("#endif")++
        Void(Var("pthread_mutex_lock(&this->lock)"))++constructor ++ ptr_ptr_construct ++
        //common_cq_element_declare++falg_setter++common_cq_element_assign++common_cq_populate++ 
        common_cq_populate_emplace++
        Void(Var("std::atomic_store(&jitd_root, new_root_ptr)")) ++ Void(Var("pthread_mutex_unlock(&this->lock)"))
        //Macro("#ifdef DEBUG")++ Void(Var("check_pq()"))++ Macro("#endif")

      )
      
    } 
  }
}
