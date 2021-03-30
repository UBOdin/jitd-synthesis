package org.apache.spark.sql.catalyst.optimizer;
/**
 * Try pushing down disjunctive join condition into left and right child.
 * To avoid expanding the join condition, the join condition will be kept in the original form even
 * when predicate pushdown happens.
 */
public  class PushExtraPredicateThroughJoin$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> implements org.apache.spark.sql.catalyst.expressions.PredicateHelper {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final PushExtraPredicateThroughJoin$ MODULE$ = null;
  public   PushExtraPredicateThroughJoin$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
