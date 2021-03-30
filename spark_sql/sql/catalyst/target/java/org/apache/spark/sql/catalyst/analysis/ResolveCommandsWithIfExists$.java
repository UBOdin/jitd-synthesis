package org.apache.spark.sql.catalyst.analysis;
/**
 * A rule for handling commands when the table or temp view is not resolved.
 * These commands support a flag, "ifExists", so that they do not fail when a relation is not
 * resolved. If the "ifExists" flag is set to true. the plan is resolved to {@link NoopCommand},
 */
public  class ResolveCommandsWithIfExists$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final ResolveCommandsWithIfExists$ MODULE$ = null;
  public   ResolveCommandsWithIfExists$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
