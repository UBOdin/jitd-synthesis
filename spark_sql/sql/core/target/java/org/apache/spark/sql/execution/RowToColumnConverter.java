package org.apache.spark.sql.execution;
/**
 * Provides an optimized set of APIs to append row based data to an array of
 * {@link WritableColumnVector}.
 */
  class RowToColumnConverter implements scala.Serializable {
  public   RowToColumnConverter (org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  public final  void convert (org.apache.spark.sql.catalyst.InternalRow row, org.apache.spark.sql.execution.vectorized.WritableColumnVector[] vectors)  { throw new RuntimeException(); }
}
