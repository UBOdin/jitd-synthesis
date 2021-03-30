package org.apache.spark.sql.catalyst.analysis;
/**
 * Represents all of the input attributes to a given relational operator, for example in
 * "SELECT * FROM ...". A {@link Star} gets automatically expanded during analysis.
 */
public abstract class Star extends org.apache.spark.sql.catalyst.expressions.LeafExpression implements org.apache.spark.sql.catalyst.expressions.NamedExpression {
  public   Star ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public abstract  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> expand (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan input, scala.Function2<java.lang.String, java.lang.String, java.lang.Object> resolver)  ;
  public  org.apache.spark.sql.catalyst.expressions.ExprId exprId ()  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.NamedExpression newInstance ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> qualifier ()  { throw new RuntimeException(); }
  // not preceding
  public  boolean resolved ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Attribute toAttribute ()  { throw new RuntimeException(); }
}
