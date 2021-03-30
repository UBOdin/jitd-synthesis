package org.apache.spark.sql.execution.streaming.state;
/**
 * The implementation of StreamingAggregationStateManager for state version 1.
 * In state version 1, the schema of key and value in state are follow:
 * <p>
 * - key: Same as key expressions.
 * - value: Same as input row attributes. The schema of value contains key expressions as well.
 * <p>
 * param:  keyExpressions The attributes of keys.
 * param:  inputRowAttributes The attributes of input row.
 */
public  class StreamingAggregationStateManagerImplV1 extends org.apache.spark.sql.execution.streaming.state.StreamingAggregationStateManagerBaseImpl {
  public   StreamingAggregationStateManagerImplV1 (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> keyExpressions, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> inputRowAttributes)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.UnsafeRow get (org.apache.spark.sql.execution.streaming.state.ReadStateStore store, org.apache.spark.sql.catalyst.expressions.UnsafeRow key)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType getStateValueSchema ()  { throw new RuntimeException(); }
  public  scala.collection.Iterator<org.apache.spark.sql.execution.streaming.state.UnsafeRowPair> iterator (org.apache.spark.sql.execution.streaming.state.ReadStateStore store)  { throw new RuntimeException(); }
  public  void put (org.apache.spark.sql.execution.streaming.state.StateStore store, org.apache.spark.sql.catalyst.expressions.UnsafeRow row)  { throw new RuntimeException(); }
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.expressions.UnsafeRow> values (org.apache.spark.sql.execution.streaming.state.ReadStateStore store)  { throw new RuntimeException(); }
}
