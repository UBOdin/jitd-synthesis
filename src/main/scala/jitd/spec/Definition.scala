package jitd.spec;

case class Definition(
  nodes:Seq[Node],
  accessors:Seq[Accessor],
  transforms:Seq[Transform],
  keyType: String = "int",
  recordType: String = "Record",
  includes:Seq[String] = Seq()
) {

  val nodesByName = nodes.map { n => n.name -> n }.toMap

}