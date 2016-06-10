open Type
open Runtime
open Value
open Expression
open ListUtils
open SimulationParameters


let concat_cog = "CONCAT";;
let tree_cog = "TREE";;
let array_cog = "ARRAY";;
let sorted_cog = "SORTED";;

(* CONCAT(lhs, rhs) *)
Cog.define {
	Cog.name = concat_cog;
	Cog.body = [ 
		"LHS", TCog(None);
		"RHS", TCog(None)
	];
};;

(* TREE(sep, lhs, rhs) *)
(* invariant: rhs keys >= sep; lhs keys < sep *)
Cog.define {
	Cog.name = tree_cog;
	Cog.body = [ 
		"SEP", key_type;
		"LHS", TCog(None);
		"RHS", TCog(None)
	];
};;

(* ARRAY(data) *)
Cog.define {
	Cog.name = array_cog;
	Cog.body = [ 
		"DATA", record_type
	];
};;

(* SORTED(data) *)
Cog.define {
	Cog.name = sorted_cog;
	Cog.body = [ 
		"DATA", record_type
	];
};;


