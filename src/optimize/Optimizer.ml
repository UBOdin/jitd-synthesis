open ListUtils
open Expression

let rec recur (op: = 
  let rcr x = recur op in
  function
  | EIfThenElse(i,t,e)            -> EIfThenElse(rcr i, rcr t, rcr e)
  | EBlock(l)                     -> EBlock(List.map rcr l)
  | ELet(var_name, var_val, body) -> ELet(var_name, rcr var_val, rcr body) 
  | EAsA(body, body_type)         -> EAsA(rcr body, body_type)
  | ECall(func_name, args)        -> ECall(func_name, List.map rcr args)
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

let rec inline ?(scope: expr_t StringMap.t = StringMap.empty) (expr:expr_t) = 
  let rcr e = inline ~scope:scope e in
  match expr with 
  | ELet(var_name, var_val, body) ->
    let var_expr = rcr var_val in
      inline ~scope:(StringMap.add var_name var_expr scope) body
  | EVar(var_name) ->
    if StringMap.mem var_name scope 
      then StringMap.find var_name scope
      else EVar(var_name)
  | _ -> recur rcr expr
;;

let optimize ?(scope: expr_t StringMap.t = StringMap.empty) (expr:expr_t) = 
  inline ~scope:scope expr
;;