package org.apache.spark.sql.execution.streaming.continuous;
/**
 * Continuous text socket input partition reader.
 * <p>
 * Polls the driver endpoint for new records.
 */
public  class TextSocketContinuousPartitionReader implements org.apache.spark.sql.connector.read.streaming.ContinuousPartitionReader<org.apache.spark.sql.catalyst.InternalRow> {
  public   TextSocketContinuousPartitionReader (java.lang.String driverEndpointName, int partitionId, int startOffset, boolean includeTimestamp)  { throw new RuntimeException(); }
  public  void close ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.InternalRow get ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.streaming.PartitionOffset getOffset ()  { throw new RuntimeException(); }
  public  boolean next ()  { throw new RuntimeException(); }
}
