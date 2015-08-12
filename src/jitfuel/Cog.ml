open Type
open Expression
open ListUtils

type cog_t = {
  name : string;
  body : (string * jf_t) list;
}

let cog_list:(cog_t StringMap.t ref) = ref StringMap.empty;;

let define (cog:cog_t) =
	cog_list := StringMap.add cog.name cog (!cog_list)
;;

let get (cog:string) = 
	StringMap.find cog (!cog_list)
;;

let field_type (cog:string) (field:string) =
	List.assoc field ((get cog).body) 
;;

let field_names (cog:string) = 
	List.map fst ((get cog).body)
;;

let all_subscripts (cog:string) (target:expr_t): expr_t list =
	List.map (fun x -> ESubscript(target, EConst(CString(x))))
			 (field_names cog)
;;