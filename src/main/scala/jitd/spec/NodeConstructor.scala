package jitd.spec;
case class NodeConstructor(args:Seq[Field],defaults:Seq[FunctionCall],body:Block=Block(Seq()))
{

	def toString(nodeName:String = "NodeConstructor") = nodeName+"("+args.mkString(", ")+"):"+ defaults.mkString(", ")+"\n"+body.asInstanceOf[Statement].toString
}