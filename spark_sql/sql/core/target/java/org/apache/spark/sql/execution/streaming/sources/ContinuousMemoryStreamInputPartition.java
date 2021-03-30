package org.apache.spark.sql.execution.streaming.sources;
/**
 * An input partition for continuous memory stream.
 */
public  class ContinuousMemoryStreamInputPartition implements org.apache.spark.sql.connector.read.InputPartition, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String driverEndpointName ()  { throw new RuntimeException(); }
  public  int partition ()  { throw new RuntimeException(); }
  public  int startOffset ()  { throw new RuntimeException(); }
  // not preceding
  public   ContinuousMemoryStreamInputPartition (java.lang.String driverEndpointName, int partition, int startOffset)  { throw new RuntimeException(); }
}
