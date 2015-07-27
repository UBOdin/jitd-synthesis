open Type
open ListUtils

type cog_t = {
  name : string;
  body : (string * jf_t) list;
}

let cog_list:(cog_t StringMap.t ref) = ref StringMap.empty;;

let define (cog:cog_t) =
	cog_list := StringMap.add cog.name cog (!cog_list)
;;

let field_type (cog:string) (field:string) =
	List.assoc field ((StringMap.find cog (!cog_list)).body) 
;;