package org.apache.spark.sql.internal.connector;
public  interface SimpleTableProvider extends org.apache.spark.sql.connector.catalog.TableProvider {
  public  org.apache.spark.sql.connector.catalog.Table getOrLoadTable (org.apache.spark.sql.util.CaseInsensitiveStringMap options)  ;
  public  org.apache.spark.sql.connector.catalog.Table getTable (org.apache.spark.sql.util.CaseInsensitiveStringMap options)  ;
  public  org.apache.spark.sql.connector.catalog.Table getTable (org.apache.spark.sql.types.StructType schema, org.apache.spark.sql.connector.expressions.Transform[] partitioning, java.util.Map<java.lang.String, java.lang.String> properties)  ;
  public  org.apache.spark.sql.types.StructType inferSchema (org.apache.spark.sql.util.CaseInsensitiveStringMap options)  ;
}
