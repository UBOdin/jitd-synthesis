
open Type


type arith_op_t =
  | APlus
  | AMinus
  | ATimes
  | ADiv
  | AAnd
  | AOr

type cmp_op_t = 
  | CmpEq
  | CmpNeq
  | CmpLt
  | CmpGt
  | CmpLte
  | CmpGte

type const_t = 
  | CInt of int
  | CFloat of float
  | CString of string
  | CBool of bool

type expr_t = 
  | EIfThenElse of expr_t * expr_t * expr_t
  | EBlock      of expr_t list
  | ELet        of var_t * jf_t * expr_t * expr_t
  | ECall       of expr_t * (expr_t list)
  | ERewrite    of var_t * expr_t
  | ENeg        of expr_t
  | EArithOp    of arith_op_t * expr_t * expr_t
  | ECmpOp      of cmp_op_t * expr_t * expr_t
  | EConst      of const_t
  | EVar        of var_t
  | EIsA        of expr_t * jf_t
  | ESubscript  of expr_t * expr_t
  | ELambda     of (var_t * jf_t) list * expr_t
  | EList       of expr_t list

let type_of_const: const_t -> prim_t = function
  | CInt _    -> TInt
  | CFloat _  -> TFloat
  | CString _ -> TString
  | CBool _   -> TBool
;;

let string_of_const: const_t -> string = function
  | CInt(i)      -> string_of_int i
  | CFloat(f)    -> string_of_float f
  | CString(s)   -> "'"^s^"'"
  | CBool(true)  -> "true"
  | CBool(false) -> "false"
;;

let string_of_arith_op = function  
  | APlus -> "+"
  | AMinus -> "-"
  | ATimes -> "*"
  | ADiv -> "/"
  | AAnd -> "&&"
  | AOr -> "||"
;;

let string_of_cmp_op = function
  | CmpEq  -> "=="
  | CmpNeq -> "!="
  | CmpLt  -> "<"
  | CmpGt  -> ">"
  | CmpLte -> "<="
  | CmpGte -> ">="
;;

let rec string_of_expr: expr_t -> string = 
  let rcr = string_of_expr 
  in function
  | EIfThenElse(i, t, e) -> "if "^(rcr i)^" then "^(rcr t)^" else "^(rcr e)
  | EBlock(l) -> "{ "^(String.concat "; " (List.map rcr l))^" }"
  | ELet(tgt, tgt_t, tgt_val, body) ->
    "let "^tgt^":"^(string_of_type tgt_t)^" = "^(rcr tgt_val)^" in "^(rcr body)
  | ECall(fn, args) ->
    (rcr fn)^"("^(String.concat "," (List.map rcr args))^")"
  | ERewrite(tgt, tgt_val) ->
    "rewrite "^tgt^" as "^(rcr tgt_val)
  | ENeg(v) -> "-("^(rcr v)^")"
  | EArithOp(op, a, b) -> (rcr a)^(string_of_arith_op op)^(rcr b)
  | ECmpOp(op, a, b) -> (rcr a)^(string_of_cmp_op op)^(rcr b)
  | EConst(c) -> string_of_const c
  | EVar(v) -> v
  | EIsA(e, t) -> (rcr e)^" ISA "^(string_of_type t)
  | ESubscript(base, sub) -> (rcr base)^"["^(rcr sub)^"]"
  | ELambda(args, body) -> 
      "/.("^(String.concat "," (List.map string_of_typed_var args))^
        ") -> "^(rcr body)
;;

let block_list (a:expr_t): expr_t list = 
  match a with EBlock(l) -> l | _ -> [a]
;;

let mk_block (a:expr_t) (b:expr_t): expr_t =
  EBlock((block_list a)@(block_list b))
;;

let mk_and (a:expr_t) (b:expr_t): expr_t =
  match (a, b) with
    | (EConst(CBool(true)), _) -> b
    | (_, EConst(CBool(true))) -> a
    | (EConst(CBool(false)), _) -> EConst(CBool(false))
    | (_, EConst(CBool(false))) -> EConst(CBool(false))
    | _ -> EArithOp(AAnd, a, b)
;;

let mk_or (a:expr_t) (b:expr_t): expr_t =
  match (a, b) with
    | (EConst(CBool(false)), _) -> b
    | (_, EConst(CBool(false))) -> a
    | (EConst(CBool(true)), _) -> EConst(CBool(true))
    | (_, EConst(CBool(true))) -> EConst(CBool(true))
    | _ -> EArithOp(AOr, a, b)
;;