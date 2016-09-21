
type var_t = string

type prim_t =
  | TInt
  | TFloat
  | TString
  | TBool

type jf_t = 
  | TAny
  | TNone
  | TPhyCog of string
  | TLogCog
  | TList of jf_t
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
  | TLogCog -> "cog"
  | TPhyCog(s) -> "<"^s^">"
  | TList(t) -> "["^(string_of_type t)^"]"
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

let rec is_a (src_t: jf_t) (cmp_t: jf_t): bool =
  match (src_t, cmp_t) with
    | (_, TAny)      -> true
    | (TNone, TNone) -> true
    | (TNone, _)     -> false
    | (TPhyCog(_), TLogCog) -> true
    | (TLogCog, TPhyCog(_)) -> false
    | (TPhyCog(ct1), TPhyCog(ct2)) -> ct1 = ct2
    | (TList(v1), TList(v2)) -> is_a v1 v2
    | (TMap(k1, v1), TMap(k2, v2)) -> (is_a k1 k2) && (is_a v1 v2)
    | (TTuple(kv1), TTuple(kv2)) -> 
        List.for_all (fun (k2, v2) ->      (* For each element of kv2... *)
            (List.mem_assoc k2 kv1) &&     (* kv1 should have each of kv2's keys *)
            (is_a (List.assoc k2 kv1) v2)  (* and kv2's value type should be a subset of kv1's type *)
          ) kv2
    | (TPrimitive(p1), TPrimitive(p2)) -> p1 = p2
    | (TFn(args1, ret1), TFn(args2, ret2)) -> (List.for_all2 is_a args1 args2) && (is_a ret1 ret2)
    | (TCustom(c1), TCustom(c2)) -> c1 = c2
    | (_, _) -> false
;;
