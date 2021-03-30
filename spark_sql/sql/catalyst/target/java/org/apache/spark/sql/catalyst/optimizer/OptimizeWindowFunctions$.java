package org.apache.spark.sql.catalyst.optimizer;
/**
 * Replaces first(col) to nth_value(col, 1) for better performance.
 */
public  class OptimizeWindowFunctions$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final OptimizeWindowFunctions$ MODULE$ = null;
  public   OptimizeWindowFunctions$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
