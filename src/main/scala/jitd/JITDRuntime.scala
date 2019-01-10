package jitd

import jitd.spec._
import jitd.typecheck._

object JITDRuntime
{
  val functions = Seq(
    FunctionSignature("array_size", Seq(TArray(TRecord())), TInt())
  )
}