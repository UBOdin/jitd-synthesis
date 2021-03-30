package org.apache.spark.sql.execution.streaming.state;
/**
 * Metrics reported by a state store
 * param:  numKeys         Number of keys in the state store
 * param:  memoryUsedBytes Memory used by the state store
 * param:  customMetrics   Custom implementation-specific metrics
 *                        The metrics reported through this must have the same <code>name</code> as those
 *                        reported by <code>StateStoreProvider.customMetrics</code>.
 */
public  class StateStoreMetrics implements scala.Product, scala.Serializable {
  static public  org.apache.spark.sql.execution.streaming.state.StateStoreMetrics combine (scala.collection.Seq<org.apache.spark.sql.execution.streaming.state.StateStoreMetrics> allMetrics)  { throw new RuntimeException(); }
  public  long numKeys ()  { throw new RuntimeException(); }
  public  long memoryUsedBytes ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<org.apache.spark.sql.execution.streaming.state.StateStoreCustomMetric, java.lang.Object> customMetrics ()  { throw new RuntimeException(); }
  // not preceding
  public   StateStoreMetrics (long numKeys, long memoryUsedBytes, scala.collection.immutable.Map<org.apache.spark.sql.execution.streaming.state.StateStoreCustomMetric, java.lang.Object> customMetrics)  { throw new RuntimeException(); }
}
