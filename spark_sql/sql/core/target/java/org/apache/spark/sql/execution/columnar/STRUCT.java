package org.apache.spark.sql.execution.columnar;
  class STRUCT extends org.apache.spark.sql.execution.columnar.ColumnType<org.apache.spark.sql.catalyst.expressions.UnsafeRow> implements org.apache.spark.sql.execution.columnar.DirectCopyColumnType<org.apache.spark.sql.catalyst.expressions.UnsafeRow>, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType dataType ()  { throw new RuntimeException(); }
  // not preceding
  public   STRUCT (org.apache.spark.sql.types.StructType dataType)  { throw new RuntimeException(); }
  public  int defaultSize ()  { throw new RuntimeException(); }
  public  void setField (org.apache.spark.sql.catalyst.InternalRow row, int ordinal, org.apache.spark.sql.catalyst.expressions.UnsafeRow value)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.UnsafeRow getField (org.apache.spark.sql.catalyst.InternalRow row, int ordinal)  { throw new RuntimeException(); }
  public  int actualSize (org.apache.spark.sql.catalyst.InternalRow row, int ordinal)  { throw new RuntimeException(); }
  public  void append (org.apache.spark.sql.catalyst.expressions.UnsafeRow value, java.nio.ByteBuffer buffer)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.UnsafeRow extract (java.nio.ByteBuffer buffer)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.UnsafeRow clone (org.apache.spark.sql.catalyst.expressions.UnsafeRow v)  { throw new RuntimeException(); }
}
