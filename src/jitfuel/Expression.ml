
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