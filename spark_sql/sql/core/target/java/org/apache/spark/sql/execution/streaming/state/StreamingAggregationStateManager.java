package org.apache.spark.sql.execution.streaming.state;
/**
 * Base trait for state manager purposed to be used from streaming aggregations.
 */
public  interface StreamingAggregationStateManager extends scala.Serializable {
  /** Extract columns consisting key from input row, and return the new row for key columns. */
  public  org.apache.spark.sql.catalyst.expressions.UnsafeRow getKey (org.apache.spark.sql.catalyst.expressions.UnsafeRow row)  ;
  /** Calculate schema for the value of state. The schema is mainly passed to the StateStoreRDD. */
  public  org.apache.spark.sql.types.StructType getStateValueSchema ()  ;
  /** Get the current value of a non-null key from the target state store. */
  public  org.apache.spark.sql.catalyst.expressions.UnsafeRow get (org.apache.spark.sql.execution.streaming.state.ReadStateStore store, org.apache.spark.sql.catalyst.expressions.UnsafeRow key)  ;
  /**
   * Put a new value for a non-null key to the target state store. Note that key will be
   * extracted from the input row, and the key would be same as the result of getKey(inputRow).
   * @param store (undocumented)
   * @param row (undocumented)
   */
  public  void put (org.apache.spark.sql.execution.streaming.state.StateStore store, org.apache.spark.sql.catalyst.expressions.UnsafeRow row)  ;
  /**
   * Commit all the updates that have been made to the target state store, and return the
   * new version.
   * @param store (undocumented)
   * @return (undocumented)
   */
  public  long commit (org.apache.spark.sql.execution.streaming.state.StateStore store)  ;
  /** Remove a single non-null key from the target state store. */
  public  void remove (org.apache.spark.sql.execution.streaming.state.StateStore store, org.apache.spark.sql.catalyst.expressions.UnsafeRow key)  ;
  /** Return an iterator containing all the key-value pairs in target state store. */
  public  scala.collection.Iterator<org.apache.spark.sql.execution.streaming.state.UnsafeRowPair> iterator (org.apache.spark.sql.execution.streaming.state.ReadStateStore store)  ;
  /** Return an iterator containing all the keys in target state store. */
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.expressions.UnsafeRow> keys (org.apache.spark.sql.execution.streaming.state.ReadStateStore store)  ;
  /** Return an iterator containing all the values in target state store. */
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.expressions.UnsafeRow> values (org.apache.spark.sql.execution.streaming.state.ReadStateStore store)  ;
}
