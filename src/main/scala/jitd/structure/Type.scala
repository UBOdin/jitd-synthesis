package jitd.structure;


abstract class Type {}

case class TKey() extends Type
case class TRecord() extends Type

case class TInt() extends Type
case class TFloat() extends Type
case class TSeq(t:Type) extends Type
case class TNode(s:String) extends Type