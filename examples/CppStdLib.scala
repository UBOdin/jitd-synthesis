package jitd.example

import jitd.spec._
import jitd.typecheck.FunctionSignature

object CppStdLib
{
  val functions = Seq(
    FunctionSignature("std::begin", Seq(TArray(TRecord())), TIterator()),
    FunctionSignature("std::end", Seq(TArray(TRecord())), TIterator()),
    FunctionSignature("std::find", Seq(TIterator(), TIterator(), TKey()), TIterator()),
    FunctionSignature("std::lower_bound", Seq(TIterator(), TIterator(), TKey()), TIterator()),
    FunctionSignature("std::vector<Record>", Seq(), TArray(TRecord())),
    FunctionSignature("std::sort", Seq(TIterator(), TIterator()))
    
  )
}