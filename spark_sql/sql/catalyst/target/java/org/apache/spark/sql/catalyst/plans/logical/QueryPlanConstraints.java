package org.apache.spark.sql.catalyst.plans.logical;
public  interface QueryPlanConstraints extends org.apache.spark.sql.catalyst.plans.logical.ConstraintHelper {
  /**
   * An {@link ExpressionSet} that contains invariants about the rows output by this operator. For
   * example, if this set contains the expression <code>a = 2</code> then that expression is guaranteed to
   * evaluate to <code>true</code> for all rows produced.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.ExpressionSet constraints ()  ;
  /**
   * This method can be overridden by any child class of QueryPlan to specify a set of constraints
   * based on the given operator's constraint propagation logic. These constraints are then
   * canonicalized and filtered automatically to contain only those attributes that appear in the
   * {@link outputSet}.
   * <p>
   * See {@link Canonicalize} for more details.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.ExpressionSet validConstraints ()  ;
}
