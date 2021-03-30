package org.apache.spark.sql.execution.datasources.v2.jdbc;
public  class JDBCScan implements org.apache.spark.sql.connector.read.V1Scan, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.datasources.jdbc.JDBCRelation relation ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType prunedSchema ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.sources.Filter[] pushedFilters ()  { throw new RuntimeException(); }
  // not preceding
  public   JDBCScan (org.apache.spark.sql.execution.datasources.jdbc.JDBCRelation relation, org.apache.spark.sql.types.StructType prunedSchema, org.apache.spark.sql.sources.Filter[] pushedFilters)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType readSchema ()  { throw new RuntimeException(); }
  public <T extends org.apache.spark.sql.sources.BaseRelation> T toV1TableScan (org.apache.spark.sql.SQLContext context)  { throw new RuntimeException(); }
  public  java.lang.String description ()  { throw new RuntimeException(); }
}
