
open ListUtils
open Type
open Expression

type scope_t = expr_t StringMap.t
type context_t = expr_t * scope_t
exception EvalError of string * context_t

type value_t =
  | VPrim of const_t
  | VFunction of (value_t list -> value_t)
  | VHandle of tuple_t ref ref
  | VCog of tuple_t ref
  | VTuple of tuple_t
  | VList of value_t list
and tuple_t = value_t StringMap.t


let default_scope (): scope_t = StringMap.empty

let rec eval ?(scope:expr_t = (default_scope())) 
			 (eval_expr:expr_t): const_t =
	let rcr = eval ~scope:scope in 
	let rcr_s s = eval ~scope:(add_all_to_map s scope) in
	let explode msg = 
		raise EvalError(msg, eval_expr, scope)
	in match eval_expr with
	| EIfThenElse(cond_clause, then_clause, else_clause) ->
		if (
			match rcr cond_clause with CBool(b) -> b 
				| _ -> explode "Expected bool in if condition"
		) then rcr then_clause else rcr else_clause
	| EBlock([]) -> explode "Empty block"
	| EBlock(cmd :: []) -> rcr cmd
	| EBlock(cmd :: rest) -> 
		let _ = rcr cmd in rcr (EBlock(rest))
	| ELet(var_name, _, var_defn, body) ->
		rcr_s [ var_name, rcr var_defn ] body
	| ECall(defn, args) -> 
		begin match rcr defn with
			| VFunction(fn) -> fn(List.map rcr args)
			| _ -> explode "Not a function"
		end
	| 
;;