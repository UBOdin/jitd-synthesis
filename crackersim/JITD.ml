open Type
open Runtime
open Value
open Expression
open ListUtils
open SimulationParameters

type handler_t = {
	args : (string * jf_t) list;
	handler : expr_t;
}

type event_t =
	| BEFORE_INSERT
	| AFTER_INSERT
	| BEFORE_DELETE
	| AFTER_DELETE
	| BEFORE_ROOT_ITERATOR
	| BEFORE_ITERATOR
	| ON_IDLE

type policy_t = (string * handler_t) list

type jitd_t = {
	data : (Cog.cog_type_t * tuple_t) ref; 
	handlers : policy_t;
}