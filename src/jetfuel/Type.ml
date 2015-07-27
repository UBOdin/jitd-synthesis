
type var_t = string

type prim_t =
  | TInt
  | TFloat
  | TString
  | TBool

type jf_t = 
  | TAny
  | TNone
  | TCog of string option
  | TList of int * jf_t
  | TMap of jf_t * jf_t
  | TTuple of (string * jf_t) list
  | TPrimitive of prim_t
  | TFn of fn_t
  | TCustom of string
and fn_t = {
  name      : string;
  typecheck : (jf_t list -> jf_t)
}