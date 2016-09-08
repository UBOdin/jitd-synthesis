(**Imparitive Code Generation.*)

open Expression
open Type

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


let rename_field (field:string): string = 
  begin
    match field with
    | "RHS" -> "rhs"
    | "LHS" -> "lhs"
    | _ -> field
  end

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

(**Returns string for datatypes.
	@param t datatype
	@return string of datatype
*)
let rec imp_type_of_jf_type (t:jf_t): string =
  let error msg = raise (TypeConversionError(msg, t)) in
  match t with
  | TAny -> error "No type signature"
  | TNone -> error "No type signature"
  | TCog _ -> "COG_BASE_TYPE"
  | TList(sub_t) -> "("^(imp_type_of_jf_type sub_t)^") *"
  | TMap _ -> error "Unsupported: Map"
  | TTuple _ -> error "Unsupported: Tuple"
  | TPrimitive(TString) -> "char *"
  | TPrimitive(TInt) -> "long int"
  | TPrimitive(TFloat) -> "double"
  | TPrimitive(TBool) -> "char"
  | TFn _ -> error "No type signatures for functions"
  | TCustom(ctype) -> ctype
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
        [StatementBlock("{", 
          (DefineVar("auto", var_name, 
            rvalue_of_jitfuel var_val
          )) :: (program_of_jitfuel body),
        "}")]
    | ERewrite(tgt, v) ->
        [Void(FunCall((tgt^"->put"), [rvalue_of_jitfuel v]))]
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
  | EAsA(body, t) ->
      rcr body
  | ECall(EVar(fname), args) ->
      FunCall(fname, List.map rcr args)
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
  | EIsA(body, TCog(Some(ctype))) ->
      RValueBlock("(", rcr body, ")->type == COG_"^(String.uppercase_ascii ctype))
  | ESubscript(body, EConst(CString(field))) ->
      RValueBlock("(", rcr body, ")->"^(rename_field field))
  | ESubscript(body, field) ->
      RValueBlock("(", BinaryOp(rcr body, ")->[", rcr field), "]")
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
    put (rename_fname fname);
    put "()";
  | FunCall(fname, hd :: rest) ->
    put (rename_fname fname);
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
  begin match List.hd stmts with 
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
    put "){";
    rcr_box t;
    put "} else {";
    rcr_box e;
    put "}";
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
  ret^" "^(rename_fname fname)^"("^(String.concat ", " (List.map (fun (n,t) -> t^" "^n) args))^") {\n"^
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
  { "^functions^"};"
;;