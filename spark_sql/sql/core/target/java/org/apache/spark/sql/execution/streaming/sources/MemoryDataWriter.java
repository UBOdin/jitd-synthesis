package org.apache.spark.sql.execution.streaming.sources;
public  class MemoryDataWriter implements org.apache.spark.sql.connector.write.DataWriter<org.apache.spark.sql.catalyst.InternalRow>, org.apache.spark.internal.Logging {
  public   MemoryDataWriter (int partition, org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  public  void abort ()  { throw new RuntimeException(); }
  public  void close ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.streaming.sources.MemoryWriterCommitMessage commit ()  { throw new RuntimeException(); }
  public  void write (org.apache.spark.sql.catalyst.InternalRow row)  { throw new RuntimeException(); }
}
