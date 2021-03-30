package org.apache.spark.sql.execution.datasources.noop;
public  class NoopStreamingWrite {
  static public  org.apache.spark.sql.connector.write.streaming.StreamingDataWriterFactory createStreamingWriterFactory (org.apache.spark.sql.connector.write.PhysicalWriteInfo info)  { throw new RuntimeException(); }
  static public  void commit (long epochId, org.apache.spark.sql.connector.write.WriterCommitMessage[] messages)  { throw new RuntimeException(); }
  static public  void abort (long epochId, org.apache.spark.sql.connector.write.WriterCommitMessage[] messages)  { throw new RuntimeException(); }
}
