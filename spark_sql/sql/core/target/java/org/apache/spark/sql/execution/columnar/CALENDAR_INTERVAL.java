package org.apache.spark.sql.execution.columnar;
public  class CALENDAR_INTERVAL {
  static public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  static public  int defaultSize ()  { throw new RuntimeException(); }
  static public  org.apache.spark.unsafe.types.CalendarInterval getField (org.apache.spark.sql.catalyst.InternalRow row, int ordinal)  { throw new RuntimeException(); }
  static public  void setField (org.apache.spark.sql.catalyst.InternalRow row, int ordinal, org.apache.spark.unsafe.types.CalendarInterval value)  { throw new RuntimeException(); }
  static public  org.apache.spark.unsafe.types.CalendarInterval extract (java.nio.ByteBuffer buffer)  { throw new RuntimeException(); }
  static public  void extract (java.nio.ByteBuffer buffer, org.apache.spark.sql.catalyst.InternalRow row, int ordinal)  { throw new RuntimeException(); }
  static public  void append (org.apache.spark.unsafe.types.CalendarInterval v, java.nio.ByteBuffer buffer)  { throw new RuntimeException(); }
  static public  int actualSize (org.apache.spark.sql.catalyst.InternalRow row, int ordinal)  { throw new RuntimeException(); }
  static public  void copyField (org.apache.spark.sql.catalyst.InternalRow from, int fromOrdinal, org.apache.spark.sql.catalyst.InternalRow to, int toOrdinal)  { throw new RuntimeException(); }
  static public  JvmType clone (JvmType v)  { throw new RuntimeException(); }
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
}
