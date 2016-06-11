open Type

let key_type = TPrimitive(TInt)
let data_type = TPrimitive(TInt)
let record_type = TTuple( [ "KEY", key_type; "DATA", data_type ] )
let buffer_size = 100

type key_t  = int
type data_t = int
type record_t = key_t * data_t

let cast_to_key = Value.cast_to_int;;
let cast_to_data = Value.cast_to_int;;
let cast_to_record (base: Value.value_t): record_t = 
	( cast_to_key  (Value.subscript base (Value.VPrim(Expression.CString("KEY" )))), 
		cast_to_data (Value.subscript base (Value.VPrim(Expression.CString("DATA"))))
	);;
let box_key (k: key_t) = Value.VPrim(Expression.CInt(k))
let box_data (v: data_t) = Value.VPrim(Expression.CInt(v))
let box_record ((k,v): record_t) = Value.VTuple(ListUtils.mk_map [
    "KEY", box_key k;
    "DATA", box_data v;
  ])
let get_key ( (k, _): record_t) = k;;
let cast_to_buffer (base: Value.value_t): record_t list =
	List.map cast_to_record (Value.cast_to_list base);;
let compare_keys = compare;;
let compare_records ((a, _): record_t) ((b, _): record_t): int =
	compare_keys a b;;
let sort_buffer (base: record_t list): record_t list =
	List.sort (compare_records) base;;