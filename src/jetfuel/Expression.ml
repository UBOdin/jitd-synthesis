
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
  | ELet        of var_t * expr_t * expr_t
  | ECall       of expr_t * (expr_t list)
  | ERewrite    of var_t * expr_t
  | ENeg        of expr_t
  | EArithOp    of arith_op_t * expr_t * expr_t
  | ECmpOp      of cmp_op_t * expr_t * expr_t
  | EConst      of const_t
  | EVar        of var_t
  | EIsA        of expr_t * jf_t
  | ESubscript  of expr_t * expr_t
  
