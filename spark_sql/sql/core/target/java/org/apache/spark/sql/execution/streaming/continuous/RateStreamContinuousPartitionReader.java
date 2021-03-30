package org.apache.spark.sql.execution.streaming.continuous;
public  class RateStreamContinuousPartitionReader implements org.apache.spark.sql.connector.read.streaming.ContinuousPartitionReader<org.apache.spark.sql.catalyst.InternalRow> {
  public   RateStreamContinuousPartitionReader (long startValue, long startTimeMs, int partitionIndex, long increment, double rowsPerSecond)  { throw new RuntimeException(); }
  public  void close ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.InternalRow get ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.streaming.PartitionOffset getOffset ()  { throw new RuntimeException(); }
  public  boolean next ()  { throw new RuntimeException(); }
}
