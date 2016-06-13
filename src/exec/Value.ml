
open ListUtils
open Type
open Expression
open Cog

type value_t =
  | VPrimitive of const_t
  | VFunction of (jf_t list * jf_t * (value_t list -> value_t))
  | VHandle of (cog_type_t * tuple_t) ref
  | VCog of cog_type_t * tuple_t
  | VTuple of tuple_t
  | VList of value_t list
  | VUnit
and tuple_t = value_t StringMap.t

let rec type_of_value: value_t -> jf_t = function
	| VPrimitive(c) -> TPrimitive(Expression.type_of_const c)
	| VFunction(arg_t, ret_t, defn) -> TFn(arg_t, ret_t)
	| VHandle(handle) -> 
		begin match !handle with
			| (cog_type, body) -> TCog(Some(cog_type))
		end
	| VCog(cog_type, body)    -> TCog(Some(cog_type))
	| VTuple(body) -> 
		TTuple(
			StringMap.fold (fun field_name field_val rest ->
				(field_name, type_of_value field_val) :: rest
			) body []
		)
	| VList([]) -> TList(TAny)
	| VList(vals) -> TList(type_of_value (List.hd vals))
	| VUnit -> TNone
;;

exception CastError of value_t * jf_t;;

let cast_to_string: value_t -> string = function
	| VPrimitive(CString(v)) -> v
	| v -> raise (CastError(v, TPrimitive(TString)))
;;
let cast_to_int: value_t -> int = function
	| VPrimitive(CInt(v)) -> v 
	| v -> raise (CastError(v, TPrimitive(TInt)))
;;
let cast_to_bool: value_t -> bool = function
	| VPrimitive(CBool(v)) -> v 
	| v -> raise (CastError(v, TPrimitive(TBool)))
;;
let cast_to_cog (base: value_t): (string * tuple_t) =
	match base with
		| VHandle(data) -> !data
		| VCog(cog_type, data) -> (cog_type, data)
		| _ -> raise (CastError(base, TCog(None)))
;;
let cast_to_list (base: value_t): (value_t list) =
	match base with 
		| VList(data) -> data
		| _ -> raise (CastError(base, TList(TAny)))
;;

let subscript (base:value_t) (idx: value_t): value_t =
	match base with 
		| VHandle(cog) -> 
			StringMap.find (cast_to_string idx) (snd !cog)
		| VCog(_, cog) -> 
			StringMap.find (cast_to_string idx) cog
		| VTuple(tuple) ->
			StringMap.find (cast_to_string idx) tuple
		| VList(l) ->
			List.nth l (cast_to_int idx)
		| _ -> raise Not_found
;;

let rec string_of_value: value_t -> string = function
	| VPrimitive(c) -> 
		Expression.string_of_const c
	| VFunction(arg_t, ret_t, defn) -> 
		"[("^(String.concat ", " (List.map string_of_type arg_t))^
			") -> "^(string_of_type ret_t)^"]"
	| VHandle(handle) -> 
		(* print_endline "handle"; *)
		let (cog_type, body) = !handle
		in "{{ "^(string_of_value (VCog(cog_type, body)))^" }}"
	| VCog(cog_type, body) -> 
		(* print_endline ("cog: "^cog_type); *)
		cog_type^(string_of_value (VTuple(body)))
	| VTuple(body) -> 
		(* print_endline "tuple"; *)
		"("^(String.concat ", " (List.map 
					(fun (k, v) -> k^" -> "^(string_of_value v))
					(StringMap.bindings body)
		    ))^")"
	| VList(vals) -> 
		"[ "^(String.concat ", " (List.map string_of_value vals))^" ]"
	| VUnit -> "ø"
;;

let mk_cog_body (t:cog_type_t) (fields:value_t list): tuple_t =
	ListUtils.mk_map (
		List.map2 (fun field_name field_value -> 
								(* print_endline ("  "^field_name);  *)
								(* print_endline ("     "^(string_of_value field_value)); *)
								(field_name, field_value)) 
				  (Cog.field_names t) fields
	)
;;
let mk_cog (t:cog_type_t) (fields:value_t list): value_t =
	VCog(t, mk_cog_body t fields)
;;
let mk_handle (t:cog_type_t) (fields:value_t list): value_t =
	VHandle(ref (t, mk_cog_body t fields))
;;
