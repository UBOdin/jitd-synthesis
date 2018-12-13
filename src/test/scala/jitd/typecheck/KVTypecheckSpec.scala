package jitd.typecheck

import jitd.spec._
import jitd.example.{KeyValueJITD, CppStdLib}

import org.specs2.mutable._
import org.specs2.specification._

import jitd.example.KeyValueJITD

class KVTypecheckSpec extends Specification {

  val accessorTypechecker = 
    new Typechecker(CppStdLib.functions++KeyValueJITD.functions++
      Map(Accessor.delegate)
    )

  def check(a:Accessor, n:Node)
  { 
    accessorTypechecker.check(a.lookups(n.name), a.scope ++ n.scope, TBool())
  }

  sequential 
  "The Key Value JITD should" >> {

    "Have correct get methods" >> {

      check(KeyValueJITD.accessor("get"), KeyValueJITD.node("Array"))
      check(KeyValueJITD.accessor("get"), KeyValueJITD.node("SortedArray"))
      check(KeyValueJITD.accessor("get"), KeyValueJITD.node("Concat"))
      check(KeyValueJITD.accessor("get"), KeyValueJITD.node("BTree"))
      ok


    }
  }
}