type token =
  | EOF
  | EOC
  | COMMA
  | PIPE
  | UNDERSCORE
  | PERIOD
  | COLON
  | ASSIGN
  | DOUBLEARROW
  | SINGLEARROW
  | LPAREN
  | RPAREN
  | LBRACK
  | RBRACK
  | LBRACE
  | RBRACE
  | ID of (string)
  | ADD
  | SUB
  | MULT
  | DIV
  | EQ
  | NEQ
  | LT
  | LTE
  | GT
  | GTE
  | AND
  | OR
  | NOT
  | CBLOCK of (string)
  | STRINGCONST of (string)
  | INTCONST of (int)
  | FLOATCONST of (float)
  | BOOLCONST of (bool)
  | POLICY
  | RULE
  | COG
  | IS
  | APPLY
  | TO
  | DONE
  | LET
  | REWRITE
  | ON
  | IN
  | AS
  | IF
  | THEN
  | ELSE
  | MATCH
  | WITH

open Parsing;;
let _ = parse_error;;
# 3 "src/parser/JFParser.mly"
open Type;;
open Expression;;


# 63 "src/parser/JFParser.ml"
let yytransl_const = [|
    0 (* EOF *);
  257 (* EOC *);
  258 (* COMMA *);
  259 (* PIPE *);
  260 (* UNDERSCORE *);
  261 (* PERIOD *);
  262 (* COLON *);
  263 (* ASSIGN *);
  264 (* DOUBLEARROW *);
  265 (* SINGLEARROW *);
  266 (* LPAREN *);
  267 (* RPAREN *);
  268 (* LBRACK *);
  269 (* RBRACK *);
  270 (* LBRACE *);
  271 (* RBRACE *);
  273 (* ADD *);
  274 (* SUB *);
  275 (* MULT *);
  276 (* DIV *);
  277 (* EQ *);
  278 (* NEQ *);
  279 (* LT *);
  280 (* LTE *);
  281 (* GT *);
  282 (* GTE *);
  283 (* AND *);
  284 (* OR *);
  285 (* NOT *);
  291 (* POLICY *);
  292 (* RULE *);
  293 (* COG *);
  294 (* IS *);
  295 (* APPLY *);
  296 (* TO *);
  297 (* DONE *);
  298 (* LET *);
  299 (* REWRITE *);
  300 (* ON *);
  301 (* IN *);
  302 (* AS *);
  303 (* IF *);
  304 (* THEN *);
  305 (* ELSE *);
  306 (* MATCH *);
  307 (* WITH *);
    0|]

let yytransl_block = [|
  272 (* ID *);
  286 (* CBLOCK *);
  287 (* STRINGCONST *);
  288 (* INTCONST *);
  289 (* FLOATCONST *);
  290 (* BOOLCONST *);
    0|]

let yylhs = "\255\255\
\001\000\002\000\002\000\002\000\004\000\004\000\003\000\003\000\
\003\000\006\000\006\000\006\000\006\000\006\000\006\000\005\000\
\005\000\009\000\009\000\008\000\008\000\011\000\011\000\010\000\
\010\000\010\000\012\000\012\000\012\000\012\000\012\000\012\000\
\012\000\012\000\012\000\017\000\017\000\018\000\018\000\020\000\
\020\000\019\000\021\000\021\000\021\000\022\000\022\000\014\000\
\014\000\013\000\013\000\016\000\016\000\016\000\016\000\015\000\
\007\000\007\000\007\000\000\000"

let yylen = "\002\000\
\001\000\002\000\003\000\001\000\001\000\001\000\003\000\003\000\
\001\000\001\000\001\000\001\000\001\000\001\000\001\000\003\000\
\001\000\001\000\001\000\003\000\001\000\001\000\001\000\004\000\
\004\000\001\000\006\000\003\000\003\000\003\000\006\000\004\000\
\001\000\001\000\007\000\001\000\000\000\003\000\001\000\003\000\
\001\000\003\000\001\000\002\000\003\000\004\000\001\000\003\000\
\001\000\003\000\001\000\001\000\001\000\001\000\001\000\001\000\
\003\000\001\000\001\000\002\000"

let yydefred = "\000\000\
\000\000\000\000\000\000\000\000\000\000\056\000\000\000\052\000\
\053\000\054\000\055\000\000\000\000\000\000\000\000\000\060\000\
\001\000\000\000\000\000\000\000\000\000\000\000\034\000\033\000\
\000\000\000\000\000\000\000\000\000\000\002\000\000\000\000\000\
\000\000\000\000\005\000\006\000\000\000\010\000\011\000\012\000\
\013\000\014\000\015\000\000\000\000\000\018\000\019\000\000\000\
\022\000\023\000\000\000\000\000\000\000\029\000\000\000\030\000\
\000\000\028\000\000\000\000\000\000\000\000\000\003\000\000\000\
\059\000\058\000\008\000\007\000\016\000\020\000\000\000\000\000\
\050\000\048\000\000\000\032\000\000\000\036\000\000\000\000\000\
\025\000\024\000\000\000\000\000\043\000\000\000\000\000\000\000\
\000\000\000\000\057\000\031\000\027\000\000\000\047\000\044\000\
\000\000\000\000\000\000\000\000\000\000\045\000\035\000\038\000\
\042\000\000\000\000\000\046\000\000\000\040\000"

let yydgoto = "\002\000\
\026\000\017\000\018\000\037\000\019\000\045\000\095\000\020\000\
\048\000\021\000\051\000\022\000\027\000\029\000\023\000\024\000\
\079\000\088\000\089\000\106\000\090\000\096\000"

let yysindex = "\008\000\
\246\254\000\000\246\254\246\254\246\254\000\000\062\255\000\000\
\000\000\000\000\000\000\254\254\254\254\246\254\246\254\000\000\
\000\000\041\255\004\255\063\255\051\255\031\255\000\000\000\000\
\024\255\043\255\036\255\056\255\039\255\000\000\058\255\021\255\
\025\255\026\255\000\000\000\000\246\254\000\000\000\000\000\000\
\000\000\000\000\000\000\250\254\246\254\000\000\000\000\246\254\
\000\000\000\000\246\254\246\254\246\254\000\000\246\254\000\000\
\246\254\000\000\246\254\246\254\246\254\072\255\000\000\068\255\
\000\000\000\000\000\000\000\000\000\000\000\000\076\255\066\255\
\000\000\000\000\044\255\000\000\042\255\000\000\032\255\073\255\
\000\000\000\000\246\254\246\254\000\000\253\254\084\255\048\255\
\089\255\090\255\000\000\000\000\000\000\088\255\000\000\000\000\
\253\254\246\254\032\255\246\254\032\255\000\000\000\000\000\000\
\000\000\095\255\099\255\000\000\032\255\000\000"

let yyrindex = "\000\000\
\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\
\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\
\000\000\001\000\193\000\052\000\103\000\142\000\000\000\000\000\
\000\000\053\255\000\000\092\255\000\000\000\000\000\000\000\000\
\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\
\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\
\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\
\000\000\000\000\000\000\000\000\000\000\040\255\000\000\000\000\
\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\
\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\
\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\
\059\255\000\000\000\000\000\000\000\000\049\255\000\000\000\000\
\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\
\000\000\000\000\100\255\000\000\000\000\000\000"

let yygindex = "\000\000\
\002\000\000\000\106\000\000\000\000\000\000\000\066\000\000\000\
\000\000\000\000\000\000\000\000\219\255\057\000\070\000\000\000\
\000\000\016\000\000\000\007\000\167\255\020\000"

let yytablesize = 500
let yytable = "\003\000\
\004\000\004\000\016\000\005\000\025\000\006\000\028\000\064\000\
\001\000\065\000\064\000\107\000\094\000\006\000\071\000\033\000\
\034\000\073\000\007\000\107\000\008\000\009\000\010\000\011\000\
\038\000\039\000\040\000\041\000\042\000\043\000\066\000\012\000\
\013\000\066\000\054\000\085\000\014\000\086\000\063\000\015\000\
\052\000\044\000\053\000\037\000\055\000\037\000\068\000\087\000\
\056\000\069\000\059\000\017\000\070\000\058\000\072\000\037\000\
\057\000\059\000\028\000\059\000\075\000\076\000\077\000\051\000\
\059\000\051\000\060\000\035\000\036\000\049\000\050\000\003\000\
\061\000\004\000\078\000\005\000\062\000\006\000\082\000\046\000\
\047\000\031\000\032\000\080\000\092\000\093\000\081\000\091\000\
\083\000\097\000\084\000\099\000\008\000\009\000\010\000\011\000\
\098\000\101\000\100\000\103\000\109\000\105\000\021\000\012\000\
\013\000\108\000\049\000\039\000\014\000\067\000\041\000\015\000\
\030\000\074\000\104\000\110\000\102\000\000\000\000\000\000\000\
\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\
\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\
\000\000\000\000\000\000\000\000\000\000\026\000\000\000\000\000\
\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\
\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\
\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\
\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\
\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\
\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\
\009\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\
\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\
\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\
\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\
\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\
\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\
\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\
\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\
\000\000\004\000\004\000\004\000\000\000\000\000\000\000\000\000\
\000\000\000\000\004\000\004\000\004\000\004\000\000\000\004\000\
\000\000\004\000\004\000\004\000\004\000\004\000\004\000\004\000\
\004\000\004\000\004\000\000\000\000\000\000\000\000\000\000\000\
\000\000\000\000\000\000\000\000\000\000\000\000\004\000\000\000\
\000\000\000\000\000\000\000\000\000\000\004\000\000\000\000\000\
\004\000\004\000\000\000\004\000\017\000\017\000\017\000\000\000\
\000\000\000\000\000\000\000\000\000\000\017\000\017\000\017\000\
\017\000\000\000\017\000\000\000\000\000\000\000\017\000\017\000\
\017\000\017\000\017\000\017\000\017\000\017\000\017\000\017\000\
\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\
\000\000\017\000\000\000\000\000\000\000\000\000\000\000\000\000\
\017\000\000\000\000\000\017\000\017\000\000\000\017\000\021\000\
\021\000\021\000\000\000\000\000\000\000\000\000\000\000\000\000\
\021\000\021\000\021\000\021\000\000\000\021\000\000\000\021\000\
\021\000\000\000\000\000\021\000\021\000\021\000\021\000\021\000\
\021\000\021\000\021\000\000\000\000\000\000\000\000\000\000\000\
\000\000\000\000\000\000\000\000\021\000\000\000\026\000\026\000\
\026\000\000\000\000\000\021\000\000\000\000\000\021\000\021\000\
\026\000\021\000\026\000\000\000\026\000\000\000\026\000\026\000\
\026\000\026\000\026\000\026\000\026\000\026\000\026\000\026\000\
\026\000\026\000\000\000\000\000\000\000\000\000\000\000\000\000\
\000\000\000\000\000\000\026\000\000\000\000\000\000\000\000\000\
\000\000\000\000\026\000\000\000\000\000\026\000\026\000\000\000\
\026\000\009\000\009\000\009\000\000\000\000\000\000\000\000\000\
\000\000\000\000\009\000\009\000\009\000\009\000\000\000\009\000\
\000\000\009\000\009\000\009\000\009\000\000\000\000\000\000\000\
\000\000\000\000\000\000\009\000\009\000\000\000\000\000\000\000\
\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\000\
\000\000\000\000\000\000\000\000\000\000\009\000\000\000\000\000\
\009\000\009\000\000\000\009\000"

let yycheck = "\010\001\
\000\000\012\001\001\000\014\001\003\000\016\001\005\000\014\001\
\001\000\016\001\014\001\101\000\016\001\016\001\052\000\014\000\
\015\000\055\000\029\001\109\000\031\001\032\001\033\001\034\001\
\021\001\022\001\023\001\024\001\025\001\026\001\037\001\042\001\
\043\001\037\001\011\001\004\001\047\001\006\001\037\000\050\001\
\010\001\038\001\012\001\004\001\002\001\006\001\045\000\016\001\
\013\001\048\000\002\001\000\000\051\000\015\001\053\000\016\001\
\001\001\009\001\057\000\011\001\059\000\060\000\061\000\011\001\
\007\001\013\001\046\001\027\001\028\001\019\001\020\001\010\001\
\048\001\012\001\003\001\014\001\051\001\016\001\013\001\017\001\
\018\001\012\000\013\000\016\001\083\000\084\000\011\001\015\001\
\045\001\006\001\049\001\003\001\031\001\032\001\033\001\034\001\
\049\001\010\001\009\001\098\000\002\001\100\000\000\000\042\001\
\043\001\011\001\015\001\049\001\047\001\044\000\011\001\050\001\
\007\000\057\000\099\000\109\000\097\000\255\255\255\255\255\255\
\255\255\255\255\255\255\255\255\255\255\255\255\255\255\255\255\
\255\255\255\255\255\255\255\255\255\255\255\255\255\255\255\255\
\255\255\255\255\255\255\255\255\255\255\000\000\255\255\255\255\
\255\255\255\255\255\255\255\255\255\255\255\255\255\255\255\255\
\255\255\255\255\255\255\255\255\255\255\255\255\255\255\255\255\
\255\255\255\255\255\255\255\255\255\255\255\255\255\255\255\255\
\255\255\255\255\255\255\255\255\255\255\255\255\255\255\255\255\
\255\255\255\255\255\255\255\255\255\255\255\255\255\255\255\255\
\255\255\255\255\255\255\255\255\255\255\255\255\255\255\255\255\
\000\000\255\255\255\255\255\255\255\255\255\255\255\255\255\255\
\255\255\255\255\255\255\255\255\255\255\255\255\255\255\255\255\
\255\255\255\255\255\255\255\255\255\255\255\255\255\255\255\255\
\255\255\255\255\255\255\255\255\255\255\255\255\255\255\255\255\
\255\255\255\255\255\255\255\255\255\255\255\255\255\255\255\255\
\255\255\255\255\255\255\255\255\255\255\255\255\255\255\255\255\
\255\255\255\255\255\255\255\255\255\255\255\255\255\255\255\255\
\255\255\255\255\255\255\255\255\255\255\255\255\255\255\255\255\
\255\255\001\001\002\001\003\001\255\255\255\255\255\255\255\255\
\255\255\255\255\010\001\011\001\012\001\013\001\255\255\015\001\
\255\255\017\001\018\001\019\001\020\001\021\001\022\001\023\001\
\024\001\025\001\026\001\255\255\255\255\255\255\255\255\255\255\
\255\255\255\255\255\255\255\255\255\255\255\255\038\001\255\255\
\255\255\255\255\255\255\255\255\255\255\045\001\255\255\255\255\
\048\001\049\001\255\255\051\001\001\001\002\001\003\001\255\255\
\255\255\255\255\255\255\255\255\255\255\010\001\011\001\012\001\
\013\001\255\255\015\001\255\255\255\255\255\255\019\001\020\001\
\021\001\022\001\023\001\024\001\025\001\026\001\027\001\028\001\
\255\255\255\255\255\255\255\255\255\255\255\255\255\255\255\255\
\255\255\038\001\255\255\255\255\255\255\255\255\255\255\255\255\
\045\001\255\255\255\255\048\001\049\001\255\255\051\001\001\001\
\002\001\003\001\255\255\255\255\255\255\255\255\255\255\255\255\
\010\001\011\001\012\001\013\001\255\255\015\001\255\255\017\001\
\018\001\255\255\255\255\021\001\022\001\023\001\024\001\025\001\
\026\001\027\001\028\001\255\255\255\255\255\255\255\255\255\255\
\255\255\255\255\255\255\255\255\038\001\255\255\001\001\002\001\
\003\001\255\255\255\255\045\001\255\255\255\255\048\001\049\001\
\011\001\051\001\013\001\255\255\015\001\255\255\017\001\018\001\
\019\001\020\001\021\001\022\001\023\001\024\001\025\001\026\001\
\027\001\028\001\255\255\255\255\255\255\255\255\255\255\255\255\
\255\255\255\255\255\255\038\001\255\255\255\255\255\255\255\255\
\255\255\255\255\045\001\255\255\255\255\048\001\049\001\255\255\
\051\001\001\001\002\001\003\001\255\255\255\255\255\255\255\255\
\255\255\255\255\010\001\011\001\012\001\013\001\255\255\015\001\
\255\255\017\001\018\001\019\001\020\001\255\255\255\255\255\255\
\255\255\255\255\255\255\027\001\028\001\255\255\255\255\255\255\
\255\255\255\255\255\255\255\255\255\255\255\255\255\255\255\255\
\255\255\255\255\255\255\255\255\255\255\045\001\255\255\255\255\
\048\001\049\001\255\255\051\001"

let yynames_const = "\
  EOF\000\
  EOC\000\
  COMMA\000\
  PIPE\000\
  UNDERSCORE\000\
  PERIOD\000\
  COLON\000\
  ASSIGN\000\
  DOUBLEARROW\000\
  SINGLEARROW\000\
  LPAREN\000\
  RPAREN\000\
  LBRACK\000\
  RBRACK\000\
  LBRACE\000\
  RBRACE\000\
  ADD\000\
  SUB\000\
  MULT\000\
  DIV\000\
  EQ\000\
  NEQ\000\
  LT\000\
  LTE\000\
  GT\000\
  GTE\000\
  AND\000\
  OR\000\
  NOT\000\
  POLICY\000\
  RULE\000\
  COG\000\
  IS\000\
  APPLY\000\
  TO\000\
  DONE\000\
  LET\000\
  REWRITE\000\
  ON\000\
  IN\000\
  AS\000\
  IF\000\
  THEN\000\
  ELSE\000\
  MATCH\000\
  WITH\000\
  "

let yynames_block = "\
  ID\000\
  CBLOCK\000\
  STRINGCONST\000\
  INTCONST\000\
  FLOATCONST\000\
  BOOLCONST\000\
  "

let yyact = [|
  (fun _ -> failwith "parser")
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 0 : 'bool_expression) in
    Obj.repr(
# 38 "src/parser/JFParser.mly"
                             ( _1 )
# 396 "src/parser/JFParser.ml"
               : Expression.expr_t))
; (fun __caml_parser_env ->
    let _2 = (Parsing.peek_val __caml_parser_env 0 : 'cmp_expression) in
    Obj.repr(
# 41 "src/parser/JFParser.mly"
                       ( ENeg(_2) )
# 403 "src/parser/JFParser.ml"
               : 'bool_expression))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 2 : 'cmp_expression) in
    let _2 = (Parsing.peek_val __caml_parser_env 1 : 'bool_op) in
    let _3 = (Parsing.peek_val __caml_parser_env 0 : Expression.expr_t) in
    Obj.repr(
# 42 "src/parser/JFParser.mly"
                                      ( EArithOp(_2, _1, _3) )
# 412 "src/parser/JFParser.ml"
               : 'bool_expression))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 0 : 'cmp_expression) in
    Obj.repr(
# 43 "src/parser/JFParser.mly"
                   ( _1 )
# 419 "src/parser/JFParser.ml"
               : 'bool_expression))
; (fun __caml_parser_env ->
    Obj.repr(
# 46 "src/parser/JFParser.mly"
        ( AAnd )
# 425 "src/parser/JFParser.ml"
               : 'bool_op))
; (fun __caml_parser_env ->
    Obj.repr(
# 47 "src/parser/JFParser.mly"
        ( AOr )
# 431 "src/parser/JFParser.ml"
               : 'bool_op))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 2 : 'add_expression) in
    let _2 = (Parsing.peek_val __caml_parser_env 1 : 'cmp_op) in
    let _3 = (Parsing.peek_val __caml_parser_env 0 : Expression.expr_t) in
    Obj.repr(
# 50 "src/parser/JFParser.mly"
                                     ( ECmpOp(_2, _1, _3) )
# 440 "src/parser/JFParser.ml"
               : 'cmp_expression))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 2 : 'add_expression) in
    let _3 = (Parsing.peek_val __caml_parser_env 0 : 'typedef) in
    Obj.repr(
# 51 "src/parser/JFParser.mly"
                              ( EIsA(_1,_3) )
# 448 "src/parser/JFParser.ml"
               : 'cmp_expression))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 0 : 'add_expression) in
    Obj.repr(
# 52 "src/parser/JFParser.mly"
                   ( _1 )
# 455 "src/parser/JFParser.ml"
               : 'cmp_expression))
; (fun __caml_parser_env ->
    Obj.repr(
# 55 "src/parser/JFParser.mly"
         ( CmpEq  )
# 461 "src/parser/JFParser.ml"
               : 'cmp_op))
; (fun __caml_parser_env ->
    Obj.repr(
# 56 "src/parser/JFParser.mly"
         ( CmpNeq )
# 467 "src/parser/JFParser.ml"
               : 'cmp_op))
; (fun __caml_parser_env ->
    Obj.repr(
# 57 "src/parser/JFParser.mly"
         ( CmpLt  )
# 473 "src/parser/JFParser.ml"
               : 'cmp_op))
; (fun __caml_parser_env ->
    Obj.repr(
# 58 "src/parser/JFParser.mly"
         ( CmpLte )
# 479 "src/parser/JFParser.ml"
               : 'cmp_op))
; (fun __caml_parser_env ->
    Obj.repr(
# 59 "src/parser/JFParser.mly"
         ( CmpGt  )
# 485 "src/parser/JFParser.ml"
               : 'cmp_op))
; (fun __caml_parser_env ->
    Obj.repr(
# 60 "src/parser/JFParser.mly"
         ( CmpGte )
# 491 "src/parser/JFParser.ml"
               : 'cmp_op))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 2 : 'mult_expression) in
    let _2 = (Parsing.peek_val __caml_parser_env 1 : 'add_op) in
    let _3 = (Parsing.peek_val __caml_parser_env 0 : Expression.expr_t) in
    Obj.repr(
# 63 "src/parser/JFParser.mly"
                                      ( EArithOp(_2, _1, _3) )
# 500 "src/parser/JFParser.ml"
               : 'add_expression))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 0 : 'mult_expression) in
    Obj.repr(
# 64 "src/parser/JFParser.mly"
                    ( _1 )
# 507 "src/parser/JFParser.ml"
               : 'add_expression))
; (fun __caml_parser_env ->
    Obj.repr(
# 67 "src/parser/JFParser.mly"
        ( APlus )
# 513 "src/parser/JFParser.ml"
               : 'add_op))
; (fun __caml_parser_env ->
    Obj.repr(
# 68 "src/parser/JFParser.mly"
        ( AMinus )
# 519 "src/parser/JFParser.ml"
               : 'add_op))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 2 : 'subscript_expression) in
    let _2 = (Parsing.peek_val __caml_parser_env 1 : 'mult_op) in
    let _3 = (Parsing.peek_val __caml_parser_env 0 : Expression.expr_t) in
    Obj.repr(
# 71 "src/parser/JFParser.mly"
                                            ( EArithOp(_2, _1, _3) )
# 528 "src/parser/JFParser.ml"
               : 'mult_expression))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 0 : 'subscript_expression) in
    Obj.repr(
# 72 "src/parser/JFParser.mly"
                         ( _1 )
# 535 "src/parser/JFParser.ml"
               : 'mult_expression))
; (fun __caml_parser_env ->
    Obj.repr(
# 75 "src/parser/JFParser.mly"
         ( ATimes )
# 541 "src/parser/JFParser.ml"
               : 'mult_op))
; (fun __caml_parser_env ->
    Obj.repr(
# 76 "src/parser/JFParser.mly"
         ( ADiv )
# 547 "src/parser/JFParser.ml"
               : 'mult_op))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 3 : 'leaf_expression) in
    let _3 = (Parsing.peek_val __caml_parser_env 1 : Expression.expr_t) in
    Obj.repr(
# 79 "src/parser/JFParser.mly"
                                             ( ESubscript(_1, _3) )
# 555 "src/parser/JFParser.ml"
               : 'subscript_expression))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 3 : 'leaf_expression) in
    let _3 = (Parsing.peek_val __caml_parser_env 1 : 'expression_list) in
    Obj.repr(
# 80 "src/parser/JFParser.mly"
                                                  ( ECall(_1, _3) )
# 563 "src/parser/JFParser.ml"
               : 'subscript_expression))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 0 : 'leaf_expression) in
    Obj.repr(
# 81 "src/parser/JFParser.mly"
                                             ( _1 )
# 570 "src/parser/JFParser.ml"
               : 'subscript_expression))
; (fun __caml_parser_env ->
    let _2 = (Parsing.peek_val __caml_parser_env 4 : Expression.expr_t) in
    let _4 = (Parsing.peek_val __caml_parser_env 2 : Expression.expr_t) in
    let _6 = (Parsing.peek_val __caml_parser_env 0 : Expression.expr_t) in
    Obj.repr(
# 85 "src/parser/JFParser.mly"
      ( EIfThenElse(_2, _4, _6) )
# 579 "src/parser/JFParser.ml"
               : 'leaf_expression))
; (fun __caml_parser_env ->
    let _2 = (Parsing.peek_val __caml_parser_env 1 : 'expression_seq) in
    Obj.repr(
# 87 "src/parser/JFParser.mly"
      ( _2 )
# 586 "src/parser/JFParser.ml"
               : 'leaf_expression))
; (fun __caml_parser_env ->
    let _2 = (Parsing.peek_val __caml_parser_env 1 : Expression.expr_t) in
    Obj.repr(
# 89 "src/parser/JFParser.mly"
      ( _2 )
# 593 "src/parser/JFParser.ml"
               : 'leaf_expression))
; (fun __caml_parser_env ->
    let _2 = (Parsing.peek_val __caml_parser_env 1 : 'expression_list) in
    Obj.repr(
# 91 "src/parser/JFParser.mly"
      ( EList(_2) )
# 600 "src/parser/JFParser.ml"
               : 'leaf_expression))
; (fun __caml_parser_env ->
    let _2 = (Parsing.peek_val __caml_parser_env 4 : 'var) in
    let _4 = (Parsing.peek_val __caml_parser_env 2 : Expression.expr_t) in
    let _6 = (Parsing.peek_val __caml_parser_env 0 : Expression.expr_t) in
    Obj.repr(
# 93 "src/parser/JFParser.mly"
      ( ELet(_2, Typechecker.typeof _4, _4, _6) )
# 609 "src/parser/JFParser.ml"
               : 'leaf_expression))
; (fun __caml_parser_env ->
    let _2 = (Parsing.peek_val __caml_parser_env 2 : 'var) in
    let _4 = (Parsing.peek_val __caml_parser_env 0 : Expression.expr_t) in
    Obj.repr(
# 95 "src/parser/JFParser.mly"
      ( ERewrite(_2, _4) )
# 617 "src/parser/JFParser.ml"
               : 'leaf_expression))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 0 : 'constant) in
    Obj.repr(
# 97 "src/parser/JFParser.mly"
      ( EConst(_1) )
# 624 "src/parser/JFParser.ml"
               : 'leaf_expression))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 0 : 'var) in
    Obj.repr(
# 99 "src/parser/JFParser.mly"
      ( EVar(_1) )
# 631 "src/parser/JFParser.ml"
               : 'leaf_expression))
; (fun __caml_parser_env ->
    let _2 = (Parsing.peek_val __caml_parser_env 5 : Expression.expr_t) in
    let _4 = (Parsing.peek_val __caml_parser_env 3 : 'bar_or_not) in
    let _5 = (Parsing.peek_val __caml_parser_env 2 : 'match_list) in
    let _7 = (Parsing.peek_val __caml_parser_env 0 : Expression.expr_t) in
    Obj.repr(
# 101 "src/parser/JFParser.mly"
      ( Pattern.mk_match _2 _5 _7 )
# 641 "src/parser/JFParser.ml"
               : 'leaf_expression))
; (fun __caml_parser_env ->
    Obj.repr(
# 104 "src/parser/JFParser.mly"
         ( () )
# 647 "src/parser/JFParser.ml"
               : 'bar_or_not))
; (fun __caml_parser_env ->
    Obj.repr(
# 105 "src/parser/JFParser.mly"
         ( () )
# 653 "src/parser/JFParser.ml"
               : 'bar_or_not))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 2 : 'pattern_effect) in
    let _3 = (Parsing.peek_val __caml_parser_env 0 : 'match_list) in
    Obj.repr(
# 108 "src/parser/JFParser.mly"
                                   ( _1 :: _3 )
# 661 "src/parser/JFParser.ml"
               : 'match_list))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 0 : 'pattern_effect) in
    Obj.repr(
# 109 "src/parser/JFParser.mly"
                                   ( [_1] )
# 668 "src/parser/JFParser.ml"
               : 'match_list))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 2 : 'pattern) in
    let _3 = (Parsing.peek_val __caml_parser_env 0 : 'pattern_list) in
    Obj.repr(
# 112 "src/parser/JFParser.mly"
                               ( _1 :: _3 )
# 676 "src/parser/JFParser.ml"
               : 'pattern_list))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 0 : 'pattern) in
    Obj.repr(
# 113 "src/parser/JFParser.mly"
            ( [_1] )
# 683 "src/parser/JFParser.ml"
               : 'pattern_list))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 2 : 'pattern) in
    let _3 = (Parsing.peek_val __caml_parser_env 0 : Expression.expr_t) in
    Obj.repr(
# 116 "src/parser/JFParser.mly"
                                   ( (_1, _3) )
# 691 "src/parser/JFParser.ml"
               : 'pattern_effect))
; (fun __caml_parser_env ->
    Obj.repr(
# 119 "src/parser/JFParser.mly"
                          ( (None, Pattern.PType(TAny)) )
# 697 "src/parser/JFParser.ml"
               : 'pattern))
; (fun __caml_parser_env ->
    let _2 = (Parsing.peek_val __caml_parser_env 0 : 'pattern_body) in
    Obj.repr(
# 120 "src/parser/JFParser.mly"
                          ( (None, _2) )
# 704 "src/parser/JFParser.ml"
               : 'pattern))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 2 : string) in
    let _3 = (Parsing.peek_val __caml_parser_env 0 : 'pattern_body) in
    Obj.repr(
# 121 "src/parser/JFParser.mly"
                          ( (Some(_1), _3) )
# 712 "src/parser/JFParser.ml"
               : 'pattern))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 3 : string) in
    let _3 = (Parsing.peek_val __caml_parser_env 1 : 'pattern_list) in
    Obj.repr(
# 124 "src/parser/JFParser.mly"
                                  ( Pattern.PCog(_1, _3) )
# 720 "src/parser/JFParser.ml"
               : 'pattern_body))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 0 : 'typedef) in
    Obj.repr(
# 125 "src/parser/JFParser.mly"
                                  ( Pattern.PType(_1) )
# 727 "src/parser/JFParser.ml"
               : 'pattern_body))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 2 : Expression.expr_t) in
    let _3 = (Parsing.peek_val __caml_parser_env 0 : 'expression_seq) in
    Obj.repr(
# 128 "src/parser/JFParser.mly"
                                  ( mk_block _1 _3 )
# 735 "src/parser/JFParser.ml"
               : 'expression_seq))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 0 : Expression.expr_t) in
    Obj.repr(
# 129 "src/parser/JFParser.mly"
                                  ( _1 )
# 742 "src/parser/JFParser.ml"
               : 'expression_seq))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 2 : Expression.expr_t) in
    let _3 = (Parsing.peek_val __caml_parser_env 0 : 'expression_list) in
    Obj.repr(
# 132 "src/parser/JFParser.mly"
                                     ( _1 :: _3 )
# 750 "src/parser/JFParser.ml"
               : 'expression_list))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 0 : Expression.expr_t) in
    Obj.repr(
# 133 "src/parser/JFParser.mly"
                                     ( [_1] )
# 757 "src/parser/JFParser.ml"
               : 'expression_list))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 0 : string) in
    Obj.repr(
# 136 "src/parser/JFParser.mly"
                ( CString(_1) )
# 764 "src/parser/JFParser.ml"
               : 'constant))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 0 : int) in
    Obj.repr(
# 137 "src/parser/JFParser.mly"
                ( CInt(_1)    )
# 771 "src/parser/JFParser.ml"
               : 'constant))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 0 : float) in
    Obj.repr(
# 138 "src/parser/JFParser.mly"
                ( CFloat(_1)  )
# 778 "src/parser/JFParser.ml"
               : 'constant))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 0 : bool) in
    Obj.repr(
# 139 "src/parser/JFParser.mly"
                ( CBool(_1)   )
# 785 "src/parser/JFParser.ml"
               : 'constant))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 0 : string) in
    Obj.repr(
# 141 "src/parser/JFParser.mly"
        ( _1 )
# 792 "src/parser/JFParser.ml"
               : 'var))
; (fun __caml_parser_env ->
    let _2 = (Parsing.peek_val __caml_parser_env 1 : string) in
    Obj.repr(
# 144 "src/parser/JFParser.mly"
                     ( TCog(Some(_2)) )
# 799 "src/parser/JFParser.ml"
               : 'typedef))
; (fun __caml_parser_env ->
    Obj.repr(
# 145 "src/parser/JFParser.mly"
                     ( TCog(None) )
# 805 "src/parser/JFParser.ml"
               : 'typedef))
; (fun __caml_parser_env ->
    let _1 = (Parsing.peek_val __caml_parser_env 0 : string) in
    Obj.repr(
# 146 "src/parser/JFParser.mly"
       ( 
    match (String.lowercase _1) with
      | "int" -> TPrimitive(TInt)
      | "float" -> TPrimitive(TFloat)
      | "string" -> TPrimitive(TString)
      | "bool" -> TPrimitive(TBool)
      | "_" -> TAny
      | _ -> TAny
  )
# 820 "src/parser/JFParser.ml"
               : 'typedef))
(* Entry expression *)
; (fun __caml_parser_env -> raise (Parsing.YYexit (Parsing.peek_val __caml_parser_env 0)))
|]
let yytables =
  { Parsing.actions=yyact;
    Parsing.transl_const=yytransl_const;
    Parsing.transl_block=yytransl_block;
    Parsing.lhs=yylhs;
    Parsing.len=yylen;
    Parsing.defred=yydefred;
    Parsing.dgoto=yydgoto;
    Parsing.sindex=yysindex;
    Parsing.rindex=yyrindex;
    Parsing.gindex=yygindex;
    Parsing.tablesize=yytablesize;
    Parsing.table=yytable;
    Parsing.check=yycheck;
    Parsing.error_function=parse_error;
    Parsing.names_const=yynames_const;
    Parsing.names_block=yynames_block }
let expression (lexfun : Lexing.lexbuf -> token) (lexbuf : Lexing.lexbuf) =
   (Parsing.yyparse yytables 1 lexfun lexbuf : Expression.expr_t)
