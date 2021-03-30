package org.apache.spark.sql.catalyst.expressions.aggregate;
public  class Corr extends org.apache.spark.sql.catalyst.expressions.aggregate.PearsonCorrelation implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression x ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression y ()  { throw new RuntimeException(); }
  public  boolean nullOnDivideByZero ()  { throw new RuntimeException(); }
  // not preceding
  public   Corr (org.apache.spark.sql.catalyst.expressions.Expression x, org.apache.spark.sql.catalyst.expressions.Expression y, boolean nullOnDivideByZero)  { throw new RuntimeException(); }
  public   Corr (org.apache.spark.sql.catalyst.expressions.Expression x, org.apache.spark.sql.catalyst.expressions.Expression y)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression evaluateExpression ()  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
}
