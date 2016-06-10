open Type
open Runtime
open Value
open Expression
open ListUtils
open CogTypes
open SimulationParameters

type callback_t = value_t -> unit

type iterator_t =
  | SeqIterator of iterator_t * key_t * iterator_t
  | MergeIterator of iterator_t * iterator_t
  | BufferIterator of record_t list
  | LazyIterator of callback_t * value_t


let get_iterator (callback: (value_t -> unit)) (cog:value_t): iterator_t =
  let lazy_iter (c: value_t) = (LazyIterator(callback, c)) in
  match Value.cast_to_cog(cog) with
    | ("CONCAT", fields) -> 
      let lhs = StringMap.find "LHS" fields in
      let rhs = StringMap.find "RHS" fields in
        MergeIterator( (lazy_iter lhs), (lazy_iter rhs) )

    | ("TREE", fields) -> 
      let lhs = StringMap.find "LHS" fields in
      let rhs = StringMap.find "RHS" fields in
      let sep: int = cast_to_int (StringMap.find "SEP" fields) in
        SeqIterator( (lazy_iter lhs), sep, (lazy_iter rhs) )

    | ("ARRAY", fields) ->
      let data = cast_to_buffer (StringMap.find "DATA" fields) in
        BufferIterator(sort_buffer data)

    | ("SORTED", fields) ->
      let data = cast_to_buffer (StringMap.find "DATA" fields) in
        BufferIterator(data)

    | (c, _) -> raise (CastError(cog, (TCog(Some(c)))))
;;

let rec peek (iter: iterator_t): (record_t option * iterator_t) =
  match iter with
    | LazyIterator(callback, value) -> 
      peek (get_iterator callback value)

    | SeqIterator(lhs, sep, rhs) -> 
      begin match peek lhs with
        | (None, _)       -> peek rhs
        | (ret, new_lhs)  -> (ret, SeqIterator(new_lhs, sep, rhs))
      end

    | MergeIterator(lhs, rhs) ->
      let (lhs_head, lhs_new) = peek lhs in
      let (rhs_head, rhs_new) = peek rhs in
      begin match (lhs_head, rhs_head) with
        | (None, _) -> (rhs_head, rhs_new)
        | (_, None) -> (lhs_head, lhs_new)
        | (Some(lhs_val), Some(rhs_val)) -> 
          let new_iter = MergeIterator(lhs_new, rhs_new) in
          if (compare_records lhs_val rhs_val) >= 0 
          then ((Some(lhs_val)), new_iter)
          else ((Some(rhs_val)), new_iter)
      end

    | BufferIterator(head :: tail) -> ((Some(head)), BufferIterator(head::tail))

    | BufferIterator([]) -> (None, (BufferIterator([])))
;;

 
let rec step (iter: iterator_t): (record_t option * iterator_t) =
  match iter with
    | LazyIterator(callback, value) -> 
      step (get_iterator callback value)

    | SeqIterator(lhs, sep, rhs) -> 
      begin match step lhs with
        | (None, _)       -> step rhs
        | (ret, new_lhs)  -> (ret, SeqIterator(new_lhs, sep, rhs))
      end

    | MergeIterator(lhs, rhs) ->
      let (lhs_head, lhs_new_1) = peek lhs in
      let (rhs_head, rhs_new_1) = peek rhs in
      begin match (lhs_head, rhs_head) with 
        | (None, _) -> step rhs
        | (_, None) -> step lhs
        | ((Some(lhs_val)), (Some(rhs_val))) -> 
          if (compare_records lhs_val rhs_val) >= 0 
          then 
            let (ret, lhs_new_2) = step lhs in
              (ret, (MergeIterator(lhs_new_2, rhs_new_1)))
          else 
            let (ret, rhs_new_2) = step rhs in
              (ret, (MergeIterator(lhs_new_1, rhs_new_2)))
      end

    | BufferIterator(head :: tail) -> ((Some(head)), BufferIterator(tail))

    | BufferIterator([]) -> (None, (BufferIterator([])))
;;

let rec skip (target: key_t) (iter: iterator_t): iterator_t =
  match iter with
    | LazyIterator(callback, value) -> skip target (get_iterator callback value)

    | SeqIterator(lhs, sep, rhs) when (compare_keys sep target) > 0 ->
      SeqIterator(skip target lhs, sep, rhs)

    | SeqIterator(lhs, sep, rhs) when (compare_keys sep target) = 0 ->
      rhs

    | SeqIterator(lhs, sep, rhs) ->
      SeqIterator(lhs, sep, skip target rhs)

    | MergeIterator(lhs, rhs) ->
      begin match (skip target lhs, skip target rhs) with
        | ( (BufferIterator([])), new_rhs ) -> new_rhs
        | ( new_lhs, (BufferIterator([])) ) -> new_lhs
        | ( new_lhs, new_rhs ) -> MergeIterator(new_lhs, new_rhs)
      end

    | BufferIterator(data) ->
      BufferIterator(
        List.filter (fun r -> (compare_keys (get_key r) target) >= 0 ) data
      )
;;





