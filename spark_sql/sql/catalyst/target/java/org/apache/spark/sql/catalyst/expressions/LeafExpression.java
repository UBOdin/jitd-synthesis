package org.apache.spark.sql.catalyst.expressions;
/**
 * A leaf expression, i.e. one without any child expressions.
 */
public abstract class LeafExpression extends org.apache.spark.sql.catalyst.expressions.Expression {
  public   LeafExpression ()  { throw new RuntimeException(); }
  public final  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
}
