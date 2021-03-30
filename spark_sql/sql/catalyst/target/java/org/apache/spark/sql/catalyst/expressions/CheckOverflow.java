package org.apache.spark.sql.catalyst.expressions;
/**
 * Rounds the decimal to given scale and check whether the decimal can fit in provided precision
 * or not. If not, if <code>nullOnOverflow</code> is <code>true</code>, it returns <code>null</code>; otherwise an
 * <code>ArithmeticException</code> is thrown.
 */
public  class CheckOverflow extends org.apache.spark.sql.catalyst.expressions.UnaryExpression implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  public  org.apache.spark.sql.catalyst.expressions.Expression child ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DecimalType dataType ()  { throw new RuntimeException(); }
  public  boolean nullOnOverflow ()  { throw new RuntimeException(); }
  // not preceding
  public   CheckOverflow (org.apache.spark.sql.catalyst.expressions.Expression child, org.apache.spark.sql.types.DecimalType dataType, boolean nullOnOverflow)  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  Object nullSafeEval (Object input)  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String sql ()  { throw new RuntimeException(); }
}
