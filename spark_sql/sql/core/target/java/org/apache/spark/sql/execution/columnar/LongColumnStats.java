package org.apache.spark.sql.execution.columnar;
 final class LongColumnStats implements org.apache.spark.sql.execution.columnar.ColumnStats {
  public   LongColumnStats ()  { throw new RuntimeException(); }
  public  java.lang.Object[] collectedStatistics ()  { throw new RuntimeException(); }
  protected  int count ()  { throw new RuntimeException(); }
  public  void gatherStats (org.apache.spark.sql.catalyst.InternalRow row, int ordinal)  { throw new RuntimeException(); }
  public  void gatherValueStats (long value)  { throw new RuntimeException(); }
  protected  long lower ()  { throw new RuntimeException(); }
  protected  int nullCount ()  { throw new RuntimeException(); }
    long sizeInBytes ()  { throw new RuntimeException(); }
  protected  long upper ()  { throw new RuntimeException(); }
}
