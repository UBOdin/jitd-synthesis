package org.apache.spark.sql.catalyst.plans.logical.statsEstimation;
public  class AggregateEstimation$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final AggregateEstimation$ MODULE$ = null;
  public   AggregateEstimation$ ()  { throw new RuntimeException(); }
  /**
   * Estimate the number of output rows based on column stats of group-by columns, and propagate
   * column stats for aggregate expressions.
   * @param agg (undocumented)
   * @return (undocumented)
   */
  public  scala.Option<org.apache.spark.sql.catalyst.plans.logical.Statistics> estimate (org.apache.spark.sql.catalyst.plans.logical.Aggregate agg)  { throw new RuntimeException(); }
}
