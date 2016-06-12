

module StringMap = Map.Make(String)

let add_all_to_map (l:(string * 'a) list) (m: 'a StringMap.t): 'a StringMap.t = 
	List.fold_left (fun curr (k,v) -> StringMap.add k v curr) m l
;;

let mk_map l = add_all_to_map l StringMap.empty;;

let reduce (input: ('a * 'b) list): ('a * 'b list) list  =
  (* A bit of a slow cludge... but it's concise, simple 
     and doesn't need to be fast (for now).
     Find all unique keys, repeatedly filter by the key, and find the values
  *)
  List.map (fun k -> (k, List.map snd (List.filter (fun (b, _) -> k = b) input)))
           (List.sort_uniq compare (List.map fst input))
