package org.apache.spark.sql.catalyst.expressions;
public  class SubqueryExpression$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final SubqueryExpression$ MODULE$ = null;
  public   SubqueryExpression$ ()  { throw new RuntimeException(); }
  /**
   * Returns true when an expression contains an IN or correlated EXISTS subquery
   * and false otherwise.
   * @param e (undocumented)
   * @return (undocumented)
   */
  public  boolean hasInOrCorrelatedExistsSubquery (org.apache.spark.sql.catalyst.expressions.Expression e)  { throw new RuntimeException(); }
  /**
   * Returns true when an expression contains a subquery that has outer reference(s). The outer
   * reference attributes are kept as children of subquery expression by
   * {@link org.apache.spark.sql.catalyst.analysis.Analyzer.ResolveSubquery}
   * @param e (undocumented)
   * @return (undocumented)
   */
  public  boolean hasCorrelatedSubquery (org.apache.spark.sql.catalyst.expressions.Expression e)  { throw new RuntimeException(); }
  /**
   * Returns true when an expression contains a subquery
   * @param e (undocumented)
   * @return (undocumented)
   */
  public  boolean hasSubquery (org.apache.spark.sql.catalyst.expressions.Expression e)  { throw new RuntimeException(); }
}
