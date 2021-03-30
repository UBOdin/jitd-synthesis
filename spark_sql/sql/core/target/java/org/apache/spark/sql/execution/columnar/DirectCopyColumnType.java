package org.apache.spark.sql.execution.columnar;
/**
 * A fast path to copy var-length bytes between ByteBuffer and UnsafeRow without creating wrapper
 * objects.
 */
public  interface DirectCopyColumnType<JvmType extends java.lang.Object> {
  public  void append (org.apache.spark.sql.catalyst.InternalRow row, int ordinal, java.nio.ByteBuffer buffer)  ;
  public  void extract (java.nio.ByteBuffer buffer, org.apache.spark.sql.catalyst.InternalRow row, int ordinal)  ;
}
