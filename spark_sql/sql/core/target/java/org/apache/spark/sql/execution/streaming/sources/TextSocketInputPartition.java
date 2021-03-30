package org.apache.spark.sql.execution.streaming.sources;
public  class TextSocketInputPartition implements org.apache.spark.sql.connector.read.InputPartition, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.mutable.ListBuffer<scala.Tuple2<org.apache.spark.unsafe.types.UTF8String, java.lang.Object>> slice ()  { throw new RuntimeException(); }
  // not preceding
  public   TextSocketInputPartition (scala.collection.mutable.ListBuffer<scala.Tuple2<org.apache.spark.unsafe.types.UTF8String, java.lang.Object>> slice)  { throw new RuntimeException(); }
}
