package org.apache.spark.sql.execution.datasources.v2.parquet;
public  class ParquetScanBuilder extends org.apache.spark.sql.execution.datasources.v2.FileScanBuilder implements org.apache.spark.sql.connector.read.SupportsPushDownFilters, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.SparkSession sparkSession ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.datasources.PartitioningAwareFileIndex fileIndex ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType schema ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType dataSchema ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.util.CaseInsensitiveStringMap options ()  { throw new RuntimeException(); }
  // not preceding
  public   ParquetScanBuilder (org.apache.spark.sql.SparkSession sparkSession, org.apache.spark.sql.execution.datasources.PartitioningAwareFileIndex fileIndex, org.apache.spark.sql.types.StructType schema, org.apache.spark.sql.types.StructType dataSchema, org.apache.spark.sql.util.CaseInsensitiveStringMap options)  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.hadoop.conf.Configuration hadoopConf ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.sources.Filter[] pushedParquetFilters ()  { throw new RuntimeException(); }
  protected  boolean supportsNestedSchemaPruning ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.sources.Filter[] pushFilters (org.apache.spark.sql.sources.Filter[] filters)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.sources.Filter[] pushedFilters ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.Scan build ()  { throw new RuntimeException(); }
}
