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
  val SortedArrayNode = Node("SortedArray", Seq(
    "data" -> TArray(TRecord())
  ))
  val ConcatNode = Node("Concat", Seq(
    "lhs" -> TNode(),
    "rhs" -> TNode()
  ))
  val BTreeNode = Node("BTree", Seq(
    "lhs" -> TNode(),
    "sep" -> TKey(),
    "rhs" -> TNode()
  ))

  //////////////////////////////////////////////

  def Begin(t:Expression=Var("data")) = FunctionCall("std::begin", Seq(t))
  def End(t:Expression=Var("data")) = FunctionCall("std::end", Seq(t))

  val GetByKey = new Accessor(
    "get",
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
        FunctionCall("delegate", Seq(Var("lhs"))),
        Return(BoolConstant(true)),
        Return(FunctionCall("delegate", Seq(Var("rhs"))))
      ),
      ////////
      BTreeNode.name -> IfThenElse(
        Var("target").lt(Var("sep")),
        Return(FunctionCall("delegate", Seq(Var("lhs")))),
        Return(FunctionCall("delegate", Seq(Var("rhs"))))
      )
    )
  )
  val Size = new Accessor(
    "size",
    Seq( ),
    Seq( ),
    Map(
      ArrayNode.name -> Return( 
        StructSubscript(Var("data"), "size()") 
      ),
      ////////
      SortedArrayNode.name -> Return( 
        StructSubscript(Var("data"), "size()") 
      ),
      ////////
      ConcatNode.name -> Return(
        Arith(ArithTypes.Add,
          FunctionCall("delegate", Seq(Var("lhs"))),
          FunctionCall("delegate", Seq(Var("rhs")))
        )
      ),
      ////////
      BTreeNode.name -> Return(
        Arith(ArithTypes.Add,
          FunctionCall("delegate", Seq(Var("lhs"))),
          FunctionCall("delegate", Seq(Var("rhs")))
        )
      )
    ),
    returnType = TInt()
  )

  //////////////////////////////////////////////

  val Insert = Mutator(
    "insert",
    Seq("data" -> TArray(TRecord())),
    MatchNode(ConcatNode.name, Seq(
      MatchAny(Some("root")),
      MatchNode(ArrayNode.name, Seq(
        MatchAny(Some("data"))
      ))
    ))
  )

  //////////////////////////////////////////////

  val SortArray = Transform(
    "SortArray",
    MatchNode(ArrayNode.name, Seq(
      MatchAny(Some("data"))
    )),
    MatchNode(SortedArrayNode.name, Seq(
      MatchAny(Some("sorted"))
    )),
    Map("sorted" -> Var("data")),
    Void(FunctionCall("std::sort", Seq(Begin(Var("sorted")), End(Var("sorted")))))
  )

  val MergeBTrees = Transform(
    "MergeSortedBTrees",
    MatchNode(BTreeNode.name, Seq(
      MatchNode(SortedArrayNode.name, Seq(
        MatchAny(Some("lhs"))
      )),
      MatchAny(),
      MatchNode(SortedArrayNode.name, Seq(
        MatchAny(Some("rhs"))
      ))
    )),
    MatchNode(SortedArrayNode.name, Seq(
      MatchAny(Some("merged"))
    )), 
    Map("merged" -> Var("lhs")),
    Void(FunctionCall("append", Seq(Var("merged"), Var("rhs"))))
  )

  val PivotLeft = Transform(
    "PivotLeft",
    MatchNode(BTreeNode.name, Seq(
      MatchAny(Some("a")),
      MatchAny(Some("sep1")),
      MatchNode(BTreeNode.name, Seq(
        MatchAny(Some("b")),
        MatchAny(Some("sep2")),
        MatchAny(Some("c"))
      ))
    )),
    MatchNode(BTreeNode.name, Seq(
      MatchNode(BTreeNode.name, Seq(
        MatchAny(Some("a")),
        MatchAny(Some("sep1")),
        MatchAny(Some("b"))
      )),
      MatchAny(Some("sep2")),
      MatchAny(Some("c"))
    )) 
  )

  val PivotRight = PivotLeft.invertAs("PivotRight")

  //////////////////////////////////////////////


  val definition = Definition(
    nodes = Seq(
      ArrayNode,
      SortedArrayNode,
      ConcatNode,
      BTreeNode
    ),
    accessors = Seq(
      GetByKey,
      Size
    ),
    mutators = Seq(
      Insert
    ),
    transforms = Seq(
      SortArray,
      MergeBTrees,
      PivotLeft,
      PivotRight
    ),
    includes = Seq("int_record.hpp")
  )



}