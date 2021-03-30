package org.apache.spark.sql.execution.streaming.continuous;
/**
 * A {@link ContinuousStream} that reads text lines through a TCP socket, designed only for tutorials
 * and debugging. This ContinuousStream will *not* work in production applications due to
 * multiple reasons, including no support for fault recovery.
 * <p>
 * The driver maintains a socket connection to the host-port, keeps the received messages in
 * buckets and serves the messages to the executors via a RPC endpoint.
 */
public  class TextSocketContinuousStream implements org.apache.spark.sql.connector.read.streaming.ContinuousStream, org.apache.spark.internal.Logging {
  public   TextSocketContinuousStream (java.lang.String host, int port, int numPartitions, org.apache.spark.sql.util.CaseInsensitiveStringMap options)  { throw new RuntimeException(); }
  public  void commit (org.apache.spark.sql.connector.read.streaming.Offset end)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.streaming.ContinuousPartitionReaderFactory createContinuousReaderFactory ()  { throw new RuntimeException(); }
  public  org.json4s.DefaultFormats defaultFormats ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.streaming.Offset deserializeOffset (java.lang.String json)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.streaming.Offset initialOffset ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.streaming.Offset mergeOffsets (org.apache.spark.sql.connector.read.streaming.PartitionOffset[] offsets)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.InputPartition[] planInputPartitions (org.apache.spark.sql.connector.read.streaming.Offset start)  { throw new RuntimeException(); }
    org.apache.spark.sql.execution.streaming.continuous.TextSocketOffset startOffset ()  { throw new RuntimeException(); }
  /** Stop this source. */
  public  void stop ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
