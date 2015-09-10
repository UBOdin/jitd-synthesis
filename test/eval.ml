
open Type
open Runtime
open Value
open Expression
open ListUtils

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

reset_scope();;

let eval_raw cmd = Runtime.eval ~scope:(!scope) cmd;;
let eval cmd = eval_raw (parse cmd);;

let expect_raw title v cmd =
	try 
		let found = eval_raw cmd in
		if found = v then
			print_endline (title^": SUCCESS")
		else (
			print_endline (title^": FAILED\n   EXPECTED:"^
				(Value.string_of_value v)^"\n   FOUND:"^
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
;;

let expect title v cmd = expect_raw title v (parse cmd);;

let expect_int    title v cmd = expect title (VPrim(CInt(v)))   cmd;;
let expect_float  title v cmd = expect title (VPrim(CFloat(v))) cmd;;
let expect_string title v cmd = expect title (VPrim(CString(v))) cmd;;
let expect_bool   title v cmd = expect title (VPrim(CBool(v))) cmd;;
let expect_int_raw    title v cmd = expect_raw title (VPrim(CInt(v)))   cmd;;
let expect_float_raw  title v cmd = expect_raw title (VPrim(CFloat(v))) cmd;;
let expect_string_raw title v cmd = expect_raw title (VPrim(CString(v))) cmd;;
let expect_bool_raw   title v cmd = expect_raw title (VPrim(CBool(v))) cmd;;

expect_int    "Trivial Expressions [int]"    101     "101";;
expect_float  "Trivial Expressions [float]"  1.01    "1.01";;
expect_string "Trivial Expressions [string]" "foo"   "'foo'";;
expect_bool   "Trivial Expressions [bool]"   true    "true";;

expect_int    "Integer Arithmetic [+]"   2  "1+1";;
expect_int    "Integer Arithmetic [-]"   0  "1-1";;
expect_int    "Integer Arithmetic [*]"   6  "3 * 2";;
expect_int    "Integer Arithmetic [/]"   2  "4 / 2";;

expect_float    "Float Arithmetic [+]"   3.2    "1.5+1.7";;
expect_float    "Float Arithmetic [-]"   (-1.0) "1.0-2.0";;
expect_float    "Float Arithmetic [*]"   6.2    "3.1 * 2.0";;
expect_float    "Float Arithmetic [/]"   2.0    "4.2 / 2.1";;

expect_float    "Float+Int Arithmetic [+]"   3.5    "1.5+2";;
expect_float    "Float+Int Arithmetic [-]"   (-1.0) "1.0-2";;
expect_float    "Float+Int Arithmetic [*]"   6.2    "3.1 * 2";;
expect_float    "Float+Int Arithmetic [/]"   2.1    "4.2 / 2";;

expect_float    "Int+Float Arithmetic [+]"   3.2    "1.5+1.7";;
expect_float    "Int+Float Arithmetic [-]"   (-1.0) "1.0-2.0";;
expect_float    "Int+Float Arithmetic [*]"   6.2    "3.1 * 2.0";;
expect_float    "Int+Float Arithmetic [/]"   2.0    "4.2 / 2.1";;

expect_bool     "Boolean AND [ff]"   false  "false && false";;
expect_bool     "Boolean AND [ft]"   false  "false && true";;
expect_bool     "Boolean AND [tf]"   false  "true && false";;
expect_bool     "Boolean AND [tt]"   true   "true && true";;
expect_bool     "Boolean OR  [ff]"   false  "false || false";;
expect_bool     "Boolean OR  [ft]"   true   "false || true";;
expect_bool     "Boolean OR  [tf]"   true   "true || false";;
expect_bool     "Boolean OR  [tt]"   true   "true || true";;

expect_bool     "Comparison [ = y]"   true   "1 == 1";;
expect_bool     "Comparison [ = n]"   false  "1 == 2";;
expect_bool     "Comparison [!= y]"   true   "1 != 2";;
expect_bool     "Comparison [!= n]"   false  "1 != 1";;
expect_bool     "Comparison [ > y]"   true   "2 > 1";;
expect_bool     "Comparison [ > n1]"  false  "1 > 2";;
expect_bool     "Comparison [ > n2]"  false  "1 > 1";;
expect_bool     "Comparison [ < y]"   true   "1 < 2";;
expect_bool     "Comparison [ < n1]"  false  "2 < 1";;
expect_bool     "Comparison [ < n2]"  false  "1 < 1";;
expect_bool     "Comparison [>= y1]"  true   "2 >= 1";;
expect_bool     "Comparison [>= y2]"  true   "1 >= 1";;
expect_bool     "Comparison [>  n]"   false  "1 >= 2";;
expect_bool     "Comparison [<= y1]"  true   "1 <= 2";;
expect_bool     "Comparison [<= y2]"  true   "1 <= 1";;
expect_bool     "Comparison [<  n]"   false  "2 <= 1";;

expect_int_raw  "Lambdas"             3      (
	ECall(
		ELambda(["A", TPrimitive(TInt)], (parse "A+2")),
		[parse "1"]
	)
);;
expect          "Cog Constructors" 
				(Value.mk_cog "COUNTER" [VPrim(CInt(5))])
				"COUNTER(5)";;


set_var "BODY" (Value.mk_handle "COUNTER" [VPrim(CInt(1))]);;
expect_int      "Handle Subscript"                    1     "BODY['VAL']";;
eval "REWRITE BODY AS COUNTER(5)";;
expect_int      "Handle Subscript (after rewrite)"    5     "BODY['VAL']";;

expect_int "Patterns: Bindings Hit" 1 
	"match 1 with x:int -> x else 0";;
expect_int "Patterns: Bindings Miss" 0 
	"match 1 with x:float -> x else 0";;
expect_int "Patterns: Wildcard" 1
	"match 1 with x -> x else 0";;
expect_int "Patterns: Nested Wildcard" 0
	"match COUNTER(1) with :COUNTER(_) -> 0 else 1";;
expect_int "Patterns: Nested Binding" 5
	"match COUNTER(5) with :COUNTER(x) -> x else 1";;
expect_int "Patterns: Nested Sequence" 5
	"match COUNTER(5) with :COUNTER(x:float) -> 20 
                         | :COUNTER(x:int) -> x 
                      else 1";;
expect_int "Patterns: Nested Sequence 2" 20
	"match COUNTER(5.0) with :COUNTER(x:float) -> 20 
                           | :COUNTER(x:int) -> x 
                        else 1";;



print_endline "All Evaluator Tests Completed"
