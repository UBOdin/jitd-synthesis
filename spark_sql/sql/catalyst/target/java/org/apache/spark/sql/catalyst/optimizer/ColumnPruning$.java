package org.apache.spark.sql.catalyst.optimizer;
/**
 * Attempts to eliminate the reading of unneeded columns from the query plan.
 * <p>
 * Since adding Project before Filter conflicts with PushPredicatesThroughProject, this rule will
 * remove the Project p2 in the following pattern:
 * <p>
 *   p1 @ Project(_, Filter(_, p2 @ Project(_, child))) if p2.outputSet.subsetOf(p2.inputSet)
 * <p>
 * p2 is usually inserted by this rule and useless, p1 could prune the columns anyway.
 */
public  class ColumnPruning$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final ColumnPruning$ MODULE$ = null;
  public   ColumnPruning$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
