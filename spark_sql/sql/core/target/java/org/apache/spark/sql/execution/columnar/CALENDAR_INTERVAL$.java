package org.apache.spark.sql.execution.columnar;
public  class CALENDAR_INTERVAL$ extends org.apache.spark.sql.execution.columnar.ColumnType<org.apache.spark.unsafe.types.CalendarInterval> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final CALENDAR_INTERVAL$ MODULE$ = null;
  public   CALENDAR_INTERVAL$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  int defaultSize ()  { throw new RuntimeException(); }
  public  org.apache.spark.unsafe.types.CalendarInterval getField (org.apache.spark.sql.catalyst.InternalRow row, int ordinal)  { throw new RuntimeException(); }
  public  void setField (org.apache.spark.sql.catalyst.InternalRow row, int ordinal, org.apache.spark.unsafe.types.CalendarInterval value)  { throw new RuntimeException(); }
  public  org.apache.spark.unsafe.types.CalendarInterval extract (java.nio.ByteBuffer buffer)  { throw new RuntimeException(); }
  public  void extract (java.nio.ByteBuffer buffer, org.apache.spark.sql.catalyst.InternalRow row, int ordinal)  { throw new RuntimeException(); }
  public  void append (org.apache.spark.unsafe.types.CalendarInterval v, java.nio.ByteBuffer buffer)  { throw new RuntimeException(); }
}
