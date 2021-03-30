package org.apache.spark.sql.catalyst.plans.logical.statsEstimation;
/**
 * This version of Spark does not have min/max for binary/string types, we define their default
 * behaviors by this class.
 */
public  class DefaultValueInterval implements org.apache.spark.sql.catalyst.plans.logical.statsEstimation.ValueInterval {
  public   DefaultValueInterval ()  { throw new RuntimeException(); }
  public  boolean contains (org.apache.spark.sql.catalyst.expressions.Literal l)  { throw new RuntimeException(); }
}
