package org.apache.spark.sql.internal;
/**
 * Internal implementation of the user-facing <code>Catalog</code>.
 */
public  class CatalogImpl extends org.apache.spark.sql.catalog.Catalog {
  static public <T extends org.apache.spark.sql.catalyst.DefinedByConstructorParams> org.apache.spark.sql.Dataset<T> makeDataset (scala.collection.Seq<T> data, org.apache.spark.sql.SparkSession sparkSession, scala.reflect.api.TypeTags.TypeTag<T> evidence$1)  { throw new RuntimeException(); }
  public   CatalogImpl (org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
  /**
   * Returns the current default database in this session.
   * @return (undocumented)
   */
  public  java.lang.String currentDatabase ()  { throw new RuntimeException(); }
  /**
   * Sets the current default database in this session.
   * @param dbName (undocumented)
   */
  public  void setCurrentDatabase (java.lang.String dbName) throws org.apache.spark.sql.AnalysisException { throw new RuntimeException(); }
  /**
   * Returns a list of databases available across all sessions.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.catalog.Database> listDatabases ()  { throw new RuntimeException(); }
  /**
   * Returns a list of tables in the current database.
   * This includes all temporary tables.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.catalog.Table> listTables ()  { throw new RuntimeException(); }
  /**
   * Returns a list of tables in the specified database.
   * This includes all temporary tables.
   * @param dbName (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.catalog.Table> listTables (java.lang.String dbName) throws org.apache.spark.sql.AnalysisException { throw new RuntimeException(); }
  /**
   * Returns a list of functions registered in the current database.
   * This includes all temporary functions
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.catalog.Function> listFunctions ()  { throw new RuntimeException(); }
  /**
   * Returns a list of functions registered in the specified database.
   * This includes all temporary functions
   * @param dbName (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.catalog.Function> listFunctions (java.lang.String dbName) throws org.apache.spark.sql.AnalysisException { throw new RuntimeException(); }
  /**
   * Returns a list of columns for the given table/view or temporary view.
   * @param tableName (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.catalog.Column> listColumns (java.lang.String tableName) throws org.apache.spark.sql.AnalysisException { throw new RuntimeException(); }
  /**
   * Returns a list of columns for the given table/view or temporary view in the specified database.
   * @param dbName (undocumented)
   * @param tableName (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.catalog.Column> listColumns (java.lang.String dbName, java.lang.String tableName) throws org.apache.spark.sql.AnalysisException { throw new RuntimeException(); }
  /**
   * Gets the database with the specified name. This throws an <code>AnalysisException</code> when no
   * <code>Database</code> can be found.
   * @param dbName (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalog.Database getDatabase (java.lang.String dbName)  { throw new RuntimeException(); }
  /**
   * Gets the table or view with the specified name. This table can be a temporary view or a
   * table/view. This throws an <code>AnalysisException</code> when no <code>Table</code> can be found.
   * @param tableName (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalog.Table getTable (java.lang.String tableName)  { throw new RuntimeException(); }
  /**
   * Gets the table or view with the specified name in the specified database. This throws an
   * <code>AnalysisException</code> when no <code>Table</code> can be found.
   * @param dbName (undocumented)
   * @param tableName (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalog.Table getTable (java.lang.String dbName, java.lang.String tableName)  { throw new RuntimeException(); }
  /**
   * Gets the function with the specified name. This function can be a temporary function or a
   * function. This throws an <code>AnalysisException</code> when no <code>Function</code> can be found.
   * @param functionName (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalog.Function getFunction (java.lang.String functionName)  { throw new RuntimeException(); }
  /**
   * Gets the function with the specified name. This returns <code>None</code> when no <code>Function</code> can be
   * found.
   * @param dbName (undocumented)
   * @param functionName (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalog.Function getFunction (java.lang.String dbName, java.lang.String functionName)  { throw new RuntimeException(); }
  /**
   * Checks if the database with the specified name exists.
   * @param dbName (undocumented)
   * @return (undocumented)
   */
  public  boolean databaseExists (java.lang.String dbName)  { throw new RuntimeException(); }
  /**
   * Checks if the table or view with the specified name exists. This can either be a temporary
   * view or a table/view.
   * @param tableName (undocumented)
   * @return (undocumented)
   */
  public  boolean tableExists (java.lang.String tableName)  { throw new RuntimeException(); }
  /**
   * Checks if the table or view with the specified name exists in the specified database.
   * @param dbName (undocumented)
   * @param tableName (undocumented)
   * @return (undocumented)
   */
  public  boolean tableExists (java.lang.String dbName, java.lang.String tableName)  { throw new RuntimeException(); }
  /**
   * Checks if the function with the specified name exists. This can either be a temporary function
   * or a function.
   * @param functionName (undocumented)
   * @return (undocumented)
   */
  public  boolean functionExists (java.lang.String functionName)  { throw new RuntimeException(); }
  /**
   * Checks if the function with the specified name exists in the specified database.
   * @param dbName (undocumented)
   * @param functionName (undocumented)
   * @return (undocumented)
   */
  public  boolean functionExists (java.lang.String dbName, java.lang.String functionName)  { throw new RuntimeException(); }
  /**
   * Creates a table from the given path and returns the corresponding DataFrame.
   * It will use the default data source configured by spark.sql.sources.default.
   * <p>
   * @group ddl_ops
   * @since 2.2.0
   * @param tableName (undocumented)
   * @param path (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> createTable (java.lang.String tableName, java.lang.String path)  { throw new RuntimeException(); }
  /**
   * Creates a table from the given path and returns the corresponding
   * DataFrame.
   * <p>
   * @group ddl_ops
   * @since 2.2.0
   * @param tableName (undocumented)
   * @param path (undocumented)
   * @param source (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> createTable (java.lang.String tableName, java.lang.String path, java.lang.String source)  { throw new RuntimeException(); }
  /**
   * (Scala-specific)
   * Creates a table based on the dataset in a data source and a set of options.
   * Then, returns the corresponding DataFrame.
   * <p>
   * @group ddl_ops
   * @since 2.2.0
   * @param tableName (undocumented)
   * @param source (undocumented)
   * @param options (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> createTable (java.lang.String tableName, java.lang.String source, scala.collection.immutable.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  /**
   * (Scala-specific)
   * Creates a table based on the dataset in a data source and a set of options.
   * Then, returns the corresponding DataFrame.
   * <p>
   * @group ddl_ops
   * @since 3.1.0
   * @param tableName (undocumented)
   * @param source (undocumented)
   * @param description (undocumented)
   * @param options (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> createTable (java.lang.String tableName, java.lang.String source, java.lang.String description, scala.collection.immutable.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  /**
   * (Scala-specific)
   * Creates a table based on the dataset in a data source, a schema and a set of options.
   * Then, returns the corresponding DataFrame.
   * <p>
   * @group ddl_ops
   * @since 2.2.0
   * @param tableName (undocumented)
   * @param source (undocumented)
   * @param schema (undocumented)
   * @param options (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> createTable (java.lang.String tableName, java.lang.String source, org.apache.spark.sql.types.StructType schema, scala.collection.immutable.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  /**
   * (Scala-specific)
   * Creates a table based on the dataset in a data source, a schema and a set of options.
   * Then, returns the corresponding DataFrame.
   * <p>
   * @group ddl_ops
   * @since 3.1.0
   * @param tableName (undocumented)
   * @param source (undocumented)
   * @param schema (undocumented)
   * @param description (undocumented)
   * @param options (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> createTable (java.lang.String tableName, java.lang.String source, org.apache.spark.sql.types.StructType schema, java.lang.String description, scala.collection.immutable.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  /**
   * Drops the local temporary view with the given view name in the catalog.
   * If the view has been cached/persisted before, it's also unpersisted.
   * <p>
   * @param viewName the identifier of the temporary view to be dropped.
   * @group ddl_ops
   * @since 2.0.0
   * @return (undocumented)
   */
  public  boolean dropTempView (java.lang.String viewName)  { throw new RuntimeException(); }
  /**
   * Drops the global temporary view with the given view name in the catalog.
   * If the view has been cached/persisted before, it's also unpersisted.
   * <p>
   * @param viewName the identifier of the global temporary view to be dropped.
   * @group ddl_ops
   * @since 2.1.0
   * @return (undocumented)
   */
  public  boolean dropGlobalTempView (java.lang.String viewName)  { throw new RuntimeException(); }
  /**
   * Recovers all the partitions in the directory of a table and update the catalog.
   * Only works with a partitioned table, and not a temporary view.
   * <p>
   * @param tableName is either a qualified or unqualified name that designates a table.
   *                  If no database identifier is provided, it refers to a table in the
   *                  current database.
   * @group ddl_ops
   * @since 2.1.1
   */
  public  void recoverPartitions (java.lang.String tableName)  { throw new RuntimeException(); }
  /**
   * Returns true if the table or view is currently cached in-memory.
   * <p>
   * @group cachemgmt
   * @since 2.0.0
   * @param tableName (undocumented)
   * @return (undocumented)
   */
  public  boolean isCached (java.lang.String tableName)  { throw new RuntimeException(); }
  /**
   * Caches the specified table or view in-memory.
   * <p>
   * @group cachemgmt
   * @since 2.0.0
   * @param tableName (undocumented)
   */
  public  void cacheTable (java.lang.String tableName)  { throw new RuntimeException(); }
  /**
   * Caches the specified table or view with the given storage level.
   * <p>
   * @group cachemgmt
   * @since 2.3.0
   * @param tableName (undocumented)
   * @param storageLevel (undocumented)
   */
  public  void cacheTable (java.lang.String tableName, org.apache.spark.storage.StorageLevel storageLevel)  { throw new RuntimeException(); }
  /**
   * Removes the specified table or view from the in-memory cache.
   * <p>
   * @group cachemgmt
   * @since 2.0.0
   * @param tableName (undocumented)
   */
  public  void uncacheTable (java.lang.String tableName)  { throw new RuntimeException(); }
  /**
   * Removes all cached tables or views from the in-memory cache.
   * <p>
   * @group cachemgmt
   * @since 2.0.0
   */
  public  void clearCache ()  { throw new RuntimeException(); }
  /**
   * Returns true if the {@link Dataset} is currently cached in-memory.
   * <p>
   * @group cachemgmt
   * @since 2.0.0
   * @param qName (undocumented)
   * @return (undocumented)
   */
  protected  boolean isCached (org.apache.spark.sql.Dataset<?> qName)  { throw new RuntimeException(); }
  /**
   * The method fully refreshes a table or view with the given name including:
   *   1. The relation cache in the session catalog. The method removes table entry from the cache.
   *   2. The file indexes of all relations used by the given view.
   *   3. Table/View schema in the Hive Metastore if the SQL config
   *      <code>spark.sql.hive.caseSensitiveInferenceMode</code> is set to <code>INFER_AND_SAVE</code>.
   *   4. Cached data of the given table or view, and all its dependents that refer to it.
   *      Existing cached data will be cleared and the cache will be lazily filled when
   *      the next time the table/view or the dependents are accessed.
   * <p>
   * The method does not do:
   *   - schema inference for file source tables
   *   - statistics update
   * <p>
   * The method is supposed to be used in all cases when need to refresh table/view data
   * and meta-data.
   * <p>
   * @group cachemgmt
   * @since 2.0.0
   * @param tableName (undocumented)
   */
  public  void refreshTable (java.lang.String tableName)  { throw new RuntimeException(); }
  /**
   * Refreshes the cache entry and the associated metadata for all Dataset (if any), that contain
   * the given data source path. Path matching is by prefix, i.e. "/" would invalidate
   * everything that is cached.
   * <p>
   * @group cachemgmt
   * @since 2.0.0
   * @param resourcePath (undocumented)
   */
  public  void refreshByPath (java.lang.String resourcePath)  { throw new RuntimeException(); }
}
