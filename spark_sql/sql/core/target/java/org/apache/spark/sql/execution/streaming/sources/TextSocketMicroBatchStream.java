package org.apache.spark.sql.execution.streaming.sources;
/**
 * A MicroBatchReadSupport that reads text lines through a TCP socket, designed only for tutorials
 * and debugging. This MicroBatchReadSupport will *not* work in production applications due to
 * multiple reasons, including no support for fault recovery.
 */
public  class TextSocketMicroBatchStream implements org.apache.spark.sql.connector.read.streaming.MicroBatchStream, org.apache.spark.internal.Logging {
  public   TextSocketMicroBatchStream (java.lang.String host, int port, int numPartitions)  { throw new RuntimeException(); }
  public  void commit (org.apache.spark.sql.connector.read.streaming.Offset end)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.PartitionReaderFactory createReaderFactory ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.streaming.Offset deserializeOffset (java.lang.String json)  { throw new RuntimeException(); }
  /** This method is only used for unit test */
    org.apache.spark.sql.execution.streaming.LongOffset getCurrentOffset ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.streaming.Offset initialOffset ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.streaming.Offset latestOffset ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.InputPartition[] planInputPartitions (org.apache.spark.sql.connector.read.streaming.Offset start, org.apache.spark.sql.connector.read.streaming.Offset end)  { throw new RuntimeException(); }
  /** Stop this source. */
  public  void stop ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
