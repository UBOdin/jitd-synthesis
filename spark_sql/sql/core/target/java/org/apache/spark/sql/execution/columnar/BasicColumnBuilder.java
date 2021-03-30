package org.apache.spark.sql.execution.columnar;
  class BasicColumnBuilder<JvmType extends java.lang.Object> implements org.apache.spark.sql.execution.columnar.ColumnBuilder {
  // not preceding
  public   BasicColumnBuilder (org.apache.spark.sql.execution.columnar.ColumnStats columnStats, org.apache.spark.sql.execution.columnar.ColumnType<JvmType> columnType)  { throw new RuntimeException(); }
  public  void appendFrom (org.apache.spark.sql.catalyst.InternalRow row, int ordinal)  { throw new RuntimeException(); }
  protected  java.nio.ByteBuffer buffer ()  { throw new RuntimeException(); }
  public  java.nio.ByteBuffer build ()  { throw new RuntimeException(); }
  protected  java.lang.String columnName ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.columnar.ColumnStats columnStats ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.columnar.ColumnType<JvmType> columnType ()  { throw new RuntimeException(); }
  public  void initialize (int initialSize, java.lang.String columnName, boolean useCompression)  { throw new RuntimeException(); }
}
