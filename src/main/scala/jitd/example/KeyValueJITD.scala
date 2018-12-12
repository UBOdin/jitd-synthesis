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
  def ArraySize(t:Expression=Var("data")) = StructSubscript(Var("data"), "size()")
  def BlankArrayOfSize(t:Expression) = FunctionCall("std::vector", Seq(t))

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
      ArrayNode.name -> Return( ArraySize(Var("data")) ),
      ////////
      SortedArrayNode.name -> Return( ArraySize(Var("data")) ),
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
    ConstructNode(ConcatNode.name, Seq(
      ConstructExpression(Var("root")),
      ConstructNode(ArrayNode.name, Seq(
        ConstructExpression(Var("data"))
      ))
    ))
  )

  //////////////////////////////////////////////

  val SortArray = Transform(
    "SortArray",
    MatchNode(ArrayNode.name, Seq(
      MatchAny(Some("data"))
    )),
    ConstructNode(SortedArrayNode.name, Seq(
      ConstructExpression(Var("data"), Some("sorted")).andAfter { 
          Void(FunctionCall("std::sort", Seq(Begin(Var("sorted")), End(Var("sorted")))))
        }
    ))
  )

  val CrackArray = Transform(
    "CrackArray",
    MatchNode(ArrayNode.name, Seq(
      MatchAny(Some("data"))
    )),
    ConstructNode(BTreeNode.name, Seq(
      ConstructNode(ArrayNode.name, Seq(
        ConstructExpression(BlankArrayOfSize(ArraySize(Var("data"))), Some("lhs_partition"))
      )),
      ConstructExpression(FunctionCall("pick_separator", Seq(Var("data"))), Some("separator")),
      ConstructNode(ArrayNode.name, Seq(
        ConstructExpression(BlankArrayOfSize(ArraySize(Var("data"))), Some("rhs_partition"))
      )).andAfter {
        Void(FunctionCall("do_crack", Seq(Var("data"), Var("separator"), Var("lhs_partition"), Var("rhs_partition"))))
      }
    ))
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
    ConstructNode(SortedArrayNode.name, Seq(
      ConstructExpression(Var("lhs"), Some("merged")).andAfter {
        Void(FunctionCall("append", Seq(Var("merged"), Var("rhs"))))
      }
    ))
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
    ConstructNode(BTreeNode.name, Seq(
      ConstructNode(BTreeNode.name, Seq(
        ConstructExpression(Var("a")),
        ConstructExpression(Var("sep1")),
        ConstructExpression(Var("b"))
      )),
      ConstructExpression(Var("sep2")),
      ConstructExpression(Var("c"))
    )) 
  )

  val PivotRight = PivotLeft.invertAs("PivotRight")

  val PushDownAndCrack = Transform(
    "PushDownAndCrack",
    MatchNode(ConcatNode.name, Seq(
      MatchNode(BTreeNode.name, Seq(
        MatchAny(Some("a")),
        MatchAny(Some("separator")),
        MatchAny(Some("b"))
      )),
      MatchNode(ArrayNode.name, Seq(
        MatchAny(Some("data"))
      ))
    )),
    ConstructNode(BTreeNode.name, Seq(
      ConstructNode(ConcatNode.name, Seq(
        ConstructExpression(Var("a")),
        ConstructNode(ArrayNode.name, Seq(
          ConstructExpression(BlankArrayOfSize(ArraySize(Var("data"))), Some("lhs_partition"))
        ))
      )),
      ConstructExpression(Var("separator")),
      ConstructNode(ConcatNode.name, Seq(
        ConstructExpression(Var("a")),
        ConstructNode(ArrayNode.name, Seq(
          ConstructExpression(BlankArrayOfSize(ArraySize(Var("data"))), Some("rhs_partition"))
        ))
      )).andAfter {
        Void(FunctionCall("do_crack", Seq(Var("data"), Var("separator"), Var("lhs_partition"), Var("rhs_partition"))))
      }
    ))
  )

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
      CrackArray,
      MergeBTrees,
      PivotLeft,
      PivotRight,
      PushDownAndCrack
    ),
    includes = Seq("int_record.hpp")
  )



}