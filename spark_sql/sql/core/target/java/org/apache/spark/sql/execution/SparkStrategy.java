package org.apache.spark.sql.execution;
/**
 * Converts a logical plan into zero or more SparkPlans.  This API is exposed for experimenting
 * with the query planner and is not designed to be stable across spark releases.  Developers
 * writing libraries should instead consider using the stable APIs provided in
 * {@link org.apache.spark.sql.sources}
 */
public abstract class SparkStrategy extends org.apache.spark.sql.catalyst.planning.GenericStrategy<org.apache.spark.sql.execution.SparkPlan> {
  public   SparkStrategy ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.execution.SparkPlan planLater (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
