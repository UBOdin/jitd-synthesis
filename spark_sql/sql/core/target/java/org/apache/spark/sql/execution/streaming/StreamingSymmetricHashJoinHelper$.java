package org.apache.spark.sql.execution.streaming;
/**
 * Helper object for {@link StreamingSymmetricHashJoinExec}. See that object for more details.
 */
public  class StreamingSymmetricHashJoinHelper$ implements org.apache.spark.internal.Logging {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final StreamingSymmetricHashJoinHelper$ MODULE$ = null;
  public   StreamingSymmetricHashJoinHelper$ ()  { throw new RuntimeException(); }
  /** Get the predicates defining the state watermarks for both sides of the join */
  public  org.apache.spark.sql.execution.streaming.StreamingSymmetricHashJoinHelper.JoinStateWatermarkPredicates getStateWatermarkPredicates (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> leftAttributes, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> rightAttributes, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> leftKeys, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> rightKeys, scala.Option<org.apache.spark.sql.catalyst.expressions.Expression> condition, scala.Option<java.lang.Object> eventTimeWatermark)  { throw new RuntimeException(); }
}
