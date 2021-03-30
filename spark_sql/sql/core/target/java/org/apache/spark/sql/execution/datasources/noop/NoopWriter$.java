package org.apache.spark.sql.execution.datasources.noop;
public  class NoopWriter$ implements org.apache.spark.sql.connector.write.DataWriter<org.apache.spark.sql.catalyst.InternalRow> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final NoopWriter$ MODULE$ = null;
  public   NoopWriter$ ()  { throw new RuntimeException(); }
  public  void write (org.apache.spark.sql.catalyst.InternalRow record)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.write.WriterCommitMessage commit ()  { throw new RuntimeException(); }
  public  void abort ()  { throw new RuntimeException(); }
  public  void close ()  { throw new RuntimeException(); }
}
