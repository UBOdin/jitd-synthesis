package org.apache.spark.sql.catalyst.plans.logical;
/**
 * An optimized version of {@link AppendColumns}, that can be executed on deserialized object directly.
 */
public  class AppendColumnsWithObject extends org.apache.spark.sql.catalyst.plans.logical.UnaryNode implements org.apache.spark.sql.catalyst.plans.logical.ObjectConsumer, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.AttributeSet references ()  { throw new RuntimeException(); }
  public  scala.Function1<java.lang.Object, java.lang.Object> func ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> childSerializer ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> newColumnsSerializer ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child ()  { throw new RuntimeException(); }
  // not preceding
  public   AppendColumnsWithObject (scala.Function1<java.lang.Object, java.lang.Object> func, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> childSerializer, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> newColumnsSerializer, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
}
