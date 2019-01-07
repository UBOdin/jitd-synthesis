package jitd.typecheck

import jitd.spec._

class TypeError(msg: String, ctx: Expression, scope:Map[String, Type]) extends Exception(msg+" in "+ctx.toString)
{
  override def toString:String = {
    val scopeLen = scope.map { case (k, _ ) => k.length }.max
    "-----------------------\n"+msg + " in " + ctx + "\n\n"+"---- Current Scope ----\n"+
      scope.map { case (k, t) => "   " + k.padTo(scopeLen, " ").mkString + "  <- " + t }.mkString("\n")+
      "\n-----------------------"
  }

  def rebind(newCtx:Expression) = new TypeError(msg, newCtx, scope)
  def rebind(newCtx:Statement) = new StatementError(msg, Seq(newCtx), scope)
}

class StatementError(msg: String, ctx: Seq[Statement], scope:Map[String, Type]) extends Exception(msg+" in "+ctx(0).toString)
{
  override def toString:String = {
    val scopeLen = scope.map { case (k, _ ) => k.length }.max
    "-----------------------\n"+msg + " in " + ctx.head + "\n\n"+"---- Current Scope ----\n"+
      scope.map { case (k, t) => "   " + k.padTo(scopeLen, " ").mkString + "  <- " + t }.mkString("\n")+
      "\n-----------------------"+
      (if(ctx.length > 1) { "\n -- in -- \n"+ctx.tail.map { _.toString }.mkString("\n -- in -- \n")} else { "" })
  }
  def trace(stmt: Statement) = new StatementError(msg, ctx :+ stmt, scope)
}


class Typechecker(functions: Map[String, FunctionSignature], nodeTypes: Map[String, Node]) {

  def comparisonCompatible(t1:Type, t2:Type): Boolean =
  {

    if(t1 == t2) { return true; }
    (t1, t2) match {
      case (TIterator(), _)    => return comparisonCompatible(TRecord(), t2)
      case (_, TIterator())    => return comparisonCompatible(t1, TRecord())
      case (TKey(), TRecord()) => return true
      case (TRecord(), TKey()) => return true
      case _ => return false
    }
  }
  
  def typeOf(e: Expression, scope: Map[String, Type]): Type = 
  {
    val error = (msg:String) => throw new TypeError(msg, e, scope)
    val recur = (r:Expression) => try { typeOf(r, scope) } catch { case t: TypeError => throw t.rebind(e) }
    e match {
      case c:Constant => c.t
      case ArraySubscript(arr, _) => {
        recur(arr) match { 
          case TArray(nested) => nested
          case _ => error("Subscript of Non-Array")
        }
      }
      case StructSubscript(struct, subscript) => {
        recur(struct) match {
          case TStruct(fields) => 
            fields.find { _.name.equals(subscript) } match {
              case Some(field) => field.t
              case None => error("Invalid Struct Subscript: "+subscript)
            }
          case _ => error("Subscript of Non-Struct")
        }
      }
      case NodeSubscript(struct, subscript) => {
        recur(struct) match {
          case TNode(nodeType) => 
            nodeTypes(nodeType).fields.find { _.name.equals(subscript) } match {
              case Some(field) => field.t
              case None => error("Invalid Node Subscript: "+subscript)
            }
          case _ => error("Subscript of Non-Node")
        }
      }
      case Cmp(op, a, b) => {
        if(comparisonCompatible(recur(a), recur(b))){
          return TBool()
        } else {
          error("Invalid Comparison")
        }
      }
      case Arith(_, a, b) => {
        (recur(a), recur(b)) match {
          case (TInt(), TInt()) => return TInt()
          case (TInt(), TFloat())
             | (TFloat(), TInt())
             | (TFloat(), TFloat()) => return TFloat()
          case _ => error("Invalid Arithmetic")
        }
      }
      case FunctionCall(name, args) => {
        try {
          functions.getOrElse(name, {
            error("Undefined function")
          })(args.map { recur }).getOrElse { error("Using return value from void function") }
        } catch { 
          case e:FunctionArgError => error(e.toString)
        }
      }
      case FunctionalIfThenElse(c, t, e) => {
        (recur(c), recur(t), recur(e)) match {
          case (TBool(), a, b) if a == b => a
          case (TBool(), _, _) => error("Incompatible functional then-else clauses")
          case (_, _, _) => error("Non-Boolean if-then-else condition")
        }
      }
      case Var(name) => {
        scope.get(name) match {
          case Some(t) => t
          case None => error(s"Variable '$name' not in scope")
        }
      }
      case WrapNode(target) => {
        recur(target) match {
          case TNode(_) => TNodeRef()
          case _ => error("Can't wrap a non-node")
        }
      }
      case MakeNode(nodeType, fields) => {
        for( (field, expr) <- nodeTypes(nodeType).fields.zip(fields)){
          if(recur(expr) != field.t) { 
            error("Invalid node constructor")
          }
        }
        TNode(nodeType)
      }
    }
  }

  def check(stmt: Statement, scope: Map[String, Type], returnType:Type): Map[String, Type] =
  {
    val exprType = (e:Expression) => try { typeOf(e, scope) } catch { case e:TypeError => throw e.rebind(stmt) }
    val error = (msg:String) => throw new StatementError(msg, Seq(stmt), scope)
    val recur = (rstmt: Statement, rscope: Map[String, Type]) => try { check(rstmt, rscope, returnType) } catch { case e:StatementError => throw e.trace(stmt) }
    stmt match { 
      case Block(elems) => {
        elems.foldLeft(scope) { (currScope, currStmt) => 
          recur(currStmt, currScope)
        }
        scope
      }
      case Assign(tgt, expr, isAtomic) => {
        val tgtType = scope.getOrElse(tgt, { error("Assignment to undefined variable: "+tgt) })
        if(exprType(expr) != tgtType){
          error("Assignment to "+tgt+" of incorrect type")
        }
        if(tgtType == TNodeRef() && !isAtomic){
          error("Non-atomic assignment to a NodeRef")
        }
        scope
      }
      case Declare(tgt, tOption, expr) => {
        if(scope contains tgt) {
          error("Overriding existing variable")
        }
        val tRet = tOption match {
          case Some(t) => if(t != exprType(expr)){ 
            error("Declaring expression of incorrect type") 
          } else { t } 
          case None => exprType(expr)
        }
        scope + (tgt -> tRet)
      }
      case ExtractNode(name, expr, nodeType, onSuccess, onFail) => {
        if(scope contains name) { 
          error("Overriding existing variable")
        }
        if(!(nodeTypes contains nodeType)) {
          error(s"Invalid Node Type: '$nodeType'")
        }
        if(exprType(expr) != TNodeRef()) {
          error("Doesn't evaluate to an (extractable) node reference")
        }
        recur(onSuccess, scope + (name -> TNode(nodeType)))
        recur(onFail, scope)
        scope
      }
      case Return(expr) => {
        if(exprType(expr) != returnType) { 
          error(s"Invalid Return Type (Found: ${exprType(expr)}; Expected: $returnType)")
        }
        scope
      }
      case Void(expr @ FunctionCall(name, args)) => {
        try {
          functions.getOrElse(name, {
            error("Undefined function")
          })(args.map { exprType(_) })
        } catch { 
          case e:FunctionArgError => error(e.toString)
        }
        scope
      }
      case Void(expr) => {
        exprType(expr)
        scope
      }
      case ForEach(loopvar, expr, body) => {
        if(scope contains loopvar) {
          error("Overriding existing variable")
        }
        exprType(expr) match {
          case TArray(nested) => 
            recur(body, scope + (loopvar -> nested))
          case _ => 
            error("Invalid loop target")
        }
        scope
      }
      case IfThenElse(c, t, e) => {
        if(exprType(c) != TBool()){
          error(c, "Invalid if-then-else condition")
        }
        recur(t, scope)
        recur(e, scope)
        scope
      }

    }
  }

  def check(fn: FunctionDefinition): FunctionDefinition =
  {
    check(fn.body, fn.args.map { case (name, t, _) => name -> t }.toMap, fn.ret)
    return fn
  }

}