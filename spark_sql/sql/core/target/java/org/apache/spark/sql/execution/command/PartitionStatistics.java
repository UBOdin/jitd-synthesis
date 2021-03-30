package org.apache.spark.sql.execution.command;
public  class PartitionStatistics implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  int numFiles ()  { throw new RuntimeException(); }
  public  long totalSize ()  { throw new RuntimeException(); }
  // not preceding
  public   PartitionStatistics (int numFiles, long totalSize)  { throw new RuntimeException(); }
}
