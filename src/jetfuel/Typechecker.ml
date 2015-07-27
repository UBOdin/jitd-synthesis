open Type
open ListUtils
open Expression

exception TypecheckError of string * (expr_t option)

let typeof_const (c:const_t): prim_t =
  match c with
    | CInt _    -> TInt
    | CFloat _  -> TFloat
    | CString _ -> TString
    | CBool _   -> TBool
;;

let escalate ?(ctx:expr_t option = None) (a:jf_t) (b:jf_t): jf_t =
	(* Hacked for now.  Proper escalation required *)
    if a != b then raise (
    	TypecheckError("Invalid match", ctx)
    ) else a
;;

let test_compat ?(ctx:expr_t option = None) (a:jf_t) (b:jf_t): unit =
	let _ = escalate ~ctx:ctx a b in ()
;;

let rec typeof 
		?(validate=false) 
		?(scope:jf_t StringMap.t = StringMap.empty) 
		(root:expr_t): jf_t =
  let rcr e = typeof ~validate:validate ~scope:scope e in
  let rcr_f t e = 
  	if validate && ((escalate ~ctx:(Some(root)) t (rcr e)) != t)
  	then raise (TypecheckError("Invalid type escalation", Some(root)))
  in
  let rcr_s (v:var_t) (t:jf_t) (e:expr_t) =
  	typeof ~validate:validate ~scope:(StringMap.add v t scope) e
  in
  match root with 
    | EIfThenElse(c, t, e) -> 
        begin
        	(* The condition had better be a boolean *)
	    	rcr_f (TPrimitive(TBool)) c;
	    	(* Return the escalated type of the then/else clauses *)
	    	escalate ~ctx:(Some(root)) (rcr t) (rcr e)
        end

    | EBlock(elist) ->
    	List.fold_left (fun _ curr -> rcr curr) TNone elist

    | ELet(tgt, defn, body) ->
    	rcr_s tgt (rcr defn) body

    | ECall(fn, arglist) ->
    	begin match rcr fn with
    		| TFn({ Type.typecheck = typecheck_args }) -> 
    			typecheck_args (List.map rcr arglist)
    		| _ -> 
    			raise (TypecheckError(
    				"Invalid call", 
    				Some(root)
    			))
    	end

    | ERewrite(handle, rewrite) ->
    	TNone

    | ENeg(e) ->
    	rcr_f (TPrimitive(TBool)) e; (TPrimitive(TBool))

    | EArithOp(op, a, b) ->
    	begin match op with
    		| (APlus | AMinus | ATimes ) -> 
    			escalate ~ctx:(Some(root)) (rcr a) (rcr b)
    		| (ADiv) ->
    			begin
	    			if validate 
	    			then test_compat ~ctx:(Some(root)) (rcr a) (rcr b);
	    			TPrimitive(TFloat)
	    		end
    		| (AAnd | AOr) -> 
    			rcr_f (TPrimitive(TBool)) a;
    			rcr_f (TPrimitive(TBool)) b;
    			(TPrimitive(TBool))
	    end

    | ECmpOp(op, a, b) ->
    	begin
	    	if validate 
	    	then test_compat ~ctx:(Some(root)) (rcr a) (rcr b);
	    	(TPrimitive(TBool))
	    end

    | EConst(c) -> 
    	TPrimitive(typeof_const c)

    | EVar(v) -> 
    	StringMap.find v scope 

    | EIsA(expr, t) ->
    	begin
	    	rcr_f TAny expr;
	    	(TPrimitive(TBool))
    	end

    | ESubscript(expr, subscript) ->
    	begin match rcr expr with
    		| TCog(Some(ctype)) ->
    			begin match subscript with
    			 	| EConst(CString(field)) ->
    			 		Cog.field_type ctype field
    			 	| _ ->
    			 		raise (TypecheckError(
    			 			"Invalid subscript: Cog",
    			 			Some(root)
    			 		))
			 	end

    		| TList(_, t) ->
    			rcr_f (TPrimitive(TInt)) subscript;
    			t

    		| TMap(kt, vt) ->
    			rcr_f kt subscript;
    			vt

    		| TTuple(fields) ->
    			begin match subscript with
    			 	| EConst(CString(field)) ->
    			 		List.assoc field fields
    			 	| _ ->
    			 		raise (TypecheckError(
    			 			"Invalid subscript: Tuple",
    			 			Some(root)
    			 		))
			 	end

			| _ -> 
				raise (TypecheckError(
					"Non group being subscripted",
					Some(root)
				))
	    end

;;
