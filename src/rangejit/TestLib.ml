open Type
open Value
open SimulationParameters
;;

let init(jitd: JITD.jitd_t) = (
  FunctionLibrary.define_fn "INSERT"
    ([data_type; TList(key_type)], TNone)
    (function 
      | [ data; VList(keys) ] -> 
        let new_data = 
          List.map (fun k -> (unbox_key k, unbox_data data)) keys
        in 
          JITD.insert jitd new_data;
          VUnit
      | args -> 
        raise (FunctionLibrary.ArgError([TCog(None); data_type; TList(key_type)], args))
    )
)