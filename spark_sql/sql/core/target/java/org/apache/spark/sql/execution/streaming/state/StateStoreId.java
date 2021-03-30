package org.apache.spark.sql.execution.streaming.state;
/**
 * Unique identifier for a bunch of keyed state data.
 * param:  checkpointRootLocation Root directory where all the state data of a query is stored
 * param:  operatorId Unique id of a stateful operator
 * param:  partitionId Index of the partition of an operators state data
 * param:  storeName Optional, name of the store. Each partition can optionally use multiple state
 *                  stores, but they have to be identified by distinct names.
 */
public  class StateStoreId implements scala.Product, scala.Serializable {
  static public  java.lang.String DEFAULT_STORE_NAME ()  { throw new RuntimeException(); }
  public  java.lang.String checkpointRootLocation ()  { throw new RuntimeException(); }
  public  long operatorId ()  { throw new RuntimeException(); }
  public  int partitionId ()  { throw new RuntimeException(); }
  public  java.lang.String storeName ()  { throw new RuntimeException(); }
  // not preceding
  public   StateStoreId (java.lang.String checkpointRootLocation, long operatorId, int partitionId, java.lang.String storeName)  { throw new RuntimeException(); }
  /**
   * Checkpoint directory to be used by a single state store, identified uniquely by the tuple
   * (operatorId, partitionId, storeName). All implementations of {@link StateStoreProvider} should
   * use this path for saving state data, as this ensures that distinct stores will write to
   * different locations.
   * @return (undocumented)
   */
  public  org.apache.hadoop.fs.Path storeCheckpointLocation ()  { throw new RuntimeException(); }
}
