package org.apache.spark.sql.catalyst.optimizer;
/**
 * If one or both of the datasets in the logical {@link Except} operator are purely transformed using
 * {@link Filter}, this rule will replace logical {@link Except} operator with a {@link Filter} operator by
 * flipping the filter condition of the right child.
 * <pre><code>
 *   SELECT a1, a2 FROM Tab1 WHERE a2 = 12 EXCEPT SELECT a1, a2 FROM Tab1 WHERE a1 = 5
 *   ==&gt;  SELECT DISTINCT a1, a2 FROM Tab1 WHERE a2 = 12 AND (a1 is null OR a1 &lt;&gt; 5)
 * </code></pre>
 * <p>
 * Note:
 * Before flipping the filter condition of the right node, we should:
 * 1. Combine all it's {@link Filter}.
 * 2. Update the attribute references to the left node;
 * 3. Add a Coalesce(condition, False) (to take into account of NULL values in the condition).
 */
public  class ReplaceExceptWithFilter$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final ReplaceExceptWithFilter$ MODULE$ = null;
  public   ReplaceExceptWithFilter$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
