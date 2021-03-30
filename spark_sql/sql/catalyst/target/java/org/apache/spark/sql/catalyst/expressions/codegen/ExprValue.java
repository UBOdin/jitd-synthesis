package org.apache.spark.sql.catalyst.expressions.codegen;
/**
 * A typed java fragment that must be a valid java expression.
 */
public  interface ExprValue extends org.apache.spark.sql.catalyst.expressions.codegen.JavaCode {
  public  java.lang.Class<?> javaType ()  ;
  public  boolean isPrimitive ()  ;
}
