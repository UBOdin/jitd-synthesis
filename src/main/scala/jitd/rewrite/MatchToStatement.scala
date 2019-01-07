package jitd.rewrite

import jitd.spec._

object MatchToStatement 
{
  type VarName  = String
  type NodeType = String

  def unroll(
    definition: Definition,
    pattern: MatchPattern, 
    extractName: VarName, 
    targetExpression: Expression
  ): 
    Seq[ (VarName, NodeType, Expression) ] =
  {
    pattern match {
      case MatchAny(_)                    => Seq()
      case MatchNode(nodeType, fields, _) => 
        Seq( (extractName, nodeType, targetExpression) ) ++
          fields.zip(definition.node(nodeType).fields).flatMap { 
            case (fieldPattern, fieldDefinition) => 
              unroll(
                definition, 
                fieldPattern, 
                extractName + "_" + fieldDefinition.name, 
                NodeSubscript(Var(extractName), fieldDefinition.name) 
              )
          }
    }
  }

  def varMappings(
    definition: Definition,
    pattern: MatchPattern,
    targetName: String
  ): Map[String, Expression] =
  {
    val myMapping = pattern.name.toSeq.map { name => name -> Var(targetName) }.toMap

    val childMappings = 
      pattern match {
        case MatchAny(_) => Map()
        case MatchNode(nodeType, fields, _) => 
            fields.zip(definition.node(nodeType).fields).map { 
              case (MatchAny(None), fieldDefinition) => Map()
              case (MatchAny(Some(name)), fieldDefinition) => Map( 
                  name -> NodeSubscript(Var(targetName), fieldDefinition.name) 
                )
              case (fieldPattern:MatchNode, fieldDefinition) => 
                varMappings(definition, fieldPattern, targetName + "_" + fieldDefinition.name)
            }.fold(Map()){ _ ++ _ }
      }
    
    return myMapping ++ childMappings
  }

  def varMappings(definition: Definition, pattern: ConstructorPattern, targetName: String): Map[String, Expression] =
    varMappings(definition, pattern.toMatchPattern, targetName)

  def apply(
    definition: Definition,
    pattern: MatchPattern, 
    target: VarName, 
    onMatch: Statement, 
    onFail: Statement
  ): Statement = 
  {
    val fromMappings = varMappings(definition, pattern, target+"_root") 

    val extractionSteps = unroll(definition, pattern, target+"_root", Var(target))

    return extractionSteps
      .foldRight(Inline(onMatch, fromMappings)) { (check, accumulator) => {
        val (nodeVarName, nodeType, nodeSourceExpression) = check
        ExtractNode(nodeVarName, nodeSourceExpression, nodeType, accumulator, onFail)
      }}
  }

  def constructorWithoutVarMapping(
    definition: Definition,
    pattern: ConstructorPattern,
    target: VarName
  ): (Statement, Expression) =
  {
    pattern match {
      case ConstructNode(node, fields, nameOption) => {
          val nodeDefinition = definition.node(node)
          val nodeName = nameOption.getOrElse(target)
          val (fieldConstructors, fieldExpressions) = 
            fields.zip(nodeDefinition.fields).map { case (fieldPattern, fieldDefinition) =>
              apply(definition, fieldPattern, nodeName+"_"+fieldDefinition.name)
            }.unzip
          (
            fieldConstructors.fold(Block(Seq())){ _ ++ _ } ++ 
            Block(
              Seq(
                Declare( nodeName+"_real", Some(TNode(node)), MakeNode(node, fieldExpressions) ),
                Declare( nodeName, Some(TNodeRef()), WrapNode(Var(target+"_real")))
              )
            ),
            Var(nodeName)
          )
        }
      case AfterConstruct(child, code) => {
        val (constructor, accessor) = apply(definition, child, target) 
        (constructor ++ code, accessor)
      }
      case BeforeConstruct(code, child) => {
        val (constructor, accessor) = apply(definition, child, target) 
        (code ++ constructor, accessor)
      }
      case ConstructExpression(expression, _) =>
        (Block(Seq()), expression)
    }
  }

  def apply(
    definition: Definition,
    pattern: ConstructorPattern,
    target: VarName
  ): (Statement, Expression) =
  {
    val (constructor, accessor) = constructorWithoutVarMapping(definition, pattern, target)
    (
      Inline(constructor, varMapping(defintion, pattern, target)),
      accessor
    )
  }
}