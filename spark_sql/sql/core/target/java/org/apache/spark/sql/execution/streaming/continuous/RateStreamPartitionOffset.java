package org.apache.spark.sql.execution.streaming.continuous;
public  class RateStreamPartitionOffset implements org.apache.spark.sql.connector.read.streaming.PartitionOffset, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  int partition ()  { throw new RuntimeException(); }
  public  long currentValue ()  { throw new RuntimeException(); }
  public  long currentTimeMs ()  { throw new RuntimeException(); }
  // not preceding
  public   RateStreamPartitionOffset (int partition, long currentValue, long currentTimeMs)  { throw new RuntimeException(); }
}
