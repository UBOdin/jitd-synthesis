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



//  void @{transform.name}(std::shared_ptr<JITDNode> &target){
//    // Make sure that we hold a reference to the physical pointer
//    std::shared_ptr<JITDNode> physicalLock = target;
//    const JITDNode *from = physicalLock.get();
//
//    // Check that the transform is valid (and extract fields)
//    @{RenderPattern.test(ctx, transform.from, "from", "return;")}
//
//    // Build the new root
//    @{RenderPattern.buildForTransform(ctx, transform.to, "to", transform.from, "from")}
//
//    // and link the rewritten node back into the tree
//    target = to;
//  }