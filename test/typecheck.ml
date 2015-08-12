
open Type

let parse cmd = 
	JFParser.expression JFLexer.token (Lexing.from_string cmd)
;;

let typecheck cmd =
	Typechecker.typeof ~validate:true (parse cmd)
;;

let expect_type title t cmd =
	let found = (typecheck cmd) in
	if found = t then
		print_endline (title^": SUCCESS")
	else (
		print_endline (title^": FAILED\n   EXPECTED:"^
			(Type.string_of_type t)^"\n   FOUND:"^
			(Type.string_of_type found));
		exit(-1)
	)
;;
let expect_ptype title t cmd = expect_type title (TPrimitive(t)) cmd
;;

expect_ptype "Const Int"      TInt    "1";
expect_ptype "Const Float"    TFloat  "1.0";
expect_ptype "Const String"   TString "'foo'";
expect_ptype "Const Bool"     TBool   "false";

expect_ptype "Int Addition"   TInt    "1+2";
expect_ptype "Float Addition" TFloat  "1.0+2.0";

expect_ptype "Comparison"     TBool   "1 < 2";
expect_ptype "ISA"            TBool   "1 is int";
expect_ptype "Parens"         TBool   "(1 < 2)";

expect_ptype "IfThenElse"     TInt    "if 1 < 2 then 1 else 2";

print_endline "All Typecheck Tests Completed"
