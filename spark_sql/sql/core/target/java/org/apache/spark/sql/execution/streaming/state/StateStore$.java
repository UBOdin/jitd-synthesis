package org.apache.spark.sql.execution.streaming.state;
/**
 * Companion object to {@link StateStore} that provides helper methods to create and retrieve stores
 * by their unique ids. In addition, when a SparkContext is active (i.e. SparkEnv.get is not null),
 * it also runs a periodic background task to do maintenance on the loaded stores. For each
 * store, it uses the {@link StateStoreCoordinator} to ensure whether the current loaded instance of
 * the store is the active instance. Accordingly, it either keeps it loaded and performs
 * maintenance, or unloads the store.
 */
public  class StateStore$ implements org.apache.spark.internal.Logging {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final StateStore$ MODULE$ = null;
  public   StateStore$ ()  { throw new RuntimeException(); }
  public  int PARTITION_ID_TO_CHECK_SCHEMA ()  { throw new RuntimeException(); }
  /** Get or create a read-only store associated with the id. */
  public  org.apache.spark.sql.execution.streaming.state.ReadStateStore getReadOnly (org.apache.spark.sql.execution.streaming.state.StateStoreProviderId storeProviderId, org.apache.spark.sql.types.StructType keySchema, org.apache.spark.sql.types.StructType valueSchema, scala.Option<java.lang.Object> indexOrdinal, long version, org.apache.spark.sql.execution.streaming.state.StateStoreConf storeConf, org.apache.hadoop.conf.Configuration hadoopConf)  { throw new RuntimeException(); }
  /** Get or create a store associated with the id. */
  public  org.apache.spark.sql.execution.streaming.state.StateStore get (org.apache.spark.sql.execution.streaming.state.StateStoreProviderId storeProviderId, org.apache.spark.sql.types.StructType keySchema, org.apache.spark.sql.types.StructType valueSchema, scala.Option<java.lang.Object> indexOrdinal, long version, org.apache.spark.sql.execution.streaming.state.StateStoreConf storeConf, org.apache.hadoop.conf.Configuration hadoopConf)  { throw new RuntimeException(); }
  /** Unload a state store provider */
  public  void unload (org.apache.spark.sql.execution.streaming.state.StateStoreProviderId storeProviderId)  { throw new RuntimeException(); }
  /** Unload all state store providers: unit test purpose */
    void unloadAll ()  { throw new RuntimeException(); }
  /** Whether a state store provider is loaded or not */
  public  boolean isLoaded (org.apache.spark.sql.execution.streaming.state.StateStoreProviderId storeProviderId)  { throw new RuntimeException(); }
  public  boolean isMaintenanceRunning ()  { throw new RuntimeException(); }
  /** Unload and stop all state store providers */
  public  void stop ()  { throw new RuntimeException(); }
}
