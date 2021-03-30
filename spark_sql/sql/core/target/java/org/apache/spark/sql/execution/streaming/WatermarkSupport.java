package org.apache.spark.sql.execution.streaming;
/** An operator that supports watermark. */
public  interface WatermarkSupport extends org.apache.spark.sql.execution.UnaryExecNode {
  /** The keys that may have a watermark attribute. */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> keyExpressions ()  ;
  /** The watermark value. */
  public  scala.Option<java.lang.Object> eventTimeWatermark ()  ;
  /** Generate an expression that matches data older than the watermark */
  public  scala.Option<org.apache.spark.sql.catalyst.expressions.Expression> watermarkExpression ()  ;
  /** Predicate based on keys that matches data older than the watermark */
  public  scala.Option<org.apache.spark.sql.catalyst.expressions.BasePredicate> watermarkPredicateForKeys ()  ;
  /** Predicate based on the child output that matches data older than the watermark. */
  public  scala.Option<org.apache.spark.sql.catalyst.expressions.BasePredicate> watermarkPredicateForData ()  ;
  public  void removeKeysOlderThanWatermark (org.apache.spark.sql.execution.streaming.state.StateStore store)  ;
  public  void removeKeysOlderThanWatermark (org.apache.spark.sql.execution.streaming.state.StreamingAggregationStateManager storeManager, org.apache.spark.sql.execution.streaming.state.StateStore store)  ;
}
