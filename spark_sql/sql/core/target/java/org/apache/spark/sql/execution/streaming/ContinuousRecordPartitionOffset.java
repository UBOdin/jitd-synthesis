package org.apache.spark.sql.execution.streaming;
public  class ContinuousRecordPartitionOffset implements org.apache.spark.sql.connector.read.streaming.PartitionOffset, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  int partitionId ()  { throw new RuntimeException(); }
  public  int offset ()  { throw new RuntimeException(); }
  // not preceding
  public   ContinuousRecordPartitionOffset (int partitionId, int offset)  { throw new RuntimeException(); }
}
