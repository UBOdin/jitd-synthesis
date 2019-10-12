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
        //val here = "\"HERE\""
        
        s"if(${target}->type != ${node.enumName}){$onFailure }\n"+
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
  
  def PqDeclare(ctx:Render,rule:PolicyRule,init:Boolean): String = 
  {
    rule match {
      case TieredPolicy(Seq()) => ""
      case TieredPolicy(policies) => policies.map{PqDeclare(ctx,_,true)}.mkString 
        
      case TransformPolicy(name, _, scoreFn) => 
        {
          val transfrom_name = name

          val pattern = ctx.definition.transform(name).from
          //println(name)
          pattern match {
            case MatchNode(nodeName, fields, name) => { 
              //val node = ctx.definition.nodesByName(nodeName)
              //println(name)
              if (fields.forall{_.isInstanceOf[MatchAny]})
              {
                if(init == true)
                {
                  s"std::set<std::shared_ptr<JITDNode> *, ${transfrom_name}_Cmp> ${transfrom_name}_PQ;\n"
                }
                else
                {
                  s"//${transfrom_name}_PQ"
                }
              }
              else
              {
                ""
              }   
          }

          }
          
        }
    
  }
  }
  def ComparatorClass(ctx:Render,rule:PolicyRule): String = 
  {
    //val rule = ctx.policy.rule;
    rule match {
      case TieredPolicy(Seq()) => ""
      case TieredPolicy(policies) => policies.map{ComparatorClass(ctx,_)}.mkString 
        
      case TransformPolicy(name, _, scoreFn) => 
        {
          val transfrom_name = name

          val pattern = ctx.definition.transform(name).from
          //println(name)
          pattern match {
            case MatchNode(nodeName, fields, name) => { 
              val node = ctx.definition.nodesByName(nodeName)
              if (fields.forall{_.isInstanceOf[MatchAny]})
              {
                s"struct ${transfrom_name}_Cmp{\n"+
                s" bool operator()( std::shared_ptr<JITDNode> * e1, std::shared_ptr<JITDNode> * e2) const{\n"+
                s"  size_t e1_score = 0;\n"+
                s"  JITDNode * e1_node_ptr = (*e1).get();\n"+
                s"  size_t e2_score = 0;\n"+
                s"  JITDNode * e2_node_ptr = (*e2).get();\n"+
                s"  ${node.renderName} * e1_node_ptr_real = (${node.renderName} *)e1_node_ptr;\n"+
                s"  ${node.renderName} * e2_node_ptr_real = (${node.renderName} *)e2_node_ptr;\n"+
                s"  e1_score = "+ ctx.expression(InlineVars(scoreFn, varMapping(ctx, pattern, "e1_node_ptr")++ctx.policy.varMapping))+";\n"+
                s"  e2_score = "+ ctx.expression(InlineVars(scoreFn, varMapping(ctx, pattern, "e2_node_ptr")++ctx.policy.varMapping))+";\n"+
                s"  if(e1_score == e2_score){\n"+
                s"    return (e1<e2);\n"+
                s"  }\n"+
                s"  else{\n"+
                s"    return (e1_score > e2_score);\n"+
                s"  }\n"+
                s" }\n"+
                s"};\n"
              }
              else
              {
                ""
              }
             
            
              
          }

          }
          
        }
    
  }
}
def PQCall(transform_name:String,pattern:MatchPattern):String = 
{
   pattern match {
            case MatchNode(nodeName, fields, name) => { 

              if(fields.forall{_.isInstanceOf[MatchAny]})
              {
                
                s"${transform_name}_PQ"
              }
              else
              {
                ""
              }
             
            }
           case MatchAny(_) => ""

  }  
}
  def setPqGen(ctx:Render, pattern:MatchPattern,setorpq:String):String = 
  {
    pattern match {
      case MatchNode(nodeName, fields, name) => {
        val node = ctx.definition.nodesByName(nodeName)
        s"${node.enumName}"+"_"+setorpq

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