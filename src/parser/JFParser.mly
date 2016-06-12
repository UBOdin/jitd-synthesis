
%{
open Type;;
open Expression;;

let raise_parse_error msg =
  raise (Typechecker.ParseError(msg, Parsing.symbol_start_pos()))
;;
   

%}

%token EOF
%token EOC
%token COMMA
%token PIPE
%token UNDERSCORE
%token PERIOD
%token COLON
%token ASSIGN DOUBLEARROW SINGLEARROW
%token LPAREN RPAREN
%token LBRACK RBRACK
%token LBRACE RBRACE
%token UNDERSCORE
%token <string> ID
%token ADD SUB MULT DIV
%token EQ NEQ LT LTE GT GTE AND OR NOT
%token <string> CBLOCK
%token <string> STRINGCONST
%token <int> INTCONST
%token <float> FLOATCONST
%token <bool> BOOLCONST
%token POLICY RULE COG IS APPLY TO DONE LET REWRITE ON IN AS
%token IF THEN ELSE
%token MATCH WITH LAMBDA

%start policy
%start expression
%type <Expression.expr_t> expression
%type <(string * string list * Expression.expr_t) list> policy

%%

policy :
  | EOF              { [] }
  | handler policy   { $1 :: $2 }
  | error { raise_parse_error "Unable to match handler" }

handler :
  | ON handler_defn handler_body
      { (fst $2, snd $2, $3) }
  | error { raise_parse_error "Bad Handler (Expecting ON name(arg, list) { body })" }

handler_defn : 
  | ID LPAREN          RPAREN { ($1, []) }
  | ID LPAREN var_list RPAREN { ($1, $3) }
  | error { raise_parse_error "Bad Handler Header (Expecting name(arg, list) )"}

handler_body : 
  | LBRACE expression_seq RBRACE { $2 }
  | error { raise_parse_error "Bad Handler Body (Expecting { body })" }


expression : 
  | bool_expression { $1 }
  | error { raise_parse_error "Invalid Expression" }

bool_expression : 
  | NOT cmp_expression { ENeg($2) }
  | cmp_expression bool_op expression { EArithOp($2, $1, $3) }
  | cmp_expression { $1 }
  | error { raise_parse_error "Invalid Boolean Expression" }

bool_op :
  | AND { AAnd }
  | OR  { AOr }

cmp_expression : 
  | add_expression cmp_op expression { ECmpOp($2, $1, $3) }
  | add_expression IS typedef { EIsA($1,$3) }
  | add_expression { $1 }
  | error { raise_parse_error "Invalid Comparison" }

cmp_op : 
  | EQ   { CmpEq  }
  | NEQ  { CmpNeq }
  | LT   { CmpLt  }
  | LTE  { CmpLte }
  | GT   { CmpGt  }
  | GTE  { CmpGte }

add_expression : 
  | mult_expression add_op expression { EArithOp($2, $1, $3) }
  | mult_expression { $1 }
  | error { raise_parse_error "Invalid Addition" }

add_op : 
  | ADD { APlus }
  | SUB { AMinus }

mult_expression : 
  | subscript_expression mult_op expression { EArithOp($2, $1, $3) }
  | subscript_expression                    { $1 }
  | error { raise_parse_error "Invalid Multiplication" }

mult_op : 
  | MULT { ATimes }
  | DIV  { ADiv }

subscript_expression : 
  | leaf_expression LBRACK expression RBRACK      { ESubscript($1, $3) }
  | leaf_expression LPAREN expression_list RPAREN { ECall($1, $3) }
  | leaf_expression                               { $1 }
  | error { raise_parse_error "Invalid Subscript" }

leaf_expression : 
  | IF expression THEN expression ELSE expression 
      { EIfThenElse($2, $4, $6) }
  | LBRACE RBRACE 
      { EBlock([]) }
  | LBRACE expression_seq RBRACE 
      { $2 }
  | LPAREN expression RPAREN
      { $2 }
  | LBRACK expression_list RBRACK
      { EList($2) }
  | LET var ASSIGN expression IN expression
      { ELet($2, Typechecker.typeof $4, $4, $6) }
  | LAMBDA LPAREN arg_list RPAREN SINGLEARROW expression
      { ELambda($3, $6) }
  | REWRITE var AS expression
      { ERewrite($2, $4) }
  | constant
      { EConst($1) }
  | var
      { EVar($1) }
  | MATCH expression WITH bar_or_not match_list ELSE expression
      { Pattern.mk_match $2 $5 $7 }
  | error 
      { raise_parse_error "Invalid Leaf Expression" }

bar_or_not:
  | PIPE { () }
  |      { () }

arg_list: 
  | var COLON typedef COMMA arg_list { ($1, $3) :: $5 }
  | var COLON typedef                { [$1, $3] }

var_list:
  | var COMMA var_list  { $1 :: $3 }
  | var                 { [$1] }
  | error  { raise_parse_error "Bad Var List; Expecting Variable" }

match_list: 
  | pattern_effect PIPE match_list { $1 :: $3 }
  | pattern_effect                 { [$1] }
  | error 
      { raise_parse_error "Invalid Match List" }

pattern_list:
  | pattern COMMA pattern_list { $1 :: $3 }
  | pattern { [$1] }

pattern_effect:
  | pattern SINGLEARROW expression { ($1, $3) }

pattern:
  | UNDERSCORE            { (None, Pattern.PType(TAny)) }
  | COLON pattern_body    { (None, $2) }
  | ID COLON pattern_body { (Some($1), $3) }
  | ID                    { (Some($1), Pattern.PType(TAny)) }
  | error 
      { raise_parse_error "Invalid Pattern" }

pattern_body:
  | ID LPAREN pattern_list RPAREN { Pattern.PCog($1, $3) }
  | typedef                       { Pattern.PType($1) }
  | error 
      { raise_parse_error "Invalid Pattern Body" }

expression_seq:
  | expression EOC expression_seq { mk_block $1 $3 }
  | expression EOC                { $1 }
  | expression                    { $1 }

expression_list:
  | expression COMMA expression_list { $1 :: $3 }
  | expression                       { [$1] }

constant: 
  | STRINGCONST { CString($1) }
  | INTCONST    { CInt($1)    }
  | FLOATCONST  { CFloat($1)  }
  | BOOLCONST   { CBool($1)   }

var: ID { $1 }

typedef: 
  | LBRACE ID RBRACE { TCog(Some($2)) }
  | COG              { TCog(None) }
  | ID { 
    match (String.lowercase $1) with
      | "int" -> TPrimitive(TInt)
      | "float" -> TPrimitive(TFloat)
      | "string" -> TPrimitive(TString)
      | "bool" -> TPrimitive(TBool)
      | "_" -> TAny
      | _ -> TAny
  }
