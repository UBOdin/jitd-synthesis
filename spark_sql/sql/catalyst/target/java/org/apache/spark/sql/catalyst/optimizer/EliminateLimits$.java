package org.apache.spark.sql.catalyst.optimizer;
/**
 * This rule optimizes Limit operators by:
 * 1. Eliminate {@link Limit}/{@link GlobalLimit} operators if it's child max row <= limit.
 * 2. Combines two adjacent {@link Limit} operators into one, merging the
 *    expressions into one single expression.
 */
public  class EliminateLimits$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final EliminateLimits$ MODULE$ = null;
  public   EliminateLimits$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
