package org.apache.spark.sql.execution.streaming;
public  class MemoryStreamScanBuilder implements org.apache.spark.sql.connector.read.ScanBuilder, org.apache.spark.sql.connector.read.Scan {
  public   MemoryStreamScanBuilder (org.apache.spark.sql.execution.streaming.MemoryStreamBase<?> stream)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.Scan build ()  { throw new RuntimeException(); }
  public  java.lang.String description ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType readSchema ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.streaming.ContinuousStream toContinuousStream (java.lang.String checkpointLocation)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.streaming.MicroBatchStream toMicroBatchStream (java.lang.String checkpointLocation)  { throw new RuntimeException(); }
}
