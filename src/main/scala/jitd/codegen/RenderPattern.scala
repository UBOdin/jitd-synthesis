package jitd.codegen

import jitd.spec._
import jitd.rewrite.Inline

object RenderPattern
{
  def test(ctx:Render, pattern:MatchPattern, target:String, onFailure:String): String =
  {
    val recur = (newPattern:MatchPattern, newTarget:String) => test(ctx, newPattern, newTarget, onFailure)

    pattern match {
      case MatchNode(nodeName, fields, name) => { 
        val node = ctx.definition.nodesByName(nodeName)
        val targetReal = target+"_real"
        s"if(${target}->type != ${node.enumName}){ $onFailure }\n"+
        s"${node.renderName} *${targetReal} = (${node.renderName} *)${target};\n"+
        fields.zip(node.fields).map { 
          case (fieldPattern:MatchNode, fieldDefinition) =>
            val newTargetName = targetReal+"_"+fieldDefinition.name
            recur(fieldPattern, newTargetName)
            s"JITDNode *${newTargetName} = ${targetReal}->${fieldDefinition.name}.get();\n"+
            recur(fieldPattern, newTargetName)
          case (fieldPattern, fieldDefinition) => ""
        }.mkString
      }
      case MatchAny(name) => ""

    }
  }

  def varMapping(ctx:Render, pattern:MatchPattern, target:String): Map[String,Var] =
  {
    pattern match {
      case MatchNode(nodeName, fields, name) => {
        val node = ctx.definition.nodesByName(nodeName)
        val targetReal = target+"_real"
        name.map { _ -> Var(s"(${target})") }.toMap ++
        fields.zip(node.fields).map { 
          case (fieldPattern:MatchNode, fieldDefinition) =>
            varMapping(ctx, fieldPattern, s"${targetReal}_${fieldDefinition.name}")      
          case (fieldPattern:MatchAny, fieldDefinition) =>
            varMapping(ctx, fieldPattern, s"${targetReal}->${fieldDefinition.name}")      
        }.flatten
      }
      case MatchAny(name) => name.map { _ -> Var(s"(${target})") }.toMap
    }    
  }
  def varMapping(ctx:Render, pattern:ConstructorPattern, target:String): Map[String,Var] =
    varMapping(ctx, pattern.toMatchPattern, target)

  def buildField(ctx:Render, pattern:ConstructorPattern, field:Field, target:String, varMappings: Map[String, Expression]): (String, Seq[String], Seq[String]) =
  {
    pattern match {
      case constructor: ConstructNode =>
        ( target,
          Seq(build(ctx, constructor, target, varMappings)),
          Seq()
        )
      case ConstructExpression(expression, _) => 
        ( ctx.expression(Inline(expression, varMappings)),
          Seq(), Seq()
        )
      case BeforeConstruct(newBefore, child) => {
          val (fieldInitializer, oldBefore, oldAfter) = buildField(ctx, child, field, target, varMappings)
          ( fieldInitializer, 
            Seq(ctx.statement(Inline(newBefore, varMappings))) ++ oldBefore,
            oldAfter
          )
        }
      case AfterConstruct(child, newAfter) => {
          val (fieldInitializer, oldBefore, oldAfter) = buildField(ctx, child, field, target, varMappings)
          ( fieldInitializer, 
            oldBefore,
            oldAfter ++ Seq(ctx.statement(Inline(newAfter, varMappings)))
          )
        }
    }
  }

  def build(ctx:Render, pattern:ConstructNode, target:String, varMappings: Map[String, Expression]): String =
  {
    val node = ctx.definition.nodesByName(pattern.node)
    val targetReal = target+"_real"

    val (fieldInitializers, before, after) = 
      pattern.fields.zip(node.fields)
            .map { case (fieldPattern, fieldDefinition) => 
                      buildField(ctx, fieldPattern, fieldDefinition, s"${targetReal}_${fieldDefinition.name}", varMappings) }
            .unzip3

    before.flatten.mkString+
    s"${node.renderName} *${targetReal} = new ${node.renderName}(${fieldInitializers.mkString(", ")});\n"+
    s"std::shared_ptr<JITDNode> ${target}(${targetReal});\n"+
    after.flatten.mkString
  }

  def buildForTransform(
    ctx:Render, 
    toPattern:ConstructNode, 
    toTarget:String, 
    fromPattern: MatchNode, 
    fromTarget:String
  ): String = {
    val (before, after) = 
      ctx.policyImplementation.onRewrite(ctx, fromPattern, toPattern, fromTarget, toTarget)
    return (
      before+
      build(ctx, toPattern, toTarget, varMapping(ctx, toPattern, toTarget) ++ varMapping(ctx, fromPattern, fromTarget))+
      after
    )
  }

  def buildForMutator(
    ctx:Render, 
    pattern:ConstructNode, 
    target:String, 
    varMappings: Map[String, Expression]
  ) =
  {
    val (before, after) = 
      ctx.policyImplementation.onRewrite(ctx, MatchAny(), pattern, "ERROR_IN_RenderPattern", target)
    build(ctx, pattern, target, varMapping(ctx, pattern, target) ++ varMappings)
  }
}