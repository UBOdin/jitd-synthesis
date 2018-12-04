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
    "memory"
  )

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

  def headers(extras: Seq[String] = Seq()): String = 
  {
    (
      includes.map { i => s"#include <${i}>" }++
      (definition.includes++extras).map { i => "#include \""+i+"\"" }
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
    val renderedNodes = definition.nodes.map { NodeTemplate(_, this) }

    return renderedNodes.mkString("\n")
  }

  def renderSections(sections:(String,String)*): String = {
    sections
      .filter( _._2.length > 0 )
      .map { case (section, content) => 
        "////////////////////////////////////////////////////\n"+
        "///////////////     \n"+
        "///////////////     "+section+"\n"+
        "///////////////     \n"+
        "////////////////////////////////////////////////////\n\n"+
        content
      }
      .mkString("\n\n")
  }

  def header(): String =
    renderSections(
      "Headers"          -> headers(),
      "Structures"       -> structTypedefs,
      "Base Node Type"   -> NodeBaseTemplate(this).toString,
      "Node Definitions" -> nodes,
      "JITD Root"        -> JITDHeaderTemplate(definition, this).toString
    )

  def body(headerFile: String): String =
    renderSections(
      "Headers"          -> ("#include \""+headerFile+"\""),
      "JITD Root"        -> JITDBodyTemplate(definition, this).toString
    )

}

object Render 
{
  def apply(definition: Definition) = new Render(definition)
}