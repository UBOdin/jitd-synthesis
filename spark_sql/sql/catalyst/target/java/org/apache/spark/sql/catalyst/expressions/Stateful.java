package org.apache.spark.sql.catalyst.expressions;
/**
 * An expression that contains mutable state. A stateful expression is always non-deterministic
 * because the results it produces during evaluation are not only dependent on the given input
 * but also on its internal state.
 * <p>
 * The state of the expressions is generally not exposed in the parameter list and this makes
 * comparing stateful expressions problematic because similar stateful expressions (with the same
 * parameter list) but with different internal state will be considered equal. This is especially
 * problematic during tree transformations. In order to counter this the <code>fastEquals</code> method for
 * stateful expressions only returns <code>true</code> for the same reference.
 * <p>
 * A stateful expression should never be evaluated multiple times for a single row. This should
 * only be a problem for interpreted execution. This can be prevented by creating fresh copies
 * of the stateful expression before execution, these can be made using the <code>freshCopy</code> function.
 */
public  interface Stateful extends org.apache.spark.sql.catalyst.expressions.Nondeterministic {
  /**
   * Only the same reference is considered equal.
   * @param other (undocumented)
   * @return (undocumented)
   */
  public  boolean fastEquals (org.apache.spark.sql.catalyst.trees.TreeNode<?> other)  ;
  /**
   * Return a fresh uninitialized copy of the stateful expression.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Stateful freshCopy ()  ;
}
