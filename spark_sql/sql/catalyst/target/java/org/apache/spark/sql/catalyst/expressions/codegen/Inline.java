package org.apache.spark.sql.catalyst.expressions.codegen;
/**
 * A piece of java code snippet inlines all types of input arguments into a string without
 * tracking any reference of <code>JavaCode</code> instances.
 */
public  class Inline implements org.apache.spark.sql.catalyst.expressions.codegen.JavaCode, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String codeString ()  { throw new RuntimeException(); }
  // not preceding
  public   Inline (java.lang.String codeString)  { throw new RuntimeException(); }
  public  java.lang.String code ()  { throw new RuntimeException(); }
}
