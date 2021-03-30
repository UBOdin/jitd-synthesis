package org.apache.spark.sql.execution.streaming;
public  class OffsetHolder extends org.apache.spark.sql.catalyst.plans.logical.LeafNode implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.streaming.Offset start ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.streaming.Offset end ()  { throw new RuntimeException(); }
  // not preceding
  public   OffsetHolder (org.apache.spark.sql.connector.read.streaming.Offset start, org.apache.spark.sql.connector.read.streaming.Offset end)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
}
