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
  Def("array_copy",record.array, record.array, record.array)
  //Def("copy_delete_array_btree",record.array, key, record.array, record.array)
  Def("append", record.array, record.array)
  //Def("appendConcat",record.array,record.array)
  Def("remove",record.array,record.array)
  //Def("delete_from_sorted_array",record.array,record.array)
  Def("delete_from_leaf",record.array,record.array)
  Def(key, "pick_separator", record.array)

  //////////////////////////////////////////////

  Node( "Array",       "data" -> record.array )(
        NodeConstructor(Seq(),Seq("data".call()))
  )
  Node( "SortedArray", "data" -> record.array )(
        NodeConstructor(Seq(),Seq("data".call()))
  )
  Node( "Concat",      "lhs"  -> node, "rhs" -> node )()
  Node( "Delete",      "lhs"  -> node, "rhs" -> node )()
  Node( "BTree",       "lhs"  -> node, "sep" -> key, "rhs" -> node )()
  Node( "DeleteElements",      "node"  -> node, "data" -> record.array )()

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
    "Delete"       -> If( Delegate("rhs") ) { Return(false) } { Return { Delegate("lhs") } },
    "DeleteElements"  -> If( "record_scan".call("data","target","result") ) { Return(false) }{Return{Delegate("node")}}
    //if it returns true from rhs the element is a part of delete list so dont check lhs and get should return false as it is not a part of the structure.
  )

  Accessor("size", int)()()(
    "Array"       -> Return { ArraySize("data") },
    "SortedArray" -> Return { ArraySize("data") },
    "Concat"      -> Return { Delegate( "lhs" ) plus Delegate("rhs") },
    "BTree"       -> Return { Delegate( "lhs" ) plus Delegate("rhs") },
    "Delete"      -> Return { Delegate( "lhs" ) minus Delegate("rhs") },
    "DeleteElements"      -> Return { Delegate( "node" ) minus ArraySize("data") }//check logic doesnt return a neg value.
  //FIX THE SIZE FOR DELETE
  )

  //////////////////////////////////////////////

  Mutator("insert")("data" -> record.array ) {
    "Concat".fromFields( "root", "Array".fromFields("data") )
  }
  Mutator("remove")("data" -> record.array ) {
    "Delete".fromFields("root","Array".fromFields("data") )
  }
  Mutator("remove_elements")("data" -> record.array ) {
    "DeleteElements".fromFields("root","data" )
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
          
      ) as "lhs_partition",
      "pick_separator".call("data") as "separator",
      "Array" fromFields(
       
      ) as "rhs_partition"
    ) andAfter(
      "do_crack".call("data", "separator", NodeSubscript(Var("lhs_partition"),"data"), NodeSubscript(Var("rhs_partition"),"data"))
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
  Transform("MergeSortedConcat") {
    "Concat" withFields( 
      "SortedArray".withFields( "lhs" ),
      
      "SortedArray".withFields( "rhs" )
    )
  } {
    "SortedArray" fromFields("lhs" as "merged") andAfter (
      "append".call("merged", "rhs") 
    ) andAfter ("std::sort".call(Begin("merged"),End("merged")) )
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
        
      )as "lhs_partition"),
      "separator",
      "Concat" fromFields( "b", "Array" fromFields(
          
      )as "rhs_partition")
    ) andAfter(
      "do_crack".call("data", "separator", NodeSubscript(Var("lhs_partition"),"data"), NodeSubscript(Var("rhs_partition"),"data"))
    )
  }
  Transform("PushDownDontDeleteBtree")
  {
    "Delete" withFields(
      "BTree" withFields( "a", "separator", "b" ),
      "Array" withFields( "data" )
    )
  } {
    "BTree" fromFields(
      "Delete" fromFields( "a", "Array" fromFields(
        
      ) as "lhs_partition"),
      "separator",
      "Delete" fromFields( "b", "Array" fromFields(
          
      ) as "rhs_partition")
    ) andAfter(
      "do_crack".call("data","separator", NodeSubscript(Var("lhs_partition"),"data"), NodeSubscript(Var("rhs_partition"),"data"))
    ) 
  }
  Transform("PushDownDontDeleteElemBtree")
  {
    "DeleteElements" withFields("BTree" withFields( "a", "separator", "b" ),"data")
  } {
    "BTree" fromFields(
      "DeleteElements" fromFields( "a", "data"),
      "separator",
      "DeleteElements" fromFields( "b", "data"))
    
  }
  Transform("PushDownDontDeleteConcat")
  {
    "Delete" withFields(
      "Concat" withFields( "a", "b" ),
      "Array" withFields( "data" )
    )
  } {
    "Concat" fromFields(
      "Delete" fromFields( "a", "Array" fromFields(
        
      ) as "lhs_partition"),
      "Delete" fromFields( "b", "Array" fromFields(
          
      ) as "rhs_partition")
    ) andAfter(
      "array_copy".call("data", NodeSubscript(Var("lhs_partition"),"data"), NodeSubscript(Var("rhs_partition"),"data"))
    ) 
  }
  Transform("PushDownDontDeleteElemConcat")
  {
    "DeleteElements" withFields("Concat" withFields( "a", "b" ),"data")
  } {
    "Concat" fromFields(
      "DeleteElements" fromFields( "a", "data"),
      "DeleteElements" fromFields( "b", "data"))
    
  }
  Transform("DeleteFromSortedArray")
  {
    "Delete" withFields("SortedArray" withFields( "data1" ),"SortedArray" withFields( "data2" ))
  } {
    "SortedArray" fromFields( "data1" as "new_sorted_array_after_delete") andAfter(
      "delete_from_leaf".call("new_sorted_array_after_delete", "data2")) 
  }
  Transform("DeleteElemFromSortedArray")
  {
    "DeleteElements" withFields("SortedArray" withFields( "data1" ), "data2" )
  } {
    "SortedArray" fromFields( "data1" as "new_sorted_array_after_delete") andAfter(
      "delete_from_leaf".call("new_sorted_array_after_delete", "data2")) 
  }
  Transform("DeleteFromArray")
  {
    "Delete" withFields("Array" withFields( "data1" ),"Array" withFields( "data2" ))
  } {
    "Array" fromFields( "data1" as "new_array_after_delete") andAfter(
      "delete_from_leaf".call("new_array_after_delete", "data2")) 
  }
  Transform("DeleteElemFromArray")
  {
    "DeleteElements" withFields("Array" withFields( "data1" ), "data2")
  } {
    "Array" fromFields( "data1" as "new_array_after_delete") andAfter(
      "delete_from_leaf".call("new_array_after_delete", "data2")) 
  }
  // Policy("MergeSortedBTrees")("crackAt" -> IntConstant(5),"null_data"-> IntConstant(0))
  // (
  //   "MergeSortedBTrees"
  // )
  Policy("CrackSort")("crackAt" -> IntConstant(100),"null_data"-> IntConstant(0)) (
    //"PushDownAndCrack"            scoreBy { ArraySize("data") }
       ("CrackArray"       onlyIf { ArraySize("data") gte "crackAt" } 
                                  scoreBy { ArraySize("data") })
      //andThen ("PushDownDontDeleteBtree"          scoreBy { ArraySize("data") })
      //andThen ("PushDownDontDeleteElemBtree"          scoreBy { ArraySize("data") })
      //andThen ("PushDownDontDeleteConcat"            scoreBy { ArraySize("data") })
      //andThen ("PushDownDontDeleteElemConcat"          scoreBy { ArraySize("data") })
      //andThen ("SortArray"        scoreBy { ArraySize("data") })
      //andThen ("MergeSortedBTrees")
      //andThen "MergeSortedConcat"
      
     // andThen "MergeDeleteNodes"
     //andThen ("DeleteElemFromArray" scoreBy{ArraySize("data2")})
     //andThen ("DeleteElemFromSortedArray" scoreBy{ArraySize("data2")})
  )

}