package org.apache.spark.sql.execution.streaming.state;
/** A class that contains configuration parameters for {@link StateStore}s. */
public  class StateStoreConf implements scala.Serializable {
  static public  java.lang.String FORMAT_VALIDATION_CHECK_VALUE_CONFIG ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.execution.streaming.state.StateStoreConf empty ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.execution.streaming.state.StateStoreConf apply (org.apache.spark.sql.internal.SQLConf conf)  { throw new RuntimeException(); }
  // not preceding
  public   StateStoreConf (org.apache.spark.sql.internal.SQLConf sqlConf, scala.collection.immutable.Map<java.lang.String, java.lang.String> extraOptions)  { throw new RuntimeException(); }
  public   StateStoreConf ()  { throw new RuntimeException(); }
  /**
   * Minimum number of delta files in a chain after which HDFSBackedStateStore will
   * consider generating a snapshot.
   * @return (undocumented)
   */
  public  int minDeltasForSnapshot ()  { throw new RuntimeException(); }
  /** Minimum versions a State Store implementation should retain to allow rollbacks */
  public  int minVersionsToRetain ()  { throw new RuntimeException(); }
  /** Maximum count of versions a State Store implementation should retain in memory */
  public  int maxVersionsToRetainInMemory ()  { throw new RuntimeException(); }
  /**
   * Optional fully qualified name of the subclass of {@link StateStoreProvider}
   * managing state data. That is, the implementation of the State Store to use.
   * @return (undocumented)
   */
  public  java.lang.String providerClass ()  { throw new RuntimeException(); }
  /** Whether validate the underlying format or not. */
  public  boolean formatValidationEnabled ()  { throw new RuntimeException(); }
  /** Whether validate the value format when the format invalidation enabled. */
  public  boolean formatValidationCheckValue ()  { throw new RuntimeException(); }
  /** The compression codec used to compress delta and snapshot files. */
  public  java.lang.String compressionCodec ()  { throw new RuntimeException(); }
  /** whether to validate state schema during query run. */
  public  boolean stateSchemaCheckEnabled ()  { throw new RuntimeException(); }
  /** The interval of maintenance tasks. */
  public  long maintenanceInterval ()  { throw new RuntimeException(); }
  /**
   * Additional configurations related to state store. This will capture all configs in
   * SQLConf that start with <code>spark.sql.streaming.stateStore.</code> and extraOptions for a specific
   * operator.
   * @return (undocumented)
   */
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> confs ()  { throw new RuntimeException(); }
}
