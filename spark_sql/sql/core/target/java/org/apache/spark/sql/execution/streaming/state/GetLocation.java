package org.apache.spark.sql.execution.streaming.state;
public  class GetLocation implements org.apache.spark.sql.execution.streaming.state.StateStoreCoordinatorMessage, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.streaming.state.StateStoreProviderId storeId ()  { throw new RuntimeException(); }
  // not preceding
  public   GetLocation (org.apache.spark.sql.execution.streaming.state.StateStoreProviderId storeId)  { throw new RuntimeException(); }
}
