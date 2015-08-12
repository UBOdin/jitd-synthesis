open Type
open Expression
open ListUtils

type cog_type_t = string

type cog_t = {
  name : cog_type_t;
  body : (string * jf_t) list;
}

let cog_list:(cog_t StringMap.t ref) = ref StringMap.empty;;

let all_cogs () = StringMap.fold (fun k _ l -> k :: l) !cog_list [];;

let define (cog:cog_t) =
	cog_list := StringMap.add cog.name cog (!cog_list)
;;

let get (cog:cog_type_t) = 
	StringMap.find cog (!cog_list)
;;

let field_type (cog:cog_type_t) (field:string) =
	List.assoc field ((get cog).body) 
;;

let field_names (cog:cog_type_t) = 
	List.map fst ((get cog).body)
;;

let field_types (cog:cog_type_t) = 
	List.map snd ((get cog).body)
;;

let all_subscripts (cog:cog_type_t) (target:expr_t): expr_t list =
	List.map (fun x -> ESubscript(target, EConst(CString(x))))
			 (field_names cog)
;;