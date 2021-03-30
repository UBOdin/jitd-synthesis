package org.apache.spark.sql.catalyst;
public  class NoopFilters extends org.apache.spark.sql.catalyst.StructFilters {
  public   NoopFilters ()  { throw new RuntimeException(); }
  public  void reset ()  { throw new RuntimeException(); }
  public  boolean skipRow (org.apache.spark.sql.catalyst.InternalRow row, int index)  { throw new RuntimeException(); }
}
