
open ListUtils
open Type
open Expression

type cog_type_t = string

type value_t =
  | VPrim of const_t
  | VFunction of (jf_t list * jf_t * (value_t list -> value_t))
  | VHandle of (cog_type_t * tuple_t ref) ref
  | VCog of cog_type_t * (tuple_t ref)
  | VTuple of tuple_t
  | VList of value_t list
  | VUnit
and tuple_t = value_t StringMap.t

type scope_t = value_t StringMap.t
type context_t = expr_t * scope_t
exception EvalError of string * context_t


let default_scope (): scope_t = StringMap.empty

let rec type_of_value: value_t -> jf_t = function
	| VPrim(c) -> TPrimitive(Expression.type_of_const c)
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
	| VList([]) -> TList(0, TAny)
	| VList(vals) -> TList(List.length vals, type_of_value (List.hd vals))
	| VUnit -> TNone
;;

let rec eval ?(scope:scope_t = (default_scope())) 
			 (eval_expr:expr_t): value_t =
	let rcr = eval ~scope:scope in 
	let rcr_s s = eval ~scope:(add_all_to_map scope s) in
	let explode msg = 
		raise (EvalError(msg, (eval_expr, scope)))
	in let cast_bool: value_t -> bool =
		function VPrim(CBool(b)) -> b | _ -> explode "Expected a boolean"
	in let escalate  ((int_op: int -> int -> const_t),
			       (flt_op: float -> float -> const_t))
			      (a_val: value_t) (b_val: value_t) =
		VPrim(match (a_val,b_val) with 
		  | (VPrim(CInt(a)), VPrim(CInt(b)))     -> int_op a b
		  | (VPrim(CFloat(a)), VPrim(CInt(b)))   -> flt_op a (float_of_int b)
		  | (VPrim(CInt(a)), VPrim(CFloat(b)))   -> flt_op (float_of_int a) b
		  | (VPrim(CFloat(a)), VPrim(CFloat(b))) -> flt_op a b
		  | _ -> explode "Invalid Arithmetic"
		)
	in let escalate_arith ((int_op: int -> int -> int),
					       (flt_op: float -> float -> float)) =
		escalate ((fun a b -> CInt(int_op a b)), 
				  (fun a b -> CFloat(flt_op a b)))
	in let escalate_cmp ((int_op: int -> int -> bool),
					     (flt_op: float -> float -> bool)) =
		escalate ((fun a b -> CBool(int_op a b)), 
				  (fun a b -> CBool(flt_op a b)))
	in match eval_expr with
	| EIfThenElse(cond_clause, then_clause, else_clause) ->
		if (cast_bool (rcr cond_clause)) 
		then rcr then_clause else rcr else_clause
	| EBlock([]) -> explode "Empty block"
	| EBlock(cmd :: []) -> rcr cmd
	| EBlock(cmd :: rest) -> 
		let _ = rcr cmd in rcr (EBlock(rest))
	| ELet(var_name, _, var_defn, body) ->
		rcr_s [ var_name, rcr var_defn ] body
	| ECall(defn, args) -> 
		begin match rcr defn with
			| VFunction(_, _, fn) -> fn(List.map rcr args)
			| _ -> explode "Not a function"
		end
	| ERewrite(tgt, replacement) -> 
		let tgt_handle = begin match rcr (EVar(tgt)) with
			| VHandle(h) -> h
			| _ -> explode "Invalid rewrite target"
		end in
		let replacement_cog = begin match rcr replacement with
			| VCog(ctype, cbody) -> (ctype,cbody)
			| _ -> explode "Invalid rewrite replacement"
		end in
		tgt_handle := replacement_cog;
		VUnit
	| ENeg(e) -> VPrim(CBool(not (cast_bool (rcr e))))
	| EArithOp((APlus | AMinus | ATimes | ADiv) as op, a, b) ->
		escalate_arith (
			match op with 
				| APlus  -> ((fun a b -> a + b), (fun a b -> a +. b))
				| AMinus -> ((fun a b -> a - b), (fun a b -> a -. b))
				| ATimes -> ((fun a b -> a * b), (fun a b -> a *. b))
				| ADiv   -> ((fun a b -> a / b), (fun a b -> a /. b))
				| _ -> explode "Internal Error"
		) (rcr a) (rcr b)
	| EArithOp(AAnd, a, b) -> 
		VPrim(CBool((cast_bool (rcr a)) && (cast_bool (rcr b))))
	| EArithOp(AOr, a, b) -> 
		VPrim(CBool((cast_bool (rcr a)) || (cast_bool (rcr b))))
	| ECmpOp(op, a, b) -> 
		escalate_cmp (
			match op with 
				| CmpEq  -> ((fun a b -> a =  b), (fun a b -> a =  b))
				| CmpNeq -> ((fun a b -> a <> b), (fun a b -> a <> b))
				| CmpLt  -> ((fun a b -> a <  b), (fun a b -> a <  b))
				| CmpGt  -> ((fun a b -> a >  b), (fun a b -> a >  b))
				| CmpLte -> ((fun a b -> a <= b), (fun a b -> a <= b))
				| CmpGte -> ((fun a b -> a >= b), (fun a b -> a >= b))
		) (rcr a) (rcr b)
	| EConst(c) -> VPrim(c)
	| EVar(v) -> StringMap.find v scope
	| EIsA(e, t) -> explode "ISA Unimplemented"
	| ESubscript(value, subscript) -> explode "Subscript unimplemented"
	| ELambda(args, body) -> explode "Lambda unimplemented"

;;