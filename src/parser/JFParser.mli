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

val expression :
  (Lexing.lexbuf  -> token) -> Lexing.lexbuf -> Expression.expr_t
