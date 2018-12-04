package jitd.typecheck

import jitd.spec._

class TypeError(msg: String, ctx: Expression, scope:Map[String, Type]) extends Exception(msg+" in "+ctx.toString)
{
  override def toString:String = {
    msg + " in " + ctx + "\n\n"+scope
  }
}


class Typechecker(functions: Map[String, FunctionDefinition]) {

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
    val recur = (r:Expression) => typeOf(r, scope)
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
      case Cmp(op, a, b) => {
        if(comparisonCompatible(recur(a), recur(b))){
          return TBool()
        } else {
          error("Invalid Comparison")
        }
      }
      case FunctionCall(name, args) => {
        functions.getOrElse(name, {
          error("Undefined function")
        })(args.map { recur })
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
          case None => error("Variable not in scope")
        }
      }
    }
  }

  def check(stmt: Statement, scope: Map[String, Type], returnType:Type): Map[String, Type] =
  {
    val exprType = (e:Expression) => typeOf(e, scope)
    val error = (e:Expression, msg:String) => throw new TypeError(msg, e, scope)
    val recur = (rstmt: Statement, rscope: Map[String, Type]) => check(rstmt, rscope, returnType)
    stmt match { 
      case Block(elems) => {
        elems.foldLeft(scope) { (currScope, currStmt) => 
          recur(currStmt, currScope)
        }
        scope
      }
      case Assign(tgt, expr) => {
        val tgtType = scope.getOrElse(tgt, { error(expr, "Assignment to undefined variable: "+tgt) })
        if(exprType(expr) != tgtType){
          error(expr, "Assignment to "+tgt+" of incorrect type")
        }
        scope
      }
      case Declare(tgt, tOption, expr) => {
        if(scope contains tgt) {
          error(expr, "Overriding existing variable")
        }
        val tRet = tOption match {
          case Some(t) => if(t != exprType(expr)){ 
            error(expr, "Declaring expression of incorrect type") 
          } else { t } 
          case None => exprType(expr)
        }
        scope + (tgt -> tRet)
      }
      case Return(expr) => {
        if(exprType(expr) != returnType) { 
          error(expr, s"Invalid Return Type (Found: ${exprType(expr)}; Expected: $returnType)")
        }
        scope
      }
      case ForEach(loopvar, expr, body) => {
        if(scope contains loopvar) {
          error(expr, "Overriding existing variable")
        }
        exprType(expr) match {
          case TArray(nested) => 
            recur(body, scope + (loopvar -> nested))
          case _ => 
            error(expr, "Invalid loop target")
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

}