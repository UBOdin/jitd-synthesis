package org.apache.spark.sql.catalyst.plans.logical;
/** Factory for constructing new `CoGroup` nodes. */
public  class CoGroup$ implements scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final CoGroup$ MODULE$ = null;
  public   CoGroup$ ()  { throw new RuntimeException(); }
  public <K extends java.lang.Object, L extends java.lang.Object, R extends java.lang.Object, OUT extends java.lang.Object> org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (scala.Function3<K, scala.collection.Iterator<L>, scala.collection.Iterator<R>, scala.collection.TraversableOnce<OUT>> func, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> leftGroup, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> rightGroup, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> leftAttr, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> rightAttr, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan left, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan right, org.apache.spark.sql.Encoder<K> evidence$20, org.apache.spark.sql.Encoder<L> evidence$21, org.apache.spark.sql.Encoder<R> evidence$22, org.apache.spark.sql.Encoder<OUT> evidence$23)  { throw new RuntimeException(); }
}
