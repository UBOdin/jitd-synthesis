package jitd.example

import jitd.spec._
import jitd.typecheck.FunctionDefinition

object CppStdLib
{
  val functions = Seq(
    FunctionDefinition("std::begin", Seq(TArray(TRecord())), TIterator()),
    FunctionDefinition("std::end", Seq(TArray(TRecord())), TIterator()),
    FunctionDefinition("std::find", Seq(TIterator(), TIterator(), TKey()), TIterator()),
    FunctionDefinition("std::lower_bound", Seq(TIterator(), TIterator(), TKey()), TIterator())

  ).map { f => f.name -> f }.toMap
}