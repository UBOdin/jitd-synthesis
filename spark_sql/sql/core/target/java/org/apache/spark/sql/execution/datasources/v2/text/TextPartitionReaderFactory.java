package org.apache.spark.sql.execution.datasources.v2.text;
/**
 * A factory used to create Text readers.
 * <p>
 * param:  sqlConf SQL configuration.
 * param:  broadcastedConf Broadcasted serializable Hadoop Configuration.
 * param:  readDataSchema Required schema in the batch scan.
 * param:  partitionSchema Schema of partitions.
 * param:  textOptions Options for reading a text file.
 * */
public  class TextPartitionReaderFactory extends org.apache.spark.sql.execution.datasources.v2.FilePartitionReaderFactory implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.internal.SQLConf sqlConf ()  { throw new RuntimeException(); }
  public  org.apache.spark.broadcast.Broadcast<org.apache.spark.util.SerializableConfiguration> broadcastedConf ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType readDataSchema ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType partitionSchema ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.datasources.text.TextOptions textOptions ()  { throw new RuntimeException(); }
  // not preceding
  public   TextPartitionReaderFactory (org.apache.spark.sql.internal.SQLConf sqlConf, org.apache.spark.broadcast.Broadcast<org.apache.spark.util.SerializableConfiguration> broadcastedConf, org.apache.spark.sql.types.StructType readDataSchema, org.apache.spark.sql.types.StructType partitionSchema, org.apache.spark.sql.execution.datasources.text.TextOptions textOptions)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.PartitionReader<org.apache.spark.sql.catalyst.InternalRow> buildReader (org.apache.spark.sql.execution.datasources.PartitionedFile file)  { throw new RuntimeException(); }
}
