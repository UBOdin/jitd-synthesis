package jitd.spec

sealed abstract class Type {}

case class TKey() extends Type
case class TRecord() extends Type

case class TInt() extends Type
case class TFloat() extends Type
case class TBool() extends Type
case class TArray(t:Type) extends Type
case class TStruct(fields:Seq[Field]) extends Type
case class TNode() extends Type
case class TIterator() extends Type