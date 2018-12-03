package jitd.spec

import scala.language.implicitConversions

case class Field(name:String, t:Type)

object FieldConversions {
  implicit def tuple2Field(t:(String, Type)) = Field(t._1, t._2)
}
