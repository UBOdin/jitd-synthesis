package jitd.spec;

import jitd.structure._

case class Definition(
  nodeTypes:Seq[Node],
  accessPaths:Map[String,AccessPath],
  keyType: String = "int",
  recordType: String = "Record",
  includes:Seq[String] = Seq()
) 