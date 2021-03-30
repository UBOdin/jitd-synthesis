package org.apache.spark.sql.catalyst.expressions.codegen;
/**
 * A local variable java expression.
 */
public  class VariableValue implements org.apache.spark.sql.catalyst.expressions.codegen.ExprValue, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String variableName ()  { throw new RuntimeException(); }
  public  java.lang.Class<?> javaType ()  { throw new RuntimeException(); }
  // not preceding
  public   VariableValue (java.lang.String variableName, java.lang.Class<?> javaType)  { throw new RuntimeException(); }
  public  java.lang.String code ()  { throw new RuntimeException(); }
}
