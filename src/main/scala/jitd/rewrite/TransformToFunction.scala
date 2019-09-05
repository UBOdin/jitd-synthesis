package jitd.rewrite

import jitd.spec._
import jitd.spec.FunctionArgType._
import jitd.codegen._
object TransformToFunction
{
  def apply(definition: Definition, transform: Transform): FunctionDefinition =
  {
    var handlerefbool = true
    var ctx = Render(definition)
    var (stmt1,stmt2) = ctx.policyImplementation.onRewrite(ctx,definition,handlerefbool,transform.from,transform.to,"target","to_ptr")
    
    //println(extractionVarListFromNode)
    //println(stringVal.lift(0))

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
        "to_ptr"
      )
      constructor ++Assign("target", (accessor), true)
    }

    definition.typechecker.check {//checks to see if its correct and returns same 
      FunctionDefinition(
        transform.name, 
        Some(TBool()),
        Seq(
          ("target", THandleRef(), OutputRef)
        ),
        Comment(s"Code to remove nodes from set")++stmt1 ++ makeMatchTest(constructNewNode() ++ stmt2)
      )
    }

  }
}
