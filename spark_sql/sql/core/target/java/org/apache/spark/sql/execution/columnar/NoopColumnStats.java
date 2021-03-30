package org.apache.spark.sql.execution.columnar;
/**
 * A no-op ColumnStats only used for testing purposes.
 */
 final class NoopColumnStats implements org.apache.spark.sql.execution.columnar.ColumnStats {
  public   NoopColumnStats ()  { throw new RuntimeException(); }
  public  java.lang.Object[] collectedStatistics ()  { throw new RuntimeException(); }
  protected  int count ()  { throw new RuntimeException(); }
  public  void gatherStats (org.apache.spark.sql.catalyst.InternalRow row, int ordinal)  { throw new RuntimeException(); }
  protected  int nullCount ()  { throw new RuntimeException(); }
    long sizeInBytes ()  { throw new RuntimeException(); }
}
