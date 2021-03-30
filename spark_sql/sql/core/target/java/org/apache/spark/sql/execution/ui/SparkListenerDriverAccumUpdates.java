package org.apache.spark.sql.execution.ui;
/**
 * A message used to update SQL metric value for driver-side updates (which doesn't get reflected
 * automatically).
 * <p>
 * param:  executionId The execution id for a query, so we can find the query plan.
 * param:  accumUpdates Map from accumulator id to the metric value (metrics are always 64-bit ints).
 */
public  class SparkListenerDriverAccumUpdates implements org.apache.spark.scheduler.SparkListenerEvent, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  long executionId ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<scala.Tuple2<java.lang.Object, java.lang.Object>> accumUpdates ()  { throw new RuntimeException(); }
  // not preceding
  public   SparkListenerDriverAccumUpdates (long executionId, scala.collection.Seq<scala.Tuple2<java.lang.Object, java.lang.Object>> accumUpdates)  { throw new RuntimeException(); }
}
