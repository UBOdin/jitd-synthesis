package org.apache.spark.sql.catalyst.optimizer;
/**
 * This rule is a variant of {@link PushPredicateThroughJoin} which can handle
 * pushing down Left semi and Left Anti joins below a join operator. The
 * allowable join types are:
 *  1) Inner
 *  2) Cross
 *  3) LeftOuter
 *  4) RightOuter
 * <p>
 * TODO:
 * Currently this rule can push down the left semi or left anti joins to either
 * left or right leg of the child join. This matches the behaviour of <code>PushPredicateThroughJoin</code>
 * when the left semi or left anti join is in expression form. We need to explore the possibility
 * to push the left semi/anti joins to both legs of join if the join condition refers to
 * both left and right legs of the child join.
 */
public  class PushLeftSemiLeftAntiThroughJoin$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> implements org.apache.spark.sql.catalyst.expressions.PredicateHelper {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final PushLeftSemiLeftAntiThroughJoin$ MODULE$ = null;
  public   PushLeftSemiLeftAntiThroughJoin$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
