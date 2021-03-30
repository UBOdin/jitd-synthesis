package org.apache.spark.sql.execution.streaming.state;
public  class VerifyIfInstanceActive implements org.apache.spark.sql.execution.streaming.state.StateStoreCoordinatorMessage, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.streaming.state.StateStoreProviderId storeId ()  { throw new RuntimeException(); }
  public  java.lang.String executorId ()  { throw new RuntimeException(); }
  // not preceding
  public   VerifyIfInstanceActive (org.apache.spark.sql.execution.streaming.state.StateStoreProviderId storeId, java.lang.String executorId)  { throw new RuntimeException(); }
}
