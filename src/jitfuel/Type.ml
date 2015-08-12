
type var_t = string

type prim_t =
  | TInt
  | TFloat
  | TString
  | TBool

type jf_t = 
  | TAny
  | TNone
  | TCog of string option
  | TList of int * jf_t
  | TMap of jf_t * jf_t
  | TTuple of (string * jf_t) list
  | TPrimitive of prim_t
  | TFn of jf_t list * jf_t
  | TCustom of string

let string_of_primitive = function
  | TInt    -> "int"
  | TFloat  -> "float"
  | TString -> "string"
  | TBool   -> "bool"
;;

let rec string_of_type = function
  | TAny -> "_"
  | TNone -> "#"
  | TCog(None) -> "cog"
  | TCog(Some(s)) -> "<"^s^">"
  | TList(cnt, t) -> "["^(string_of_int cnt)^"*"^(string_of_type t)^"]"
  | TMap(k,t) -> "["^(string_of_type k)^"->"^(string_of_type t)^"]"
  | TTuple(kl) -> "{"^(
      String.concat ", " (
        List.map 
          (fun (fn,ft) -> fn^"->"^(string_of_type ft))
          kl
      ))^"}"
  | TPrimitive(p) -> string_of_primitive p
  | TFn(args,ret_t) -> 
    "("^
    (String.concat ", " (List.map string_of_type args))^
    " -> "^
    (string_of_type ret_t)^
    ")"
  | TCustom(ct) -> "`"^ct^"`"
;;

let string_of_typed_var ((v,t):(var_t * jf_t)): string = v^":"^(string_of_type t);;