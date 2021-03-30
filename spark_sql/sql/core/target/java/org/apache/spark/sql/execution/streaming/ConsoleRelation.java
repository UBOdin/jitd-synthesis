package org.apache.spark.sql.execution.streaming;
public  class ConsoleRelation extends org.apache.spark.sql.sources.BaseRelation implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.SQLContext sqlContext ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> data ()  { throw new RuntimeException(); }
  // not preceding
  public   ConsoleRelation (org.apache.spark.sql.SQLContext sqlContext, org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> data)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType schema ()  { throw new RuntimeException(); }
}
