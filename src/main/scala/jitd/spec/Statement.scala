package jitd.spec

import jitd.structure._

sealed abstract class Statement

case class Return(v:Expression) extends Statement
case class Abort(err:Option[String] = None) extends Statement
case class IfThenElse(condition:Expression, ifTrue:Statement, ifFalse:Statement = Block(Seq())) extends Statement
case class Assign(name:String, t:Type, v:Expression) extends Statement
case class Block(statements:Seq[Statement]) extends Statement
case class ForEach(loopvar:String, over:Expression, body:Statement) extends Statement