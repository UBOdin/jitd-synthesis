package org.apache.spark.sql.execution.command;
/**
 * Clear all cached data from the in-memory cache.
 */
public  class ClearCacheCommand$ extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.execution.command.RunnableCommand, org.apache.spark.sql.catalyst.plans.logical.IgnoreCachedData, scala.Product, scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final ClearCacheCommand$ MODULE$ = null;
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public   ClearCacheCommand$ ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.Row> run (org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
}
