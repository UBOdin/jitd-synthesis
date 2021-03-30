package org.apache.spark.sql.execution.datasources.v2.json;
/**
 * A factory used to create JSON readers.
 * <p>
 * param:  sqlConf SQL configuration.
 * param:  broadcastedConf Broadcast serializable Hadoop Configuration.
 * param:  dataSchema Schema of JSON files.
 * param:  readDataSchema Required schema of JSON files.
 * param:  partitionSchema Schema of partitions.
 * param:  parsedOptions Options for parsing JSON files.
 * param:  filters The filters pushed down to JSON datasource.
 */
public  class JsonPartitionReaderFactory extends org.apache.spark.sql.execution.datasources.v2.FilePartitionReaderFactory implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6, T7 v7)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.internal.SQLConf sqlConf ()  { throw new RuntimeException(); }
  public  org.apache.spark.broadcast.Broadcast<org.apache.spark.util.SerializableConfiguration> broadcastedConf ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType dataSchema ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType readDataSchema ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType partitionSchema ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.json.JSONOptionsInRead parsedOptions ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.sources.Filter> filters ()  { throw new RuntimeException(); }
  // not preceding
  public   JsonPartitionReaderFactory (org.apache.spark.sql.internal.SQLConf sqlConf, org.apache.spark.broadcast.Broadcast<org.apache.spark.util.SerializableConfiguration> broadcastedConf, org.apache.spark.sql.types.StructType dataSchema, org.apache.spark.sql.types.StructType readDataSchema, org.apache.spark.sql.types.StructType partitionSchema, org.apache.spark.sql.catalyst.json.JSONOptionsInRead parsedOptions, scala.collection.Seq<org.apache.spark.sql.sources.Filter> filters)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.PartitionReader<org.apache.spark.sql.catalyst.InternalRow> buildReader (org.apache.spark.sql.execution.datasources.PartitionedFile partitionedFile)  { throw new RuntimeException(); }
}
