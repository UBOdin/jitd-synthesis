package org.apache.spark.sql.catalyst.optimizer;
/**
 * Transpose Adjacent Window Expressions.
 * - If the partition spec of the parent Window expression is compatible with the partition spec
 *   of the child window expression, transpose them.
 */
public  class TransposeWindow$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final TransposeWindow$ MODULE$ = null;
  public   TransposeWindow$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
