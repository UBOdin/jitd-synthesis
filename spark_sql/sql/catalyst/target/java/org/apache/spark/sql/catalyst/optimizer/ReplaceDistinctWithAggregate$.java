package org.apache.spark.sql.catalyst.optimizer;
/**
 * Replaces logical {@link Distinct} operator with an {@link Aggregate} operator.
 * <pre><code>
 *   SELECT DISTINCT f1, f2 FROM t  ==&gt;  SELECT f1, f2 FROM t GROUP BY f1, f2
 * </code></pre>
 */
public  class ReplaceDistinctWithAggregate$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final ReplaceDistinctWithAggregate$ MODULE$ = null;
  public   ReplaceDistinctWithAggregate$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
