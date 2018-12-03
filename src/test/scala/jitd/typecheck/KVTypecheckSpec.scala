package jitd.typecheck

import jitd.spec._
import jitd.example.{KeyValueJITD, CppStdLib}

import org.specs2.mutable._
import org.specs2.specification._

import jitd.example.KeyValueJITD

class KVTypecheckSpec extends Specification {

  val typechecker = new Typechecker(CppStdLib.functions++KeyValueJITD.functions)

  def check(a:Accessor, n:Node)
  { 
    typechecker.check(a.lookups(n.name), a.scope ++ n.scope, TNode(), TBool())
  }

  sequential 
  "The Key Value JITD should" >> {

    "Have correct get methods" >> {

      check(KeyValueJITD.GetByKey, KeyValueJITD.ArrayNode)
      check(KeyValueJITD.GetByKey, KeyValueJITD.SortedArrayNode)
      check(KeyValueJITD.GetByKey, KeyValueJITD.ConcatNode)
      check(KeyValueJITD.GetByKey, KeyValueJITD.BTreeNode)
      ok


    }
  }
}