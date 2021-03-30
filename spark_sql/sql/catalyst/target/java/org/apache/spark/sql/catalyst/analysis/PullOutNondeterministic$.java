package org.apache.spark.sql.catalyst.analysis;
/**
 * Pulls out nondeterministic expressions from LogicalPlan which is not Project or Filter,
 * put them into an inner Project and finally project them away at the outer Project.
 */
public  class PullOutNondeterministic$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final PullOutNondeterministic$ MODULE$ = null;
  public   PullOutNondeterministic$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  public  scala.PartialFunction<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> applyLocally ()  { throw new RuntimeException(); }
}
