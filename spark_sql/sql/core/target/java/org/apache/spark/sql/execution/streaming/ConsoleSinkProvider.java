package org.apache.spark.sql.execution.streaming;
public  class ConsoleSinkProvider implements org.apache.spark.sql.internal.connector.SimpleTableProvider, org.apache.spark.sql.sources.DataSourceRegister, org.apache.spark.sql.sources.CreatableRelationProvider {
  public   ConsoleSinkProvider ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.sources.BaseRelation createRelation (org.apache.spark.sql.SQLContext sqlContext, org.apache.spark.sql.SaveMode mode, scala.collection.immutable.Map<java.lang.String, java.lang.String> parameters, org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> data)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.Table getTable (org.apache.spark.sql.util.CaseInsensitiveStringMap options)  { throw new RuntimeException(); }
  public  java.lang.String shortName ()  { throw new RuntimeException(); }
}
