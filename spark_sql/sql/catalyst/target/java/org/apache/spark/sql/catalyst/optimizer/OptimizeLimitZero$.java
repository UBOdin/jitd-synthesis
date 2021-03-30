package org.apache.spark.sql.catalyst.optimizer;
/**
 * Replaces GlobalLimit 0 and LocalLimit 0 nodes (subtree) with empty Local Relation, as they don't
 * return any rows.
 */
public  class OptimizeLimitZero$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final OptimizeLimitZero$ MODULE$ = null;
  public   OptimizeLimitZero$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
