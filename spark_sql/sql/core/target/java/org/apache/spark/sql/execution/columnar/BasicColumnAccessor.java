package org.apache.spark.sql.execution.columnar;
 abstract class BasicColumnAccessor<JvmType extends java.lang.Object> implements org.apache.spark.sql.execution.columnar.ColumnAccessor {
  // not preceding
  public   BasicColumnAccessor (java.nio.ByteBuffer buffer, org.apache.spark.sql.execution.columnar.ColumnType<JvmType> columnType)  { throw new RuntimeException(); }
  protected  java.nio.ByteBuffer buffer ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.execution.columnar.ColumnType<JvmType> columnType ()  { throw new RuntimeException(); }
  public  void extractSingle (org.apache.spark.sql.catalyst.InternalRow row, int ordinal)  { throw new RuntimeException(); }
  public  void extractTo (org.apache.spark.sql.catalyst.InternalRow row, int ordinal)  { throw new RuntimeException(); }
  public  boolean hasNext ()  { throw new RuntimeException(); }
  protected  void initialize ()  { throw new RuntimeException(); }
  protected  java.nio.ByteBuffer underlyingBuffer ()  { throw new RuntimeException(); }
}
