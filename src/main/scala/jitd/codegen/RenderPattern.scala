package jitd.codegen

import jitd.spec._

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

  def build(ctx:Render, pattern:MatchPattern, target:String, initializers:Map[String,Expression]): String =
  {
    pattern match {
      case MatchNode(nodeName, fields, name) => {
        val node = ctx.definition.nodesByName(nodeName)
        val targetReal = target+"_real"

        val (init, body) = fields.zip(node.fields).map {
          case (fieldPattern:MatchNode, fieldDefinition) =>
            (
              s"${targetReal}_${fieldDefinition.name}",
              Some(build(ctx, fieldPattern, s"${targetReal}_${fieldDefinition.name}", initializers))
            )
          case (MatchAny(Some(name)), fieldDefinition) =>
            (
              ctx.expression(initializers(name)),
              None
            )
          case _ => throw new Exception("Erroneous Pattern Build")
        }.unzip

        body.flatten.mkString+
        s"${node.renderName} *${targetReal} = new ${node.renderName}(${init.mkString(", ")});\n"+
        s"std::shared_ptr<JITDNode> ${target}(${targetReal});\n"
      }

      // MatchAny should never happen.  The match root needs to be a node, 
      // and the MatchNode case only recurs on MatchNodes
      case MatchAny(name) => throw new Exception("Erroneous Pattern Build")
    }
  }
}