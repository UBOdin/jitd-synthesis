package org.apache.spark.sql.execution;
/**
 * Remove redundant ProjectExec node from the spark plan. A ProjectExec node is redundant when
 * - It has the same output attributes and orders as its child's output and the ordering of
 *   the attributes is required.
 * - It has the same output attributes as its child's output when attribute output ordering
 *   is not required.
 * This rule needs to be a physical rule because project nodes are useful during logical
 * optimization to prune data. During physical planning, redundant project nodes can be removed
 * to simplify the query plan.
 */
public  class RemoveRedundantProjects$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.execution.SparkPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final RemoveRedundantProjects$ MODULE$ = null;
  public   RemoveRedundantProjects$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan apply (org.apache.spark.sql.execution.SparkPlan plan)  { throw new RuntimeException(); }
}
