package org.apache.spark.sql.execution.streaming.continuous;
public  class SetWriterPartitions implements org.apache.spark.sql.execution.streaming.continuous.EpochCoordinatorMessage, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  int numPartitions ()  { throw new RuntimeException(); }
  // not preceding
  public   SetWriterPartitions (int numPartitions)  { throw new RuntimeException(); }
}
