package org.apache.spark.sql.execution.adaptive;
/**
 * This optimization rule detects and eliminates unnecessary Join:
 * 1. Join is single column NULL-aware anti join (NAAJ), and broadcasted {@link HashedRelation}
 *    is {@link HashedRelationWithAllNullKeys}. Eliminate join to an empty {@link LocalRelation}.
 * <p>
 * 2. Join is inner join, and either side of join is empty. Eliminate join to an empty
 *    {@link LocalRelation}.
 * <p>
 * 3. Join is left semi join
 *    3.1. Join right side is empty. Eliminate join to an empty {@link LocalRelation}.
 *    3.2. Join right side is non-empty and condition is empty. Eliminate join to its left side.
 * <p>
 * 4. Join is left anti join
 *    4.1. Join right side is empty. Eliminate join to its left side.
 *    4.2. Join right side is non-empty and condition is empty. Eliminate join to an empty
 *         {@link LocalRelation}.
 * <p>
 * This applies to all joins (sort merge join, shuffled hash join, broadcast hash join, and
 * broadcast nested loop join), because sort merge join and shuffled hash join will be changed
 * to broadcast hash join with AQE at the first place.
 */
public  class EliminateUnnecessaryJoin$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final EliminateUnnecessaryJoin$ MODULE$ = null;
  public   EliminateUnnecessaryJoin$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
