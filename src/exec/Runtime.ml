
open ListUtils
open Type
open Expression
open Value

type scope_t = value_t StringMap.t
type context_t = expr_t * scope_t
exception EvalError of string * context_t


let cog_constructors (): (var_t * value_t) list =
  List.map (fun cog_name -> 
    (cog_name, (VFunction(
      Cog.field_types cog_name,
      TCog(Some(cog_name)),
      Value.mk_cog cog_name
    )))
  ) (Cog.all_cogs ())
;;

let default_scope (): scope_t = 
  ListUtils.mk_map (cog_constructors()) 
;;

let make_scope (vars : (string * value_t) list) =
  List.fold_left (fun map (vname, vval) -> StringMap.add vname vval map)
                 (default_scope()) 
                 vars
;;

let construct_type_scope (scope:scope_t): jf_t StringMap.t =
  StringMap.map type_of_value scope
;;

let rec eval ?(scope:scope_t = (default_scope ())) 
       (eval_expr:expr_t): value_t =
  let rcr = eval ~scope:scope in 
  let rcr_s s = eval ~scope:(add_all_to_map s scope) in
  let explode msg = 
    raise (EvalError(msg, (eval_expr, scope)))
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
  in 
  try match eval_expr with
  | EIfThenElse(cond_clause, then_clause, else_clause) ->
    if (Value.cast_to_bool (rcr cond_clause)) 
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
  | ENeg(e) -> VPrim(CBool(not (Value.cast_to_bool (rcr e))))
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
    VPrim(CBool((Value.cast_to_bool (rcr a)) && (Value.cast_to_bool (rcr b))))
  | EArithOp(AOr, a, b) -> 
    VPrim(CBool((Value.cast_to_bool (rcr a)) || (Value.cast_to_bool (rcr b))))
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
  | EIsA(e, t) -> VPrim(CBool(is_a (Value.type_of_value (rcr e)) t))
  | EList(elems) -> VList(List.map rcr elems)
  | ESubscript(value, subscript) -> 
    Value.subscript (rcr value) (rcr subscript)
  | ELambda(arg_defns, body) -> 
    VFunction(
      List.map snd arg_defns, 
      Typechecker.typeof ~scope:(ListUtils.mk_map arg_defns) body,
      (fun args -> 
        let fn_scope = 
          ListUtils.mk_map (
            List.map2 (fun (arg_name,_) arg_val -> 
                        (arg_name, arg_val))
                  arg_defns args
          )
        in eval ~scope:fn_scope body
      )
    )
  with 
    | Not_found -> explode "Not Found"
    | Value.CastError(v, t) ->
      explode ("Could not cast "^(string_of_value v)^" to "^(string_of_type t))

;;