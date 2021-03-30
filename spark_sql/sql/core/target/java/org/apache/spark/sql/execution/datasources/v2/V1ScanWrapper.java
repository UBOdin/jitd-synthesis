package org.apache.spark.sql.execution.datasources.v2;
public  class V1ScanWrapper implements org.apache.spark.sql.connector.read.Scan, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.V1Scan v1Scan ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.sources.Filter> translatedFilters ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.sources.Filter> handledFilters ()  { throw new RuntimeException(); }
  // not preceding
  public   V1ScanWrapper (org.apache.spark.sql.connector.read.V1Scan v1Scan, scala.collection.Seq<org.apache.spark.sql.sources.Filter> translatedFilters, scala.collection.Seq<org.apache.spark.sql.sources.Filter> handledFilters)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType readSchema ()  { throw new RuntimeException(); }
}
