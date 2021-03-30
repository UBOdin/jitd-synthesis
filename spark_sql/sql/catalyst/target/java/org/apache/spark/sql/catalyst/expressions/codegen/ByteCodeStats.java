package org.apache.spark.sql.catalyst.expressions.codegen;
/**
 * Java bytecode statistics of a compiled class by Janino.
 */
public  class ByteCodeStats implements scala.Product, scala.Serializable {
  static public  org.apache.spark.sql.catalyst.expressions.codegen.ByteCodeStats UNAVAILABLE ()  { throw new RuntimeException(); }
  public  int maxMethodCodeSize ()  { throw new RuntimeException(); }
  public  int maxConstPoolSize ()  { throw new RuntimeException(); }
  public  int numInnerClasses ()  { throw new RuntimeException(); }
  // not preceding
  public   ByteCodeStats (int maxMethodCodeSize, int maxConstPoolSize, int numInnerClasses)  { throw new RuntimeException(); }
}
