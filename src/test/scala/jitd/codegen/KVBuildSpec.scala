package jitd.codegen

import org.specs2.mutable._
import org.specs2.specification._

import jitd.example.KeyValueJITD

class KVBuildSpec extends Specification {

  val render = Render(KeyValueJITD.definition)

  sequential 
  "The Key Value JITD should" >> {

    "Generate sensible node definitions" >> {
      render.nodes must contain("class BTreeNode")
    }

    "Generate a file that compiles and runs" >> {
      render() must contain("#include <vector>")
      Compile(render) must contain("TEST SUCCESSFUL!")
    }

  }
}