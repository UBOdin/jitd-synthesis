open CogTypes
open Iterators
open JITD
open Value
open Expression

let parse (cmd:string): expr_t = 
  begin try 
    JFParser.expression JFLexer.token (Lexing.from_string cmd)
  with 
    | Typechecker.ParseError(msg, _) ->
      print_endline ("Parse Error: " ^ msg);
      raise Parsing.Parse_error
    | Parsing.Parse_error -> 
      print_endline "Unknown parse error";
      raise Parsing.Parse_error
  end
;;

let policy (input: (event_t * string) list): policy_t =
  List.map (fun (evt, cmd) -> (evt, parse cmd)) input
;;

CogTypes.init();;
Printexc.record_backtrace(true)
(* Parsing.set_trace(true);; *)


let sort_all_policy = policy [
  AFTER_INSERT, "
    lambda (v: cog) -> {
      match v with 
        | :CONCAT(lhs, :ARRAY(data)) -> {
            rewrite v as CONCAT(lhs, SORT(data))
          }
      else { }
    }"
]
;;

let test_object = JITD.init(sort_all_policy);;
let insert = JITD.insert test_object;;
let get_iterator () = JITD.iterator test_object;;
let print() = print_endline (string_of_value (JITD.root_handle test_object));;

(*** ACTUAL TEST STARTS HERE ***)

try 
  insert [(1,0); (5,0); (3,0); (2,0)];
  print();
  ()
with 
  | Typechecker.TypecheckError(msg, expr, expected, found) ->
    print_endline ("Typecheck Error: "^msg);
    begin match expr with 
      | Some(e) -> print_endline ("In: "^(string_of_expr e))
      | None    -> ()
    end;
    print_endline ("Expected: "^(Type.string_of_type expected));
    print_endline ("Found: "^(Type.string_of_type found));
    Printexc.print_backtrace stdout;    
  | Runtime.EvalError(msg, (expr, scope)) ->
    print_endline ("Eval Error: "^msg);
    print_endline ("In: "^(string_of_expr expr));
    print_endline ("Scope: "^(Runtime.string_of_scope scope));
    Printexc.print_backtrace stdout;    
  | e ->
    print_endline ("Error: "^(Printexc.to_string e));
    Printexc.print_backtrace stdout;