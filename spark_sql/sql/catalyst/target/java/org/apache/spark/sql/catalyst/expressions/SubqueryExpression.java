package org.apache.spark.sql.catalyst.expressions;
/**
 * A base interface for expressions that contain a {@link LogicalPlan}.
 */
public abstract class SubqueryExpression extends org.apache.spark.sql.catalyst.expressions.PlanExpression<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  /**
   * Returns true when an expression contains an IN or correlated EXISTS subquery
   * and false otherwise.
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  boolean hasInOrCorrelatedExistsSubquery (org.apache.spark.sql.catalyst.expressions.Expression e)  { throw new RuntimeException(); }
  /**
   * Returns true when an expression contains a subquery that has outer reference(s). The outer
   * reference attributes are kept as children of subquery expression by
   * {@link org.apache.spark.sql.catalyst.analysis.Analyzer.ResolveSubquery}
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  boolean hasCorrelatedSubquery (org.apache.spark.sql.catalyst.expressions.Expression e)  { throw new RuntimeException(); }
  /**
   * Returns true when an expression contains a subquery
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  boolean hasSubquery (org.apache.spark.sql.catalyst.expressions.Expression e)  { throw new RuntimeException(); }
  public   SubqueryExpression (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children, org.apache.spark.sql.catalyst.expressions.ExprId exprId)  { throw new RuntimeException(); }
  // not preceding
  public  boolean resolved ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.catalyst.expressions.AttributeSet references ()  { throw new RuntimeException(); }
  public abstract  org.apache.spark.sql.catalyst.expressions.SubqueryExpression withNewPlan (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  ;
  public  boolean semanticEquals (org.apache.spark.sql.catalyst.expressions.Expression o)  { throw new RuntimeException(); }
}
