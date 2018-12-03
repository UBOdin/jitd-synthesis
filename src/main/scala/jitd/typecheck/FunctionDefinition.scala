package jitd.typecheck

import jitd.spec._

abstract class FunctionDefinition()
{
  def apply(args:Seq[Type]): Type
  def name: String
}

class FunctionArgError(function:FunctionDefinition, args:Seq[Type]) extends Exception

class SimpleFunctionDefinition(val name:String, args:Seq[Type], ret:Type) extends FunctionDefinition
{
  def apply(cmpArgs:Seq[Type]) = 
    if(args == cmpArgs){ ret; }
    else { throw new FunctionArgError(this, cmpArgs) } 
}

object FunctionDefinition 
{
  def apply(name:String, args:Seq[Type], ret:Type) = 
    new SimpleFunctionDefinition(name, args, ret)

}