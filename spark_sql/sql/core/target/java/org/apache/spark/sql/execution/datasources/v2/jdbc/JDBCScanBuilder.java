package org.apache.spark.sql.execution.datasources.v2.jdbc;
public  class JDBCScanBuilder implements org.apache.spark.sql.connector.read.ScanBuilder, org.apache.spark.sql.connector.read.SupportsPushDownFilters, org.apache.spark.sql.connector.read.SupportsPushDownRequiredColumns, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.SparkSession session ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType schema ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.datasources.jdbc.JDBCOptions jdbcOptions ()  { throw new RuntimeException(); }
  // not preceding
  public   JDBCScanBuilder (org.apache.spark.sql.SparkSession session, org.apache.spark.sql.types.StructType schema, org.apache.spark.sql.execution.datasources.jdbc.JDBCOptions jdbcOptions)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.sources.Filter[] pushFilters (org.apache.spark.sql.sources.Filter[] filters)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.sources.Filter[] pushedFilters ()  { throw new RuntimeException(); }
  public  void pruneColumns (org.apache.spark.sql.types.StructType requiredSchema)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.Scan build ()  { throw new RuntimeException(); }
}
