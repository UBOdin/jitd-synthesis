package org.apache.spark.sql.catalyst.expressions;
/**
 * Round an expression to d decimal places using HALF_EVEN rounding mode,
 * also known as Gaussian rounding or bankers' rounding.
 * round(2.5) = 2.0, round(3.5) = 4.0.
 */
public  class BRound extends org.apache.spark.sql.catalyst.expressions.RoundBase implements scala.Serializable, org.apache.spark.sql.catalyst.expressions.ImplicitCastInputTypes, scala.Product {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression child ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression scale ()  { throw new RuntimeException(); }
  // not preceding
  public   BRound (org.apache.spark.sql.catalyst.expressions.Expression child, org.apache.spark.sql.catalyst.expressions.Expression scale)  { throw new RuntimeException(); }
  public   BRound (org.apache.spark.sql.catalyst.expressions.Expression child)  { throw new RuntimeException(); }
}
