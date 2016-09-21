open Type
open Expression
  
type pattern_t = string option * pattern_body_t 
and pattern_body_t = 
  | PCog of string * pattern_t list
  | PType of jf_t

let mk_match ?(match_base_type:jf_t = TAny) 
             (target:expr_t) 
             (matches:(pattern_t * expr_t) list)
             (elseclause:expr_t): expr_t =
  let rec pattern_match (_,struct_type) (target:expr_t) =
    match struct_type with 
      | PType(t) -> EIsA(target, t)
      | PCog(cog_name, cog_body) -> 
        begin try 
          List.fold_left2 (fun rest field_subscript field_pattern -> 
            mk_and 
              rest
              (pattern_match field_pattern field_subscript)
          ) (EIsA(target, TPhyCog(cog_name)))
            (Cog.all_subscripts cog_name target)
            cog_body
          with Not_found -> (
            prerr_endline("Warning: Invalid Cog Match '"^cog_name^"'");
            EConst(CBool(false))
          )
        end
  in
  let pattern_cast (expr: expr_t) = function 
    | PType(TAny) -> expr
    | PType t -> EAsA(expr, t)
    | PCog(cog_name, _) -> EAsA(expr, TPhyCog(cog_name))
  in
  let rec pattern_bindings (struct_name, struct_type) target continuation =
    let typed_target = pattern_cast target struct_type in
    let recursive_continuation = 
      match struct_type with
        | PType _ -> continuation
        | PCog(cog_name, cog_body) ->
          begin try 
            List.fold_left2 (fun rest field_subscript field_pattern ->
              pattern_bindings field_pattern field_subscript rest
            ) continuation 
              (Cog.all_subscripts cog_name typed_target)
              cog_body
            with Not_found -> continuation
          end
    in
      match struct_name with 
        | None -> recursive_continuation
        | Some(name_to_be_assigned) ->
        let type_from_pattern =
          begin match struct_type with
            | PType(t) -> t
            | PCog(cog_name, _) -> TPhyCog(cog_name)
          end
        in
            ELet(
              name_to_be_assigned, 
              (EAsA(target, type_from_pattern)),
              recursive_continuation
            )
  in
    ELet("__match_target", (EAsA(target, match_base_type)), 
      List.fold_right (fun (pattern,match_body) rest ->
          EIfThenElse(
            pattern_match pattern (EVar("__match_target")),
            pattern_bindings pattern (EVar("__match_target")) match_body,
            rest
          )
      ) matches elseclause
    )