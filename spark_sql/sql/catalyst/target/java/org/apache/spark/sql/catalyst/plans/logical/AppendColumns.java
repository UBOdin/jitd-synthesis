package org.apache.spark.sql.catalyst.plans.logical;
public  class AppendColumns extends org.apache.spark.sql.catalyst.plans.logical.UnaryNode implements scala.Product, scala.Serializable {
  static public <T extends java.lang.Object, U extends java.lang.Object> org.apache.spark.sql.catalyst.plans.logical.AppendColumns apply (scala.Function1<T, U> func, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child, org.apache.spark.sql.Encoder<T> evidence$9, org.apache.spark.sql.Encoder<U> evidence$10)  { throw new RuntimeException(); }
  static public <T extends java.lang.Object, U extends java.lang.Object> org.apache.spark.sql.catalyst.plans.logical.AppendColumns apply (scala.Function1<T, U> func, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> inputAttributes, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child, org.apache.spark.sql.Encoder<T> evidence$11, org.apache.spark.sql.Encoder<U> evidence$12)  { throw new RuntimeException(); }
  public  scala.Function1<java.lang.Object, java.lang.Object> func ()  { throw new RuntimeException(); }
  public  java.lang.Class<?> argumentClass ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType argumentSchema ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression deserializer ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> serializer ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child ()  { throw new RuntimeException(); }
  // not preceding
  public   AppendColumns (scala.Function1<java.lang.Object, java.lang.Object> func, java.lang.Class<?> argumentClass, org.apache.spark.sql.types.StructType argumentSchema, org.apache.spark.sql.catalyst.expressions.Expression deserializer, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> serializer, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> newColumns ()  { throw new RuntimeException(); }
}
