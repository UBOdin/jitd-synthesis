package org.apache.spark.sql.execution.columnar;
 abstract class NativeColumnAccessor<T extends org.apache.spark.sql.types.AtomicType> extends org.apache.spark.sql.execution.columnar.BasicColumnAccessor<java.lang.Object> implements org.apache.spark.sql.execution.columnar.NullableColumnAccessor, org.apache.spark.sql.execution.columnar.compression.CompressibleColumnAccessor<T> {
  // not preceding
  public   NativeColumnAccessor (java.nio.ByteBuffer buffer, org.apache.spark.sql.execution.columnar.NativeColumnType<T> columnType)  { throw new RuntimeException(); }
  protected  java.nio.ByteBuffer buffer ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.execution.columnar.NativeColumnType<T> columnType ()  { throw new RuntimeException(); }
}
