

module StringMap = Map.Make(String)

let add_all_to_map (l:(string * 'a) list) (m: 'a StringMap.t): 'a StringMap.t = 
	List.fold_left (fun curr (k,v) -> StringMap.add k v curr) m l
;;

let mk_map l = add_all_to_map l StringMap.empty;;