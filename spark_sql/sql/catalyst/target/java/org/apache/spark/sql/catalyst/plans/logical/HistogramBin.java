package org.apache.spark.sql.catalyst.plans.logical;
/**
 * A bin in an equi-height histogram. We use double type for lower/higher bound for simplicity.
 * <p>
 * param:  lo lower bound of the value range in this bin
 * param:  hi higher bound of the value range in this bin
 * param:  ndv approximate number of distinct values in this bin
 */
public  class HistogramBin implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  double lo ()  { throw new RuntimeException(); }
  public  double hi ()  { throw new RuntimeException(); }
  public  long ndv ()  { throw new RuntimeException(); }
  // not preceding
  public   HistogramBin (double lo, double hi, long ndv)  { throw new RuntimeException(); }
}
