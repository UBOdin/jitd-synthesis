package org.apache.spark.sql.catalyst.plans.logical;
public  class TypedFilter extends org.apache.spark.sql.catalyst.plans.logical.UnaryNode implements scala.Product, scala.Serializable {
  static public <T extends java.lang.Object> org.apache.spark.sql.catalyst.plans.logical.TypedFilter apply (java.lang.Object func, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child, org.apache.spark.sql.Encoder<T> evidence$8)  { throw new RuntimeException(); }
  public  java.lang.Object func ()  { throw new RuntimeException(); }
  public  java.lang.Class<?> argumentClass ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType argumentSchema ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression deserializer ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child ()  { throw new RuntimeException(); }
  // not preceding
  public   TypedFilter (java.lang.Object func, java.lang.Class<?> argumentClass, org.apache.spark.sql.types.StructType argumentSchema, org.apache.spark.sql.catalyst.expressions.Expression deserializer, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.Filter withObjectProducerChild (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan obj)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression typedCondition (org.apache.spark.sql.catalyst.expressions.Expression input)  { throw new RuntimeException(); }
}
