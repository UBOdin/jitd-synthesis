package org.apache.spark.sql.execution;
/**
 * A trait that provides functionality to handle aliases in the <code>outputExpressions</code>.
 */
public  interface AliasAwareOutputExpression extends org.apache.spark.sql.execution.UnaryExecNode {
  public  boolean hasAlias ()  ;
  public  org.apache.spark.sql.catalyst.expressions.Expression normalizeExpression (org.apache.spark.sql.catalyst.expressions.Expression exp)  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> outputExpressions ()  ;
}
