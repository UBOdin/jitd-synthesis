package jitd.typecheck

import jitd.spec._

abstract class FunctionSignature()
{
  def apply(args:Seq[Type]): Option[Type]
  def name: String
}

class FunctionArgError(function:FunctionSignature, args:Seq[Type]) extends Exception
{
  override def toString =
    function.toString + " <- (" + args.map { Type.toString(_) }.mkString(", ") + ")"
}

class SimpleFunctionSignature(val name:String, args:Seq[Type], ret:Option[Type]) extends FunctionSignature
{
  def apply(cmpArgs:Seq[Type]) = 
    if(args == cmpArgs){ ret; }
    else { throw new FunctionArgError(this, cmpArgs) } 
  override def toString = 
    ret.getOrElse("void")+" "+name+"("+args.map { Type.toString(_) }.mkString(", ")+")"
}

object FunctionSignature 
{
  def apply(name:String, args:Seq[Type], ret:Type) = 
    new SimpleFunctionSignature(name, args, Some(ret))
  def apply(name:String, args:Seq[Type]) = 
    new SimpleFunctionSignature(name, args, None)

}