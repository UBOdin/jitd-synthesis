package org.apache.spark.sql.execution.datasources.v2;
/**
 * A wrapper reader that always appends partition values to {@link InternalRow}s produced by the input
 * reader {@link fileReader}.
 */
public  class PartitionReaderWithPartitionValues implements org.apache.spark.sql.connector.read.PartitionReader<org.apache.spark.sql.catalyst.InternalRow> {
  public   PartitionReaderWithPartitionValues (org.apache.spark.sql.connector.read.PartitionReader<org.apache.spark.sql.catalyst.InternalRow> fileReader, org.apache.spark.sql.types.StructType readDataSchema, org.apache.spark.sql.types.StructType partitionSchema, org.apache.spark.sql.catalyst.InternalRow partitionValues)  { throw new RuntimeException(); }
  public  void close ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.InternalRow get ()  { throw new RuntimeException(); }
  public  boolean next ()  { throw new RuntimeException(); }
}
