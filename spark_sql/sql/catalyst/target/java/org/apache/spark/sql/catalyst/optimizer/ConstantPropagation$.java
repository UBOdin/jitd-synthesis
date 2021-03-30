package org.apache.spark.sql.catalyst.optimizer;
/**
 * Substitutes {@link Attribute Attributes} which can be statically evaluated with their corresponding
 * value in conjunctive {@link Expression Expressions}
 * e.g.
 * <pre><code>
 *   SELECT * FROM table WHERE i = 5 AND j = i + 3
 *   ==&gt;  SELECT * FROM table WHERE i = 5 AND j = 8
 * </code></pre>
 * <p>
 * Approach used:
 * - Populate a mapping of attribute =&gt; constant value by looking at all the equals predicates
 * - Using this mapping, replace occurrence of the attributes with the corresponding constant values
 *   in the AND node.
 */
public  class ConstantPropagation$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> implements org.apache.spark.sql.catalyst.expressions.PredicateHelper {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final ConstantPropagation$ MODULE$ = null;
  public   ConstantPropagation$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
