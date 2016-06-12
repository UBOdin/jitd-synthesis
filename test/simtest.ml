open CogTypes
open Iterators
open JITD
open Value
open Type
open Expression
open SimulationParameters

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
  List.map (fun (evt, cmd) -> (evt, parse ("lambda (target_cog: cog) -> {"^cmd^"}"))) input
;;

CogTypes.init();;
Printexc.record_backtrace(true);;
(* Parsing.set_trace(true);; *)

let null_policy = policy [];;
let naive_sort_all_policy = policy [
  AFTER_INSERT, "
      match target_cog with 
        | :CONCAT(lhs, :ARRAY(data)) -> {
            rewrite target_cog as CONCAT(lhs, SORTED(SORT(data)))
          }
      else { }
    "
]
;;
let crack_policy = policy [
  AFTER_INSERT, "
      match target_cog with 
        | :CONCAT(lhs, :ARRAY(data)) -> {
            rewrite v as CONCAT(lhs, SORTED(SORT(data)))
          }
      else { }
    "
]
;;

let test_object = JITD.init(null_policy);;
let test_iterator = ref (BufferIterator([]));;
let insert = JITD.insert test_object;;
let iter_reset () = test_iterator := JITD.iterator test_object;;
let iter_step () = 
    let (v, tmp_iter) = (Iterators.step !test_iterator) in
    begin match v with 
      | None    -> 
        print_endline "END_OF_ITER";
        false
      | Some(s) -> 
        test_iterator := tmp_iter;
        print_endline (string_of_record s);
        true
    end
;;
let iter_seek k =
    test_iterator := Iterators.seek k !test_iterator
;;
let iter_flush () =
    while iter_step () do () done
;;
let print() = print_endline (string_of_value (JITD.root_handle test_object));;

(*** ACTUAL TEST STARTS HERE ***)

try 
  print();
  insert [(1,0); (5,0); (3,0); (2,0)];
  print();
  iter_reset();
  iter_flush();
  iter_reset();
  iter_seek 4;
  iter_flush();
  iter_reset();
  iter_seek 3;
  iter_flush();
  insert [(2,1); (20,1); (4,1)];
  iter_reset();
  iter_flush();
  iter_reset();
  iter_seek 4;
  iter_flush();
  iter_reset();
  iter_seek 3;
  iter_flush();
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