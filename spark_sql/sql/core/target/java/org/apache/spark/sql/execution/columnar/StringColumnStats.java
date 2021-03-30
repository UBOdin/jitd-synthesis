package org.apache.spark.sql.execution.columnar;
 final class StringColumnStats implements org.apache.spark.sql.execution.columnar.ColumnStats {
  public   StringColumnStats ()  { throw new RuntimeException(); }
  public  java.lang.Object[] collectedStatistics ()  { throw new RuntimeException(); }
  protected  int count ()  { throw new RuntimeException(); }
  public  void gatherStats (org.apache.spark.sql.catalyst.InternalRow row, int ordinal)  { throw new RuntimeException(); }
  public  void gatherValueStats (org.apache.spark.unsafe.types.UTF8String value, int size)  { throw new RuntimeException(); }
  protected  org.apache.spark.unsafe.types.UTF8String lower ()  { throw new RuntimeException(); }
  protected  int nullCount ()  { throw new RuntimeException(); }
    long sizeInBytes ()  { throw new RuntimeException(); }
  protected  org.apache.spark.unsafe.types.UTF8String upper ()  { throw new RuntimeException(); }
}
