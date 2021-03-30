package org.apache.spark.sql.catalyst.optimizer;
/**
 * Removes repetition from group expressions in {@link Aggregate}, as they have no effect to the result
 * but only makes the grouping key bigger.
 */
public  class RemoveRepetitionFromGroupExpressions$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final RemoveRepetitionFromGroupExpressions$ MODULE$ = null;
  public   RemoveRepetitionFromGroupExpressions$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
