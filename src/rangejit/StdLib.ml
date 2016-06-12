open Type
open Value
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
)