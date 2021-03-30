package org.apache.spark.sql.execution.datasources.v2.json;
public  class JsonScanBuilder extends org.apache.spark.sql.execution.datasources.v2.FileScanBuilder implements org.apache.spark.sql.connector.read.SupportsPushDownFilters {
  public   JsonScanBuilder (org.apache.spark.sql.SparkSession sparkSession, org.apache.spark.sql.execution.datasources.PartitioningAwareFileIndex fileIndex, org.apache.spark.sql.types.StructType schema, org.apache.spark.sql.types.StructType dataSchema, org.apache.spark.sql.util.CaseInsensitiveStringMap options)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.Scan build ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.sources.Filter[] pushFilters (org.apache.spark.sql.sources.Filter[] filters)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.sources.Filter[] pushedFilters ()  { throw new RuntimeException(); }
}
