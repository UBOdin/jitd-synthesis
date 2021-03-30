package org.apache.spark.sql.hive;
public  class HiveUtils$ implements org.apache.spark.internal.Logging {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final HiveUtils$ MODULE$ = null;
  public   HiveUtils$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.SparkContext withHiveExternalCatalog (org.apache.spark.SparkContext sc)  { throw new RuntimeException(); }
  /** The version of hive used internally by Spark SQL. */
  public  java.lang.String builtinHiveVersion ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> HIVE_METASTORE_VERSION ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> FAKE_HIVE_VERSION ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.String> HIVE_METASTORE_JARS ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<scala.collection.Seq<java.lang.String>> HIVE_METASTORE_JARS_PATH ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CONVERT_METASTORE_PARQUET ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CONVERT_METASTORE_PARQUET_WITH_SCHEMA_MERGING ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CONVERT_METASTORE_ORC ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CONVERT_INSERTING_PARTITIONED_TABLE ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> CONVERT_METASTORE_CTAS ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<scala.collection.Seq<java.lang.String>> HIVE_METASTORE_SHARED_PREFIXES ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<scala.collection.Seq<java.lang.String>> HIVE_METASTORE_BARRIER_PREFIXES ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.config.ConfigEntry<java.lang.Object> HIVE_THRIFT_SERVER_ASYNC ()  { throw new RuntimeException(); }
  /**
   * Change time configurations needed to create a {@link HiveClient} into unified {@link Long} format.
   * @param hadoopConf (undocumented)
   * @return (undocumented)
   */
    scala.collection.immutable.Map<java.lang.String, java.lang.String> formatTimeVarsForHiveClient (org.apache.hadoop.conf.Configuration hadoopConf)  { throw new RuntimeException(); }
  /**
   * Check current Thread's SessionState type
   * @return true when SessionState.get returns an instance of CliSessionState,
   *         false when it gets non-CliSessionState instance or null
   */
  public  boolean isCliSessionState ()  { throw new RuntimeException(); }
  /**
   * Create a {@link HiveClient} used for execution.
   * <p>
   * Currently this must always be the Hive built-in version that packaged
   * with Spark SQL. This copy of the client is used for execution related tasks like
   * registering temporary functions or ensuring that the ThreadLocal SessionState is
   * correctly populated.  This copy of Hive is *not* used for storing persistent metadata,
   * and only point to a dummy metastore in a temporary directory.
   * @param conf (undocumented)
   * @param hadoopConf (undocumented)
   * @return (undocumented)
   */
  protected  org.apache.spark.sql.hive.client.HiveClientImpl newClientForExecution (org.apache.spark.SparkConf conf, org.apache.hadoop.conf.Configuration hadoopConf)  { throw new RuntimeException(); }
  /**
   * Create a {@link HiveClient} used to retrieve metadata from the Hive MetaStore.
   * <p>
   * The version of the Hive client that is used here must match the metastore that is configured
   * in the hive-site.xml file.
   * @param conf (undocumented)
   * @param hadoopConf (undocumented)
   * @return (undocumented)
   */
  protected  org.apache.spark.sql.hive.client.HiveClient newClientForMetadata (org.apache.spark.SparkConf conf, org.apache.hadoop.conf.Configuration hadoopConf)  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.hive.client.HiveClient newClientForMetadata (org.apache.spark.SparkConf conf, org.apache.hadoop.conf.Configuration hadoopConf, scala.collection.immutable.Map<java.lang.String, java.lang.String> configurations)  { throw new RuntimeException(); }
  /** Constructs a configuration for hive, where the metastore is located in a temp directory. */
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> newTemporaryConfiguration (boolean useInMemoryDerby)  { throw new RuntimeException(); }
  /**
   * Infers the schema for Hive serde tables and returns the CatalogTable with the inferred schema.
   * When the tables are data source tables or the schema already exists, returns the original
   * CatalogTable.
   * @param table (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.catalog.CatalogTable inferSchema (org.apache.spark.sql.catalyst.catalog.CatalogTable table)  { throw new RuntimeException(); }
}
