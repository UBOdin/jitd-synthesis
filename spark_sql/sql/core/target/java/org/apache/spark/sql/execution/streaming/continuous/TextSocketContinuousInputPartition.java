package org.apache.spark.sql.execution.streaming.continuous;
/**
 * Continuous text socket input partition.
 */
public  class TextSocketContinuousInputPartition implements org.apache.spark.sql.connector.read.InputPartition, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String driverEndpointName ()  { throw new RuntimeException(); }
  public  int partitionId ()  { throw new RuntimeException(); }
  public  int startOffset ()  { throw new RuntimeException(); }
  public  boolean includeTimestamp ()  { throw new RuntimeException(); }
  // not preceding
  public   TextSocketContinuousInputPartition (java.lang.String driverEndpointName, int partitionId, int startOffset, boolean includeTimestamp)  { throw new RuntimeException(); }
}
