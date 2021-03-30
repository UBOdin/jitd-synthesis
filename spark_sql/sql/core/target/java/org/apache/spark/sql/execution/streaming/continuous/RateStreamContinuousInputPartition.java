package org.apache.spark.sql.execution.streaming.continuous;
public  class RateStreamContinuousInputPartition implements org.apache.spark.sql.connector.read.InputPartition, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  long startValue ()  { throw new RuntimeException(); }
  public  long startTimeMs ()  { throw new RuntimeException(); }
  public  int partitionIndex ()  { throw new RuntimeException(); }
  public  long increment ()  { throw new RuntimeException(); }
  public  double rowsPerSecond ()  { throw new RuntimeException(); }
  // not preceding
  public   RateStreamContinuousInputPartition (long startValue, long startTimeMs, int partitionIndex, long increment, double rowsPerSecond)  { throw new RuntimeException(); }
}
