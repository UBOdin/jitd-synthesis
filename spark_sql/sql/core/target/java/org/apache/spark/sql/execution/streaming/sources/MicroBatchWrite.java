package org.apache.spark.sql.execution.streaming.sources;
/**
 * A {@link BatchWrite} used to hook V2 stream writers into a microbatch plan. It implements
 * the non-streaming interface, forwarding the epoch ID determined at construction to a wrapped
 * streaming write support.
 */
public  class MicroBatchWrite implements org.apache.spark.sql.connector.write.BatchWrite {
  // not preceding
  public   MicroBatchWrite (long eppchId, org.apache.spark.sql.connector.write.streaming.StreamingWrite writeSupport)  { throw new RuntimeException(); }
  public  void abort (org.apache.spark.sql.connector.write.WriterCommitMessage[] messages)  { throw new RuntimeException(); }
  public  void commit (org.apache.spark.sql.connector.write.WriterCommitMessage[] messages)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.write.DataWriterFactory createBatchWriterFactory (org.apache.spark.sql.connector.write.PhysicalWriteInfo info)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.write.streaming.StreamingWrite writeSupport ()  { throw new RuntimeException(); }
}
