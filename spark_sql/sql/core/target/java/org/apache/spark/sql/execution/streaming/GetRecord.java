package org.apache.spark.sql.execution.streaming;
public  class GetRecord implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.streaming.ContinuousRecordPartitionOffset offset ()  { throw new RuntimeException(); }
  // not preceding
  public   GetRecord (org.apache.spark.sql.execution.streaming.ContinuousRecordPartitionOffset offset)  { throw new RuntimeException(); }
}
