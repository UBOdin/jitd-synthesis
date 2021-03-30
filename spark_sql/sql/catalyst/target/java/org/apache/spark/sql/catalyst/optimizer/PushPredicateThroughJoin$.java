package org.apache.spark.sql.catalyst.optimizer;
/**
 * Pushes down {@link Filter} operators where the <code>condition</code> can be
 * evaluated using only the attributes of the left or right side of a join.  Other
 * {@link Filter} conditions are moved into the <code>condition</code> of the {@link Join}.
 * <p>
 * And also pushes down the join filter, where the <code>condition</code> can be evaluated using only the
 * attributes of the left or right side of sub query when applicable.
 * <p>
 * Check https://cwiki.apache.org/confluence/display/Hive/OuterJoinBehavior for more details
 */
public  class PushPredicateThroughJoin$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> implements org.apache.spark.sql.catalyst.expressions.PredicateHelper {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final PushPredicateThroughJoin$ MODULE$ = null;
  public   PushPredicateThroughJoin$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  public  scala.PartialFunction<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> applyLocally ()  { throw new RuntimeException(); }
}
