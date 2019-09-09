package jitd.codegen

import jitd.spec._
import jitd.rewrite.InlineVars

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
  def setIteration(ctx:Render,constraint:Expression,scoreFn:Expression, pattern:MatchPattern, target:String, onFailure:String): String =
  {

    val indent = "\t\t\t"
    val indent2 = "\t\t\t\t"
    val indent3 = "\t\t\t\t\t"
    val indent4 = "\t\t\t\t\t\t"
    val here = "\"HERE\""
    pattern match{
      case MatchNode(nodeName,fields,name)=>{
        val node = ctx.definition.nodesByName(nodeName)
        val sizeCheck = ctx.expression(InlineVars(constraint,RenderPattern.varMapping(ctx, pattern, "lock_raw")++ctx.policy.varMapping))
        val scoreCalc = ctx.expression(InlineVars(scoreFn,RenderPattern.varMapping(ctx, pattern, "lock_raw")++ctx.policy.varMapping))
        s"if(!${node.enumName}_set.empty()){\n"+
        //s"std::cout<<${node.enumName}_set.size()"+"<<std::endl;\n"+
        indent+s"std::set< std::shared_ptr<JITDNode>  >::iterator it;\n"+
        indent+s"for(it = ${node.enumName}_set.begin();it != ${node.enumName}_set.end();++it ){\n"+
          indent2+s"JITDNode *lock_raw = it->get();\n"+ 
          indent2+s"if(lock_raw->type!= JITD_NODE_Array){break;}\n"+
          //s"std::cout<<lock_raw->type"+"<<std::endl;\n"+
          indent2+s"${node.renderName} *${target}_real = (${node.renderName}*)${target};\n"+ 
          indent2+s"if("+sizeCheck.mkString+"){\n"+
            indent3+s"bestScoreVal = "+scoreCalc.mkString+";\n"+
            indent3+s"if(bestScoreVal > currentScoreVal){\n"+
            //s"std::cout<<bestScoreVal"+"<<std::endl;\n"+
              indent4+s"currentScoreVal = bestScoreVal;\n"+
              //s"std::cout<<currentScoreVal"+"<<std::endl;\n"+
              indent4+s"targetHandleRef = (std::shared_ptr<JITDNode> *)&(*it);\n"+
              indent4+"}\n"+
            indent3+s"}\n"+ 
          indent2+s"}\n"+
          //s"std::cout<<"+here+"<<&targetHandleRef<<"+here+"<<targetHandleRef->get()->type<<std::endl;\n"+
        "\t}"
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
        ( ctx.expression(InlineVars(expression, varMappings)),
          Seq(), Seq()
        )
      case BeforeConstruct(newBefore, child) => {
          val (fieldInitializer, oldBefore, oldAfter) = buildField(ctx, child, field, target, varMappings)
          ( fieldInitializer, 
            Seq(ctx.statement(InlineVars(newBefore, varMappings))) ++ oldBefore,
            oldAfter
          )
        }
      case AfterConstruct(child, newAfter) => {
          val (fieldInitializer, oldBefore, oldAfter) = buildField(ctx, child, field, target, varMappings)
          ( fieldInitializer, 
            oldBefore,
            oldAfter ++ Seq(ctx.statement(InlineVars(newAfter, varMappings)))
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