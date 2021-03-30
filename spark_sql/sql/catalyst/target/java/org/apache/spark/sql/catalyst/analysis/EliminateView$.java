package org.apache.spark.sql.catalyst.analysis;
/**
 * This rule removes {@link View} operators from the plan. The operator is respected till the end of
 * analysis stage because we want to see which part of an analyzed logical plan is generated from a
 * view.
 */
public  class EliminateView$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> implements org.apache.spark.sql.catalyst.analysis.CastSupport {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final EliminateView$ MODULE$ = null;
  public   EliminateView$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
