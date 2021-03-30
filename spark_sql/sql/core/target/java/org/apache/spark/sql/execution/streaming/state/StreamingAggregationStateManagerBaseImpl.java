package org.apache.spark.sql.execution.streaming.state;
public abstract class StreamingAggregationStateManagerBaseImpl implements org.apache.spark.sql.execution.streaming.state.StreamingAggregationStateManager {
  // not preceding
  public   StreamingAggregationStateManagerBaseImpl (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> keyExpressions, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> inputRowAttributes)  { throw new RuntimeException(); }
  public  long commit (org.apache.spark.sql.execution.streaming.state.StateStore store)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.UnsafeRow getKey (org.apache.spark.sql.catalyst.expressions.UnsafeRow row)  { throw new RuntimeException(); }
  protected  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> inputRowAttributes ()  { throw new RuntimeException(); }
  protected  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> keyExpressions ()  { throw new RuntimeException(); }
  // not preceding
  protected  org.apache.spark.sql.catalyst.expressions.UnsafeProjection keyProjector ()  { throw new RuntimeException(); }
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.expressions.UnsafeRow> keys (org.apache.spark.sql.execution.streaming.state.ReadStateStore store)  { throw new RuntimeException(); }
  public  void remove (org.apache.spark.sql.execution.streaming.state.StateStore store, org.apache.spark.sql.catalyst.expressions.UnsafeRow key)  { throw new RuntimeException(); }
}
