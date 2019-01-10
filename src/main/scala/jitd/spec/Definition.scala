package jitd.spec;

import jitd.JITDRuntime
import jitd.typecheck._

case class Definition(
  nodes:Seq[Node],
  accessors:Seq[Accessor],
  mutators:Seq[Mutator],
  transforms:Seq[Transform],
  policies:Seq[Policy],
  functions:Seq[FunctionSignature],
  keyType: String = "int",
  recordType: String = "Record",
  includes:Seq[String] = Seq()
) {

  val nodesByName = nodes.map { n => n.name -> n }.toMap
  val functionsByName = functions.map { n => n.name -> n }.toMap
  val typechecker = new Typechecker(functionsByName, nodesByName)

  def node(name:String):Node = nodesByName(name)
  def accessor(name:String):Accessor = accessors.find { _.name.equals(name) }.get
  def mutator(name:String):Mutator = mutators.find { _.name.equals(name) }.get
  def transform(name:String):Transform = transforms.find { _.name.equals(name) }.get
  def policy(name:String):Policy = policies.find { _.name.equals(name) }.get
  def function(name:String):FunctionSignature = functionsByName(name)

  override def toString =
    Seq(
      Seq(s"key $keyType", s"record $recordType"),
      includes.map { include => "include \""+include+"\"" },
      nodes.map { _.toString },
      accessors.map { _.toString },
      mutators.map { _.toString },
      transforms.map { _.toString },
      policies.map { _.toString }
    ).map { _.mkString("\n") }.mkString("\n\n////////////////\n\n")
}

class HardcodedDefinition
{
  var functionSignatures:List[FunctionSignature] = JITDRuntime.functions.toList
  var nodes = List[jitd.spec.Node]()
  var accessors = List[jitd.spec.Accessor]()
  var mutators = List[jitd.spec.Mutator]()
  var transforms = List[jitd.spec.Transform]()
  var policies = List[jitd.spec.Policy]()

  def Def(ret: Type, name: String, args:Type*) 
  {
    functionSignatures = jitd.typecheck.FunctionSignature(name, args, ret) :: functionSignatures
  }
  def Def(name: String, args:Type*) 
  {
    functionSignatures = jitd.typecheck.FunctionSignature(name, args) :: functionSignatures
  }
  def Import(newFunctions: Seq[FunctionSignature])
  {
    functionSignatures = functionSignatures ++ newFunctions
  }

  def Node(name:String, fields:Field*) 
  {
    nodes = jitd.spec.Node(name, fields) :: nodes
  }

  def Accessor(name: String, ret:Type = TBool())(inputs:Field*)(outputs:Field*)(per_node:(String, Statement)*)
  {
    accessors = new jitd.spec.Accessor(name, inputs, outputs, per_node.toMap, ret) :: accessors
  }

  def Mutator(name:String)(args:Field*)(constructor:ConstructNode)
  {
    mutators = jitd.spec.Mutator(name, args, constructor) :: mutators
  }

  def Transform(name: String)(from: MatchNode)(to: ConstructorPattern)
  {
    transforms = jitd.spec.Transform(name, from, to) :: transforms
  }

  def InvertedTransform(name:String, as:String)
  {
    val source = transforms.find { _.name == name }.get
    transforms = source.invertAs(as) :: transforms
  }

  def Policy(name:String)(parameters:(String,Constant)*)(rule:PolicyRule)
  {
    policies = jitd.spec.Policy(name, parameters.map { p => Field(p._1, p._2.t) }, parameters.map { _._2 }, rule) :: policies
  }

  def Build(node:String, args:ConstructorPattern*) = ConstructNode(node, args)
  def Match(node:String, args:MatchPattern*)       = MatchNode(node, args)
  def Any(name:String)                             = MatchAny(Some(name))
  def Any                                          = MatchAny(None)

  def Call(fn: String)(args:Expression*): Expression =
    FunctionCall(fn, args)

  def If(cond:Expression)(thenClause:Statement)(elseClause:Statement): Statement =
    IfThenElse(cond, thenClause, elseClause)

  def record            = TRecord()
  def key               = TKey()
  def int               = TInt()
  def float             = TFloat()
  def bool              = TBool()
  def node              = TNodeRef()
  def iterator          = TIterator()

  def Delegate(args:Expression*) = Call("delegate")(args:_*)

  import scala.language.implicitConversions
  implicit def stringToVar(x:String) = Var(x)
  implicit def stringToExpressionConstructor(x:String) = ConstructExpression(Var(x))
  implicit def stringToMatchAny(x:String) = MatchAny(Some(x))
  implicit def stringToTransformPolicy(x:String) = TransformPolicy(x)
  implicit def boolToBoolConst(x:Boolean) = BoolConstant(x)
  implicit def intToIntConstant(x:Integer) = IntConstant(x)
  implicit def doubleToFloatConstant(x:Double) = FloatConstant(x)
  implicit class StringHelper(s:String) 
  {
    def withFields(fields:MatchPattern*) = MatchNode(s, fields)
    def fromFields(fields:ConstructorPattern*) = ConstructNode(s, fields)
    def call(args: Expression*) = FunctionCall(s, args)
  }
  implicit def expressionToConstructor(x:Expression) = ConstructExpression(x)

  def definition = Definition(
    nodes      = nodes,
    accessors  = accessors,
    mutators   = mutators,
    transforms = transforms,
    policies   = policies,
    functions  = functionSignatures,
    includes = Seq("int_record.hpp", "runtime.hpp")
  )

  def functions = functionSignatures.map { f => f.name -> f }.toMap
  def node(name:String):Node = nodes.find { _.name.equals(name) }.get
  def accessor(name:String):Accessor = accessors.find { _.name.equals(name) }.get
  def mutator(name:String):Mutator = mutators.find { _.name.equals(name) }.get
  def transform(name:String):Transform = transforms.find { _.name.equals(name) }.get
  def policy(name:String):Policy = policies.find { _.name.equals(name) }.get
}