package org.apache.spark.sql.catalyst.expressions;
/**
 * Round an expression to d decimal places using HALF_UP rounding mode.
 * round(2.5) == 3.0, round(3.5) == 4.0.
 */
public  class Round extends org.apache.spark.sql.catalyst.expressions.RoundBase implements scala.Serializable, org.apache.spark.sql.catalyst.expressions.ImplicitCastInputTypes, scala.Product {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression child ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression scale ()  { throw new RuntimeException(); }
  // not preceding
  public   Round (org.apache.spark.sql.catalyst.expressions.Expression child, org.apache.spark.sql.catalyst.expressions.Expression scale)  { throw new RuntimeException(); }
  public   Round (org.apache.spark.sql.catalyst.expressions.Expression child)  { throw new RuntimeException(); }
}
