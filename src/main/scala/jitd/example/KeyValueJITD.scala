package jitd.example;

import jitd.typecheck.FunctionSignature
import jitd.spec._
import jitd.spec.FieldConversions._
import jitd.spec.StatementConversions._
import jitd.spec.CmpTypes._

object KeyValueJITD extends HardcodedDefinition {

  Import(CppStdLib.functions)
  Def(bool, "record_scan",          record.array, key, record)
  Def(bool, "record_binary_search", record.array, key, record)
  Def("do_crack", record.array, key, record.array, record.array)
  Def("append", record.array, record.array)
  Def(key, "pick_separator", record.array)

  //////////////////////////////////////////////

  Node( "Array",       "data" -> record.array )
  Node( "SortedArray", "data" -> record.array )
  Node( "Concat",      "lhs"  -> node, "rhs" -> node )
  Node( "BTree",       "lhs"  -> node, "sep" -> key, "rhs" -> node )

  //////////////////////////////////////////////

  def Begin(t:Expression)            = "std::begin".call(t)
  def End(t:Expression)              = "std::end".call(t)
  def ArraySize(t:Expression)        = "data".get("size()")
  def BlankArray                     = "std::vector<Record>".call()

  //////////////////////////////////////////////

  Accessor("get")( "target"  -> key )( "result"  -> record )(
    "Array"        -> Return { "record_scan".call("data", "target", "result") },
    "SortedArray"  -> Return { "record_binary_search".call("data", "target", "result") }, 
    "Concat"       -> If( Delegate("lhs") ) { Return(true) } { Return { Delegate("rhs") } },
    "BTree"        -> If( "target" lt "sep" ) { Return { Delegate("lhs") } } { Return { Delegate("rhs") } } 
  )

  Accessor("size", int)()()(
    "Array"       -> Return { ArraySize("data") },
    "SortedArray" -> Return { ArraySize("data") },
    "Concat"      -> Return { Delegate( "lhs" ) plus Delegate("rhs") },
    "BTree"       -> Return { Delegate( "lhs" ) plus Delegate("rhs") }
  )

  //////////////////////////////////////////////

  Mutator("insert")("data" -> record.array ) {
    "Concat".fromFields( "root", "Array".fromFields("data") )
  }

  //////////////////////////////////////////////

  Transform("SortArray") {
    "Array" withFields( "data" )
  } {
    "SortedArray" fromFields( "data" as "sorted") andAfter (
      "std::sort".call( Begin("sorted"), End("sorted") )
    )
  }

  Transform("CrackArray") {
    "Array" withFields( "data" )
  } {
    "BTree" fromFields(
      "Array" fromFields(
        BlankArray as "lhs_partition"
      ),
      "pick_separator".call("data") as "separator",
      "Array" fromFields(
        BlankArray as "rhs_partition"
      )
    ) andAfter(
      "do_crack".call("data", "separator", "lhs_partition", "rhs_partition")
    )
  }

  Transform("MergeSortedBTrees") {
    "BTree" withFields( 
      "SortedArray".withFields( "lhs" ),
      Any,
      "SortedArray".withFields( "rhs" )
    )
  } {
    "SortedArray" fromFields("lhs" as "merged") andAfter (
      "append".call("merged", "rhs")
    )
  }

  Transform("PivotLeft") {
    "BTree" withFields( "a", "sep1", 
      "BTree" withFields( "b", "sep2", "c" ) 
    )
  } {
    "BTree" fromFields( 
      "BTree" fromFields( "a", "sep1", "b" ),
      "sep2", "c"
    )
  }
  InvertedTransform("PivotLeft", "PivotRight")

  Transform("PushDownAndCrack") {
    "Concat" withFields(
      "BTree" withFields( "a", "separator", "b" ),
      "Array" withFields( "data" )
    )
  } {
    "BTree" fromFields(
      "Concat" fromFields( "a", "Array" fromFields(
        BlankArray as "lhs_partition"
      )),
      "separator",
      "Concat" fromFields( "b", "Array" fromFields(
          BlankArray as "rhs_partition"
      ))
    ) andAfter(
      "do_crack".call("data", "separator", "lhs_partition", "rhs_partition")
    )
  }

  Policy("CrackSortMerge")("crackAt" -> IntConstant(10)) (
    "PushDownAndCrack"            scoreBy { ArraySize("data") }
      andThen ("CrackArray"       onlyIf { ArraySize("data") gte "crackAt" } 
                                  scoreBy { ArraySize("data") })
      andThen ("SortArray"        scoreBy { ArraySize("data") })
      andThen "MergeSortedBTrees"
  )

}