open ListUtils
open Expression
open Type
;;

let rec recur (op:expr_t -> expr_t) = 
  let rcr x = op x in
  function
  | EIfThenElse(i,t,e)            -> EIfThenElse(rcr i, rcr t, rcr e)
  | EBlock(l)                     -> EBlock(List.map rcr l)
  | ELet(var_name, var_val, body) -> ELet(var_name, rcr var_val, rcr body) 
  | EAsA(body, body_type)         -> EAsA(rcr body, body_type)
  | ECall(func_name, args)        -> ECall(rcr func_name, List.map rcr args)
  | ERewrite(target, new_cog)     -> ERewrite(target, rcr new_cog)
  | ENeg(target)                  -> ENeg(rcr target)
  | EArithOp(op, lhs, rhs)        -> EArithOp(op, rcr lhs, rcr rhs)
  | ECmpOp(op, lhs, rhs)          -> ECmpOp(op, rcr lhs, rcr rhs)
  | EConst(c)                     -> EConst(c)
  | EVar(var_name)                -> EVar(var_name)
  | EIsA(target, check_type)      -> EIsA(rcr target, check_type)
  | ESubscript(target, subscript) -> ESubscript(rcr target, rcr subscript)
  | ELambda(args, body)           -> ELambda(args, rcr body)
  | EList(elems)                  -> EList(List.map rcr elems)
;;

let all_children = function
  | EIfThenElse(i,t,e)            -> [i; t; e]
  | EBlock(l)                     -> l
  | ELet(var_name, var_val, body) -> [var_val; body]
  | EAsA(body, body_type)         -> [body]
  | ECall(func_name, args)        -> func_name :: args
  | ERewrite(target, new_cog)     -> [new_cog]
  | ENeg(target)                  -> [target]
  | EArithOp(op, lhs, rhs)        -> [lhs; rhs]
  | ECmpOp(op, lhs, rhs)          -> [lhs; rhs]
  | EConst(c)                     -> []
  | EVar(var_name)                -> []
  | EIsA(target, check_type)      -> [target]
  | ESubscript(target, subscript) -> [target; subscript]
  | ELambda(args, body)           -> [body]
  | EList(elems)                  -> elems
;;

let rec inline_vars ?(scope: expr_t StringMap.t = StringMap.empty) (expr:expr_t): expr_t = 
  let rcr e = inline_vars ~scope:scope e in
  match expr with 
  | EVar(var_name) ->
    (* print_endline ("Replacing var: "^var_name); *)
    if StringMap.mem var_name scope 
      then StringMap.find var_name scope
      else EVar(var_name)
  | ERewrite(var_name, subexp) ->
    let subexp_new = rcr subexp in
    if StringMap.mem var_name scope 
      then 
        begin match StringMap.find var_name scope with
          | EVar(new_name) -> ERewrite(new_name, subexp_new)
          | x -> 
            (* Unusual corner case where we're replacing a rewrite variable by a 
               non-variable value.  This really shouldn't be happening, but we
               can get around it by binding the variable to a new temporary *)
            ELet(
              "TEMP_REWRITE_VAR_TARGET", x, 
              ERewrite("TEMP_REWRITE_VAR_TARGET", subexp_new)
            )
        end
      else ERewrite(var_name, subexp_new)
  | _ -> recur rcr expr
;;

let rec inline_calls (expr:expr_t): expr_t = 
  match expr with 
  | ECall(ELambda(arg_vars, base_body), arg_vals) ->
    List.fold_right2 (fun var_name var_val body -> ELet(var_name, var_val, body)) (List.map fst arg_vars) arg_vals base_body
  | _ -> recur inline_calls expr
;;

let rec is_idempotent (expr: expr_t): bool = 
  match expr with
  | ECall _ -> false
  | _ -> List.fold_left (fun a b -> a && (is_idempotent b)) true (all_children expr)
;;

let rec inline_lets (expr:expr_t): expr_t = 
  match expr with 
  | ELet(var_name, var_val, body) when is_idempotent var_val ->
    inline_vars ~scope:(ListUtils.mk_map [var_name, var_val]) body
  | _ -> recur inline_lets expr
;;

let rec strip_no_ops (expr: expr_t): expr_t =
  match expr with 
  | EAsA(body, TAny) -> body
  | EIsA(body, TAny) -> EConst(CBool(true))
  | EIsA(body, TNone) -> EConst(CBool(false))
  | EArithOp(AAnd, EConst(CBool(true)), x) -> x
  | EArithOp(AAnd, x, EConst(CBool(true))) -> x
  | EArithOp(AAnd, EConst(CBool(false)), x) -> EConst(CBool(false))
  | EArithOp(AAnd, x, EConst(CBool(false))) -> EConst(CBool(false))
  | EArithOp(AOr, EConst(CBool(false)), x) -> x
  | EArithOp(AOr, x, EConst(CBool(false))) -> x
  | EArithOp(AOr, EConst(CBool(true)), x) -> EConst(CBool(true))
  | EArithOp(AOr, x, EConst(CBool(true))) -> EConst(CBool(true))
  | EIfThenElse(EConst(CBool(true)), t, _) -> t
  | EIfThenElse(EConst(CBool(false)), _, e) -> e
  | _ -> recur strip_no_ops expr


let optimize ?(scope: expr_t StringMap.t = StringMap.empty) (expr:expr_t) = 
  let opts = [
    strip_no_ops;
    inline_vars ~scope:scope;
    inline_calls;
    inline_lets;
  ] in
  let step e = List.fold_left (fun curr opt -> opt curr) e opts in
  let rec fixpoint curr = 
    (* print_endline ("Step: "^(string_of_expr curr)); *)
    let next = step curr in
      if next = curr then next
      else fixpoint next
  in fixpoint expr
;;
