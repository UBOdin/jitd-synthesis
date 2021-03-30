package org.apache.spark.sql.catalyst.analysis;
/**
 * Represents all the resolved input attributes to a given relational operator. This is used
 * in the data frame DSL.
 * <p>
 * param:  expressions Expressions to expand.
 */
public  class ResolvedStar extends org.apache.spark.sql.catalyst.analysis.Star implements org.apache.spark.sql.catalyst.expressions.Unevaluable, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> expressions ()  { throw new RuntimeException(); }
  // not preceding
  public   ResolvedStar (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> expressions)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.NamedExpression newInstance ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> expand (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan input, scala.Function2<java.lang.String, java.lang.String, java.lang.Object> resolver)  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
