
open Type

exception ParseError of string * Lexing.position


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
  | EAsA        of expr_t * jf_t
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

let string_of_expr ?(indent = 2) (expr: expr_t): string = 
  let buffer: Buffer.t = Buffer.create 1000 in
  let formatter = Format.formatter_of_buffer buffer in
  let put x = Format.pp_print_string formatter x in
  let space () = Format.pp_print_space formatter () in
  let open_box () = Format.pp_open_box formatter indent in
  let close_box () = Format.pp_close_box formatter () in
  let rec rcr_box (e:expr_t):unit = (
    open_box();
    rcr e;
    close_box();
  )
  and rcr_list (sep:string) (l: expr_t list): unit =
    begin match l with 
      | [] -> ();
      | hd :: [] -> rcr_box hd;
      | hd :: rest -> open_box(); rcr hd; put sep; space(); close_box(); rcr_list sep rest;
    end
  and rcr (curr_expr:expr_t): unit =
  match curr_expr with 
  | EIfThenElse(i, t, e) -> 
    put "if"; space();
      rcr_box i;
    space();
      rcr_box t;
    space(); put "else"; space();
      rcr_box e;
  | EBlock([]) -> 
    open_box();
    put "{ }";
    close_box();
  | EBlock(l) -> (
    put "{"; space();
    rcr_list "; " l;
    space(); put "}";
  )
  | ELet(tgt, tgt_val, body) ->
    put "let"; space();
      put tgt;
    space(); put ":="; space();
      rcr_box tgt_val;
    space(); put "in"; space();
      rcr_box body;
  | EAsA(e, t) -> 
    put "(";
      rcr_box e;
    put (") as "^(string_of_type t))
  | ECall(fn, args) ->
    rcr_box fn;
    put "("; space();
    rcr_list "," args;
    space(); put ")";
  | ERewrite(tgt, tgt_val) ->
    put ("rewrite "^tgt^" as");
    space();
    rcr_box tgt_val;
  | ENeg(v) -> 
    put "-("; 
    rcr_box v; 
    put ")";
  | EArithOp(op, a, b) ->
    rcr_box a;
    space(); put (string_of_arith_op op); space();
    rcr_box b;
  | ECmpOp(op, a, b) -> 
    rcr_box a;
    space(); put (string_of_cmp_op op); space();
    rcr_box b;
  | EConst(c) -> 
    put (string_of_const c)
  | EVar(v) -> 
    put v
  | EIsA(e, t) -> 
    put "(";
    rcr_box e;
    put ")";
    space(); put ("ISA "^(string_of_type t))
  | ESubscript(base, sub) -> 
    put "(";
    rcr_box base;
    put ")["; space();
    rcr_box sub;
    space(); put "]";
  | ELambda(args, body) -> 
    put "LAMBDA("; space();
    open_box();
      put (String.concat ", " (List.map string_of_typed_var args));
    close_box();
    space(); put ") ->"; space();
    rcr_box body;
  | EList(data) -> 
    put "["; space();
    rcr_list "," data;
    space(); put "]";
  in
    open_box();
    rcr expr; 
    close_box();
    Format.pp_print_flush formatter ();
    Buffer.contents buffer
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