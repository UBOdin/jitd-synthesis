package org.apache.spark.sql.catalyst.optimizer;
/**
 * Remove useless FILTER clause for aggregate expressions.
 * This rule should be applied before RewriteDistinctAggregates.
 */
public  class EliminateAggregateFilter$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final EliminateAggregateFilter$ MODULE$ = null;
  public   EliminateAggregateFilter$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
