package org.apache.spark.sql.execution;
/**
 * The base class for subquery that is used in SparkPlan.
 */
public abstract class ExecSubqueryExpression extends org.apache.spark.sql.catalyst.expressions.PlanExpression<org.apache.spark.sql.execution.BaseSubqueryExec> {
  /**
   * Returns true when an expression contains a subquery
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  boolean hasSubquery (org.apache.spark.sql.catalyst.expressions.Expression e)  { throw new RuntimeException(); }
  public   ExecSubqueryExpression ()  { throw new RuntimeException(); }
  /**
   * Fill the expression with collected result from executed plan.
   */
  public abstract  void updateResult ()  ;
  /** Updates the expression with a new plan. */
  public abstract  org.apache.spark.sql.execution.ExecSubqueryExpression withNewPlan (org.apache.spark.sql.execution.BaseSubqueryExec plan)  ;
}
