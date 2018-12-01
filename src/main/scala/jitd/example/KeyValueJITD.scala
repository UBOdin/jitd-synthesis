package jitd.example;

import jitd.structure._
import jitd.structure.FieldConversions._
import jitd.spec._
import jitd.spec.CmpTypes._

object KeyValueJITD {
  
  val SingletonNode = Node("Singleton", Seq(
    "value" -> TRecord()
  ))
  val ArrayNode = Node("Array", Seq(
    "data" -> TVector(TRecord())
  ))
  val SortedArrayNode = Node("Sorted", Seq(
    "data" -> TVector(TRecord())
  ))
  val ConcatNode = Node("Concat", Seq(
    "lhs" -> TNode(),
    "rhs" -> TNode()
  ))
  val BTreeNode = Node("BTree", Seq(
    "sep" -> TKey(),
    "lhs" -> TNode(),
    "rhs" -> TNode()
  ))

  //////////////////////////////////////////////

  val GetOne = new AccessPath(
    Seq( ("target", TKey()) ),
    Map(
      ArrayNode.name -> Block(Seq(
        ForEach("x", Var("data"),
          IfThenElse(
            Cmp(Eq, Dereference(Var("x")), Var("target")),
            Return(Var("x"))
          )
        ),
        Abort()
      ))
    )
  )

  //////////////////////////////////////////////


  val definition = Definition(
    nodeTypes = Seq(
      ArrayNode,
      SortedArrayNode,
      ConcatNode,
      BTreeNode
    ),
    accessPaths = Map(
      "get" -> GetOne
    ),
    includes = Seq("int_record.hpp")
  )



}