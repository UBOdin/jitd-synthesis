package jitd.spec

import jitd.typecheck.FunctionSignature

object FunctionArgType extends Enumeration 
{
  type T = Value
  val Input, OutputRef, ConstInputRef = Value

  def isConst(t: T): Boolean = 
    t match { 
      case ConstInputRef => true
      case Input | OutputRef => false
    }
  def isByRef(t: T): Boolean = 
    t match { 
      case ConstInputRef | OutputRef => true
      case Input => false
    }
}

case class FunctionDefinition(
    name: String, 
    ret: Option[Type], 
    args: Seq[(String, Type, FunctionArgType.T)], 
    body: Statement
) 
{
  def signature =
    ret match { 
      case Some(t) =>
        FunctionSignature(name, args.map { _._2 }, t)
      case None => 
        FunctionSignature(name, args.map { _._2 })
    }
}