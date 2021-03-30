package org.apache.spark.sql.execution.streaming.state;
/** Wraps the instance of StateStore to make the instance read-only. */
public  class WrappedReadStateStore implements org.apache.spark.sql.execution.streaming.state.ReadStateStore {
  public   WrappedReadStateStore (org.apache.spark.sql.execution.streaming.state.StateStore store)  { throw new RuntimeException(); }
  public  void abort ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.UnsafeRow get (org.apache.spark.sql.catalyst.expressions.UnsafeRow key)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.streaming.state.StateStoreId id ()  { throw new RuntimeException(); }
  public  scala.collection.Iterator<org.apache.spark.sql.execution.streaming.state.UnsafeRowPair> iterator ()  { throw new RuntimeException(); }
  public  long version ()  { throw new RuntimeException(); }
}
