package org.apache.spark.sql.execution.datasources.noop;
public  class NoopBatchWrite {
  static public  org.apache.spark.sql.connector.write.DataWriterFactory createBatchWriterFactory (org.apache.spark.sql.connector.write.PhysicalWriteInfo info)  { throw new RuntimeException(); }
  static public  boolean useCommitCoordinator ()  { throw new RuntimeException(); }
  static public  void commit (org.apache.spark.sql.connector.write.WriterCommitMessage[] messages)  { throw new RuntimeException(); }
  static public  void abort (org.apache.spark.sql.connector.write.WriterCommitMessage[] messages)  { throw new RuntimeException(); }
  static public  void onDataWriterCommit (org.apache.spark.sql.connector.write.WriterCommitMessage x$1)  { throw new RuntimeException(); }
}
