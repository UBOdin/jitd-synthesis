
open Type
open Runtime
open Value
open Expression
open ListUtils
open Pattern

let parse cmd = JFParser.expression JFLexer.token (Lexing.from_string cmd);;

let scope = ref (Runtime.default_scope ());;
let reset_scope () = scope := (Runtime.default_scope ());;
let set_var (k:var_t) (v:value_t) = scope := StringMap.add k v !scope;;
let dump_scope () =
	print_endline " == SCOPE ==";
	StringMap.iter (fun k v -> print_endline (k ^ ": " ^(string_of_value v))) !scope
;;

Cog.define {
	Cog.name = "COUNTER";
	Cog.body = [ "VAL", TPrimitive(TInt) ];
};;
Cog.define {
	Cog.name = "POINTER";
	Cog.body = [ "TARGET", TCog(None) ];
};;

reset_scope();;

let eval_raw cmd = Runtime.eval ~scope:(!scope) cmd;;
let eval cmd = eval_raw (parse cmd);;

let expect_raw title v cmd =
	try 
		let found = eval_raw cmd in
		if found = v then
			print_endline (title^": SUCCESS")
		else (
			print_endline (title^": FAILED\n    PATTERN:"^
				(string_of_expr cmd)^"\n    EXPECTED:"^
				(Value.string_of_value v)^"\n    FOUND:"^
				(Value.string_of_value found));
			exit(-1)
		);
	with EvalError(msg, (err_expr, err_scope)) -> (
		print_endline (title^": ERROR\n  "^msg);
		print_endline ("  Expression: "^(string_of_expr err_expr));
		print_endline ("  Scope:");
		StringMap.iter (fun k v -> 
			print_endline ("     " ^ k ^ ": " ^(string_of_value v))
		) err_scope;
		exit(-1)
	)
	| Not_found -> (
		print_endline (title^": ERROR (not found)\n");
		print_endline ("  Expression: "^(string_of_expr cmd));
		exit(-1)

	)
;;

let expect title match_idx v patterns =
	let idx = ref (-2) in
	let next_idx () = idx := !idx + 1; EConst(CInt(!idx)) in
	expect_raw 
		title 
		(VPrim(CInt(match_idx))) 
		(Pattern.mk_match (parse v) 
			(List.map (fun pat -> ((None,pat), (next_idx()))) patterns)
			(next_idx())
		)
;;

let no_match = -1;;

let prim_patterns = List.map 
	(fun pt -> (PType(TPrimitive(pt))))
	[TInt; TFloat; TString; TBool]
;;

expect "Primitive: Int"    0        "1"       prim_patterns;;
expect "Primitive: Float"  1        "1.0"     prim_patterns;;
expect "Primitive: String" 2        "'foo'"   prim_patterns;;
expect "Primitive: Bool"   3        "true"    prim_patterns;;
expect "Primitive: Other"  no_match "[1]" 	  prim_patterns;;

expect "Generic: Any"      0        "1"       [PType(TAny)];;

expect "Cog: Trivial"       0        "COUNTER(1)" [PType(TAny)];;
expect "Cog: Typed"         0        "COUNTER(1)"
		[PCog("COUNTER", [None, PType(TAny)])];;
expect "Cog: Invalid"       (-1)     "COUNTER(1)"
		[PCog("COUNTESS", [None, PType(TAny)])];;
let wrapped_prim_patterns = 
	(List.map (fun x -> PCog("COUNTER", [None, x])) prim_patterns)
;;

expect "Cog: Nested Int"    0 "COUNTER(1)"     wrapped_prim_patterns;;
expect "Cog: Nested Float"  1 "COUNTER(1.0)"   wrapped_prim_patterns;;
expect "Cog: Nested String" 2 "COUNTER('foo')" wrapped_prim_patterns;;
expect "Cog: Nested Bool"   3 "COUNTER(true)"  wrapped_prim_patterns;;

expect "Nested Cog"    0 "POINTER(COUNTER(1))" 
	[PCog("POINTER", [None, PCog("COUNTER", [None, PType(TAny)])])];;


print_endline "All Pattern Tests Completed"
