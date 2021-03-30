package org.apache.spark.sql.execution.streaming.state;
/**
 * This message is used to report active instance of a state store provider
 * to {@link StateStoreCoordinator}. This message also carries other loaded state
 * store providers on the same executor. {@link StateStoreCoordinator} will check
 * if these providers are inactive now. Inactive providers will be returned
 * back to the sender of the message for unloading.
 */
public  class ReportActiveInstance implements org.apache.spark.sql.execution.streaming.state.StateStoreCoordinatorMessage, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.streaming.state.StateStoreProviderId storeId ()  { throw new RuntimeException(); }
  public  java.lang.String host ()  { throw new RuntimeException(); }
  public  java.lang.String executorId ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.execution.streaming.state.StateStoreProviderId> providerIdsToCheck ()  { throw new RuntimeException(); }
  // not preceding
  public   ReportActiveInstance (org.apache.spark.sql.execution.streaming.state.StateStoreProviderId storeId, java.lang.String host, java.lang.String executorId, scala.collection.Seq<org.apache.spark.sql.execution.streaming.state.StateStoreProviderId> providerIdsToCheck)  { throw new RuntimeException(); }
}
