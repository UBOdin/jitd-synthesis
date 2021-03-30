package org.apache.spark.sql.execution.streaming.continuous;
/**
 * Set the reader and writer partition counts. Tasks may not be started until the coordinator
 * has acknowledged these messages.
 */
  class SetReaderPartitions implements org.apache.spark.sql.execution.streaming.continuous.EpochCoordinatorMessage, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  int numPartitions ()  { throw new RuntimeException(); }
  // not preceding
  public   SetReaderPartitions (int numPartitions)  { throw new RuntimeException(); }
}
