package jitd.spec


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
    ret: Type, 
    args: Seq[(String, Type, FunctionArgType.T)], 
    body:Statement
)