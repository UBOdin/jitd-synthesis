package org.apache.spark.sql.execution;
public  class PartialMapperPartitionSpec implements org.apache.spark.sql.execution.ShufflePartitionSpec, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  int mapIndex ()  { throw new RuntimeException(); }
  public  int startReducerIndex ()  { throw new RuntimeException(); }
  public  int endReducerIndex ()  { throw new RuntimeException(); }
  // not preceding
  public   PartialMapperPartitionSpec (int mapIndex, int startReducerIndex, int endReducerIndex)  { throw new RuntimeException(); }
}
