package org.apache.spark.sql.execution.datasources.noop;
public  class NoopStreamingWrite$ implements org.apache.spark.sql.connector.write.streaming.StreamingWrite {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final NoopStreamingWrite$ MODULE$ = null;
  public   NoopStreamingWrite$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.write.streaming.StreamingDataWriterFactory createStreamingWriterFactory (org.apache.spark.sql.connector.write.PhysicalWriteInfo info)  { throw new RuntimeException(); }
  public  void commit (long epochId, org.apache.spark.sql.connector.write.WriterCommitMessage[] messages)  { throw new RuntimeException(); }
  public  void abort (long epochId, org.apache.spark.sql.connector.write.WriterCommitMessage[] messages)  { throw new RuntimeException(); }
}
