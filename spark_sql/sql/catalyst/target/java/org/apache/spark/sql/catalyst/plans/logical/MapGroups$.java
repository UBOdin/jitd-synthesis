package org.apache.spark.sql.catalyst.plans.logical;
/** Factory for constructing new `MapGroups` nodes. */
public  class MapGroups$ implements scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final MapGroups$ MODULE$ = null;
  public   MapGroups$ ()  { throw new RuntimeException(); }
  public <K extends java.lang.Object, T extends java.lang.Object, U extends java.lang.Object> org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (scala.Function2<K, scala.collection.Iterator<T>, scala.collection.TraversableOnce<U>> func, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> groupingAttributes, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> dataAttributes, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child, org.apache.spark.sql.Encoder<K> evidence$13, org.apache.spark.sql.Encoder<T> evidence$14, org.apache.spark.sql.Encoder<U> evidence$15)  { throw new RuntimeException(); }
}
