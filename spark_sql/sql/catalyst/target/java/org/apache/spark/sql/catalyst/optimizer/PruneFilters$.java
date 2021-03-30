package org.apache.spark.sql.catalyst.optimizer;
/**
 * Removes filters that can be evaluated trivially.  This can be done through the following ways:
 * 1) by eliding the filter for cases where it will always evaluate to <code>true</code>.
 * 2) by substituting a dummy empty relation when the filter will always evaluate to <code>false</code>.
 * 3) by eliminating the always-true conditions given the constraints on the child's output.
 */
public  class PruneFilters$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> implements org.apache.spark.sql.catalyst.expressions.PredicateHelper {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final PruneFilters$ MODULE$ = null;
  public   PruneFilters$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
