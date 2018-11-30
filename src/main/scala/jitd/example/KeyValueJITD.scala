package jitd.example;

import jitd.structure._
import jitd.structure.FieldConversions._
import jitd.parser.Definition

object KeyValueJITD {
  
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

  val definition = Definition(
    nodeTypes = Seq(
      ArrayNode,
      SortedArrayNode,
      ConcatNode,
      BTreeNode
    ),
    includes = Seq("int_record.hpp")
  )



}