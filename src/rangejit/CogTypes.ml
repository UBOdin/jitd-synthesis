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

let mk_concat (lhs: value_t) (rhs: value_t) =
	(concat_cog, ListUtils.mk_map [
		"LHS", lhs;
		"RHS", rhs;
	])
;;
let mk_tree (sep: key_t) (lhs: value_t) (rhs: value_t) =
	(tree_cog, ListUtils.mk_map [
		"SEP", box_key sep;
		"LHS", lhs;
		"RHS", rhs;
	])
;;
let mk_array (buffer: record_t list) =
	(array_cog, ListUtils.mk_map [
		"DATA", (VList(List.map box_record buffer));
	])
;;
let mk_sorted (buffer: record_t list) =
	(sorted_cog, ListUtils.mk_map [
		"DATA", (VList(List.map box_record buffer));
	])
;;
let init() = (
	(* CONCAT(lhs, rhs) *)
	Cog.define {
		Cog.name = concat_cog;
		Cog.body = [ 
			"LHS", TLogCog;
			"RHS", TLogCog
		];
	};

	(* TREE(sep, lhs, rhs) *)
	(* invariant: rhs keys >= sep; lhs keys < sep *)
	Cog.define {
		Cog.name = tree_cog;
		Cog.body = [ 
			"SEP", key_type;
			"LHS", TLogCog;
			"RHS", TLogCog
		];
	};

	(* ARRAY(data) *)
	Cog.define {
		Cog.name = array_cog;
		Cog.body = [ 
			"DATA", record_type
		];
	};

	(* SORTED(data) *)
	Cog.define {
		Cog.name = sorted_cog;
		Cog.body = [ 
			"DATA", record_type
		];
	};
)
