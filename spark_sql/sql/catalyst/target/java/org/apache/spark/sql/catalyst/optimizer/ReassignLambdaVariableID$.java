package org.apache.spark.sql.catalyst.optimizer;
/**
 * Reassigns per-query unique IDs to <code>LambdaVariable</code>s, whose original IDs are globally unique. This
 * can help Spark to hit codegen cache more often and improve performance.
 */
public  class ReassignLambdaVariableID$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final ReassignLambdaVariableID$ MODULE$ = null;
  public   ReassignLambdaVariableID$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
