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
    targetExpression: Expression,
    addornot:Boolean
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
                if(addornot == false)
                {
                    WrapNodeRef(NodeSubscript(Var(extractName), fieldDefinition.name))
                }
                else{
                    WrapNodeRef(NodeCast(nodeType,Var(extractName), fieldDefinition.name))
                },
                if(addornot == false)
                {
                  false
                }
                else{
                  true
                } 
              )
          } 

    }
  }
  // def unroll(
  //   definition: Definition,
  //   pattern: ConstructorPattern, 
  //   extractName: VarName, 
  //   targetExpression: Expression,
  //   addornot:Boolean
  // ): 
  //   Seq[ (VarName, NodeType, Expression) ] =
  // {
     
    
  //   pattern match {
  //     case MatchAny(_)                    => Seq()
  //     case MatchNode(nodeType, fields, _) => 
  //       Seq( (extractName, nodeType, targetExpression) ) ++
  //         fields.zip(definition.node(nodeType).fields).flatMap { 
  //           case (fieldPattern, fieldDefinition) => 
  //             unroll(
  //               definition, 
  //               fieldPattern, 
  //               extractName + "_" + fieldDefinition.name,
  //               UnWrapHandle(NodeSubscript(Var(extractName), fieldDefinition.name)),
  //               true  
  //             )
  //         } 

  //   }
  // }


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
    //println(directFieldRef)
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
def varMappingsForEmplace(
    definition: Definition, 
    pattern: ConstructorPattern, 
    targetName: String,
    directFieldRef: Expression
  )
  {
    //println(directFieldRef)
    // val ret = pattern match {
    //   case ConstructExpression(_, None) => Seq()
      
    //   case ConstructExpression(_, Some(name)) => 
    //     Seq(Var(targetName))
    //   case ConstructNode(nodeType, fields, name) => {
    //        val me = Var(targetName)
    //       // val typeOfNode = nodeType 
    //       // val myMapping:Map[String, Expression] = 
    //       //   name match { 
    //       //     case Some(x) => Map(x -> Var(" "))
    //       //     case None => Map()
    //       //   }
    //       val temp = fields.zip(definition.node(nodeType).fields).map { 
    //         case (fieldPattern, fieldDefinition) => 
    //           varMappingsForEmplace(
    //             definition, 
    //             fieldPattern, 
    //             targetName+"_"+fieldDefinition.name,
    //            NodeSubscript(me, fieldDefinition.name)
    //           )
              
    //           //println(temp)
    //       }.flatten
    //     }
      
    //   case BeforeConstruct(_, target) => Seq()
    //   case AfterConstruct(target, _) => Seq()
    // }
    // println(ret)
    // //directFieldRef 
    // directFieldRef match {
    //   case ns@NodeSubscript(_,_) =>  Seq(ns) ++ ret
    //   // case ns@NodeSubscript(_,"rhs")) =>  Seq(ns)
    //   // case ns@NodeSubscript(_,"listptr")) =>  Seq(ns)
    //   // case ns@NodeSubscript(_,"data")) =>  Seq(ns)    
    //   case _ => ret
    //   }
  }



  def apply(
    definition: Definition,
    pattern: MatchPattern, 
    target: VarName,
    handleref : Boolean, 
    onMatch: Statement, 
    onFail: Statement
  ): Statement = 
  {
    val fromMappings = varMappings(definition, pattern, target+"_root") 
    val extractionSteps = if(handleref == true) 
      {unroll(definition, pattern, target+"_root", (Var(target)),false)} 
    else 
      {unroll(definition, pattern, target+"_root", WrapNodeRef(Var(target)),false)}
    //println(InlineVars(onMatch, fromMappings))
    return extractionSteps
      .foldRight(InlineVars(onMatch, fromMappings)) { (check, accumulator) => {
        val (nodeVarName, nodeType, nodeSourceExpression) = check
        //println("MTS "+nodeVarName+"||"+nodeType+"||"+nodeSourceExpression)
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
          //println("Construct: "+node)
          val nodeDefinition = definition.node(node)
          val nodeName = nameOption.getOrElse(target)
          //println(nodeName)
          val (fieldConstructors, fieldExpressions) = 
            fields.zip(nodeDefinition.fields).map { case (fieldPattern, fieldDefinition) =>
              constructorWithoutVarMapping(definition, fieldPattern, nodeName+"_"+fieldDefinition.name)
            }.unzip
          (
            fieldConstructors.fold(Block(Seq())){ _ ++ _ } ++ 
            Block(
              Seq(
                Comment(s"Assemble $target as a $node"),
                Declare( nodeName, Some(TNode(node)), MakeNode(node, fieldExpressions)),
                Declare( nodeName+"_ref", Some(TNodeRef()), WrapNode(Var(nodeName))),
                Comment(s"Code to add nodes into sets")
                
              )
            ),
            Var(nodeName+"_ref")
          )
        }
      case AfterConstruct(child, code) => {
        val (constructor, accessor) = constructorWithoutVarMapping(definition, child, target) 
        (constructor ++Comment(s"Handle post-processing for $target") ++ code, accessor)
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
    //println(pattern)
    //println(varMappings(definition, pattern, target))
    val (constructor, accessor) = constructorWithoutVarMapping(definition, pattern, target)
    //println("MTS"+constructor)
    //println(InlineVars(constructor, varMappings(definition, pattern, target)))
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