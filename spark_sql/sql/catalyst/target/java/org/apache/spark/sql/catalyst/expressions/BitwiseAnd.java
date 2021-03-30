package org.apache.spark.sql.catalyst.expressions;
/**
 * A function that calculates bitwise and(&amp;) of two numbers.
 * <p>
 * Code generation inherited from BinaryArithmetic.
 */
public  class BitwiseAnd extends org.apache.spark.sql.catalyst.expressions.BinaryArithmetic implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression left ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression right ()  { throw new RuntimeException(); }
  // not preceding
  public   BitwiseAnd (org.apache.spark.sql.catalyst.expressions.Expression left, org.apache.spark.sql.catalyst.expressions.Expression right)  { throw new RuntimeException(); }
  protected  boolean failOnError ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.AbstractDataType inputType ()  { throw new RuntimeException(); }
  public  java.lang.String symbol ()  { throw new RuntimeException(); }
  protected  Object nullSafeEval (Object input1, Object input2)  { throw new RuntimeException(); }
}
