package org.apache.spark.sql.execution.datasources.v2.parquet;
/**
 * A factory used to create Parquet readers.
 * <p>
 * param:  sqlConf SQL configuration.
 * param:  broadcastedConf Broadcast serializable Hadoop Configuration.
 * param:  dataSchema Schema of Parquet files.
 * param:  readDataSchema Required schema of Parquet files.
 * param:  partitionSchema Schema of partitions.
 * param:  filters Filters to be pushed down in the batch scan.
 * param:  parquetOptions The options of Parquet datasource that are set for the read.
 */
public  class ParquetPartitionReaderFactory extends org.apache.spark.sql.execution.datasources.v2.FilePartitionReaderFactory implements org.apache.spark.internal.Logging, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6, T7 v7)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.internal.SQLConf sqlConf ()  { throw new RuntimeException(); }
  public  org.apache.spark.broadcast.Broadcast<org.apache.spark.util.SerializableConfiguration> broadcastedConf ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType dataSchema ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType readDataSchema ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType partitionSchema ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.sources.Filter[] filters ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.datasources.parquet.ParquetOptions parquetOptions ()  { throw new RuntimeException(); }
  // not preceding
  public   ParquetPartitionReaderFactory (org.apache.spark.sql.internal.SQLConf sqlConf, org.apache.spark.broadcast.Broadcast<org.apache.spark.util.SerializableConfiguration> broadcastedConf, org.apache.spark.sql.types.StructType dataSchema, org.apache.spark.sql.types.StructType readDataSchema, org.apache.spark.sql.types.StructType partitionSchema, org.apache.spark.sql.sources.Filter[] filters, org.apache.spark.sql.execution.datasources.parquet.ParquetOptions parquetOptions)  { throw new RuntimeException(); }
  public  boolean supportColumnarReads (org.apache.spark.sql.connector.read.InputPartition partition)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.PartitionReader<org.apache.spark.sql.catalyst.InternalRow> buildReader (org.apache.spark.sql.execution.datasources.PartitionedFile file)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.PartitionReader<org.apache.spark.sql.vectorized.ColumnarBatch> buildColumnarReader (org.apache.spark.sql.execution.datasources.PartitionedFile file)  { throw new RuntimeException(); }
}
