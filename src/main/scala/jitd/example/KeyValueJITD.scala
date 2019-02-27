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
  Def("copy_delete_array",record.array, record.array, record.array)
  Def("append", record.array, record.array)
  Def("remove",record.array,record.array)
  Def(key, "pick_separator", record.array)

  //////////////////////////////////////////////

  Node( "Array",       "data" -> record.array )
  Node( "SortedArray", "data" -> record.array )
  Node( "Concat",      "lhs"  -> node, "rhs" -> node )
  Node( "Delete",      "lhs"  -> node, "rhs" -> node )
  Node( "BTree",       "lhs"  -> node, "sep" -> key, "rhs" -> node )
  
  //Node( "Delete",      "listptr"  -> node, "data" -> record.array )

  //////////////////////////////////////////////

  def Begin(t:Expression)            = "std::begin".call(t)
  def End(t:Expression)              = "std::end".call(t)
  def ArraySize(t:Expression)        = "array_size".call(t)
  def BlankArray                     = "std::vector<Record>".call()

  //////////////////////////////////////////////

  Accessor("get")( "target"  -> key )( "result"  -> record )(
    "Array"        -> Return { "record_scan".call("data", "target", "result") },
    "SortedArray"  -> Return { "record_binary_search".call("data", "target", "result") }, 
    "Concat"       -> If( Delegate("lhs") ) { Return(true) } { Return { Delegate("rhs") } },
    "BTree"        -> If( "target" lt "sep" ) { Return { Delegate("lhs") } } { Return { Delegate("rhs") } }, 
    "Delete"       -> If( Delegate("rhs") ) { Return(true) } { Return { Delegate("lhs") } }
    //if it returns true from rhs the element is a part of delete list so dont check lhs and get should return false as it is not a part of the structure.
  )

  Accessor("size", int)()()(
    "Array"       -> Return { ArraySize("data") },
    "SortedArray" -> Return { ArraySize("data") },
    "Concat"      -> Return { Delegate( "lhs" ) plus Delegate("rhs") },
    "BTree"       -> Return { Delegate( "lhs" ) plus Delegate("rhs") },
    "Delete"      -> Return { Delegate( "lhs" ) minus Delegate("rhs") }//check logic doesnt return a neg value.
  )

  //////////////////////////////////////////////

  Mutator("insert")("data" -> record.array ) {
    "Concat".fromFields( "root", "Array".fromFields("data") )
  }
  Mutator("Delete")("data" -> record.array ) {
    "Delete".fromFields("root","Array".fromFields("data") )
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
  // Transform("MergeDeleteNodes") {
  //   "Delete" withFields( 
  //     "Array".withFields( "lhs" ),
  //     Any,
  //     "Array".withFields( "rhs" )
  //   )
  // } {
  //   "Array" fromFields("lhs" as "deleted") andAfter (
  //     "remove".call("deleted", "rhs")
  //   )
  // }
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
  Transform("PushDownAndDelete")
  {
    "Delete" withFields(
      "BTree" withFields( "a", "separator", "b" ),
      "Array" withFields( "data" )
    )
  } {
    "BTree" fromFields(
      "Delete" fromFields( "a", "Array" fromFields(
        BlankArray as "lhs_partition"
      )),
      "separator",
      "Delete" fromFields( "b", "Array" fromFields(
          BlankArray as "rhs_partition"
      ))
    ) andAfter(
      "copy_delete_array".call("data", "lhs_partition", "rhs_partition")
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