open CogTypes
open Iterators
open JITD
open Value
open Type
open Expression
open SimulationParameters
;;

(* Parsing.set_trace true;; *)

let load_policy (file: string): ((string * expr_t) list * policy_t) = 
  let input = open_in file in
  let buffer = Lexing.from_channel input in
    JFLexer.init_line ~file:file buffer;
  let (globals, base_policy) = 
    try 
      JFParser.program JFLexer.token buffer 
    with 
      | Parsing.Parse_error -> 
        print_endline "Unknown Parser Error";
        exit(-1)
      | Expression.ParseError(message, position) ->
        print_endline ("Error: "^message);
        print_endline ("At: "^
            (position.Lexing.pos_fname)^":"^
            (string_of_int position.Lexing.pos_lnum)^":"^
            (string_of_int (position.Lexing.pos_cnum - position.Lexing.pos_bol))
          );
        exit(-1)
  in
    (globals, List.map JITD.specialize_handler base_policy)
;;

let jitd_files: string list ref = ref [];;
let include_file x = jitd_files := x :: !jitd_files;;

let usage_msg = "jitdc [options] file1.jd [file2.jd [...]]";;

let rec arg_spec = [
  "?", (Arg.Unit(usage)), "Display this help information"
]
and usage () = 
  Arg.usage arg_spec usage_msg;
  exit(-1);
;;

CogTypes.init();;
StdLib.init();;

Arg.parse arg_spec include_file usage_msg;;

jitd_files := List.rev !jitd_files;;

try 
  let (global_functions, raw_policies) = 
    List.split (List.map load_policy !jitd_files) 
  in
  let jitd = JITD.init (JITD.merge_policies raw_policies)
  in
    List.iter (fun (fn_name, fn_defn) -> 
      print_endline ("FN: "^fn_name^" is ");
      print_endline (string_of_expr fn_defn);
      match Runtime.eval fn_defn
      with 
        | VFunction(arg_t, ret_t, fn_defn) -> 
            FunctionLibrary.define_fn fn_name (arg_t, ret_t) fn_defn
        | _ -> 
            print_endline ("Invalid Function: "^fn_name);
            exit(-1)
    ) (List.flatten global_functions);
    TestLib.init(jitd);
    JITD.call_handler jitd JITD.TEST [];
with 
  | Typechecker.TypecheckError(msg, ctx, expected, found) -> 
    print_endline ("Typecheck Error: "^msg);
    print_endline ("Expected: "^(string_of_type expected));
    print_endline ("Found: "^(string_of_type found));
    begin match ctx with
      | Some(s) -> print_endline ("In: "^(string_of_expr s))
      | None -> ()
    end
