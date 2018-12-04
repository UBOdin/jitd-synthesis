package jitd.codegen

import scala.collection.mutable

import jitd.spec._
import jitd.codegen.txt._

class Render(val definition: Definition) {
  def keyType = definition.keyType
  def recordType = definition.recordType
  def includes = Seq(
    "iostream",
    "vector",
    "memory",
    "algorithm"
  )

  def statement = new RenderStatement(this)
  def expression = statement.renderExpression

  val required_structs = mutable.ListBuffer[Seq[Field]]()

  def structID(fields:Seq[Field]):Int =
  {
    val ret = required_structs.indexOf(fields)
    if(ret < 0){
      required_structs += fields
      return required_structs.size-1
    }
    return ret
  }

  def structName(fields:Seq[Field]): String =
  {
    s"jitd_struct_${structID(fields)}"
  }

  def bufferName(t:Type): String =
  {
    val nestedType = cType(t)
    s"std::vector<$nestedType>"
  }

  def cType(t:Type): String =
  {
    t match {
      case TInt()          => "int"
      case TFloat()        => "double"
      case TBool()         => "boolean"
      case TKey()          => keyType
      case TNode()         => "std::shared_ptr<JITDNode>"
      case TRecord()       => recordType
      case TStruct(fields) => structName(fields)
      case TArray(nested)  => bufferName(nested)
      case TIterator()     => s"std::vector<$recordType>::const_iterator"
    }
  }

  def fieldDefn(f:Field, passByRef:Boolean = false): String = {
    val pbr = if(passByRef){ "&" } else { "" }
    s"${cType(f.t)} $pbr${f.name}"
  }

  def structTypedefs: String = 
  {
    required_structs.zipWithIndex.map {
      case (f, i) => 
        StructTemplate(f, s"jitd_struct_${i}", this) 
    }.mkString("\n")
  }

  def header(): String =
    JITDHeader(this).toString

  def body(headerFile: String): String =
    JITDBody(this, headerFile).toString

}

object Render 
{
  def apply(definition: Definition) = new Render(definition)
}