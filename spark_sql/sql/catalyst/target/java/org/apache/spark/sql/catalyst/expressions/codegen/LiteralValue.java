package org.apache.spark.sql.catalyst.expressions.codegen;
/**
 * A literal java expression.
 */
public  class LiteralValue implements org.apache.spark.sql.catalyst.expressions.codegen.ExprValue, scala.Serializable {
  // not preceding
  public   LiteralValue (java.lang.String value, java.lang.Class<?> javaType)  { throw new RuntimeException(); }
  public  java.lang.String code ()  { throw new RuntimeException(); }
  public  boolean equals (Object arg)  { throw new RuntimeException(); }
  public  int hashCode ()  { throw new RuntimeException(); }
  public  java.lang.Class<?> javaType ()  { throw new RuntimeException(); }
  public  java.lang.String value ()  { throw new RuntimeException(); }
}
