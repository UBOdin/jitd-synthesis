package org.apache.spark.sql.execution.columnar;
public  class BINARY$ extends org.apache.spark.sql.execution.columnar.ByteArrayColumnType<byte[]> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final BINARY$ MODULE$ = null;
  public   BINARY$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  void setField (org.apache.spark.sql.catalyst.InternalRow row, int ordinal, byte[] value)  { throw new RuntimeException(); }
  public  byte[] getField (org.apache.spark.sql.catalyst.InternalRow row, int ordinal)  { throw new RuntimeException(); }
  public  int actualSize (org.apache.spark.sql.catalyst.InternalRow row, int ordinal)  { throw new RuntimeException(); }
  public  byte[] serialize (byte[] value)  { throw new RuntimeException(); }
  public  byte[] deserialize (byte[] bytes)  { throw new RuntimeException(); }
}
