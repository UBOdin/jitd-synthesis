package jitd.codegen
import scala.collection.mutable.Set
import jitd.spec._
import jitd.rewrite.InlineVars
import jitd.rewrite.MatchToStatement
import jitd.codegen.policy._
object RenderPattern
{
  //Try using immutable
  var trackablesets = scala.collection.mutable.Set[String]()
  
  var nodeTransformMap = scala.collection.mutable.Map[String,scala.collection.mutable.Set[String]]()
  var patternTransformMap = scala.collection.mutable.Map[MatchPattern,scala.collection.mutable.Set[String]]()
  var trackablepq = scala.collection.mutable.Set[String]()
  def test(ctx:Render, pattern:MatchPattern, target:String, onFailure:String,score_root_pattern_set:Option[String]=None): String =
  {
    //val root_pattern = score_root_pattern.getOrElse{(None)}
    var string_append = ""
    val root_pattern_set = score_root_pattern_set.getOrElse{""}

    val recur = (newPattern:MatchPattern, newTarget:String) => test(ctx, newPattern, newTarget, onFailure,score_root_pattern_set)

    pattern match {
      case MatchNode(nodeName, fields, name) => { 
        val node = ctx.definition.nodesByName(nodeName)
        val targetReal = target+"_real"
        //val here = "\"HERE\""
        // s"#ifdef DEBUG\n"+
        // s"assert(${target}!=NULL);\n"+
        // s"#endif\n"+
        //s"//${root_pattern_set}\n"+
        if(!((root_pattern_set.toString).isEmpty))
        {

          string_append = s"${root_pattern_set}.erase(*it);check_pq();/*${root_pattern_set}.emplace_hint(${root_pattern_set}.end(),*it);check_pq();*/"
        }
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

  def NodeMatchTransformPattern(ctx:Render,pattern:MatchPattern,target:String,onFailure:String):String = 
  {
    val recur = (newPattern:MatchPattern, newTarget:String) => NodeMatchTransformPattern(ctx, newPattern, newTarget, onFailure)

    pattern match {
      case MatchNode(nodeName, fields, name) => { 
        val node = ctx.definition.nodesByName(nodeName)
        val targetReal = target+"_real"
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
  def ViewCall(ctx:Render,rule:PolicyRule,nodeName:String,op:String,node:String):String = 
  {
    rule match {
      case TieredPolicy(Seq()) => ""
      case TieredPolicy(policies) => policies.map{ViewCall(ctx,_,nodeName,op,node)}.mkString
      case TransformPolicy(unique_name,name, _, scoreFn) =>
      {
        val transform_name = name
        val pattern = ctx.definition.transform(name).from
        pattern match{
          case MatchNode(nodeType, fields, _) => 
          {
            // println(nodeType)
            // println(nodeName)
            // s"//onMatch${transform_name}"
            
              if(nodeType == nodeName)
               {
                  if(op == "erase")
                  {
                    s"this->${transform_name}_View.${op}(${node});\n"

                  }
                  else
                  {
                    s"matched = this->match${transform_name}(${node});\n"+
                    s"if(matched == true){\n"+
                    s"this->${transform_name}_View.${op}(${node});\n"+
                    s"}\n"
                  }
                  
               }
               else
               {
                  ""
               }

            
             
          }
          //case MatchAny(_) => ""
        }
      } 
    }
  }
   def ViewDeclare(ctx:Render,rule:PolicyRule,init:Boolean): String = 
  {
    rule match {
      case TieredPolicy(Seq()) => ""
      case TieredPolicy(policies) => policies.map{ViewDeclare(ctx,_,true)}.mkString 
        
      case TransformPolicy(unique_name,name, _, scoreFn) => 
        {
          val transfrom_name = name
          val pattern = ctx.definition.transform(name).from
          pattern match {
            case MatchNode(nodeType, fields, _) => {
              //println(nodeType)
              //nodeTransformMap.addBinding(nodeType,transfrom_name)
              //val elem = scala.collection.mutable.Set[String]()
              var elem = nodeTransformMap.getOrElse(nodeType,Set())
              var trans_set = patternTransformMap.getOrElse(pattern,Set())
              if(trans_set.isEmpty)
              {
                patternTransformMap += (pattern -> Set(transfrom_name))
              }
              else{
                //println(elem)
                trans_set += transfrom_name
                patternTransformMap.update(pattern,trans_set)
              }
              if(elem.isEmpty)
              {
                nodeTransformMap += (nodeType -> Set(transfrom_name))
              }
              else{
                //println(elem)
                elem += transfrom_name
                nodeTransformMap.update(nodeType,elem)
              }
              //nodeTransformMap += nodeTransformMap.get(nodeType).map(elem => nodeType-> elem.add(transfrom_name))
            }
          }
          val eligibility = PqPolicyImplementation.eligible(pattern)
              //println(trackablesets)
              if (eligibility == true)
              {
                if(init == true)
                {

                   //s"std::set<std::shared_ptr<JITDNode> *, ${transfrom_name}_Cmp> ${transfrom_name}_PQ;\n"
                   s"#ifdef CACHE_ALIGNED_ALLOCATOR\n"+
                   s"std::set<std::shared_ptr<JITDNode> *, ${transfrom_name}_Cmp,tbb::cache_aligned_allocator<std::shared_ptr<JITDNode> *>> ${transfrom_name}_View;\n"+
                   s"#endif\n"+
                    s"#ifdef DEFAULT_ALLOCATOR\n"+
                   s"std::set<std::shared_ptr<JITDNode> *, ${transfrom_name}_Cmp> ${transfrom_name}_View;\n"+
                   s"#endif\n"
                   
                   
                }
                else
                {
                   ""
                }
              }
              else
              {
                 s"#ifdef CACHE_ALIGNED_ALLOCATOR\n"+
                   s"std::set<std::shared_ptr<JITDNode> *,std::less<std::shared_ptr<JITDNode> *>,tbb::cache_aligned_allocator<std::shared_ptr<JITDNode> *>> ${transfrom_name}_View;\n"+
                   s"#endif\n"+
                    s"#ifdef DEFAULT_ALLOCATOR\n"+
                  s"std::set<std::shared_ptr<JITDNode> *> ${transfrom_name}_View;\n"+
                   s"#endif\n"
                
                
                
              } 
         

          
          
        }
    
  }
  
 } 
 
  def SetPqDeclare(ctx:Render,rule:PolicyRule,init:Boolean): String = 
  {
    rule match {
      case TieredPolicy(Seq()) => ""
      case TieredPolicy(policies) => policies.map{SetPqDeclare(ctx,_,true)}.mkString 
        
      case TransformPolicy(unique_name,name, _, scoreFn) => 
        {
          val transfrom_name = name

          val pattern = ctx.definition.transform(name).from
          val eligibility = PqPolicyImplementation.eligible(pattern)
              //println(trackablesets)
              if (eligibility == true)
              {
                if(init == true)
                {

                   s"std::set<std::shared_ptr<JITDNode> *, ${transfrom_name}_Cmp> ${transfrom_name}_PQ;\n"
                   //s"std::set<std::shared_ptr<JITDNode> *> ${transfrom_name}_View;\n"
                   
                }
                else
                {
                   ""
                }
              }
              else
              {
                val extract = MatchToStatement.unrollSet(ctx.definition,pattern,"",(Var("")),(Var("")))
                if(trackablesets(extract(0)._2.toString))
                {
                  ""//s"std::set<std::shared_ptr<JITDNode> *> ${transfrom_name}_View;\n"
                }
                else
                {
                  trackablesets.add(extract(0)._2.toString)
                  s"std::set<std::shared_ptr<JITDNode> *> JITD_NODE_${extract(0)._2.toString}_set;\n"
                  //s"std::set<std::shared_ptr<JITDNode> *> ${transfrom_name}_View;\n"
                  
                }
                
                
              }  
          

          
          
        }
    
  }
  
 } 
 
 def PQPopulate(ctx:Render,rule:PolicyRule,op:String,node_name:String,node_type:String,node_enumName:String):String = 
 {
  rule match {
      case TieredPolicy(Seq()) => ""
      case TieredPolicy(policies) => policies.map{PQPopulate(ctx,_,op,node_name,node_type,node_enumName)}.mkString 
        
      case TransformPolicy(unique_name,name, _, scoreFn) => 
        {
          val transfrom_name = name

          val pattern = ctx.definition.transform(name).from
          //println(name)
          pattern match {
            case MatchNode(nodeName, fields, name) => { 
              //val equality = node_type.equals(nodeName)
              val node = ctx.definition.nodesByName(nodeName)
              if (fields.forall{_.isInstanceOf[MatchAny]} && node_type.equals(nodeName))
              {
                s"this->"+transfrom_name+"_PQ."+op+"("+node_name+");\n" //Assumption: If there is a PQ there cannot be a set
                
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
 def SetPopulate(ctx:Render,rule:PolicyRule,op:String,node_name:String,node_type:String,node_enumName:String):String = 
 {
  
  if(trackablesets(node_type)) 
  {
    s"this->"+node_enumName+"_set."+op+"("+node_name+");\n" //Assumption: If there is a PQ there cannot be a set 
   
  }
  else
  {
    ""
  }
 
 }
 
  def ComparatorClass(ctx:Render,rule:PolicyRule): String = 
  {
    //val rule = ctx.policy.rule;
    rule match {
      case TieredPolicy(Seq()) => ""
      case TieredPolicy(policies) => policies.map{ComparatorClass(ctx,_)}.mkString 
        
      case TransformPolicy(unique_name,name, _, scoreFn) => 
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
                //s"  assert(e1_node_ptr_real!=NULL);\n"+
                //s"  assert(e2_node_ptr_real!=NULL);\n"+
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
//Function is used in pure Set policy
  def setGen(ctx:Render, pattern:MatchPattern):String = 
  {
    pattern match {
      case MatchNode(nodeName, fields, name) => {
        val node = ctx.definition.nodesByName(nodeName)
        s"${node.enumName}"+"_"+"set"

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