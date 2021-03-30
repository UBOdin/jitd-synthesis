package org.apache.spark.sql.catalyst.optimizer;
/**
 * Remove useless DISTINCT for MAX and MIN.
 * This rule should be applied before RewriteDistinctAggregates.
 */
public  class EliminateDistinct$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final EliminateDistinct$ MODULE$ = null;
  public   EliminateDistinct$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
