package jitd.parser;

import jitd.structure._

case class Definition(
  nodeTypes:Seq[Node],
  keyType: String = "int",
  recordType: String = "Record",
  includes:Seq[String] = Seq()
) 