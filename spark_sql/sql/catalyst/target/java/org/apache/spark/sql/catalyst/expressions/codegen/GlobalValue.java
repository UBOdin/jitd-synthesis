package org.apache.spark.sql.catalyst.expressions.codegen;
/**
 * A global variable java expression.
 */
public  class GlobalValue implements org.apache.spark.sql.catalyst.expressions.codegen.ExprValue, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String value ()  { throw new RuntimeException(); }
  public  java.lang.Class<?> javaType ()  { throw new RuntimeException(); }
  // not preceding
  public   GlobalValue (java.lang.String value, java.lang.Class<?> javaType)  { throw new RuntimeException(); }
  public  java.lang.String code ()  { throw new RuntimeException(); }
}
