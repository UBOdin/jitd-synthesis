package org.apache.spark.sql.catalyst.plans.logical;
/**
 * This class is an implementation of equi-height histogram.
 * Equi-height histogram represents the distribution of a column's values by a sequence of bins.
 * Each bin has a value range and contains approximately the same number of rows.
 * <p>
 * param:  height number of rows in each bin
 * param:  bins equi-height histogram bins
 */
public  class Histogram implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  double height ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.HistogramBin[] bins ()  { throw new RuntimeException(); }
  // not preceding
  public   Histogram (double height, org.apache.spark.sql.catalyst.plans.logical.HistogramBin[] bins)  { throw new RuntimeException(); }
  public  boolean equals (Object other)  { throw new RuntimeException(); }
  public  int hashCode ()  { throw new RuntimeException(); }
}
