package org.apache.spark.sql.execution.adaptive;
/**
 * This optimization rule detects a join child that has a high ratio of empty partitions and
 * adds a no-broadcast-hash-join hint to avoid it being broadcast.
 */
public  class DemoteBroadcastHashJoin$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final DemoteBroadcastHashJoin$ MODULE$ = null;
  public   DemoteBroadcastHashJoin$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
