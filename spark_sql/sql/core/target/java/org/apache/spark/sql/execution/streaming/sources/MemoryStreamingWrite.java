package org.apache.spark.sql.execution.streaming.sources;
public  class MemoryStreamingWrite implements org.apache.spark.sql.connector.write.streaming.StreamingWrite {
  // not preceding
  public   MemoryStreamingWrite (org.apache.spark.sql.execution.streaming.sources.MemorySink sink, org.apache.spark.sql.types.StructType schema, boolean needTruncate)  { throw new RuntimeException(); }
  public  void abort (long epochId, org.apache.spark.sql.connector.write.WriterCommitMessage[] messages)  { throw new RuntimeException(); }
  public  void commit (long epochId, org.apache.spark.sql.connector.write.WriterCommitMessage[] messages)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.streaming.sources.MemoryWriterFactory createStreamingWriterFactory (org.apache.spark.sql.connector.write.PhysicalWriteInfo info)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.streaming.sources.MemorySink sink ()  { throw new RuntimeException(); }
}
