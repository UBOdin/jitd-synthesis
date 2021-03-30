package org.apache.spark.sql.execution.streaming.sources;
public  class RateStreamMicroBatchPartitionReader implements org.apache.spark.sql.connector.read.PartitionReader<org.apache.spark.sql.catalyst.InternalRow> {
  public   RateStreamMicroBatchPartitionReader (int partitionId, int numPartitions, long rangeStart, long rangeEnd, long localStartTimeMs, double relativeMsPerValue)  { throw new RuntimeException(); }
  public  void close ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.InternalRow get ()  { throw new RuntimeException(); }
  public  boolean next ()  { throw new RuntimeException(); }
}
