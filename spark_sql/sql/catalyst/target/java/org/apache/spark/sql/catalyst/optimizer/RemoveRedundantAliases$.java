package org.apache.spark.sql.catalyst.optimizer;
/**
 * Remove redundant aliases from a query plan. A redundant alias is an alias that does not change
 * the name or metadata of a column, and does not deduplicate it.
 */
public  class RemoveRedundantAliases$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final RemoveRedundantAliases$ MODULE$ = null;
  public   RemoveRedundantAliases$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
