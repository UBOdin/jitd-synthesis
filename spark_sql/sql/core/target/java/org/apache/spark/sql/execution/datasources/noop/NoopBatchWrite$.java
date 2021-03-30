package org.apache.spark.sql.execution.datasources.noop;
public  class NoopBatchWrite$ implements org.apache.spark.sql.connector.write.BatchWrite {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final NoopBatchWrite$ MODULE$ = null;
  public   NoopBatchWrite$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.write.DataWriterFactory createBatchWriterFactory (org.apache.spark.sql.connector.write.PhysicalWriteInfo info)  { throw new RuntimeException(); }
  public  boolean useCommitCoordinator ()  { throw new RuntimeException(); }
  public  void commit (org.apache.spark.sql.connector.write.WriterCommitMessage[] messages)  { throw new RuntimeException(); }
  public  void abort (org.apache.spark.sql.connector.write.WriterCommitMessage[] messages)  { throw new RuntimeException(); }
}
