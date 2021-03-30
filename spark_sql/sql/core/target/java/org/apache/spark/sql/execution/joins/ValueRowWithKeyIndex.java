package org.apache.spark.sql.execution.joins;
/**
 * A wrapper for key index and value in InternalRow type.
 * Designed to be instantiated once per thread and reused.
 */
  class ValueRowWithKeyIndex {
  public   ValueRowWithKeyIndex ()  { throw new RuntimeException(); }
  public  int getKeyIndex ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.InternalRow getValue ()  { throw new RuntimeException(); }
  /** Updates this ValueRowWithKeyIndex.  Returns itself. */
  public  org.apache.spark.sql.execution.joins.ValueRowWithKeyIndex update (int newKeyIndex, org.apache.spark.sql.catalyst.InternalRow newValue)  { throw new RuntimeException(); }
  /** Updates this ValueRowWithKeyIndex by updating its key index.  Returns itself. */
  public  org.apache.spark.sql.execution.joins.ValueRowWithKeyIndex withNewKeyIndex (int newKeyIndex)  { throw new RuntimeException(); }
  /** Updates this ValueRowWithKeyIndex by updating its value.  Returns itself. */
  public  org.apache.spark.sql.execution.joins.ValueRowWithKeyIndex withNewValue (org.apache.spark.sql.catalyst.InternalRow newValue)  { throw new RuntimeException(); }
}
