package org.apache.spark.sql.catalyst.expressions.aggregate;
public  class VarianceSamp extends org.apache.spark.sql.catalyst.expressions.aggregate.CentralMomentAgg implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression child ()  { throw new RuntimeException(); }
  public  boolean nullOnDivideByZero ()  { throw new RuntimeException(); }
  // not preceding
  public   VarianceSamp (org.apache.spark.sql.catalyst.expressions.Expression child, boolean nullOnDivideByZero)  { throw new RuntimeException(); }
  public   VarianceSamp (org.apache.spark.sql.catalyst.expressions.Expression child)  { throw new RuntimeException(); }
  protected  int momentOrder ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression evaluateExpression ()  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
}
