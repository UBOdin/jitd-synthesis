package org.apache.spark.sql.catalyst.expressions.codegen;
/**
 * A java expression fragment.
 */
public  class SimpleExprValue implements org.apache.spark.sql.catalyst.expressions.codegen.ExprValue, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String expr ()  { throw new RuntimeException(); }
  public  java.lang.Class<?> javaType ()  { throw new RuntimeException(); }
  // not preceding
  public   SimpleExprValue (java.lang.String expr, java.lang.Class<?> javaType)  { throw new RuntimeException(); }
  public  java.lang.String code ()  { throw new RuntimeException(); }
}
