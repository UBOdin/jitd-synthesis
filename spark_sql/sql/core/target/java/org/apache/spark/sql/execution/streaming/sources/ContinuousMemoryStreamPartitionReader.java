package org.apache.spark.sql.execution.streaming.sources;
/**
 * An input partition reader for continuous memory stream.
 * <p>
 * Polls the driver endpoint for new records.
 */
public  class ContinuousMemoryStreamPartitionReader implements org.apache.spark.sql.connector.read.streaming.ContinuousPartitionReader<org.apache.spark.sql.catalyst.InternalRow> {
  public   ContinuousMemoryStreamPartitionReader (java.lang.String driverEndpointName, int partition, int startOffset)  { throw new RuntimeException(); }
  public  void close ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.InternalRow get ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.streaming.ContinuousRecordPartitionOffset getOffset ()  { throw new RuntimeException(); }
  public  boolean next ()  { throw new RuntimeException(); }
}
