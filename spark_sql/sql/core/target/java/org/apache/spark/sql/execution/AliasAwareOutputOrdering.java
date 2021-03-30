package org.apache.spark.sql.execution;
/**
 * A trait that handles aliases in the <code>orderingExpressions</code> to produce <code>outputOrdering</code> that
 * satisfies ordering requirements.
 */
public  interface AliasAwareOutputOrdering extends org.apache.spark.sql.execution.AliasAwareOutputExpression {
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> orderingExpressions ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> outputOrdering ()  ;
}
