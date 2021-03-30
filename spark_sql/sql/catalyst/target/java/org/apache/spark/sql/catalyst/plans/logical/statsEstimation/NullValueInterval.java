package org.apache.spark.sql.catalyst.plans.logical.statsEstimation;
/** This is for columns with only null values. */
public  class NullValueInterval implements org.apache.spark.sql.catalyst.plans.logical.statsEstimation.ValueInterval {
  public   NullValueInterval ()  { throw new RuntimeException(); }
  public  boolean contains (org.apache.spark.sql.catalyst.expressions.Literal l)  { throw new RuntimeException(); }
}
