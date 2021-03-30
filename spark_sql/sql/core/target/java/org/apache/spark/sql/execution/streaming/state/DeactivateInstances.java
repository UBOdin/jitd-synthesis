package org.apache.spark.sql.execution.streaming.state;
public  class DeactivateInstances implements org.apache.spark.sql.execution.streaming.state.StateStoreCoordinatorMessage, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.util.UUID runId ()  { throw new RuntimeException(); }
  // not preceding
  public   DeactivateInstances (java.util.UUID runId)  { throw new RuntimeException(); }
}
