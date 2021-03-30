package org.apache.spark.sql.execution.columnar;
  class MAP extends org.apache.spark.sql.execution.columnar.ColumnType<org.apache.spark.sql.catalyst.expressions.UnsafeMapData> implements org.apache.spark.sql.execution.columnar.DirectCopyColumnType<org.apache.spark.sql.catalyst.expressions.UnsafeMapData>, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.MapType dataType ()  { throw new RuntimeException(); }
  // not preceding
  public   MAP (org.apache.spark.sql.types.MapType dataType)  { throw new RuntimeException(); }
  public  int defaultSize ()  { throw new RuntimeException(); }
  public  void setField (org.apache.spark.sql.catalyst.InternalRow row, int ordinal, org.apache.spark.sql.catalyst.expressions.UnsafeMapData value)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.UnsafeMapData getField (org.apache.spark.sql.catalyst.InternalRow row, int ordinal)  { throw new RuntimeException(); }
  public  int actualSize (org.apache.spark.sql.catalyst.InternalRow row, int ordinal)  { throw new RuntimeException(); }
  public  void append (org.apache.spark.sql.catalyst.expressions.UnsafeMapData value, java.nio.ByteBuffer buffer)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.UnsafeMapData extract (java.nio.ByteBuffer buffer)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.UnsafeMapData clone (org.apache.spark.sql.catalyst.expressions.UnsafeMapData v)  { throw new RuntimeException(); }
}
