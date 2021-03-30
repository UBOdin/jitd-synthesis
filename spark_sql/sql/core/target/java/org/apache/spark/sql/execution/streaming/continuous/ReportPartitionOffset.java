package org.apache.spark.sql.execution.streaming.continuous;
/**
 * Report that a partition is ending the specified epoch at the specified offset.
 */
  class ReportPartitionOffset implements org.apache.spark.sql.execution.streaming.continuous.EpochCoordinatorMessage, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  int partitionId ()  { throw new RuntimeException(); }
  public  long epoch ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.streaming.PartitionOffset offset ()  { throw new RuntimeException(); }
  // not preceding
  public   ReportPartitionOffset (int partitionId, long epoch, org.apache.spark.sql.connector.read.streaming.PartitionOffset offset)  { throw new RuntimeException(); }
}
