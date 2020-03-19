package jitd.rewrite

import jitd.spec._
import jitd.spec.FunctionArgType._
import jitd.codegen._
object TransformToFunction
{
  def apply(definition: Definition, transform: Transform,prefix:String): FunctionDefinition =
  {
    var handlerefbool = true
   

    var ctx = Render(definition) 
    var (stmt1,stmt2) = ctx.policyImplementation.onRewriteSet(ctx,definition,false,handlerefbool,transform.from,transform.to,"target","to_ptr")
    
    def makeMatchTest(onMatch: Statement) = 
      MatchToStatement(
        definition, 
        transform.from, 
        "target", 
        handlerefbool,
        onMatch ++ Return(BoolConstant(true)),
        Return(BoolConstant(false))
      )
    
    def constructNewNode() = {
      val (constructor, accessor) = MatchToStatement(
        definition,
        transform.to,
        "to_ptr",
        false
      )
      constructor ++Assign("target", (accessor), true)++stmt2 //++ Macro("#ifdef DEBUG")++ Void(Var("check_pq()"))++ Macro("#endif")
    }
    definition.typechecker.check {//checks to see if its correct and returns same 
      FunctionDefinition(
        prefix+transform.name, 
        Some(TBool()),
        Seq(
          ("target", THandleRef(), OutputRef)
        ),
        makeMatchTest(stmt1++constructNewNode())
      )
    }

  }
}
