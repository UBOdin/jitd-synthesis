package org.apache.spark.sql.execution.datasources.v2;
/**
 * A base interface for data source v2 implementations of the built-in file-based data sources.
 */
public  interface FileDataSourceV2 extends org.apache.spark.sql.connector.catalog.TableProvider, org.apache.spark.sql.sources.DataSourceRegister {
  /**
   * Returns a V1 {@link FileFormat} class of the same file data source.
   * This is a solution for the following cases:
   * 1. File datasource V2 implementations cause regression. Users can disable the problematic data
   *    source via SQL configuration and fall back to FileFormat.
   * 2. Catalog support is required, which is still under development for data source V2.
   * @return (undocumented)
   */
  public  java.lang.Class<? extends org.apache.spark.sql.execution.datasources.FileFormat> fallbackFileFormat ()  ;
  public  org.apache.spark.sql.util.CaseInsensitiveStringMap getOptionsWithoutPaths (org.apache.spark.sql.util.CaseInsensitiveStringMap map)  ;
  public  scala.collection.Seq<java.lang.String> getPaths (org.apache.spark.sql.util.CaseInsensitiveStringMap map)  ;
  public  org.apache.spark.sql.connector.catalog.Table getTable (org.apache.spark.sql.util.CaseInsensitiveStringMap options)  ;
  public  org.apache.spark.sql.connector.catalog.Table getTable (org.apache.spark.sql.util.CaseInsensitiveStringMap options, org.apache.spark.sql.types.StructType schema)  ;
  public  org.apache.spark.sql.connector.catalog.Table getTable (org.apache.spark.sql.types.StructType schema, org.apache.spark.sql.connector.expressions.Transform[] partitioning, java.util.Map<java.lang.String, java.lang.String> properties)  ;
  public  java.lang.String getTableName (org.apache.spark.sql.util.CaseInsensitiveStringMap map, scala.collection.Seq<java.lang.String> paths)  ;
  public  org.apache.spark.sql.connector.expressions.Transform[] inferPartitioning (org.apache.spark.sql.util.CaseInsensitiveStringMap options)  ;
  public  org.apache.spark.sql.types.StructType inferSchema (org.apache.spark.sql.util.CaseInsensitiveStringMap options)  ;
  public  java.lang.String qualifiedPathName (java.lang.String path, org.apache.hadoop.conf.Configuration hadoopConf)  ;
  public  org.apache.spark.sql.SparkSession sparkSession ()  ;
  public  boolean supportsExternalMetadata ()  ;
}
