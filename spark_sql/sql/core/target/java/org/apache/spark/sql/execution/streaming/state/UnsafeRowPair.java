package org.apache.spark.sql.execution.streaming.state;
/** Mutable, and reusable class for representing a pair of UnsafeRows. */
public  class UnsafeRowPair {
  public  org.apache.spark.sql.catalyst.expressions.UnsafeRow key ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.UnsafeRow value ()  { throw new RuntimeException(); }
  // not preceding
  public   UnsafeRowPair (org.apache.spark.sql.catalyst.expressions.UnsafeRow key, org.apache.spark.sql.catalyst.expressions.UnsafeRow value)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.streaming.state.UnsafeRowPair withRows (org.apache.spark.sql.catalyst.expressions.UnsafeRow key, org.apache.spark.sql.catalyst.expressions.UnsafeRow value)  { throw new RuntimeException(); }
}
