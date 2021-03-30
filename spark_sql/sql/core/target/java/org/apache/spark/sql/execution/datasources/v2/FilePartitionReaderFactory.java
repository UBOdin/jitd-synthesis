package org.apache.spark.sql.execution.datasources.v2;
public abstract class FilePartitionReaderFactory implements org.apache.spark.sql.connector.read.PartitionReaderFactory {
  public   FilePartitionReaderFactory ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.PartitionReader<org.apache.spark.sql.vectorized.ColumnarBatch> buildColumnarReader (org.apache.spark.sql.execution.datasources.PartitionedFile partitionedFile)  { throw new RuntimeException(); }
  public abstract  org.apache.spark.sql.connector.read.PartitionReader<org.apache.spark.sql.catalyst.InternalRow> buildReader (org.apache.spark.sql.execution.datasources.PartitionedFile partitionedFile)  ;
  public  org.apache.spark.sql.connector.read.PartitionReader<org.apache.spark.sql.vectorized.ColumnarBatch> createColumnarReader (org.apache.spark.sql.connector.read.InputPartition partition)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.PartitionReader<org.apache.spark.sql.catalyst.InternalRow> createReader (org.apache.spark.sql.connector.read.InputPartition partition)  { throw new RuntimeException(); }
}
