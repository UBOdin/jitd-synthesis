package org.apache.spark.sql.execution.streaming.sources;
public  class ContinuousMemoryStreamOffset extends org.apache.spark.sql.connector.read.streaming.Offset implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.Object, java.lang.Object> partitionNums ()  { throw new RuntimeException(); }
  // not preceding
  public   ContinuousMemoryStreamOffset (scala.collection.immutable.Map<java.lang.Object, java.lang.Object> partitionNums)  { throw new RuntimeException(); }
  public  java.lang.String json ()  { throw new RuntimeException(); }
}
