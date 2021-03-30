package org.apache.spark.sql.catalyst.plans.logical.statsEstimation;
/** For simplicity we use double to unify operations of numeric intervals. */
public  class NumericValueInterval implements org.apache.spark.sql.catalyst.plans.logical.statsEstimation.ValueInterval, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  double min ()  { throw new RuntimeException(); }
  public  double max ()  { throw new RuntimeException(); }
  // not preceding
  public   NumericValueInterval (double min, double max)  { throw new RuntimeException(); }
  public  boolean contains (org.apache.spark.sql.catalyst.expressions.Literal l)  { throw new RuntimeException(); }
}
