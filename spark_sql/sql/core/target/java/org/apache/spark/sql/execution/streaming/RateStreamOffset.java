package org.apache.spark.sql.execution.streaming;
public  class RateStreamOffset extends org.apache.spark.sql.connector.read.streaming.Offset implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.Object, org.apache.spark.sql.execution.streaming.ValueRunTimeMsPair> partitionToValueAndRunTimeMs ()  { throw new RuntimeException(); }
  // not preceding
  public   RateStreamOffset (scala.collection.immutable.Map<java.lang.Object, org.apache.spark.sql.execution.streaming.ValueRunTimeMsPair> partitionToValueAndRunTimeMs)  { throw new RuntimeException(); }
  public  org.json4s.DefaultFormats defaultFormats ()  { throw new RuntimeException(); }
  public  java.lang.String json ()  { throw new RuntimeException(); }
}
