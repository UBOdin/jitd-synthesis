open Type
open Value
open Expression
open SimulationParameters
;;

let init () = (
  FunctionLibrary.define_fn "SORT" 
    ([TList(record_type)], TList(record_type)) 
    (function
      | [VList(records)] -> 
          VList(
            List.map box_record 
                     (sort_buffer (List.map unbox_record records))
          )
      | args -> raise (FunctionLibrary.ArgError([TList(record_type)], args))
    )
  ;

  FunctionLibrary.define_fn "PRINT"
    ([TAny], TNone)
    (fun args -> print_endline (string_of_value (List.hd args)); VUnit)
  ;

  FunctionLibrary.define_fn "SPLIT"
    ([key_type; TList(record_type)], 
      TList(TCog(Some(CogTypes.tree_cog))))
    (function
      | [split_key_boxed; VList(records)] -> 
          let split_key = unbox_key split_key_boxed in
          let (low, high) = 
            List.partition 
              (fun r -> split_key > (fst (unbox_record r)))
              records
          in
            (* CogTypes.mk_tree split_key (VList(low)) (VList(high)) *)
            VList([VCog(CogTypes.tree_cog,ListUtils.mk_map [
                                      "SEP",split_key_boxed;
                                      "LHS", VList(low);
                                      "RHS", VList(high)
                                    ])])

      | args -> raise (FunctionLibrary.ArgError([key_type; TList(record_type)], args))
    )
  ;
(* 
  FunctionLibrary.define_fn "SPLIT"
    ([key_type; TList(record_type)], 
      TTuple(["LOW", TList(record_type); "HIGH", TList(record_type)]))
    (function
      | [split_key_boxed; VList(records)] -> 
          let split_key = unbox_key split_key_boxed in
          let (low, high) = 
            List.partition 
              (fun r -> split_key > (fst (unbox_record r)))
              records
          in
            VTuple(ListUtils.mk_map [ 
              "LOW",  VList(low);
              "HIGH", VList(high)
            ])
      | args -> raise (FunctionLibrary.ArgError([key_type; TList(record_type)], args))
    )
  ;
 *)
  FunctionLibrary.define_fn "SIZEOF" 
    ([TList(record_type)], TPrimitive(TInt)) 
    (function
      | [VList(records)] -> VPrimitive(CInt(List.length records))
      | args -> raise (FunctionLibrary.ArgError([TList(record_type)], args))
    )
  ;
)