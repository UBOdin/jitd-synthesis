package org.apache.spark.sql.hive.execution;
/**
 * <code>FileFormat</code> for writing Hive tables.
 * <p>
 * TODO: implement the read logic.
 */
public  class HiveFileFormat implements org.apache.spark.sql.execution.datasources.FileFormat, org.apache.spark.sql.sources.DataSourceRegister, org.apache.spark.internal.Logging {
  public   HiveFileFormat (org.apache.spark.sql.hive.HiveShim.ShimFileSinkDesc fileSinkConf)  { throw new RuntimeException(); }
  public   HiveFileFormat ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.types.StructType> inferSchema (org.apache.spark.sql.SparkSession sparkSession, scala.collection.immutable.Map<java.lang.String, java.lang.String> options, scala.collection.Seq<org.apache.hadoop.fs.FileStatus> files)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.datasources.OutputWriterFactory prepareWrite (org.apache.spark.sql.SparkSession sparkSession, org.apache.hadoop.mapreduce.Job job, scala.collection.immutable.Map<java.lang.String, java.lang.String> options, org.apache.spark.sql.types.StructType dataSchema)  { throw new RuntimeException(); }
  public  java.lang.String shortName ()  { throw new RuntimeException(); }
}
