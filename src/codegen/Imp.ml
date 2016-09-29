(**Imparitive Code Generation.*)

open Expression
open Type
open FunctionLibrary
open ListUtils

exception ConversionError of string * expr_t
exception TypeConversionError of string * jf_t

(**Return Value.*)
type rvalue_t =
  | RValueBlock of string * rvalue_t * string 			(**lhs, body, rhs.*)
  | BinaryOp of rvalue_t * string * rvalue_t 		(**lhs, separator, rhs.*)
  | FunCall of string * (rvalue_t list) 			(**function name, list of Return Value.*)
  | Literal of string 								(**literal.*)
  | FunctionalIf of rvalue_t * rvalue_t * rvalue_t 	(**codition, if condition true Return Value, if condition false Return Value.*)
  
(**Statement.*)
type stmt_t =
  | StatementBlock of string * stmt_t list * string 			(**lhs, statement list, rhs.*)
  | DefineVar of string * string * rvalue_t 			(**variable type, variable name, initialization Return Value.*)
  | AssignVar of string * rvalue_t 						(**variable name, assignment Return Value.*)
  | Void      of rvalue_t 								(**Return Value.*)
  | IfThenElse of rvalue_t * stmt_t list * stmt_t list 	(**condition, if condition true Statement, if condition false Statement.*)

(**Function.*)
type function_t = (string * (string * string) list * string * stmt_t list) (**function name, argument name and type list, function return type, statement list.*)

(**Program.*)
type program_t =  function_t list 	(**list of Functions.*)

let caps_of_ctype (ctype:string): string = 
  begin
    match ctype with
    | "TREE" -> "BTREE"
    | "SORTED" -> "SORTED_ARRAY"
    | _ -> ctype
  end

let rename_constructor (fname:string): string = 
  begin
    match fname with
    | "ARRAY" -> "ArrayCog<Tuple>"
    | "TREE" -> "BTreeCog<Tuple>"
    | "CONCAT" -> "ConcatCog<Tuple>"
    | "DELETE" -> "DeleteCog<Tuple>"
    | "SORTED" -> "SortedArrayCog<Tuple>"
    | "COG_BASE_TYPE" -> "CogHandle<Tuple>"
    | _ -> fname
  end

let rename_field (field:string): string = 
  begin
    match field with
    | "SEP" -> "sep"
    | "RHS" -> "rhs"
    | "LHS" -> "lhs"
    | "DATA" -> "buffer"
    | _ -> field
  end
;;

let rename_fname (fname:string): string = 
  begin
    match fname with
    | "BEFORE_INSERT" -> "beforeInsert"
    | "AFTER_INSERT" -> "afterInsert"
    | "BEFORE_DELETE" -> "beforeDelete"
    | "AFTER_DELETE" -> "afterDelete"
    | "BEFORE_ROOT_ITERATOR" -> "beforeRootIterator"
    | "BEFORE_ITERATOR" -> "beforeIterator"
    | "IDLE" -> "idle"
    | _ -> fname
  end;
;;

let is_constructor (fname:string): bool = 
  try let cog = Cog.get fname in
    match cog with
    | _-> true
  with Not_found -> match fname with
  | "COG_BASE_TYPE" -> true
  | _ -> false

let chk_library_constructor (fname:string): string = 
  let new_fname = rename_fname fname in
  if (is_constructor new_fname) then "CogPtr<"^(rename_constructor new_fname)^">"
else new_fname
;;
(* 
let chk_library_constructor_rval (fname:string): string = 
  let new_fname = rename_fname fname in
  if (is_constructor new_fname) then "CogPtr<Tuple>(new "^(rename_constructor new_fname)^")"
else new_fname
;;
 *)

(**Returns string for datatypes.
  @param t datatype
  @return string of datatype
*)
let rec imp_type_of_jf_type (t:jf_t): string =
  let error msg = raise (TypeConversionError(msg, t)) in
  match t with
  | TAny -> error "No type signature"
  | TNone -> error "No type signature"
  | TPhyCog (ctype) -> ctype
  | TLogCog -> "COG_BASE_TYPE"
  | TList(sub_t) -> chk_library_constructor(imp_type_of_jf_type sub_t)^"*"
  | TMap _ -> error "Unsupported: Map"
  | TTuple(args) -> "std::tuple<"^(String.concat "," (List.map (fun (name,jft)->imp_type_of_jf_type jft) args))^">"(* error "Unsupported: Tuple" *)
  | TPrimitive(TString) -> "char *"
  | TPrimitive(TInt) -> "long int"
  | TPrimitive(TFloat) -> "double"
  | TPrimitive(TBool) -> "char"
  | TFn _ -> error "No type signatures for functions"
  | TCustom(ctype) -> ctype
;;



let library_rval (fname:string): string = 
  let new_fname = chk_library_constructor fname in
  try 
  imp_type_of_jf_type (StringMap.find new_fname (!global_functions)).returns
with Not_found->new_fname

let rec returntype_of_expr_t (expr:expr_t): string = 
  let rcr = returntype_of_expr_t in
  match expr with
    (* "RV of "^(string_of_expr expr) *)
    | EIfThenElse(a,b,c)  -> rcr b
    | EBlock(a)           -> ""
    | ELet(a,b,c)         -> rcr c
    | EAsA(a,b)           -> imp_type_of_jf_type b
    | EExtract(a,b)       -> imp_type_of_jf_type b
    | ECall(a,b)          -> rcr a
    | ERewrite(a,b)       -> rcr b
    | ENeg(a)             -> rcr a
    | EArithOp(a,b,c)     -> rcr b
    | ECmpOp(a,b,c)       -> imp_type_of_jf_type (TPrimitive(TBool))
    | EConst(a)           -> imp_type_of_jf_type (TPrimitive(type_of_const a))
    | EVar(a)             -> library_rval a
    | EIsA(a,b)           -> imp_type_of_jf_type b
    | ESubscript(a,b)     -> rcr a
    | ELambda(a,b)        -> rcr b(* of (var_t * jf_t) list * expr_t *)
    | EList(a)            -> ""
;;

(**Returns list of statements for the given expression.
	@param expr expression to be converted
	@return list of Statements
*)
let rec program_of_jitfuel (expr: expr_t): stmt_t list =
  let error msg = raise (ConversionError(msg, expr)) in
  match expr with 
    | EIfThenElse(i,t,e) -> 
        [IfThenElse(
          rvalue_of_jitfuel i, 
          program_of_jitfuel t, 
          program_of_jitfuel e
        )]
    | EBlock(ops) ->
        List.flatten (List.map program_of_jitfuel ops)
    | ELet(var_name, var_val, body) ->
        let ret_t = returntype_of_expr_t var_val in
        let var_ret_t = if (is_constructor ret_t) then chk_library_constructor ret_t else ret_t in
        [StatementBlock("{", 
          (DefineVar(var_ret_t, var_name, 
            rvalue_of_jitfuel var_val
          )) :: (program_of_jitfuel body),
        "}")]
    | ERewrite(tgt, v) ->
        [Void( FunCall(tgt^"->put", [rvalue_of_jitfuel v]))]
        (* [AssignVar(tgt^"*", rvalue_of_jitfuel v)] *)
    | ELambda _ ->
        error "Direct program translation expects no lambdas"
    | _ ->
        [Void(rvalue_of_jitfuel expr)]

(**Returns the return value for given expression.
	@param expr expression to be converted
	@return Return Value of expression
*)
and rvalue_of_jitfuel (expr: expr_t): rvalue_t =
  let error msg = raise (ConversionError(msg, expr)) in
  let rcr e = rvalue_of_jitfuel e in
  let parens e = RValueBlock("(", rcr e, ")") in
  match expr with
  | EIfThenElse(i,t,e) -> 
      FunctionalIf(rcr i, rcr t, rcr e)
  | EBlock([x]) -> rcr x
  | EExtract(body,TPhyCog(ctype)) ->
      RValueBlock("(CogPtr<"^(rename_constructor ctype)^">)(",rcr body,"->get())")
  | EExtract(body,t) -> rcr body
  | EAsA(body, t) ->
      rcr body
  | ECall(EVar(fname), args) ->
      if (is_constructor fname) then FunCall("CogPtr<Tuple>",[FunCall("new "^(rename_constructor fname), List.map rcr args)]) else
      FunCall( fname , List.map rcr args)
  | ENeg(body) ->
      RValueBlock("-(", rcr body, ")")
  | EArithOp(op, lhs, rhs) ->
      BinaryOp(
        parens lhs,
        begin match op with
          | APlus -> "+"
          | AMinus -> "-"
          | ATimes -> "*"
          | ADiv -> "/"
          | AAnd -> "&&"
          | AOr -> "||"
        end,
        parens rhs
      )
  | ECmpOp(op, lhs, rhs) ->
      BinaryOp(
        parens lhs,
        begin match op with
          | CmpEq -> "=="
          | CmpNeq -> "!="
          | CmpLt -> "<"
          | CmpGt -> ">"
          | CmpLte -> "<="
          | CmpGte -> ">="
        end,
        parens rhs
      )
  | EConst(c) -> 
      Literal(string_of_const c)
  | EVar(v) -> 
      Literal(v)
  | EIsA(body, TPhyCog(ctype)) ->
      RValueBlock("", rcr body, "->type() == COG_"^(caps_of_ctype ctype))
  | ESubscript(body, EConst(CString(field))) ->
      RValueBlock("", rcr body, "->"^(rename_field field))
  | ESubscript(body, field) ->
      RValueBlock("", BinaryOp(rcr body, "[", rcr field), "]")
  | EList(elems) -> error "List Literal Not Supported Yet"
  | _ -> error "Invalid rvalue"
;;

(**Formating return value to imperative syntax.
	@param formatter Formatting function
	@param rval Return Value to be formatted
	@return unit
*)
let rec render_rval (formatter: Format.formatter) (rval:rvalue_t): unit =
  let put x = Format.pp_print_string formatter x in
  let space () = Format.pp_print_space formatter () in
  let open_box () = Format.pp_open_box formatter 1 in
  let close_box () = Format.pp_close_box formatter () in
  let rcr_box (body:rvalue_t):unit = (
    open_box();
    render_rval formatter body;
    close_box();
  ) in
  begin match rval with 
  | RValueBlock(lhs, body, rhs) -> 
    put lhs; space(); rcr_box body; space(); put rhs;  
  | BinaryOp(lhs, sep, rhs) ->
    rcr_box lhs; space(); put sep; space(); rcr_box rhs;
  | FunCall(fname, []) ->
    put (chk_library_constructor fname);
    put "()";
  | FunCall(fname, hd :: rest) ->
    put (chk_library_constructor fname);
    put "("; space();
    rcr_box hd;
    List.iter (fun arg -> put ","; space(); rcr_box arg) rest;
    space(); put ")";
  | Literal(lit) ->
    put lit;
  | FunctionalIf(i, t, e) ->
    put "(";
    rcr_box i;
    put ") ? (";
    rcr_box t;
    put ") : (";
    rcr_box e;
    put ")";
  end

(**Formating statements to imperative syntax.
	@param formatter Formatting function
	@param stmts list of Statements to be formatted
	@return unit
*)
and render_imp (formatter: Format.formatter) (stmts: stmt_t list): unit =
  if List.length stmts <= 0 then () else
  let put x = Format.pp_print_string formatter x in
  let space () = Format.pp_print_space formatter () in
  let open_box () = Format.pp_open_box formatter 1 in
  let close_box () = Format.pp_close_box formatter () in
  let rcr_box (body:stmt_t list):unit = (
    open_box();
    render_imp formatter body;
    close_box();
  ) in
  begin 
  match List.hd stmts with 
  | StatementBlock(lhs, body, rhs) -> 
    put lhs; space(); rcr_box body; space(); put rhs;
  | DefineVar(var_type, var_name, var_val) -> 
    put var_type;
    put " ";
    put var_name;
    put " = ";
    open_box(); render_rval formatter var_val; close_box();
    put ";"
  | AssignVar(var_name, var_val) ->
    put var_name;
    put " = ";
    open_box(); render_rval formatter var_val; close_box();
    put ";"
  | Void(rval) -> 
    render_rval formatter rval;
    put ";"
  | IfThenElse(i, t, e) ->
    put "if(";
    render_rval formatter i;
    put ")";
    if (List.length t)>0 then begin
      rcr_box t;
    end
    else 
    begin
      put "{}";
    end;
    if (List.length e)>0 then
    begin
      put "else {";
      rcr_box e;
      put "}"
    end
  end;
  Format.pp_force_newline formatter ();
  render_imp formatter (List.tl stmts);
;;

(**Formating a function to imperative syntax.
	@param fname name of Function to be rendered
	@param args list of agumrents (name * type) of Function
	@param ret return type of Function
	@param body list of Statements in body of Function
	@return string of rendered Function in imperative syntax
*)
let render_function (((fname:string), (args:((string * string) list)), (ret:string), (body:stmt_t list))): string =
  let buffer: Buffer.t = Buffer.create 1000 in
  let formatter = Format.formatter_of_buffer buffer in
  Format.pp_open_box formatter 2;
  render_imp formatter body;
  Format.pp_close_box formatter ();
  Format.pp_print_flush formatter ();
  ret^" "^(chk_library_constructor fname)^"("^(String.concat ", " (List.map (fun (n,t) -> t^" "^n) args))^") {\n"^
    (Buffer.contents buffer)^"\n}"
;;

(**Formating a program to imperative syntax.
	@parm prog Program to be rendered
	@return string of rendered Program in imperative syntax
*)
let render_program (prog: program_t): string =
  let functions = String.concat "\n\n" (List.map render_function prog) in
  "template <class Tuple>
  class MyPolicy : public RewritePolicyBase <Tuple>
  { 
  public:"^functions^"};"
;;