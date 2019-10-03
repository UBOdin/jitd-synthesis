package jitd.codegen

import scala.collection.mutable

import jitd.spec._
import jitd.codegen.txt._
import jitd.codegen.policy._

case class Render(
  val definition: Definition, 
  policyName: String = "",
  val policyImplementation:PolicyImplementation = PqPolicyImplementation,
  val debug:Boolean = false
) {
  def keyType = definition.keyType
  def recordType = definition.recordType

  lazy val policy = policyName match {
    case "" => definition.policies(0)
    case _ => definition.policies.find { _.name == policyName }.get
  }

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
      case TBool()         => "bool"
      case TKey()          => keyType
      case TNodeRef()      => "std::shared_ptr<JITDNode>"
      case TNode(t)        => s"${definition.node(t).renderName} *"
      case THandleRef()      => s"std::shared_ptr<JITDNode> *"
      case TRecord()       => recordType
      case TStruct(fields) => structName(fields)
      case TArray(nested)  => bufferName(nested)
      case TIterator()     => s"std::vector<$recordType>::const_iterator"
    }
  }

  def fieldDefn(f:Field, passByRef:Boolean = false, isConst:Boolean = false): String = {
    val pbr = if(passByRef){ "&" } else { "" }
    val const = if(isConst){ "const " } else { "" } 
    s"${const}${cType(f.t)} $pbr${f.name}"
  }

  def printableValue(name:String, t:Type): String = 
  {
    t match { 
      case TArray(_) => name + ".size() << \" elements\""
      case TInt() | TFloat() | TBool() | TKey() | TRecord() => name
      case TIterator() => ???
      case TStruct(_) => ???
      case TNodeRef() => ???
      case THandleRef() => ???
      case TNode(t) => ???
    }
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
