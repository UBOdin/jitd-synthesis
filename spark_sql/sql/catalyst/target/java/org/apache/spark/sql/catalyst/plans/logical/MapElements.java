package org.apache.spark.sql.catalyst.plans.logical;
public  class MapElements extends org.apache.spark.sql.catalyst.plans.logical.UnaryNode implements org.apache.spark.sql.catalyst.plans.logical.ObjectConsumer, org.apache.spark.sql.catalyst.plans.logical.ObjectProducer, scala.Product, scala.Serializable {
  static public <T extends java.lang.Object, U extends java.lang.Object> org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (java.lang.Object func, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child, org.apache.spark.sql.Encoder<T> evidence$6, org.apache.spark.sql.Encoder<U> evidence$7)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.AttributeSet references ()  { throw new RuntimeException(); }
  public  java.lang.Object func ()  { throw new RuntimeException(); }
  public  java.lang.Class<?> argumentClass ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType argumentSchema ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Attribute outputObjAttr ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child ()  { throw new RuntimeException(); }
  // not preceding
  public   MapElements (java.lang.Object func, java.lang.Class<?> argumentClass, org.apache.spark.sql.types.StructType argumentSchema, org.apache.spark.sql.catalyst.expressions.Attribute outputObjAttr, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child)  { throw new RuntimeException(); }
}
