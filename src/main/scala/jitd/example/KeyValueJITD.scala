package jitd.example;

import jitd.typecheck.FunctionDefinition
import jitd.spec._
import jitd.spec.FieldConversions._
import jitd.spec.StatementConversions._
import jitd.spec.CmpTypes._

object KeyValueJITD {

  val functions = Seq(
    FunctionDefinition("record_scan", Seq(TArray(TRecord()), TKey(), TRecord()), TBool()),
    FunctionDefinition("record_binary_search", Seq(TArray(TRecord()), TKey(), TRecord()), TBool())
  ).map { f => f.name -> f }.toMap


  val ArrayNode = Node("Array", Seq(
    "data" -> TArray(TRecord())
  ))
  val SortedArrayNode = Node("Sorted", Seq(
    "data" -> TArray(TRecord())
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

  def Begin(t:Expression=Var("data")) = FunctionCall("std::begin", Seq(t))
  def End(t:Expression=Var("data")) = FunctionCall("std::end", Seq(t))

  val GetByKey = new Accessor(
    Seq( "target" -> TKey() ),
    Seq( "result" -> TRecord() ),
    Map(
      ArrayNode.name -> Return( 
        FunctionCall("record_scan", Seq(Var("data"), Var("target"), Var("result"))) 
      ),
      ////////
      SortedArrayNode.name -> Return( 
        FunctionCall("record_binary_search", Seq(Var("data"), Var("target"), Var("result"))) 
      ),
      ////////
      ConcatNode.name -> IfThenElse(
        Delegate(Var("lhs")),
        Return(BoolConstant(true)),
        Return(Delegate(Var("rhs")))
      ),
      ////////
      BTreeNode.name -> IfThenElse(
        Var("target").lt(Var("sep")),
        Return(Delegate(Var("lhs"))),
        Return(Delegate(Var("rhs")))
      )
    )
  )

  //////////////////////////////////////////////


  val definition = Definition(
    nodes = Seq(
      ArrayNode,
      SortedArrayNode,
      ConcatNode,
      BTreeNode
    ),
    accessors = Map(
      "get" -> GetByKey
    ),
    includes = Seq("int_record.hpp")
  )



}