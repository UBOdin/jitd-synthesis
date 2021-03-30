package org.apache.spark.sql.catalyst.optimizer;
/**
 * Pushes down {@link LocalLimit} beneath WINDOW. This rule optimizes the following case:
 * <pre><code>
 *   SELECT *, ROW_NUMBER() OVER(ORDER BY a) AS rn FROM Tab1 LIMIT 5 ==&gt;
 *   SELECT *, ROW_NUMBER() OVER(ORDER BY a) AS rn FROM (SELECT * FROM Tab1 ORDER BY a LIMIT 5) t
 * </code></pre>
 */
public  class LimitPushDownThroughWindow$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final LimitPushDownThroughWindow$ MODULE$ = null;
  public   LimitPushDownThroughWindow$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
