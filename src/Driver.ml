open CogTypes
open Iterators
open JITD
open Value
open Type
open Expression
open SimulationParameters
;;

(* Parsing.set_trace true;; *)

let load_policy (file: string): policy_t = 
  begin try 
    let input = open_in file in
    let buffer = Lexing.from_channel input in
      JFLexer.init_line ~file:file buffer;
    let base_policy = 
      try 
        JFParser.policy JFLexer.token buffer 
      with 
        | Parsing.Parse_error -> 
          print_endline "Unknown Parser Error";
          exit(-1)
        | Typechecker.ParseError(message, position) ->
          print_endline ("Error: "^message);
          print_endline ("At: "^
              (position.Lexing.pos_fname)^":"^
              (string_of_int position.Lexing.pos_lnum)^":"^
              (string_of_int position.Lexing.pos_bol)
            );
          exit(-1)


    in
      List.map JITD.specialize_handler base_policy
  with 
    | Typechecker.ParseError(msg, _) ->
      print_endline ("Parse Error: " ^ msg);
      raise Parsing.Parse_error
    | Parsing.Parse_error -> 
      print_endline "Unknown parse error";
      raise Parsing.Parse_error
  end
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
  let jitd = 
    JITD.init
      (JITD.merge_policies (List.map load_policy !jitd_files))
  in
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
