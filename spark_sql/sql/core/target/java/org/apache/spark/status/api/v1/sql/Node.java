package org.apache.spark.status.api.v1.sql;
public  class Node implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  long nodeId ()  { throw new RuntimeException(); }
  public  java.lang.String nodeName ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object> wholeStageCodegenId ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.status.api.v1.sql.Metric> metrics ()  { throw new RuntimeException(); }
  // not preceding
     Node (long nodeId, java.lang.String nodeName, scala.Option<java.lang.Object> wholeStageCodegenId, scala.collection.Seq<org.apache.spark.status.api.v1.sql.Metric> metrics)  { throw new RuntimeException(); }
}
