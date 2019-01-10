package jitd.rewrite

import jitd.spec._
import jitd.spec.FunctionArgType._

object TransformToFunction
{
  def apply(definition: Definition, transform: Transform): FunctionDefinition =
  {

    def makeMatchTest(onMatch: Statement) = 
      MatchToStatement(
        definition, 
        transform.from, 
        "target", 
        onMatch ++ Return(BoolConstant(true)),
        Return(BoolConstant(false))
      )

    def constructNewNode() = {
      val (constructor, accessor) = MatchToStatement(
        definition,
        transform.to,
        "to_ptr"
      )
      constructor ++ Assign("target", accessor, true)
    }

    definition.typechecker.check {
      FunctionDefinition(
        transform.name, 
        TBool(),
        Seq(
          ("target", TNodeRef(), OutputRef)
        ),
        makeMatchTest( constructNewNode() )
      )
    }
  }
}
