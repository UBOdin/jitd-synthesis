package jitd.structure;

import scala.language.implicitConversions

case class Field(name:String, t:Type)

object FieldConversions {
  implicit def tuple2Field(t:(String, Type)) = Field(t._1, t._2)
}



abstract sealed class Type {}

case class TKey() extends Type
case class TRecord() extends Type

case class TInt() extends Type
case class TFloat() extends Type
case class TVector(t:Type) extends Type
case class TStruct(fields:Seq[Field]) extends Type
case class TNode() extends Type