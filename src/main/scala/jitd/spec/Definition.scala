package jitd.spec;

case class Definition(
  nodes:Seq[Node],
  accessors:Map[String,Accessor],
  keyType: String = "int",
  recordType: String = "Record",
  includes:Seq[String] = Seq()
) {

  val nodesByName = nodes.map { n => n.name -> n }.toMap

}