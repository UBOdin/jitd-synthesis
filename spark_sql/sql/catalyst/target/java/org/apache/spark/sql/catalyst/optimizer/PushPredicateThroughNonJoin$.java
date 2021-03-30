package org.apache.spark.sql.catalyst.optimizer;
/**
 * Pushes {@link Filter} operators through many operators iff:
 * 1) the operator is deterministic
 * 2) the predicate is deterministic and the operator will not change any of rows.
 * <p>
 * This heuristic is valid assuming the expression evaluation cost is minimal.
 */
public  class PushPredicateThroughNonJoin$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> implements org.apache.spark.sql.catalyst.expressions.PredicateHelper {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final PushPredicateThroughNonJoin$ MODULE$ = null;
  public   PushPredicateThroughNonJoin$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  public  scala.PartialFunction<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> applyLocally ()  { throw new RuntimeException(); }
  public  boolean canPushThrough (org.apache.spark.sql.catalyst.plans.logical.UnaryNode p)  { throw new RuntimeException(); }
}
