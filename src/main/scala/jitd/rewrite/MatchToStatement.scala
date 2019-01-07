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

  def varMappings(
    definition: Definition, 
    pattern: ConstructorPattern, 
    targetName: String,
    directFieldRef: Option[Expression] = None
  ): Map[String, Expression] =
  {
    pattern match {
      case ConstructExpression(_, None) => Map()
      
      case ConstructExpression(_, Some(name)) => 
        Map( name -> 
              directFieldRef.getOrElse { Var(targetName) }
        )

      case ConstructNode(nodeType, fields, name) => {
          val me = Var(targetName)
          val myMapping:Map[String, Expression] = 
            name match { 
              case Some(x) => Map(x -> Var(targetName+"_ref"))
              case None => Map()
            }
          fields.zip(definition.node(nodeType).fields).map { 
            case (fieldPattern, fieldDefinition) => 
              varMappings(
                definition, 
                fieldPattern, 
                targetName+"_"+fieldDefinition.name, 
                Some(NodeSubscript(me, fieldDefinition.name))
              )
          }.fold(myMapping) { _ ++ _ }
        }
      
      case BeforeConstruct(_, target) => varMappings(definition, target, targetName)
      case AfterConstruct(target, _) => varMappings(definition, target, targetName)
    }
  }

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
      .foldRight(InlineVars(onMatch, fromMappings)) { (check, accumulator) => {
        val (nodeVarName, nodeType, nodeSourceExpression) = check
        ExtractNode(nodeVarName, nodeSourceExpression, Seq(nodeType -> accumulator), onFail)
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
          // println("Construct: "+node)
          val nodeDefinition = definition.node(node)
          val nodeName = nameOption.getOrElse(target)
          val (fieldConstructors, fieldExpressions) = 
            fields.zip(nodeDefinition.fields).map { case (fieldPattern, fieldDefinition) =>
              constructorWithoutVarMapping(definition, fieldPattern, nodeName+"_"+fieldDefinition.name)
            }.unzip
          (
            fieldConstructors.fold(Block(Seq())){ _ ++ _ } ++ 
            Block(
              Seq(
                Comment(s"Assemble $target as a $node"),
                Declare( nodeName, Some(TNode(node)), MakeNode(node, fieldExpressions) ),
                Declare( nodeName+"_ref", Some(TNodeRef()), WrapNode(Var(target)))
              )
            ),
            Var(nodeName+"_ref")
          )
        }
      case AfterConstruct(child, code) => {
        val (constructor, accessor) = constructorWithoutVarMapping(definition, child, target) 
        (constructor ++ Comment(s"Handle post-processing for $target") ++ code, accessor)
      }
      case BeforeConstruct(code, child) => {
        val (constructor, accessor) = constructorWithoutVarMapping(definition, child, target) 
        (Comment(s"Handle pre-processing for $target") ++ code ++ constructor, accessor)
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
    // println(pattern)
    // println(varMappings(definition, pattern, target))
    val (constructor, accessor) = constructorWithoutVarMapping(definition, pattern, target)
    // println(constructor)
    // println(InlineVars(constructor, varMappings(definition, pattern, target)))
    (
      InlineVars(
        Comment(s"BEGIN ASSEMBLING $target") ++ 
          constructor ++ 
          Comment(s"END ASSEMBLING $target as $accessor"), 
        varMappings(definition, pattern, target)),
      // constructor,
      accessor
    )
  }
}