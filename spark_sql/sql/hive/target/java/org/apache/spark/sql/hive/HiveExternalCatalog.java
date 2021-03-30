package org.apache.spark.sql.hive;
/**
 * A persistent implementation of the system catalog using Hive.
 * All public methods must be synchronized for thread-safety.
 */
  class HiveExternalCatalog implements org.apache.spark.sql.catalyst.catalog.ExternalCatalog, org.apache.spark.internal.Logging {
  static public  java.lang.String SPARK_SQL_PREFIX ()  { throw new RuntimeException(); }
  static public  java.lang.String DATASOURCE_PREFIX ()  { throw new RuntimeException(); }
  static public  java.lang.String DATASOURCE_PROVIDER ()  { throw new RuntimeException(); }
  static public  java.lang.String DATASOURCE_SCHEMA ()  { throw new RuntimeException(); }
  static public  java.lang.String DATASOURCE_SCHEMA_PREFIX ()  { throw new RuntimeException(); }
  static public  java.lang.String DATASOURCE_SCHEMA_NUMPARTCOLS ()  { throw new RuntimeException(); }
  static public  java.lang.String DATASOURCE_SCHEMA_NUMSORTCOLS ()  { throw new RuntimeException(); }
  static public  java.lang.String DATASOURCE_SCHEMA_NUMBUCKETS ()  { throw new RuntimeException(); }
  static public  java.lang.String DATASOURCE_SCHEMA_NUMBUCKETCOLS ()  { throw new RuntimeException(); }
  static public  java.lang.String DATASOURCE_SCHEMA_PART_PREFIX ()  { throw new RuntimeException(); }
  static public  java.lang.String DATASOURCE_SCHEMA_PARTCOL_PREFIX ()  { throw new RuntimeException(); }
  static public  java.lang.String DATASOURCE_SCHEMA_BUCKETCOL_PREFIX ()  { throw new RuntimeException(); }
  static public  java.lang.String DATASOURCE_SCHEMA_SORTCOL_PREFIX ()  { throw new RuntimeException(); }
  static public  java.lang.String STATISTICS_PREFIX ()  { throw new RuntimeException(); }
  static public  java.lang.String STATISTICS_TOTAL_SIZE ()  { throw new RuntimeException(); }
  static public  java.lang.String STATISTICS_NUM_ROWS ()  { throw new RuntimeException(); }
  static public  java.lang.String STATISTICS_COL_STATS_PREFIX ()  { throw new RuntimeException(); }
  static public  java.lang.String TABLE_PARTITION_PROVIDER ()  { throw new RuntimeException(); }
  static public  java.lang.String TABLE_PARTITION_PROVIDER_CATALOG ()  { throw new RuntimeException(); }
  static public  java.lang.String TABLE_PARTITION_PROVIDER_FILESYSTEM ()  { throw new RuntimeException(); }
  static public  java.lang.String CREATED_SPARK_VERSION ()  { throw new RuntimeException(); }
  static public  scala.collection.immutable.Set<java.lang.String> HIVE_GENERATED_TABLE_PROPERTIES ()  { throw new RuntimeException(); }
  static public  scala.collection.immutable.Set<java.lang.String> HIVE_GENERATED_STORAGE_PROPERTIES ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.types.StructType EMPTY_DATA_SCHEMA ()  { throw new RuntimeException(); }
  /**
   * Detects a data source table. This checks both the table provider and the table properties,
   * unlike DDLUtils which just checks the former.
   * @param table (undocumented)
   * @return (undocumented)
   */
  static   boolean isDatasourceTable (org.apache.spark.sql.catalyst.catalog.CatalogTable table)  { throw new RuntimeException(); }
  public   HiveExternalCatalog (org.apache.spark.SparkConf conf, org.apache.hadoop.conf.Configuration hadoopConf)  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.hive.client.HiveClient client ()  { throw new RuntimeException(); }
  /**
   * Get the raw table metadata from hive metastore directly. The raw table metadata may contain
   * special data source properties that should not be exposed outside of <code>HiveExternalCatalog</code>. We
   * should interpret these special data source properties and restore the original table metadata
   * before returning it.
   * @param db (undocumented)
   * @param table (undocumented)
   * @return (undocumented)
   */
    org.apache.spark.sql.catalyst.catalog.CatalogTable getRawTable (java.lang.String db, java.lang.String table)  { throw new RuntimeException(); }
    scala.collection.Seq<org.apache.spark.sql.catalyst.catalog.CatalogTable> getRawTablesByNames (java.lang.String db, scala.collection.Seq<java.lang.String> tables)  { throw new RuntimeException(); }
  public  void createDatabase (org.apache.spark.sql.catalyst.catalog.CatalogDatabase dbDefinition, boolean ignoreIfExists)  { throw new RuntimeException(); }
  public  void dropDatabase (java.lang.String db, boolean ignoreIfNotExists, boolean cascade)  { throw new RuntimeException(); }
  /**
   * Alter a database whose name matches the one specified in <code>dbDefinition</code>,
   * assuming the database exists.
   * <p>
   * Note: As of now, this only supports altering database properties!
   * @param dbDefinition (undocumented)
   */
  public  void alterDatabase (org.apache.spark.sql.catalyst.catalog.CatalogDatabase dbDefinition)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.catalog.CatalogDatabase getDatabase (java.lang.String db)  { throw new RuntimeException(); }
  public  boolean databaseExists (java.lang.String db)  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> listDatabases ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> listDatabases (java.lang.String pattern)  { throw new RuntimeException(); }
  public  void setCurrentDatabase (java.lang.String db)  { throw new RuntimeException(); }
  public  void createTable (org.apache.spark.sql.catalyst.catalog.CatalogTable tableDefinition, boolean ignoreIfExists)  { throw new RuntimeException(); }
  public  void dropTable (java.lang.String db, java.lang.String table, boolean ignoreIfNotExists, boolean purge)  { throw new RuntimeException(); }
  public  void renameTable (java.lang.String db, java.lang.String oldName, java.lang.String newName)  { throw new RuntimeException(); }
  /**
   * Alter a table whose name that matches the one specified in <code>tableDefinition</code>,
   * assuming the table exists. This method does not change the properties for data source and
   * statistics.
   * <p>
   * Note: As of now, this doesn't support altering table schema, partition column names and bucket
   * specification. We will ignore them even if users do specify different values for these fields.
   * @param tableDefinition (undocumented)
   */
  public  void alterTable (org.apache.spark.sql.catalyst.catalog.CatalogTable tableDefinition)  { throw new RuntimeException(); }
  /**
   * Alter the data schema of a table identified by the provided database and table name. The new
   * data schema should not have conflict column names with the existing partition columns, and
   * should still contain all the existing data columns.
   * @param db (undocumented)
   * @param table (undocumented)
   * @param newDataSchema (undocumented)
   */
  public  void alterTableDataSchema (java.lang.String db, java.lang.String table, org.apache.spark.sql.types.StructType newDataSchema)  { throw new RuntimeException(); }
  /** Alter the statistics of a table. If `stats` is None, then remove all existing statistics. */
  public  void alterTableStats (java.lang.String db, java.lang.String table, scala.Option<org.apache.spark.sql.catalyst.catalog.CatalogStatistics> stats)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.catalog.CatalogTable getTable (java.lang.String db, java.lang.String table)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.catalog.CatalogTable> getTablesByName (java.lang.String db, scala.collection.Seq<java.lang.String> tables)  { throw new RuntimeException(); }
  public  boolean tableExists (java.lang.String db, java.lang.String table)  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> listTables (java.lang.String db)  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> listTables (java.lang.String db, java.lang.String pattern)  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> listViews (java.lang.String db, java.lang.String pattern)  { throw new RuntimeException(); }
  public  void loadTable (java.lang.String db, java.lang.String table, java.lang.String loadPath, boolean isOverwrite, boolean isSrcLocal)  { throw new RuntimeException(); }
  public  void loadPartition (java.lang.String db, java.lang.String table, java.lang.String loadPath, scala.collection.immutable.Map<java.lang.String, java.lang.String> partition, boolean isOverwrite, boolean inheritTableSpecs, boolean isSrcLocal)  { throw new RuntimeException(); }
  public  void loadDynamicPartitions (java.lang.String db, java.lang.String table, java.lang.String loadPath, scala.collection.immutable.Map<java.lang.String, java.lang.String> partition, boolean replace, int numDP)  { throw new RuntimeException(); }
  public  void createPartitions (java.lang.String db, java.lang.String table, scala.collection.Seq<org.apache.spark.sql.catalyst.catalog.CatalogTablePartition> parts, boolean ignoreIfExists)  { throw new RuntimeException(); }
  public  void dropPartitions (java.lang.String db, java.lang.String table, scala.collection.Seq<scala.collection.immutable.Map<java.lang.String, java.lang.String>> parts, boolean ignoreIfNotExists, boolean purge, boolean retainData)  { throw new RuntimeException(); }
  public  void renamePartitions (java.lang.String db, java.lang.String table, scala.collection.Seq<scala.collection.immutable.Map<java.lang.String, java.lang.String>> specs, scala.collection.Seq<scala.collection.immutable.Map<java.lang.String, java.lang.String>> newSpecs)  { throw new RuntimeException(); }
  public  void alterPartitions (java.lang.String db, java.lang.String table, scala.collection.Seq<org.apache.spark.sql.catalyst.catalog.CatalogTablePartition> newParts)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.catalog.CatalogTablePartition getPartition (java.lang.String db, java.lang.String table, scala.collection.immutable.Map<java.lang.String, java.lang.String> spec)  { throw new RuntimeException(); }
  /**
   * Returns the specified partition or None if it does not exist.
   * @param db (undocumented)
   * @param table (undocumented)
   * @param spec (undocumented)
   * @return (undocumented)
   */
  public  scala.Option<org.apache.spark.sql.catalyst.catalog.CatalogTablePartition> getPartitionOption (java.lang.String db, java.lang.String table, scala.collection.immutable.Map<java.lang.String, java.lang.String> spec)  { throw new RuntimeException(); }
  /**
   * Returns the partition names from hive metastore for a given table in a database.
   * @param db (undocumented)
   * @param table (undocumented)
   * @param partialSpec (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<java.lang.String> listPartitionNames (java.lang.String db, java.lang.String table, scala.Option<scala.collection.immutable.Map<java.lang.String, java.lang.String>> partialSpec)  { throw new RuntimeException(); }
  /**
   * Returns the partitions from hive metastore for a given table in a database.
   * @param db (undocumented)
   * @param table (undocumented)
   * @param partialSpec (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.catalog.CatalogTablePartition> listPartitions (java.lang.String db, java.lang.String table, scala.Option<scala.collection.immutable.Map<java.lang.String, java.lang.String>> partialSpec)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.catalog.CatalogTablePartition> listPartitionsByFilter (java.lang.String db, java.lang.String table, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> predicates, java.lang.String defaultTimeZoneId)  { throw new RuntimeException(); }
  public  void createFunction (java.lang.String db, org.apache.spark.sql.catalyst.catalog.CatalogFunction funcDefinition)  { throw new RuntimeException(); }
  public  void dropFunction (java.lang.String db, java.lang.String name)  { throw new RuntimeException(); }
  public  void alterFunction (java.lang.String db, org.apache.spark.sql.catalyst.catalog.CatalogFunction funcDefinition)  { throw new RuntimeException(); }
  public  void renameFunction (java.lang.String db, java.lang.String oldName, java.lang.String newName)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.catalog.CatalogFunction getFunction (java.lang.String db, java.lang.String funcName)  { throw new RuntimeException(); }
  public  boolean functionExists (java.lang.String db, java.lang.String funcName)  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> listFunctions (java.lang.String db, java.lang.String pattern)  { throw new RuntimeException(); }
}
