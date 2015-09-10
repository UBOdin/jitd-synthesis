
%{
open Type;;
open Expression;;


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
%token MATCH WITH

%start expression
%type <Expression.expr_t> expression

%%
  
expression : bool_expression { $1 }

bool_expression : 
  | NOT cmp_expression { ENeg($2) }
  | cmp_expression bool_op expression { EArithOp($2, $1, $3) }
  | cmp_expression { $1 }

bool_op :
  | AND { AAnd }
  | OR  { AOr }

cmp_expression : 
  | add_expression cmp_op expression { ECmpOp($2, $1, $3) }
  | add_expression IS typedef { EIsA($1,$3) }
  | add_expression { $1 }

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

add_op : 
  | ADD { APlus }
  | SUB { AMinus }

mult_expression : 
  | subscript_expression mult_op expression { EArithOp($2, $1, $3) }
  | subscript_expression { $1 }

mult_op : 
  | MULT { ATimes }
  | DIV  { ADiv }

subscript_expression : 
  | leaf_expression LBRACK expression RBRACK { ESubscript($1, $3) }
  | leaf_expression LPAREN expression_list RPAREN { ECall($1, $3) }
  | leaf_expression                          { $1 }

leaf_expression : 
  | IF expression THEN expression ELSE expression 
      { EIfThenElse($2, $4, $6) }
  | LBRACE expression_seq RBRACE 
      { $2 }
  | LPAREN expression RPAREN
      { $2 }
  | LBRACK expression_list RBRACK
      { EList($2) }
  | LET var ASSIGN expression IN expression
      { ELet($2, Typechecker.typeof $4, $4, $6) }
  | REWRITE var AS expression
      { ERewrite($2, $4) }
  | constant
      { EConst($1) }
  | var
      { EVar($1) }
  | MATCH expression WITH bar_or_not match_list ELSE expression
      { Pattern.mk_match $2 $5 $7 }

bar_or_not:
  | PIPE { () }
  |      { () }

match_list: 
  | pattern_effect PIPE match_list { $1 :: $3 }
  | pattern_effect                 { [$1] }

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

pattern_body:
  | ID LPAREN pattern_list RPAREN { Pattern.PCog($1, $3) }
  | typedef                       { Pattern.PType($1) }

expression_seq:
  | expression EOC expression_seq { mk_block $1 $3 }
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
