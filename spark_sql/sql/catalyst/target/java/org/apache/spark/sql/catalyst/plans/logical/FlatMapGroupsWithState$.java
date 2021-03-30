package org.apache.spark.sql.catalyst.plans.logical;
/** Factory for constructing new `MapGroupsWithState` nodes. */
public  class FlatMapGroupsWithState$ implements scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final FlatMapGroupsWithState$ MODULE$ = null;
  public   FlatMapGroupsWithState$ ()  { throw new RuntimeException(); }
  // not preceding
  public <K extends java.lang.Object, V extends java.lang.Object, S extends java.lang.Object, U extends java.lang.Object> org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (scala.Function3<java.lang.Object, scala.collection.Iterator<java.lang.Object>, org.apache.spark.sql.catalyst.plans.logical.LogicalGroupState<java.lang.Object>, scala.collection.Iterator<java.lang.Object>> func, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> groupingAttributes, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> dataAttributes, org.apache.spark.sql.streaming.OutputMode outputMode, boolean isMapGroupsWithState, org.apache.spark.sql.streaming.GroupStateTimeout timeout, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child, org.apache.spark.sql.Encoder<K> evidence$16, org.apache.spark.sql.Encoder<V> evidence$17, org.apache.spark.sql.Encoder<S> evidence$18, org.apache.spark.sql.Encoder<U> evidence$19)  { throw new RuntimeException(); }
}
