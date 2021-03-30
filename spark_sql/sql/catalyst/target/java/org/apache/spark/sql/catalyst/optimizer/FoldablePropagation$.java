package org.apache.spark.sql.catalyst.optimizer;
/**
 * Replace attributes with aliases of the original foldable expressions if possible.
 * Other optimizations will take advantage of the propagated foldable expressions. For example,
 * this rule can optimize
 * <pre><code>
 *   SELECT 1.0 x, 'abc' y, Now() z ORDER BY x, y, 3
 * </code></pre>
 * to
 * <pre><code>
 *   SELECT 1.0 x, 'abc' y, Now() z ORDER BY 1.0, 'abc', Now()
 * </code></pre>
 * and other rules can further optimize it and remove the ORDER BY operator.
 */
public  class FoldablePropagation$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final FoldablePropagation$ MODULE$ = null;
  public   FoldablePropagation$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
