package jitd.spec

import jitd.structure._

class AccessPath(
  args:Seq[(String,Type)],
  lookups: Map[String, Statement]
)