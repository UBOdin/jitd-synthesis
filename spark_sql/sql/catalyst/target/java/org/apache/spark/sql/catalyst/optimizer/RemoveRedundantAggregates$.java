package org.apache.spark.sql.catalyst.optimizer;
/**
 * Remove redundant aggregates from a query plan. A redundant aggregate is an aggregate whose
 * only goal is to keep distinct values, while its parent aggregate would ignore duplicate values.
 */
public  class RemoveRedundantAggregates$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> implements org.apache.spark.sql.catalyst.expressions.AliasHelper {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final RemoveRedundantAggregates$ MODULE$ = null;
  public   RemoveRedundantAggregates$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
