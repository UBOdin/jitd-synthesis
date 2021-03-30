package org.apache.spark.sql.execution;
public  class PartialReducerPartitionSpec implements org.apache.spark.sql.execution.ShufflePartitionSpec, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  int reducerIndex ()  { throw new RuntimeException(); }
  public  int startMapIndex ()  { throw new RuntimeException(); }
  public  int endMapIndex ()  { throw new RuntimeException(); }
  public  long dataSize ()  { throw new RuntimeException(); }
  // not preceding
  public   PartialReducerPartitionSpec (int reducerIndex, int startMapIndex, int endMapIndex, long dataSize)  { throw new RuntimeException(); }
}
