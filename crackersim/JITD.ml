open Type
open Runtime
open Value
open Expression
open ListUtils
open CogTypes
open SimulationParameters
open Iterators

type handler_t = expr_t

type event_t =
  | BEFORE_INSERT
  | AFTER_INSERT
  | BEFORE_DELETE
  | AFTER_DELETE
  | BEFORE_ROOT_ITERATOR
  | BEFORE_ITERATOR
  | ON_IDLE

type policy_t = (event_t * handler_t) list

type jitd_t = {
  data : (Cog.cog_type_t * tuple_t) ref; 
  handlers : policy_t;
}

let init (policy: policy_t): jitd_t = 
  { data = ref (mk_sorted []);
    handlers = policy;
  }

let invoke (call: expr_t) (args: (string * value_t) list) =
  ignore ( Runtime.eval 
    ~scope:(Runtime.make_scope args)
    (ECall(call, (List.map (fun (v, _) -> EVar(v)) args)))
  )
;;

let call_handler (jitd: jitd_t) (event: event_t) (args: expr_t list): unit =
  try 
    invoke (List.assoc event jitd.handlers) 
           ["__ROOT", (VHandle(jitd.data))]
  with Not_found -> ()


let insert (jitd: jitd_t) (buffer: record_t list): unit = (
  call_handler jitd BEFORE_INSERT [];
  jitd.data := 
    (mk_concat (VHandle(jitd.data)) (VHandle(ref (mk_array buffer))));
  call_handler jitd AFTER_INSERT []
);;

let iterator (jitd: jitd_t): iterator_t = (
  call_handler jitd BEFORE_ROOT_ITERATOR [];
  let callback = 
    try 
      let handler = 
        (List.assoc BEFORE_ITERATOR jitd.handlers)
      in 
        (fun (node: value_t) -> 
          invoke handler ["__ROOT", node])
    with Not_found -> (fun (node: value_t) -> ())
  in 
    LazyIterator(callback, (VHandle(jitd.data)))
);;

let idle (jitd: jitd_t): unit = (
  call_handler jitd ON_IDLE []
)
