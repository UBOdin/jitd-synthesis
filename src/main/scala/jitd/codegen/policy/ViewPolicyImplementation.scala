package jitd.codegen.policy

import jitd.codegen.Render
import jitd.spec._
import jitd.codegen.policy.txt._
import jitd.rewrite._
import jitd.codegen.RenderPattern
import jitd.codegen.RenderStatement
import util.control.Breaks._
import jitd.codegen.RenderExpression
object ViewPolicyImplementation extends PolicyImplementation
{
  var node_transform = RenderPattern.nodeTransformMap
  //println(node_transform)  
  // Render field definitions for the JITD object
  def state(ctx:Render): String = "//std::cout<<\"STATE CALLED\"<<std::endl;"
  //Pre-conditoin: All support structures are empty
  def init(ctx:Render,rule:PolicyRule,root:String):String = 
  {
    s"std::shared_ptr<JITDNode> *root_handle = &"++root++";\n"+
    s"initialize_struts_view(root_handle,NULL);\n"
    //PQ_init(ctx,rule,"emplace(",Var("root_handle"),Var("root_handle")).toString
    //setpqAdd(ctx,definition,handlerefbool,to,toTarget,mutator)

  }
  
  def onRewriteSet(ctx:Render, 
    definition:Definition,
    mutator: Boolean,
    handlerefbool:Boolean,
    from:MatchPattern, 
    to:ConstructorPattern, 
    fromTarget:String, 
    toTarget:String): (Statement, Statement) =
  {
    if(mutator == true)
    {
      ((Comment(s"ViewMaintenance")++viewErase(ctx,definition,handlerefbool,from,fromTarget,mutator)++
      Comment(s"MapMaintenance")++mapErase(ctx,definition,handlerefbool,from,fromTarget,mutator)),
      (Comment(s"UpdateTarget")++atomic_store(ctx,definition,handlerefbool,to,toTarget,mutator)++ 
      Comment(s"ViewMaintenance")++viewAdd(ctx,definition,handlerefbool,to,toTarget,mutator)++
      Comment(s"MapMaintenance")++mapAdd(ctx,definition,handlerefbool,to,toTarget,mutator)))
    }
    else
    {
      ((Comment(s"ViewMaintenanceParent")++commonFunction("viewErase(",Var("parent"),Var(""))++
      Comment(s"ViewMaintenance")++viewErase(ctx,definition,handlerefbool,from,fromTarget,mutator)++
      Comment(s"MapMaintenance")++mapErase(ctx,definition,handlerefbool,from,fromTarget,mutator)), 
      (Comment(s"ViewMaintenanceParent")++commonFunction("viewAdd(",Var("parent"),Var(""))++
      Comment(s"ViewMaintenance")++viewAdd(ctx,definition,handlerefbool,to,toTarget,mutator)++
      Comment(s"MapMaintenance")++mapAdd(ctx,definition,handlerefbool,to,toTarget,mutator)))
    }
  }
  //(setpqRemove(ctx,definition,handlerefbool,from,fromTarget,mutator), (setpqAdd(ctx,definition,handlerefbool,to,toTarget,mutator)++ mapAdd(ctx,definition,handlerefbool,to,toTarget,mutator)))
  //Eg: of what OnRewriteSet should return

  //array(data) -> Btree(Array1,sep,Array2) 
  //CrackArray_PQ.erase(array)
  //SortArray_PQ.erase(array)
  //CrackArray_PQ.emplace(Array1)
  //CrackArray_PQ.emplace(Array2)
  //SortArray_PQ.emplace(Array1)
  //SortArray_PQ.emplace(Array1)

  //array(data) ->SortedArray(data)
  //CrackArray_PQ.erase(array)
  //SortArray_PQ.erase(array)
  //No PQ.emplace should happen since there is no transform that works on a sorted array. 
  //PROBLEM: But with the current logic there is a CrackArray_PQ.emplace(SortedArray) and SortArray_PQ.emplace(SortArray)

  //This function takes in the MatchPattern and adds that node to all possible PQs.
  //Post-condition:Every matched Node apprears in every PQ thats its eligible for and in appropriate sets.
  // def viewErase(ctx:Render,definition:Definition,handlerefbool:Boolean,fromNode:MatchPattern,fromNodeVar:String,mutator:Boolean):Statement =
  // {

  // }
 
  def viewErase(ctx:Render,definition:Definition,handlerefbool:Boolean,fromNode:MatchPattern,fromNodeVar:String,mutator:Boolean):Statement =
  {
    val rule = ctx.policy.rule
    //println(node_transform)
    val extract = 
      if(handlerefbool == true)
        {MatchToStatement.unrollSet(definition,fromNode,fromNodeVar+"_root",Var("target"),Var("target"))}
      else
        {MatchToStatement.unrollSet(definition,fromNode,fromNodeVar+"_root",WrapNodeRef(Var("target")),Var("target"))}
    
    val eachVarName = extract.map(getVarNameandType => (getVarNameandType._1,getVarNameandType._2,getVarNameandType._3,getVarNameandType._4,getVarNameandType._5))
    val viewseqStmt = eachVarName.map(vnnt => {
                                      vnnt._4 match{
                                              case MatchNode(nodeType, fields, _) =>
                                              {
                                                
                                                val elem = node_transform.getOrElse(nodeType,scala.collection.mutable.Set())
                                                if(!(elem.isEmpty))
                                                {
                                                  
                                                
                                                  Block(elem.toSeq.map(x => commonFunction("this->"+x+"_View.erase(",vnnt._3,Var(""))))
                                                  
                                                }
                                                else{
                                                  Block(Seq())
                                                }
                                                
                                                
                                                  
                                              }
                                              case MatchAny(_) => commonFunction("viewErase(",vnnt._3,Var("")) 
                                            } 
                                          })

    return Block(viewseqStmt)
  }
  def viewAdd(ctx:Render,definition:Definition,handlerefbool:Boolean,to:ConstructorPattern,toNodeVar:String,mutator:Boolean):Statement = 
  {
    val target = if (mutator == true) "*(cq_elem.second)" else "target"
    val rule = ctx.policy.rule

    val extract = 
      if(handlerefbool == true)//UnrollSet has been modified to return (varName,NodeType,Expression,MatchPattern)
        {MatchToStatement.unrollSet(definition,to.toMatchPattern,toNodeVar,(Var(target)),(Var(target)))}
      else
        {MatchToStatement.unrollSet(definition,to.toMatchPattern,toNodeVar,WrapNodeRef(Var(target)),(Var(target)))}

    val eachVarName = extract.map(getVarNameandType => (getVarNameandType._1,getVarNameandType._2,getVarNameandType._3,getVarNameandType._4,getVarNameandType._5)) 
    val viewseqStmt = eachVarName.map(vnnt => {
                                      vnnt._4 match{
                                              case MatchNode(nodeType, fields, _) =>
                                              {
                                                
                                                val elem = node_transform.getOrElse(nodeType,scala.collection.mutable.Set())
                                                if(!(elem.isEmpty))
                                                {
                                                  
                                                
                                                  Block(elem.toSeq.map(x => commonFunction("this->"+x+"_View.emplace(",vnnt._3,Var(""))))
                                                  
                                                }
                                                else{
                                                  Block(Seq())
                                                }
                                          
                                                
                                                  
                                              }
                                              case MatchAny(_) => commonFunction("viewAdd(",vnnt._3,Var("")) 
                                            } 
                                          })
                                      
    return Block(viewseqStmt)
  
  } 
  def mapErase(ctx:Render,definition:Definition,handlerefbool:Boolean,fromNode:MatchPattern,fromNodeVar:String,mutator:Boolean):Statement =
  {

    val rootNodeType = fromNode match {
      case MatchNode(nodeType,fields,_) => nodeType
      case MatchAny(_) => "" 
    }
    val rule = ctx.policy.rule
    val extract = 
      if(handlerefbool == true)
        {MatchToStatement.unrollSet(definition,fromNode,fromNodeVar+"_root",Var("target"),Var("target"))}
      else
        {MatchToStatement.unrollSet(definition,fromNode,fromNodeVar+"_root",WrapNodeRef(Var("target")),Var("target"))}
    
    val eachVarName = extract.map(getVarNameandType => (getVarNameandType._1,getVarNameandType._2,getVarNameandType._3,getVarNameandType._4,getVarNameandType._5))
    val maperaseseqStmt = eachVarName.map(vnnt => commonFunction("this->childParentMap.erase(",vnnt._3,Var("")))
                                     
    return Block(maperaseseqStmt)
  }
  def mapAdd(ctx:Render,definition:Definition,handlerefbool:Boolean,to:ConstructorPattern,toNodeVar:String,mutator:Boolean,prev_node:Option[Expression]=None):Statement =
  {
    val rootNodeType = to.toMatchPattern match {
      case MatchNode(nodeType,fields,_) => nodeType
      case MatchAny(_) => "" 
    }
    //println(nodeType)
    val target = if (mutator == true) "*(cq_elem.second)" else "target"
    val rule = ctx.policy.rule
    var prev_node_node = prev_node
    var prev_node_any = prev_node
    val extract = 
      if(handlerefbool == true)//UnrollSet has been modified to return (varName,NodeType,Expression,MatchPattern)
        {MatchToStatement.unrollSet(definition,to.toMatchPattern,toNodeVar,(Var(target)),(Var(target)))}
      else
        {MatchToStatement.unrollSet(definition,to.toMatchPattern,toNodeVar,WrapNodeRef(Var(target)),(Var(target)))}
    
    val eachVarName = extract.map(getVarNameandType => (getVarNameandType._1,getVarNameandType._2,getVarNameandType._3,getVarNameandType._4,getVarNameandType._5,getVarNameandType._6)) 
    //val tgt_prt = eachVarName.map(elem => println("current:",elem._3,"parent:",elem._6))
    val mapseqStmt = eachVarName.map(vnnt => 
                                      vnnt._4 match{ 
                                              case MatchNode(nodeType, fields, _) =>
                                              {
                                                  if(nodeType == rootNodeType)
                                                  {
                                                    if(mutator == true)
                                                    {
                                                      commonFunction("this->childParentMap.emplace(std::make_pair<std::shared_ptr<JITDNode> *,std::shared_ptr<JITDNode> *>(",vnnt._3,Var(",NULL)"))
                                                    }
                                                    else
                                                    {


                                                      commonFunction("this->childParentMap.emplace(",vnnt._3,Var(",parent"))
                                                    }
                                                  }
                                                 else
                                                 {
                                                    if(mutator == true)
                                                    {
                                                      
                                                      commonFunction("this->childParentMap.emplace(",vnnt._3,Var(",&(*(cq_elem.second))"))
                                                    }
                                                    else
                                                    {
                                                      
                                                      if(vnnt._6 == Var(target)|| vnnt._6 == WrapNodeRef(Var(target)))
                                                      {
                                                        commonFunctionSpecial("this->childParentMap.emplace(",vnnt._3,Some(vnnt._6))
                                                      }
                                                      else
                                                      {
                                                        commonFunctionSpecial("this->childParentMap.emplace(",vnnt._3,Some(vnnt._6))++
                                                        commonFunctionSpecial("fixMap(",vnnt._3,Some(vnnt._3))
                                                      }
                                                      
                                                      
                                                      
                                                    }
                                                    
                                                 }
                                                  
                                              }
                                              case MatchAny(_) => 
                                              {
                                                  if(mutator == true)
                                                  {
                                                    commonFunction("this->childParentMap.emplace(",vnnt._3,Var(",&(*(cq_elem.second))"))
                                                  }
                                                  else
                                                  {
                                                   

                                                    
                                                   if(vnnt._6 == Var(target)|| vnnt._6 == WrapNodeRef(Var(target)))
                                                      {
                                                        commonFunctionSpecial("this->childParentMap.emplace(",vnnt._3,Some(vnnt._6))
                                                      }
                                                      else
                                                      {
                                                        commonFunctionSpecial("this->childParentMap.emplace(",vnnt._3,Some(vnnt._6))++
                                                        commonFunctionSpecial("fixMap(",vnnt._3,Some(vnnt._3))
                                                      }
                                                    

                                                  
                                                   
                                                   
                                                  }
                                                
                                                 
                                              }
                                        })
    return Block(mapseqStmt)
 
  }
  def atomic_store(ctx:Render,definition:Definition,handlerefbool:Boolean,to:ConstructorPattern,toNodeVar:String,mutator:Boolean):Statement = 
  { 
    val target = if (mutator == true) "*(cq_elem.second)" else "target"
    val rule = ctx.policy.rule

    val extract = 
      if(handlerefbool == true)//UnrollSet has been modified to return (varName,NodeType,Expression,MatchPattern)
        {MatchToStatement.unrollSet(definition,to.toMatchPattern,toNodeVar,(Var(target)),(Var(target)))}
      else
        {MatchToStatement.unrollSet(definition,to.toMatchPattern,toNodeVar,WrapNodeRef(Var(target)),(Var(target)))}

    val eachVarName = extract.map(getVarNameandType => (getVarNameandType._1,getVarNameandType._2,getVarNameandType._3,getVarNameandType._4,getVarNameandType._5)) 
    val setseqStmt = eachVarName.map(vnnt => 
                                      vnnt._4 match{
                                              case MatchNode(nodeType, fields, _) =>
                                              {
                                                
                                                  Block(Seq())
                                                
                                                  
                                              }
                                              case MatchAny(_) => 
                                                {
                                                  if(mutator == true)
                                                  {

                                                    
                                                    commonFunction("std::atomic_store(",vnnt._3,Var(", *(cq_elem.first)"))++
                                                    commonFunction("fixMap(",Var("&(*(cq_elem.first)),"),vnnt._3)
                                     
                                                
                                                  }
                                                  else
                                                  {
                                                    
                                                  Block(Seq())

                                                  }
                                                }
                                              }) 
          return {Block(setseqStmt)}
         
  }

  def onRewrite(ctx:Render,
    from:MatchPattern, 
    to:ConstructorPattern, 
    fromTarget:String, 
    toTarget:String
    
  ): (Statement, Statement) = (Comment(s"onRewrite1"), Comment(s"onRewrite2"))


  def utilityFunctions(ctx:Render, rule:PolicyRule): String = 
  {
    
      rule match {
      case TieredPolicy(policies) => policies.map { utilityFunctions(ctx, _) }.mkString
      case TransformPolicy(unique_name,name, constraint, scoreFn) =>
        
        UseViewPolicySearchFor(  // Generated via Twirl template
                    ctx, 
                    ctx.definition.transform(name), 
                    constraint, 
                    scoreFn
                    ).toString
        
    }

  
    
  }

  def utilityFunctions(ctx:Render): String =
    utilityFunctions(ctx, ctx.policy.rule)
  def onMatchPattern(ctx:Render,rule:PolicyRule):String = 
  {
    rule match{
      case TieredPolicy(policies) => policies.map { onMatchPattern(ctx, _) }.mkString
      case TransformPolicy(unique_name,name, constraint, scoreFn) =>
        {
          ViewOnMatchPattern(ctx, 
                    ctx.definition.transform(name), 
                    constraint, 
                    scoreFn
                    ).toString
        }

    }
  }

  def doOrganize(ctx:Render, root:String, rule:PolicyRule, onSuccess:String, onFail:String): String =
    rule match {
      case TieredPolicy(Seq()) => onFail
      case TieredPolicy(policies) => 
        doOrganize(ctx, root, policies.head, onSuccess, "")+"  "+
          doOrganize(ctx, root, TieredPolicy(policies.tail), onSuccess, onFail)
      case TransformPolicy(unique_name,name, _, _) => 
        UsePqPolicyTryTransform(ctx, root, name, onSuccess, onFail).toString
    }

  // Render a block of code to be run when an idle cycle is available.
  def doOrganize(ctx:Render, root:String): String = 
  {
    //println(ctx.definition.transforms.to)
    doOrganize(ctx, root, ctx.policy.rule, "return true;\n", "return false;\n")+"\n"
    
    
  }
    
}
