package org.apache.spark.sql.execution.columnar;
 abstract class ByteArrayColumnType<JvmType extends java.lang.Object> extends org.apache.spark.sql.execution.columnar.ColumnType<JvmType> implements org.apache.spark.sql.execution.columnar.DirectCopyColumnType<JvmType> {
  // not preceding
  public   ByteArrayColumnType (int defaultSize)  { throw new RuntimeException(); }
  public  void append (JvmType v, java.nio.ByteBuffer buffer)  { throw new RuntimeException(); }
  public  int defaultSize ()  { throw new RuntimeException(); }
  public abstract  JvmType deserialize (byte[] bytes)  ;
  public  JvmType extract (java.nio.ByteBuffer buffer)  { throw new RuntimeException(); }
  public abstract  byte[] serialize (JvmType value)  ;
}
