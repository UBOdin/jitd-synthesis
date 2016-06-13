
open ListUtils
open Type
open Expression
open Value

type scope_t = value_t StringMap.t
type context_t = expr_t * scope_t
exception EvalError of string * context_t


let cog_constructors (): (var_t * value_t) list =
  List.map (fun cog_name -> 
    (* print_endline ("COG: "^cog_name); *)
    (cog_name, (VFunction(
      Cog.field_types cog_name,
      TCog(Some(cog_name)),
      Value.mk_handle cog_name
    )))
  ) (Cog.all_cogs ())
;;

let app_globals:(string * value_t) list ref = ref [];;
let add_app_global (name, v) = app_globals := (name, v) :: !app_globals;;

let global_scope (): scope_t = 
  ListUtils.mk_map (List.flatten [
      cog_constructors();
      FunctionLibrary.all_functions();
      !app_globals;
    ]
  )
;;

let make_scope (vars : (string * value_t) list) =
  List.fold_left (fun map (vname, vval) -> StringMap.add vname vval map)
                 (global_scope()) 
                 vars
;;
let string_of_scope (scope: scope_t): string =
  "{{ \n"^(String.concat "\n" (
    List.map (fun (var_name, var_value) -> 
                ("    "^var_name ^ " -> " ^ (string_of_value var_value)))
             (StringMap.bindings scope)
  ))^"}}"
;;

let construct_type_scope (scope:scope_t): jf_t StringMap.t =
  StringMap.map type_of_value scope
;;
let global_type_scope (): jf_t StringMap.t =
  StringMap.map type_of_value (global_scope())
;;

let rec eval ?(trace = false) ?(scope:scope_t = (global_scope ())) 
       (eval_expr:expr_t): value_t =
  if trace then (
    print_endline ("Enter: "^(string_of_expr eval_expr));
    print_endline ("Scope: "^(string_of_scope scope));
  );
  let rcr = eval ~trace:trace ~scope:scope in 
  let rcr_s s = eval ~trace:trace ~scope:(add_all_to_map s scope) in
  let explode msg = 
    raise (EvalError(msg, (eval_expr, scope)))
  in let escalate  ((int_op: int -> int -> const_t),
             (flt_op: float -> float -> const_t))
            (a_val: value_t) (b_val: value_t) =
    VPrimitive(match (a_val,b_val) with 
      | (VPrimitive(CInt(a)), VPrimitive(CInt(b)))     -> int_op a b
      | (VPrimitive(CFloat(a)), VPrimitive(CInt(b)))   -> flt_op a (float_of_int b)
      | (VPrimitive(CInt(a)), VPrimitive(CFloat(b)))   -> flt_op (float_of_int a) b
      | (VPrimitive(CFloat(a)), VPrimitive(CFloat(b))) -> flt_op a b
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
  | ELet(var_name, var_defn, body) ->
    rcr_s [ var_name, rcr var_defn ] body
  | EAsA(e, t) ->
    rcr e

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
      | VHandle(type_body) -> (fst !type_body, snd !type_body)
      | _ -> explode "Invalid rewrite replacement"
    end in
    tgt_handle := replacement_cog;
    VUnit
  | ENeg(e) -> VPrimitive(CBool(not (Value.cast_to_bool (rcr e))))
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
    VPrimitive(CBool((Value.cast_to_bool (rcr a)) && (Value.cast_to_bool (rcr b))))
  | EArithOp(AOr, a, b) -> 
    VPrimitive(CBool((Value.cast_to_bool (rcr a)) || (Value.cast_to_bool (rcr b))))
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
  | EConst(c) -> VPrimitive(c)
  | EVar(v) -> 
    begin try
      StringMap.find v scope
      with Not_found -> explode ("Missing Variable: "^v)
    end
  | EIsA(e, t) -> VPrimitive(CBool(is_a (Value.type_of_value (rcr e)) t))
  | EList(elems) -> VList(List.map rcr elems)
  | ESubscript(value, subscript) -> 
    Value.subscript (rcr value) (rcr subscript)
  | ELambda(arg_defns, body) -> 
    VFunction(
      List.map snd arg_defns, 
      Typechecker.typeof ~scope:(List.fold_left 
                            (fun folded_scope (n,t) -> StringMap.add n t folded_scope)
                            (global_type_scope())
                            arg_defns
                          ) 
                         ~globals:(global_type_scope()) 
                         body,
      (fun args -> 
        let fn_scope = 
          make_scope (
            List.map2 (fun (arg_name,_) arg_val -> 
                        (arg_name, arg_val))
                  arg_defns args
          )
        in eval ~scope:fn_scope body
      )
    )
  with 
    | Not_found -> Printexc.print_backtrace stdout; explode "Not Found"
    | Value.CastError(v, t) ->
      explode ("Could not cast "^(string_of_value v)^" to "^(string_of_type t))

;;