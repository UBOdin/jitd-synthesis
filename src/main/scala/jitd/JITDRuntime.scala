package jitd

import jitd.spec._
import jitd.typecheck._

object JITDRuntime
{
  val functions = Seq(
    FunctionSignature("array_size", Seq(TArray(TRecord())), TInt()),
    FunctionSignature("key_array_size", Seq(TArray(TKey())), TInt())
  )
}