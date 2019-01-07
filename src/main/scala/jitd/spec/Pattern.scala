package jitd.spec


/////////// Matching Patterns //////////

sealed abstract class MatchPattern
{
  def toConstructorPattern: ConstructorPattern
  def name: Option[String]
}

case class MatchNode(node: String, fields: Seq[MatchPattern], val name: Option[String] = None) extends MatchPattern
{
  def toConstructorPattern: ConstructNode = 
    ConstructNode(node, fields.map { _.toConstructorPattern }, name)
  override def toString = s"$node(${fields.map { _.toString}.mkString(", ")})"
}
case class MatchAny(val name: Option[String] = None) extends MatchPattern
{
  def toConstructorPattern =
    ConstructExpression(Var(name.get), None)
  override def toString = name.getOrElse("_")
}

/////////// Constructor Patterns //////////

sealed abstract class ConstructorPattern
{
  def andAfter(after: Statement):ConstructorPattern    = AfterConstruct(this, after)
  def andAfter(after: Expression):ConstructorPattern   = andAfter(Void(after))
  def butBefore(before: Statement):ConstructorPattern  = BeforeConstruct(before, this)
  def butBefore(before: Expression):ConstructorPattern = butBefore(Void(before))

  def toMatchPattern: MatchPattern
  def as(newName:String): ConstructorPattern
  
  override def toString = toString("")
  def toString(prefix: String): String
}

case class ConstructNode(node: String, fields: Seq[ConstructorPattern], name: Option[String] = None) extends ConstructorPattern
{
  def toMatchPattern = MatchNode(node, fields.map { _.toMatchPattern }, name)
  def as(newName:String) = ConstructNode(node, fields, Some(newName))
  def toString(prefix: String) = s"${prefix}$node${name.map { " @ "+_ }.getOrElse("")}["+fields.map { _.toString("\n"+prefix+"  ") }.mkString(",")+"\n"+prefix+"]"
}
case class BeforeConstruct(block: Statement, child: ConstructorPattern) extends ConstructorPattern
{
  def toMatchPattern = child.toMatchPattern
  def as(newName:String) = BeforeConstruct(block, child.as(newName))
  def toString(prefix: String) = 
    s"${prefix}{\n${block.toString(prefix+"  ")}\n${prefix}}\n${child.toString(prefix)}"
}
case class AfterConstruct(child: ConstructorPattern, block: Statement) extends ConstructorPattern
{
  def toMatchPattern = child.toMatchPattern
  def as(newName:String) = AfterConstruct(child.as(newName), block)
  def toString(prefix:String) = 
    s"${child.toString(prefix)}\n${prefix}{\n${block.toString(prefix+"  ")}\n${prefix}}"
}
case class ConstructExpression(expression: Expression, name: Option[String] = None) extends ConstructorPattern
{
  def toMatchPattern = 
    (expression, name) match {
      case (_, Some(s)) => MatchAny(name)
      case (Var(v), _)  => MatchAny(Some(v))
      case _            => MatchAny(None)
    }
  def as(newName:String) = ConstructExpression(expression, Some(newName))
  def toString(prefix:String) = prefix + expression + name.map { " @ "+_ }.getOrElse("")
}

/////////// Pattern Overlap //////////

sealed abstract class PatternOverlap

case class AncestorOverlap(levels: Integer) extends PatternOverlap
case class ComponentOverlap(fieldSequence: Seq[String]) extends PatternOverlap


object Pattern {

  def compatible(a: MatchPattern, b: MatchPattern): Boolean =
  {
    // println(s"Testing for compatibility between $a and $b")
    (a, b) match {
      case ( MatchNode(aNode, aFields, _), MatchNode(bNode, bFields, _) ) => (
          aNode.equals(bNode) && 
          aFields.zip(bFields)
                 .forall { compatible(_) }
        )
      case ( MatchAny(_), _ ) => true
      case ( _, MatchAny(_) ) => true
    }
  }
  def compatible(t: (MatchPattern, MatchPattern)): Boolean = 
    compatible(t._1, t._2)


  def allNodeDescendents(
    pattern: MatchPattern, 
    nodeMap:Map[String,Node], 
    prefix: Seq[String] = Seq(),
    omitSelf: Boolean = false
  ): Seq[(Seq[String], MatchNode)] = {
    pattern match {
      case MatchAny(_) => Seq()
      case mnPattern @ MatchNode(node, fields, _) => {
        val fieldNames = nodeMap(node).fields.map { _.name }
        fieldNames.zip(fields).map { 
          case (fieldName, fieldPattern) => 
            allNodeDescendents(fieldPattern, nodeMap, prefix++Seq(fieldName))
        }.flatten ++ (
          if(omitSelf) { Seq() }
          else { Seq( (prefix, mnPattern) ) } 
        )
           
      }
    }
  }


  //
  // Comprehensive check for overlap between patterns.
  //
  // Specifically, if we add a set of nodes matching [from] to the JITD, find every
  // way in which we could create a __new__ match for the pattern [to]
  // 
  // The result is a set of matches: 
  //   ComponentOverlap(path) indicates that [from] or one of its descendants could
  //     potentially be a match for [to].  The specific descendant is identified by 
  //     [path], a sequence of field names.  For example, an empty [path] indicates
  //     that the root of [from] itself is a potential match, while a [path] of size
  //     two indicates that a grandchild of [from] could match [to].
  //   
  //   AncestorOverlap(levels) indicates that it is possible that an ancestor of 
  //     [from], [levels] generations removed could potentially be a match for [to]
  //
  def overlap(
    from: MatchPattern, 
    to: MatchPattern, 
    nodes:Seq[Node]
  ): Seq[PatternOverlap] = 
  {
    val nodeMap = nodes.map { n => n.name -> n }.toMap

    // println(s"========== Checking descendants of $from against $to")
    val descendantMatches: Seq[ComponentOverlap] = 
      allNodeDescendents(from, nodeMap)
        .filter { node => 
            // println(s"Descendant checking $to against ${node._2}");
            compatible(node._2, to) }
        .map { _._1 }
        .map { ComponentOverlap(_) }

    // println(s"========== Checking ancestors of $from against $to")
    val ancestorMatches: Seq[AncestorOverlap] = 
      allNodeDescendents(to, nodeMap, omitSelf = true)
        .filter { node => 
            // println(s"Ancestor checking ${node._2} against $from");
            compatible(from, node._2) }
        .map { _._1.size }
        .map { AncestorOverlap(_) }

    return descendantMatches ++ ancestorMatches
  }

}