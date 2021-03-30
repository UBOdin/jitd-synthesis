package org.apache.spark.sql.catalyst.optimizer;
/**
 * Smplify the children of <code>Union</code> or remove no-op <code>Union</code> from the query plan that
 * do not make any modifications to the query.
 */
public  class RemoveNoopUnion$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final RemoveNoopUnion$ MODULE$ = null;
  public   RemoveNoopUnion$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
