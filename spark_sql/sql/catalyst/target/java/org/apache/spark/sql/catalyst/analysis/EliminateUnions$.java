package org.apache.spark.sql.catalyst.analysis;
/**
 * Removes {@link Union} operators from the plan if it just has one child.
 */
public  class EliminateUnions$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final EliminateUnions$ MODULE$ = null;
  public   EliminateUnions$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
