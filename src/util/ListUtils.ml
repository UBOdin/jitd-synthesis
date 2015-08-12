

module StringMap = Map.Make(String)

let add_all_to_map l m = 
	List.fold_left (fun curr (k,v) -> StringMap.add k v curr) l m
;;