package org.apache.spark.sql.catalyst.optimizer;
/**
 * Removes literals from group expressions in {@link Aggregate}, as they have no effect to the result
 * but only makes the grouping key bigger.
 */
public  class RemoveLiteralFromGroupExpressions$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final RemoveLiteralFromGroupExpressions$ MODULE$ = null;
  public   RemoveLiteralFromGroupExpressions$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
