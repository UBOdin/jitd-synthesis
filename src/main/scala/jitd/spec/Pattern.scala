package jitd.spec

sealed abstract class MatchPattern

case class MatchNode(t: String, fields: Seq[MatchPattern], name: Option[String] = None) extends MatchPattern
case class MatchAny(name: Option[String] = None) extends MatchPattern
