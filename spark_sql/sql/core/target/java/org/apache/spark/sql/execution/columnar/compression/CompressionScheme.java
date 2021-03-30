package org.apache.spark.sql.execution.columnar.compression;
public  interface CompressionScheme {
  public  int typeId ()  ;
  public  boolean supports (org.apache.spark.sql.execution.columnar.ColumnType<?> columnType)  ;
  public <T extends org.apache.spark.sql.types.AtomicType> org.apache.spark.sql.execution.columnar.compression.Encoder<T> encoder (org.apache.spark.sql.execution.columnar.NativeColumnType<T> columnType)  ;
  public <T extends org.apache.spark.sql.types.AtomicType> org.apache.spark.sql.execution.columnar.compression.Decoder<T> decoder (java.nio.ByteBuffer buffer, org.apache.spark.sql.execution.columnar.NativeColumnType<T> columnType)  ;
}
