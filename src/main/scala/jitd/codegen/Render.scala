package jitd.codegen

import scala.collection.mutable

import jitd.spec._
import jitd.structure._
import jitd.codegen.txt.{NodeTemplate, StructTemplate, HeaderTemplate}

class Render(val definition: Definition) {
  def keyType = definition.keyType
  def recordType = definition.recordType
  def includes = Seq(
    "iostream",
    "vector"
  )

  val required_structs = mutable.ListBuffer[Seq[Field]]()

  def getStructID(fields:Seq[Field]):Int =
  {
    val ret = required_structs.indexOf(fields)
    if(ret < 0){
      required_structs += fields
      return required_structs.size-1
    }
    return ret
  }

  def getStructName(fields:Seq[Field]): String =
  {
    s"jitd_struct_${getStructID(fields)}"
  }

  def getBufferName(t:Type): String =
  {
    val nestedType = getCType(t)
    s"std::vector<$nestedType>"
  }

  def getCType(t:Type): String =
  {
    t match {
      case TInt()          => "int"
      case TFloat()        => "double"
      case TKey()          => keyType
      case TNode()         => "JITDNode *"
      case TRecord()       => recordType
      case TStruct(fields) => getStructName(fields)
      case TVector(nested) => getBufferName(nested)
    }
  }

  def getFieldDefn(f:Field): String = 
    s"${getCType(f.t)} ${f.name}"


  def headers: String = 
  {
    (
      includes.map { i => s"#include <${i}>" }++
      definition.includes.map { i => "#include \""+i+"\"" }
    ).mkString("\n")
  }

  def structTypedefs: String = 
  {
    required_structs.zipWithIndex.map {
      case (f, i) => 
        StructTemplate(f, s"jitd_struct_${i}", this) 
    }.mkString("\n")
  }

  def nodes: String =
  {
    val renderedNodes = definition.nodeTypes.map { NodeTemplate(_, this) }

    return renderedNodes.mkString("\n")
  }

  def header(): String =
  {
    return Seq[String](
      headers,
      HeaderTemplate(this).toString,
      structTypedefs,
      nodes
    ).filter( _.length > 0 )
     .mkString("\n\n/*****************************/\n\n")
  }

}

object Render 
{
  def apply(definition: Definition) = new Render(definition)
}