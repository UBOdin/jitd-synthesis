package org.apache.spark.sql.execution.datasources.jdbc;
public  class JdbcRelationProvider implements org.apache.spark.sql.sources.CreatableRelationProvider, org.apache.spark.sql.sources.RelationProvider, org.apache.spark.sql.sources.DataSourceRegister {
  public   JdbcRelationProvider ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.sources.BaseRelation createRelation (org.apache.spark.sql.SQLContext sqlContext, scala.collection.immutable.Map<java.lang.String, java.lang.String> parameters)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.sources.BaseRelation createRelation (org.apache.spark.sql.SQLContext sqlContext, org.apache.spark.sql.SaveMode mode, scala.collection.immutable.Map<java.lang.String, java.lang.String> parameters, org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> df)  { throw new RuntimeException(); }
  public  java.lang.String shortName ()  { throw new RuntimeException(); }
}
