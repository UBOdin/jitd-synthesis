package jitd.spec

sealed abstract class Type {
  def array = TArray(this)
}

case class TKey() extends Type { override def toString = "key" }
case class TRecord() extends Type

case class TInt() extends Type
case class TFloat() extends Type
case class TBool() extends Type
case class TArray(t:Type) extends Type
case class TStruct(fields:Seq[Field]) extends Type
case class TNode() extends Type
case class TIterator() extends Type

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
      case TNode() => "node"
      case TIterator() => "iterator"
    }
}