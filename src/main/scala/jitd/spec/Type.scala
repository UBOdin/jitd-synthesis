package jitd.spec

sealed abstract class Type {
  def array = TArray(this)
}

sealed abstract class PrimType extends Type

case class TKey() extends PrimType { override def toString = "key" }
case class TRecord() extends Type

case class TInt() extends PrimType
case class TFloat() extends PrimType
case class TBool() extends PrimType
case class TArray(t:Type) extends Type
case class TStruct(fields:Seq[Field]) extends Type
case class TNodeRef() extends Type
case class TNode(t:String) extends Type
case class TIterator() extends Type
case class THandleRef() extends Type
object Type
{
  def toString(t: Type): String =
    t match {
      case TKey() => "key"
      case TRecord() => "record"
      case TInt() => "int"
      case TFloat() => "float"
      case TBool() => "bool"
      case TArray(nested) => s"array[${Type.toString(nested)}]"
      case TStruct(fields) => s"struct[${fields.map { _.toString }.mkString{", "}}]"
      case TNodeRef() => "noderef"
      case THandleRef() => "handleref"
      case TNode(t) => s"node[$t]"
      case TIterator() => "iterator"
    }
}