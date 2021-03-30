package org.apache.spark.sql.execution.streaming.state;
/**
 * Trait representing a provider that provide {@link StateStore} instances representing
 * versions of state data.
 * <p>
 * The life cycle of a provider and its provide stores are as follows.
 * <p>
 * - A StateStoreProvider is created in a executor for each unique {@link StateStoreId} when
 *   the first batch of a streaming query is executed on the executor. All subsequent batches reuse
 *   this provider instance until the query is stopped.
 * <p>
 * - Every batch of streaming data request a specific version of the state data by invoking
 *   <code>getStore(version)</code> which returns an instance of {@link StateStore} through which the required
 *   version of the data can be accessed. It is the responsible of the provider to populate
 *   this store with context information like the schema of keys and values, etc.
 * <p>
 * - After the streaming query is stopped, the created provider instances are lazily disposed off.
 */
public  interface StateStoreProvider {
  /**
   * Initialize the provide with more contextual information from the SQL operator.
   * This method will be called first after creating an instance of the StateStoreProvider by
   * reflection.
   * <p>
   * @param stateStoreId Id of the versioned StateStores that this provider will generate
   * @param keySchema Schema of keys to be stored
   * @param valueSchema Schema of value to be stored
   * @param keyIndexOrdinal Optional column (represent as the ordinal of the field in keySchema) by
   *                        which the StateStore implementation could index the data.
   * @param storeConfs Configurations used by the StateStores
   * @param hadoopConf Hadoop configuration that could be used by StateStore to save state data
   */
  public  void init (org.apache.spark.sql.execution.streaming.state.StateStoreId stateStoreId, org.apache.spark.sql.types.StructType keySchema, org.apache.spark.sql.types.StructType valueSchema, scala.Option<java.lang.Object> keyIndexOrdinal, org.apache.spark.sql.execution.streaming.state.StateStoreConf storeConfs, org.apache.hadoop.conf.Configuration hadoopConf)  ;
  /**
   * Return the id of the StateStores this provider will generate.
   * Should be the same as the one passed in init().
   * @return (undocumented)
   */
  public  org.apache.spark.sql.execution.streaming.state.StateStoreId stateStoreId ()  ;
  /** Called when the provider instance is unloaded from the executor */
  public  void close ()  ;
  /** Return an instance of {@link StateStore} representing state data of the given version */
  public  org.apache.spark.sql.execution.streaming.state.StateStore getStore (long version)  ;
  /**
   * Return an instance of {@link ReadStateStore} representing state data of the given version.
   * By default it will return the same instance as getStore(version) but wrapped to prevent
   * modification. Providers can override and return optimized version of {@link ReadStateStore}
   * based on the fact the instance will be only used for reading.
   * @param version (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.execution.streaming.state.ReadStateStore getReadStore (long version)  ;
  /** Optional method for providers to allow for background maintenance (e.g. compactions) */
  public  void doMaintenance ()  ;
  /**
   * Optional custom metrics that the implementation may want to report.
   * @note The StateStore objects created by this provider must report the same custom metrics
   * (specifically, same names) through <code>StateStore.metrics</code>.
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.execution.streaming.state.StateStoreCustomMetric> supportedCustomMetrics ()  ;
}
