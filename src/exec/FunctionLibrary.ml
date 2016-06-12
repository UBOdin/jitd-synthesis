open Type
open Value
open ListUtils

type function_t = {
  args    : jf_t list;
  returns : jf_t;
  impl    : (value_t list -> value_t)
}

exception ArgError of jf_t list * value_t list

let global_functions: function_t StringMap.t ref = ref StringMap.empty;;

let define_fn (name: string) 
              ((args, ret): (jf_t list * jf_t))
              (impl:(value_t list -> value_t)): unit =
  global_functions := StringMap.add name {
    args    = args;
    returns = ret;
    impl    = impl;
  } (!global_functions)
;;

let invoke (name: string) (args: value_t list): value_t =
  ((StringMap.find name !global_functions).impl) args
;;

let schema (name: string): (jf_t list * jf_t) = 
  let { args = args ; returns = ret; } = StringMap.find name !global_functions
  in (args, ret)
;;

let all_functions (): (string * value_t) list = 
  List.map (fun (name, { args = args; returns = ret; impl = impl; }) -> 
    (name, VFunction(args, ret, impl))
  ) (StringMap.bindings !global_functions)
;;