package org.apache.spark.sql.catalyst.analysis;
/**
 * Cleans up unnecessary Aliases inside the plan. Basically we only need Alias as a top level
 * expression in Project(project list) or Aggregate(aggregate expressions) or
 * Window(window expressions). Notice that if an expression has other expression parameters which
 * are not in its <code>children</code>, e.g. <code>RuntimeReplaceable</code>, the transformation for Aliases in this
 * rule can't work for those parameters.
 */
public  class CleanupAliases$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> implements org.apache.spark.sql.catalyst.expressions.AliasHelper {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final CleanupAliases$ MODULE$ = null;
  public   CleanupAliases$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
