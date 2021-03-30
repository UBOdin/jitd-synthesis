package org.apache.spark.sql.catalyst.optimizer;
/**
 * This rule is a variant of {@link PushPredicateThroughNonJoin} which can handle
 * pushing down Left semi and Left Anti joins below the following operators.
 *  1) Project
 *  2) Window
 *  3) Union
 *  4) Aggregate
 *  5) Other permissible unary operators. please see {@link PushPredicateThroughNonJoin.canPushThrough}.
 */
public  class PushDownLeftSemiAntiJoin$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> implements org.apache.spark.sql.catalyst.expressions.PredicateHelper, org.apache.spark.sql.catalyst.optimizer.JoinSelectionHelper {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final PushDownLeftSemiAntiJoin$ MODULE$ = null;
  public   PushDownLeftSemiAntiJoin$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
