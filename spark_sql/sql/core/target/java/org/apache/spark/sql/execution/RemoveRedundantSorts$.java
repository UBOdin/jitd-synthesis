package org.apache.spark.sql.execution;
/**
 * Remove redundant SortExec node from the spark plan. A sort node is redundant when
 * its child satisfies both its sort orders and its required child distribution. Note
 * this rule differs from the Optimizer rule EliminateSorts in that this rule also checks
 * if the child satisfies the required distribution so that it is safe to remove not only a
 * local sort but also a global sort when its child already satisfies required sort orders.
 */
public  class RemoveRedundantSorts$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.execution.SparkPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final RemoveRedundantSorts$ MODULE$ = null;
  public   RemoveRedundantSorts$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan apply (org.apache.spark.sql.execution.SparkPlan plan)  { throw new RuntimeException(); }
}
