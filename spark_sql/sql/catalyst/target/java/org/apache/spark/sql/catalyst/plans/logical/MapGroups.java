package org.apache.spark.sql.catalyst.plans.logical;
public  class MapGroups extends org.apache.spark.sql.catalyst.plans.logical.UnaryNode implements org.apache.spark.sql.catalyst.plans.logical.ObjectProducer, scala.Product, scala.Serializable {
  static public <K extends java.lang.Object, T extends java.lang.Object, U extends java.lang.Object> org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (scala.Function2<K, scala.collection.Iterator<T>, scala.collection.TraversableOnce<U>> func, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> groupingAttributes, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> dataAttributes, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child, org.apache.spark.sql.Encoder<K> evidence$13, org.apache.spark.sql.Encoder<T> evidence$14, org.apache.spark.sql.Encoder<U> evidence$15)  { throw new RuntimeException(); }
  public  scala.Function2<java.lang.Object, scala.collection.Iterator<java.lang.Object>, scala.collection.TraversableOnce<java.lang.Object>> func ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression keyDeserializer ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression valueDeserializer ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> groupingAttributes ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> dataAttributes ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Attribute outputObjAttr ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child ()  { throw new RuntimeException(); }
  // not preceding
  public   MapGroups (scala.Function2<java.lang.Object, scala.collection.Iterator<java.lang.Object>, scala.collection.TraversableOnce<java.lang.Object>> func, org.apache.spark.sql.catalyst.expressions.Expression keyDeserializer, org.apache.spark.sql.catalyst.expressions.Expression valueDeserializer, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> groupingAttributes, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> dataAttributes, org.apache.spark.sql.catalyst.expressions.Attribute outputObjAttr, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child)  { throw new RuntimeException(); }
}
