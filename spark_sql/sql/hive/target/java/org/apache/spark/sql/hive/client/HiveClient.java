package org.apache.spark.sql.hive.client;
/**
 * An externally visible interface to the Hive client.  This interface is shared across both the
 * internal and external classloaders for a given version of Hive and thus must expose only
 * shared classes.
 */
public  interface HiveClient {
  /** Add a jar into class loader */
  public  void addJar (java.lang.String path)  ;
  /**
   * Alter a database whose name matches the one specified in <code>database</code>, assuming it exists.
   * @param database (undocumented)
   */
  public  void alterDatabase (org.apache.spark.sql.catalyst.catalog.CatalogDatabase database)  ;
  /** Alter a function whose name matches the one specified in `func`, assuming it exists. */
  public  void alterFunction (java.lang.String db, org.apache.spark.sql.catalyst.catalog.CatalogFunction func)  ;
  /**
   * Alter one or more table partitions whose specs match the ones specified in <code>newParts</code>,
   * assuming the partitions exist.
   * @param db (undocumented)
   * @param table (undocumented)
   * @param newParts (undocumented)
   */
  public  void alterPartitions (java.lang.String db, java.lang.String table, scala.collection.Seq<org.apache.spark.sql.catalyst.catalog.CatalogTablePartition> newParts)  ;
  /** Alter a table whose name matches the one specified in `table`, assuming it exists. */
  public  void alterTable (org.apache.spark.sql.catalyst.catalog.CatalogTable table)  ;
  /**
   * Updates the given table with new metadata, optionally renaming the table or
   * moving across different database.
   * @param dbName (undocumented)
   * @param tableName (undocumented)
   * @param table (undocumented)
   */
  public  void alterTable (java.lang.String dbName, java.lang.String tableName, org.apache.spark.sql.catalyst.catalog.CatalogTable table)  ;
  /**
   * Updates the given table with a new data schema and table properties, and keep everything else
   * unchanged.
   * <p>
   * TODO(cloud-fan): it's a little hacky to introduce the schema table properties here in
   * <code>HiveClient</code>, but we don't have a cleaner solution now.
   * @param dbName (undocumented)
   * @param tableName (undocumented)
   * @param newDataSchema (undocumented)
   * @param schemaProps (undocumented)
   */
  public  void alterTableDataSchema (java.lang.String dbName, java.lang.String tableName, org.apache.spark.sql.types.StructType newDataSchema, scala.collection.immutable.Map<java.lang.String, java.lang.String> schemaProps)  ;
  /** Creates a new database with the given name. */
  public  void createDatabase (org.apache.spark.sql.catalyst.catalog.CatalogDatabase database, boolean ignoreIfExists)  ;
  /** Create a function in an existing database. */
  public  void createFunction (java.lang.String db, org.apache.spark.sql.catalyst.catalog.CatalogFunction func)  ;
  /**
   * Create one or many partitions in the given table.
   * @param db (undocumented)
   * @param table (undocumented)
   * @param parts (undocumented)
   * @param ignoreIfExists (undocumented)
   */
  public  void createPartitions (java.lang.String db, java.lang.String table, scala.collection.Seq<org.apache.spark.sql.catalyst.catalog.CatalogTablePartition> parts, boolean ignoreIfExists)  ;
  /** Creates a table with the given metadata. */
  public  void createTable (org.apache.spark.sql.catalyst.catalog.CatalogTable table, boolean ignoreIfExists)  ;
  /** Return whether a table/view with the specified name exists. */
  public  boolean databaseExists (java.lang.String dbName)  ;
  /**
   * Drop the specified database, if it exists.
   * <p>
   * @param name database to drop
   * @param ignoreIfNotExists if true, do not throw error if the database does not exist
   * @param cascade whether to remove all associated objects such as tables and functions
   */
  public  void dropDatabase (java.lang.String name, boolean ignoreIfNotExists, boolean cascade)  ;
  /** Drop an existing function in the database. */
  public  void dropFunction (java.lang.String db, java.lang.String name)  ;
  /**
   * Drop one or many partitions in the given table, assuming they exist.
   * @param db (undocumented)
   * @param table (undocumented)
   * @param specs (undocumented)
   * @param ignoreIfNotExists (undocumented)
   * @param purge (undocumented)
   * @param retainData (undocumented)
   */
  public  void dropPartitions (java.lang.String db, java.lang.String table, scala.collection.Seq<scala.collection.immutable.Map<java.lang.String, java.lang.String>> specs, boolean ignoreIfNotExists, boolean purge, boolean retainData)  ;
  /** Drop the specified table. */
  public  void dropTable (java.lang.String dbName, java.lang.String tableName, boolean ignoreIfNotExists, boolean purge)  ;
  /** Return whether a function exists in the specified database. */
  public  boolean functionExists (java.lang.String db, java.lang.String name)  ;
  /** Returns the configuration for the given key in the current session. */
  public  java.lang.String getConf (java.lang.String key, java.lang.String defaultValue)  ;
  /** Returns the metadata for specified database, throwing an exception if it doesn't exist */
  public  org.apache.spark.sql.catalyst.catalog.CatalogDatabase getDatabase (java.lang.String name)  ;
  /** Return an existing function in the database, assuming it exists. */
  public  org.apache.spark.sql.catalyst.catalog.CatalogFunction getFunction (java.lang.String db, java.lang.String name)  ;
  /** Return an existing function in the database, or None if it doesn't exist. */
  public  scala.Option<org.apache.spark.sql.catalyst.catalog.CatalogFunction> getFunctionOption (java.lang.String db, java.lang.String name)  ;
  /** Returns the specified partition, or throws `NoSuchPartitionException`. */
  public  org.apache.spark.sql.catalyst.catalog.CatalogTablePartition getPartition (java.lang.String dbName, java.lang.String tableName, scala.collection.immutable.Map<java.lang.String, java.lang.String> spec)  ;
  /**
   * Returns the partition names for the given table that match the supplied partition spec.
   * If no partition spec is specified, all partitions are returned.
   * <p>
   * The returned sequence is sorted as strings.
   * @param table (undocumented)
   * @param partialSpec (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<java.lang.String> getPartitionNames (org.apache.spark.sql.catalyst.catalog.CatalogTable table, scala.Option<scala.collection.immutable.Map<java.lang.String, java.lang.String>> partialSpec)  ;
  /** Returns the specified partition or None if it does not exist. */
  public  scala.Option<org.apache.spark.sql.catalyst.catalog.CatalogTablePartition> getPartitionOption (java.lang.String db, java.lang.String table, scala.collection.immutable.Map<java.lang.String, java.lang.String> spec)  ;
  /** Returns the specified partition or None if it does not exist. */
  public  scala.Option<org.apache.spark.sql.catalyst.catalog.CatalogTablePartition> getPartitionOption (org.apache.spark.sql.catalyst.catalog.CatalogTable table, scala.collection.immutable.Map<java.lang.String, java.lang.String> spec)  ;
  /**
   * Returns the partitions for the given table that match the supplied partition spec.
   * If no partition spec is specified, all partitions are returned.
   * @param db (undocumented)
   * @param table (undocumented)
   * @param partialSpec (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.catalog.CatalogTablePartition> getPartitions (java.lang.String db, java.lang.String table, scala.Option<scala.collection.immutable.Map<java.lang.String, java.lang.String>> partialSpec)  ;
  /**
   * Returns the partitions for the given table that match the supplied partition spec.
   * If no partition spec is specified, all partitions are returned.
   * @param catalogTable (undocumented)
   * @param partialSpec (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.catalog.CatalogTablePartition> getPartitions (org.apache.spark.sql.catalyst.catalog.CatalogTable catalogTable, scala.Option<scala.collection.immutable.Map<java.lang.String, java.lang.String>> partialSpec)  ;
  /** Returns partitions filtered by predicates for the given table. */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.catalog.CatalogTablePartition> getPartitionsByFilter (org.apache.spark.sql.catalyst.catalog.CatalogTable catalogTable, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> predicates, java.lang.String timeZoneId)  ;
  /**
   * Return the associated Hive SessionState of this {@link HiveClientImpl}
   * @return <code>Any</code> not SessionState to avoid linkage error
   */
  public  Object getState ()  ;
  /** Returns the specified table, or throws `NoSuchTableException`. */
  public  org.apache.spark.sql.catalyst.catalog.CatalogTable getTable (java.lang.String dbName, java.lang.String tableName)  ;
  /** Returns the metadata for the specified table or None if it doesn't exist. */
  public  scala.Option<org.apache.spark.sql.catalyst.catalog.CatalogTable> getTableOption (java.lang.String dbName, java.lang.String tableName)  ;
  /** Returns metadata of existing permanent tables/views for given names. */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.catalog.CatalogTable> getTablesByName (java.lang.String dbName, scala.collection.Seq<java.lang.String> tableNames)  ;
  /** List the names of all the databases that match the specified pattern. */
  public  scala.collection.Seq<java.lang.String> listDatabases (java.lang.String pattern)  ;
  /** Return the names of all functions that match the given pattern in the database. */
  public  scala.collection.Seq<java.lang.String> listFunctions (java.lang.String db, java.lang.String pattern)  ;
  /** Returns the names of all tables in the given database. */
  public  scala.collection.Seq<java.lang.String> listTables (java.lang.String dbName)  ;
  /** Returns the names of tables in the given database that matches the given pattern. */
  public  scala.collection.Seq<java.lang.String> listTables (java.lang.String dbName, java.lang.String pattern)  ;
  /**
   * Returns the names of tables with specific tableType in the given database that matches
   * the given pattern.
   * @param dbName (undocumented)
   * @param pattern (undocumented)
   * @param tableType (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<java.lang.String> listTablesByType (java.lang.String dbName, java.lang.String pattern, org.apache.spark.sql.catalyst.catalog.CatalogTableType tableType)  ;
  /** Loads new dynamic partitions into an existing table. */
  public  void loadDynamicPartitions (java.lang.String loadPath, java.lang.String dbName, java.lang.String tableName, java.util.LinkedHashMap<java.lang.String, java.lang.String> partSpec, boolean replace, int numDP)  ;
  /** Loads a static partition into an existing table. */
  public  void loadPartition (java.lang.String loadPath, java.lang.String dbName, java.lang.String tableName, java.util.LinkedHashMap<java.lang.String, java.lang.String> partSpec, boolean replace, boolean inheritTableSpecs, boolean isSrcLocal)  ;
  /** Loads data into an existing table. */
  public  void loadTable (java.lang.String loadPath, java.lang.String tableName, boolean replace, boolean isSrcLocal)  ;
  /** Return a {@link HiveClient} as new session, that will share the class loader and Hive client */
  public  org.apache.spark.sql.hive.client.HiveClient newSession ()  ;
  /** Rename an existing function in the database. */
  public  void renameFunction (java.lang.String db, java.lang.String oldName, java.lang.String newName)  ;
  /**
   * Rename one or many existing table partitions, assuming they exist.
   * @param db (undocumented)
   * @param table (undocumented)
   * @param specs (undocumented)
   * @param newSpecs (undocumented)
   */
  public  void renamePartitions (java.lang.String db, java.lang.String table, scala.collection.Seq<scala.collection.immutable.Map<java.lang.String, java.lang.String>> specs, scala.collection.Seq<scala.collection.immutable.Map<java.lang.String, java.lang.String>> newSpecs)  ;
  /** Used for testing only.  Removes all metadata from this instance of Hive. */
  public  void reset ()  ;
  /**
   * Runs a HiveQL command using Hive, returning the results as a list of strings.  Each row will
   * result in one string.
   * @param sql (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<java.lang.String> runSqlHive (java.lang.String sql)  ;
  /** Sets the name of current database. */
  public  void setCurrentDatabase (java.lang.String databaseName)  ;
  public  void setError (java.io.PrintStream stream)  ;
  public  void setInfo (java.io.PrintStream stream)  ;
  public  void setOut (java.io.PrintStream stream)  ;
  /** Return whether a table/view with the specified name exists. */
  public  boolean tableExists (java.lang.String dbName, java.lang.String tableName)  ;
  /** Returns the user name which is used as owner for Hive table. */
  public  java.lang.String userName ()  ;
  /** Returns the Hive Version of this client. */
  public  org.apache.spark.sql.hive.client.HiveVersion version ()  ;
  /** Run a function within Hive state (SessionState, HiveConf, Hive client and class loader) */
  public <A extends java.lang.Object> A withHiveState (scala.Function0<A> f)  ;
}
