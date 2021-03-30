package org.apache.spark.sql.catalyst.expressions;
/**
 * Trait to indicate the expression does not throw an exception by itself when they are evaluated.
 * For example, UDFs, {@link AssertTrue}, etc can throw an exception when they are executed.
 * In such case, it is necessary to call {@link Expression.eval}, and the optimization rule should
 * not ignore it.
 * <p>
 * This trait can be used in an optimization rule such as
 * {@link org.apache.spark.sql.catalyst.optimizer.ConstantFolding} to fold the expressions that
 * do not need to execute, for example, <code>size(array(c0, c1, c2))</code>.
 */
public  interface NoThrow {
}
