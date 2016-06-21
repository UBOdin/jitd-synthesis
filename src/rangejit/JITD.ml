open Type
open Runtime
open Value
open Expression
open ListUtils
open CogTypes
open SimulationParameters
open Iterators

type handler_t = (string list) * expr_t

type event_t =
  | BEFORE_INSERT
  | AFTER_INSERT
  | BEFORE_DELETE
  | AFTER_DELETE
  | BEFORE_ROOT_ITERATOR
  | BEFORE_ITERATOR
  | IDLE
  | TEST

type policy_t = (event_t * handler_t) list

type jitd_t = {
  data : (Cog.cog_type_t * tuple_t) ref; 
  handlers : policy_t;
}

let init (policy: policy_t): jitd_t = 
  { data = ref (mk_sorted []);
    handlers = policy;
  }

let arg_types: (event_t -> jf_t list) = function
  | BEFORE_INSERT        -> [ TCog(None) ]
  | AFTER_INSERT         -> [ TCog(None) ] 
  | BEFORE_DELETE        -> [ TCog(None) ] 
  | AFTER_DELETE         -> [ TCog(None) ] 
  | BEFORE_ROOT_ITERATOR -> [ TCog(None) ] 
  | BEFORE_ITERATOR      -> [ TCog(None) ]
  | IDLE                 -> [ TCog(None) ]
  | TEST                 -> [ TCog(None) ]
;;

let get_handler (jitd: jitd_t) (event: event_t) =
  let (arg_names, handler_body) = 
    List.assoc event jitd.handlers 
  in
    ELambda(List.map2 (fun arg_name arg_type -> (arg_name, arg_type))
                      arg_names (arg_types event),
            handler_body)
;;

let invoke (call: expr_t) (args: (string * value_t) list) =
  ignore ( Runtime.eval 
    ~scope:(Runtime.make_scope args)
    (ECall(call, (List.map (fun (v, _) -> EVar(v)) args)))
  )
;;

let call_handler (jitd: jitd_t) (event: event_t) (args: (string * value_t) list): unit =
  try 
    invoke (get_handler jitd event) 
           (("__ROOT", (VHandle(jitd.data)))::args)
  with Not_found -> ()
;;

let root_handle (jitd: jitd_t): value_t = 
  VHandle(jitd.data)
;;

let insert (jitd: jitd_t) (buffer: record_t list): unit = (
  call_handler jitd BEFORE_INSERT [];
  let old_data = !(jitd.data) in
  jitd.data := 
    (mk_concat (VHandle(ref old_data)) (VHandle(ref (mk_array buffer))));
  call_handler jitd AFTER_INSERT []
);;

let iterator (jitd: jitd_t): iterator_t = (
  call_handler jitd BEFORE_ROOT_ITERATOR [];
  let callback = 
    try 
      let handler = 
        get_handler jitd BEFORE_ITERATOR
      in 
        (fun (node: value_t) -> 
          invoke handler ["__ROOT", node])
    with Not_found -> (fun (node: value_t) -> ())
  in 
    LazyIterator(callback, (VHandle(jitd.data)))
);;

let idle (jitd: jitd_t): unit = (
  call_handler jitd IDLE []
)
;;

let string_of_event_type: event_t -> string = function
  | TEST                 -> "TEST"                
  | IDLE                 -> "IDLE"                
  | BEFORE_ITERATOR      -> "BEFORE_ITERATOR"     
  | BEFORE_ROOT_ITERATOR -> "BEFORE_ROOT_ITERATOR"
  | AFTER_DELETE         -> "AFTER_DELETE"        
  | BEFORE_DELETE        -> "BEFORE_DELETE"       
  | AFTER_INSERT         -> "AFTER_INSERT"        
  | BEFORE_INSERT        -> "BEFORE_INSERT"       
;;

let string_of_jitd ({ data = data; handlers = handlers }: jitd_t): string = (
  String.concat "\n\n" (List.map (fun (event, (args, body)) -> 
    "ON "^(string_of_event_type event)^"("^(String.concat ", " args)^")\n"^
    (string_of_expr (EBlock(Expression.block_list body)))
  ) handlers)
)
;;

exception InvalidEvent of string
type raw_handler_t = string * string list * expr_t
type raw_policy_t = raw_handler_t list

let specialize_handler ((event_name: string), 
                        (args: string list), 
                        (handler_body: expr_t)): (event_t * handler_t) = 
  let event: event_t = 
    match String.uppercase event_name with 
      | "BEFORE_INSERT"        -> BEFORE_INSERT
      | "AFTER_INSERT"         -> AFTER_INSERT
      | "BEFORE_DELETE"        -> BEFORE_DELETE
      | "AFTER_DELETE"         -> AFTER_DELETE
      | "BEFORE_ROOT_ITERATOR" -> BEFORE_ROOT_ITERATOR
      | "BEFORE_ITERATOR"      -> BEFORE_ITERATOR
      | "IDLE"                 -> IDLE
      | "TEST"                 -> TEST
      | _                      -> raise (InvalidEvent(event_name))
  in
    (event, (args, handler_body))
;;

let init_raw (policy: raw_policy_t): jitd_t =
  init (List.map specialize_handler policy)
;;

let merge_policies (policies: policy_t list): policy_t =
  let policy_groups: (event_t * (string list * expr_t) list) list = 
    ListUtils.reduce (List.flatten policies)
  in
    List.map (fun (event, handlers) -> 
      let id = ref 0 in
      let event_schema = 
        List.map (fun t -> id := !id + 1; ("ARG_"^(string_of_int !id), t))
                 (arg_types event)
      in
      let joint_handler = 
        match handlers with 
          | [] -> ((List.map fst event_schema), EBlock([]))
          | [x] -> x
          | _ -> 
            (
              List.map fst event_schema,
              EBlock(
                List.map (fun (handler_args, handler_body) -> 
                  ECall(
                    (ELambda(
                      List.map2 (fun (_, arg_type) arg_name ->
                        (arg_name, arg_type)
                      ) event_schema handler_args,
                      handler_body
                    )),
                    List.map (fun (arg_name, _) -> EVar(arg_name)) event_schema
                  )
                ) handlers
              )
            )
      in 
        (event, joint_handler)
    ) policy_groups
;;

let optimize (scope: expr_t StringMap.t) (policy: policy_t): policy_t = 
  List.map (fun (event, (args, handler)) -> 
              (event, (args, Optimizer.optimize ~scope:scope handler))
  ) policy
;;


