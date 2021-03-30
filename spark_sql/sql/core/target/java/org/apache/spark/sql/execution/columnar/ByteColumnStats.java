package org.apache.spark.sql.execution.columnar;
 final class ByteColumnStats implements org.apache.spark.sql.execution.columnar.ColumnStats {
  public   ByteColumnStats ()  { throw new RuntimeException(); }
  public  java.lang.Object[] collectedStatistics ()  { throw new RuntimeException(); }
  protected  int count ()  { throw new RuntimeException(); }
  public  void gatherStats (org.apache.spark.sql.catalyst.InternalRow row, int ordinal)  { throw new RuntimeException(); }
  public  void gatherValueStats (byte value)  { throw new RuntimeException(); }
  protected  byte lower ()  { throw new RuntimeException(); }
  protected  int nullCount ()  { throw new RuntimeException(); }
    long sizeInBytes ()  { throw new RuntimeException(); }
  protected  byte upper ()  { throw new RuntimeException(); }
}
