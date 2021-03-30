package org.apache.spark.sql.catalyst.catalog;
public  class SessionCatalog implements org.apache.spark.sql.catalyst.SQLConfHelper, org.apache.spark.internal.Logging {
  // not preceding
  static public  java.lang.String DEFAULT_DATABASE ()  { throw new RuntimeException(); }
  public   SessionCatalog (scala.Function0<org.apache.spark.sql.catalyst.catalog.ExternalCatalog> externalCatalogBuilder, scala.Function0<org.apache.spark.sql.catalyst.catalog.GlobalTempViewManager> globalTempViewManagerBuilder, org.apache.spark.sql.catalyst.analysis.FunctionRegistry functionRegistry, org.apache.hadoop.conf.Configuration hadoopConf, org.apache.spark.sql.catalyst.parser.ParserInterface parser, org.apache.spark.sql.catalyst.catalog.FunctionResourceLoader functionResourceLoader, int cacheSize, long cacheTTL)  { throw new RuntimeException(); }
  public   SessionCatalog (org.apache.spark.sql.catalyst.catalog.ExternalCatalog externalCatalog, org.apache.spark.sql.catalyst.analysis.FunctionRegistry functionRegistry, org.apache.spark.sql.internal.SQLConf conf)  { throw new RuntimeException(); }
  public   SessionCatalog (org.apache.spark.sql.catalyst.catalog.ExternalCatalog externalCatalog, org.apache.spark.sql.catalyst.analysis.FunctionRegistry functionRegistry)  { throw new RuntimeException(); }
  public   SessionCatalog (org.apache.spark.sql.catalyst.catalog.ExternalCatalog externalCatalog)  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.catalyst.catalog.ExternalCatalog externalCatalog ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.catalyst.catalog.GlobalTempViewManager globalTempViewManager ()  { throw new RuntimeException(); }
  /** List of temporary views, mapping from table name to their logical plan. */
  protected  scala.collection.mutable.HashMap<java.lang.String, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> tempViews ()  { throw new RuntimeException(); }
  protected  java.lang.String currentDb ()  { throw new RuntimeException(); }
  /**
   * Format table name, taking into account case sensitivity.
   * @param name (undocumented)
   * @return (undocumented)
   */
  protected  java.lang.String formatTableName (java.lang.String name)  { throw new RuntimeException(); }
  /**
   * Format database name, taking into account case sensitivity.
   * @param name (undocumented)
   * @return (undocumented)
   */
  protected  java.lang.String formatDatabaseName (java.lang.String name)  { throw new RuntimeException(); }
  /** This method provides a way to get a cached plan. */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan getCachedPlan (org.apache.spark.sql.catalyst.QualifiedTableName t, java.util.concurrent.Callable<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> c)  { throw new RuntimeException(); }
  /** This method provides a way to get a cached plan if the key exists. */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan getCachedTable (org.apache.spark.sql.catalyst.QualifiedTableName key)  { throw new RuntimeException(); }
  /** This method provides a way to cache a plan. */
  public  void cacheTable (org.apache.spark.sql.catalyst.QualifiedTableName t, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan l)  { throw new RuntimeException(); }
  /** This method provides a way to invalidate a cached plan. */
  public  void invalidateCachedTable (org.apache.spark.sql.catalyst.QualifiedTableName key)  { throw new RuntimeException(); }
  /** This method discards any cached table relation plans for the given table identifier. */
  public  void invalidateCachedTable (org.apache.spark.sql.catalyst.TableIdentifier name)  { throw new RuntimeException(); }
  /** This method provides a way to invalidate all the cached plans. */
  public  void invalidateAllCachedTables ()  { throw new RuntimeException(); }
  public  void createDatabase (org.apache.spark.sql.catalyst.catalog.CatalogDatabase dbDefinition, boolean ignoreIfExists)  { throw new RuntimeException(); }
  public  void dropDatabase (java.lang.String db, boolean ignoreIfNotExists, boolean cascade)  { throw new RuntimeException(); }
  public  void alterDatabase (org.apache.spark.sql.catalyst.catalog.CatalogDatabase dbDefinition)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.catalog.CatalogDatabase getDatabaseMetadata (java.lang.String db)  { throw new RuntimeException(); }
  public  boolean databaseExists (java.lang.String db)  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> listDatabases ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> listDatabases (java.lang.String pattern)  { throw new RuntimeException(); }
  public  java.lang.String getCurrentDatabase ()  { throw new RuntimeException(); }
  public  void setCurrentDatabase (java.lang.String db)  { throw new RuntimeException(); }
  /**
   * Get the path for creating a non-default database when database location is not provided
   * by users.
   * @param db (undocumented)
   * @return (undocumented)
   */
  public  java.net.URI getDefaultDBPath (java.lang.String db)  { throw new RuntimeException(); }
  /**
   * Create a metastore table in the database specified in <code>tableDefinition</code>.
   * If no such database is specified, create it in the current database.
   * @param tableDefinition (undocumented)
   * @param ignoreIfExists (undocumented)
   * @param validateLocation (undocumented)
   */
  public  void createTable (org.apache.spark.sql.catalyst.catalog.CatalogTable tableDefinition, boolean ignoreIfExists, boolean validateLocation)  { throw new RuntimeException(); }
  public  void validateTableLocation (org.apache.spark.sql.catalyst.catalog.CatalogTable table)  { throw new RuntimeException(); }
  /**
   * Alter the metadata of an existing metastore table identified by <code>tableDefinition</code>.
   * <p>
   * If no database is specified in <code>tableDefinition</code>, assume the table is in the
   * current database.
   * <p>
   * Note: If the underlying implementation does not support altering a certain field,
   * this becomes a no-op.
   * @param tableDefinition (undocumented)
   */
  public  void alterTable (org.apache.spark.sql.catalyst.catalog.CatalogTable tableDefinition)  { throw new RuntimeException(); }
  /**
   * Alter the data schema of a table identified by the provided table identifier. The new data
   * schema should not have conflict column names with the existing partition columns, and should
   * still contain all the existing data columns.
   * <p>
   * @param identifier TableIdentifier
   * @param newDataSchema Updated data schema to be used for the table
   */
  public  void alterTableDataSchema (org.apache.spark.sql.catalyst.TableIdentifier identifier, org.apache.spark.sql.types.StructType newDataSchema)  { throw new RuntimeException(); }
  /**
   * Alter Spark's statistics of an existing metastore table identified by the provided table
   * identifier.
   * @param identifier (undocumented)
   * @param newStats (undocumented)
   */
  public  void alterTableStats (org.apache.spark.sql.catalyst.TableIdentifier identifier, scala.Option<org.apache.spark.sql.catalyst.catalog.CatalogStatistics> newStats)  { throw new RuntimeException(); }
  /**
   * Return whether a table/view with the specified name exists. If no database is specified, check
   * with current database.
   * @param name (undocumented)
   * @return (undocumented)
   */
  public  boolean tableExists (org.apache.spark.sql.catalyst.TableIdentifier name)  { throw new RuntimeException(); }
  /**
   * Retrieve the metadata of an existing permanent table/view. If no database is specified,
   * assume the table/view is in the current database.
   * We replace char/varchar with "annotated" string type in the table schema, as the query
   * engine doesn't support char/varchar yet.
   * @param name (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.catalog.CatalogTable getTableMetadata (org.apache.spark.sql.catalyst.TableIdentifier name) throws org.apache.spark.sql.catalyst.analysis.NoSuchDatabaseException, org.apache.spark.sql.catalyst.analysis.NoSuchTableException { throw new RuntimeException(); }
  /**
   * Retrieve the metadata of an existing permanent table/view. If no database is specified,
   * assume the table/view is in the current database.
   * @param name (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.catalog.CatalogTable getTableRawMetadata (org.apache.spark.sql.catalyst.TableIdentifier name) throws org.apache.spark.sql.catalyst.analysis.NoSuchDatabaseException, org.apache.spark.sql.catalyst.analysis.NoSuchTableException { throw new RuntimeException(); }
  /**
   * Retrieve all metadata of existing permanent tables/views. If no database is specified,
   * assume the table/view is in the current database.
   * Only the tables/views belong to the same database that can be retrieved are returned.
   * For example, if none of the requested tables could be retrieved, an empty list is returned.
   * There is no guarantee of ordering of the returned tables.
   * @param names (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.catalog.CatalogTable> getTablesByName (scala.collection.Seq<org.apache.spark.sql.catalyst.TableIdentifier> names) throws org.apache.spark.sql.catalyst.analysis.NoSuchDatabaseException { throw new RuntimeException(); }
  /**
   * Load files stored in given path into an existing metastore table.
   * If no database is specified, assume the table is in the current database.
   * If the specified table is not found in the database then a {@link NoSuchTableException} is thrown.
   * @param name (undocumented)
   * @param loadPath (undocumented)
   * @param isOverwrite (undocumented)
   * @param isSrcLocal (undocumented)
   */
  public  void loadTable (org.apache.spark.sql.catalyst.TableIdentifier name, java.lang.String loadPath, boolean isOverwrite, boolean isSrcLocal)  { throw new RuntimeException(); }
  /**
   * Load files stored in given path into the partition of an existing metastore table.
   * If no database is specified, assume the table is in the current database.
   * If the specified table is not found in the database then a {@link NoSuchTableException} is thrown.
   * @param name (undocumented)
   * @param loadPath (undocumented)
   * @param spec (undocumented)
   * @param isOverwrite (undocumented)
   * @param inheritTableSpecs (undocumented)
   * @param isSrcLocal (undocumented)
   */
  public  void loadPartition (org.apache.spark.sql.catalyst.TableIdentifier name, java.lang.String loadPath, scala.collection.immutable.Map<java.lang.String, java.lang.String> spec, boolean isOverwrite, boolean inheritTableSpecs, boolean isSrcLocal)  { throw new RuntimeException(); }
  public  java.net.URI defaultTablePath (org.apache.spark.sql.catalyst.TableIdentifier tableIdent)  { throw new RuntimeException(); }
  /**
   * Create a local temporary view.
   * @param name (undocumented)
   * @param tableDefinition (undocumented)
   * @param overrideIfExists (undocumented)
   */
  public  void createTempView (java.lang.String name, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan tableDefinition, boolean overrideIfExists)  { throw new RuntimeException(); }
  /**
   * Create a global temporary view.
   * @param name (undocumented)
   * @param viewDefinition (undocumented)
   * @param overrideIfExists (undocumented)
   */
  public  void createGlobalTempView (java.lang.String name, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan viewDefinition, boolean overrideIfExists)  { throw new RuntimeException(); }
  /**
   * Alter the definition of a local/global temp view matching the given name, returns true if a
   * temp view is matched and altered, false otherwise.
   * @param name (undocumented)
   * @param viewDefinition (undocumented)
   * @return (undocumented)
   */
  public  boolean alterTempViewDefinition (org.apache.spark.sql.catalyst.TableIdentifier name, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan viewDefinition)  { throw new RuntimeException(); }
  /**
   * Return a local temporary view exactly as it was stored.
   * @param name (undocumented)
   * @return (undocumented)
   */
  public  scala.Option<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> getRawTempView (java.lang.String name)  { throw new RuntimeException(); }
  /**
   * Generate a {@link View} operator from the temporary view stored.
   * @param name (undocumented)
   * @return (undocumented)
   */
  public  scala.Option<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> getTempView (java.lang.String name)  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> getTempViewNames ()  { throw new RuntimeException(); }
  /**
   * Return a global temporary view exactly as it was stored.
   * @param name (undocumented)
   * @return (undocumented)
   */
  public  scala.Option<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> getRawGlobalTempView (java.lang.String name)  { throw new RuntimeException(); }
  /**
   * Generate a {@link View} operator from the global temporary view stored.
   * @param name (undocumented)
   * @return (undocumented)
   */
  public  scala.Option<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> getGlobalTempView (java.lang.String name)  { throw new RuntimeException(); }
  /**
   * Drop a local temporary view.
   * <p>
   * Returns true if this view is dropped successfully, false otherwise.
   * @param name (undocumented)
   * @return (undocumented)
   */
  public  boolean dropTempView (java.lang.String name)  { throw new RuntimeException(); }
  /**
   * Drop a global temporary view.
   * <p>
   * Returns true if this view is dropped successfully, false otherwise.
   * @param name (undocumented)
   * @return (undocumented)
   */
  public  boolean dropGlobalTempView (java.lang.String name)  { throw new RuntimeException(); }
  /**
   * Retrieve the metadata of an existing temporary view or permanent table/view.
   * <p>
   * If a database is specified in <code>name</code>, this will return the metadata of table/view in that
   * database.
   * If no database is specified, this will first attempt to get the metadata of a temporary view
   * with the same name, then, if that does not exist, return the metadata of table/view in the
   * current database.
   * @param name (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.catalog.CatalogTable getTempViewOrPermanentTableMetadata (org.apache.spark.sql.catalyst.TableIdentifier name)  { throw new RuntimeException(); }
  /**
   * Rename a table.
   * <p>
   * If a database is specified in <code>oldName</code>, this will rename the table in that database.
   * If no database is specified, this will first attempt to rename a temporary view with
   * the same name, then, if that does not exist, rename the table in the current database.
   * <p>
   * This assumes the database specified in <code>newName</code> matches the one in <code>oldName</code>.
   * @param oldName (undocumented)
   * @param newName (undocumented)
   */
  public  void renameTable (org.apache.spark.sql.catalyst.TableIdentifier oldName, org.apache.spark.sql.catalyst.TableIdentifier newName)  { throw new RuntimeException(); }
  /**
   * Drop a table.
   * <p>
   * If a database is specified in <code>name</code>, this will drop the table from that database.
   * If no database is specified, this will first attempt to drop a temporary view with
   * the same name, then, if that does not exist, drop the table from the current database.
   * @param name (undocumented)
   * @param ignoreIfNotExists (undocumented)
   * @param purge (undocumented)
   */
  public  void dropTable (org.apache.spark.sql.catalyst.TableIdentifier name, boolean ignoreIfNotExists, boolean purge)  { throw new RuntimeException(); }
  /**
   * Return a {@link LogicalPlan} that represents the given table or view.
   * <p>
   * If a database is specified in <code>name</code>, this will return the table/view from that database.
   * If no database is specified, this will first attempt to return a temporary view with
   * the same name, then, if that does not exist, return the table/view from the current database.
   * <p>
   * Note that, the global temp view database is also valid here, this will return the global temp
   * view matching the given name.
   * <p>
   * If the relation is a view, we generate a {@link View} operator from the view description, and
   * wrap the logical plan in a {@link SubqueryAlias} which will track the name of the view.
   * {@link SubqueryAlias} will also keep track of the name and database(optional) of the table/view
   * <p>
   * @param name The name of the table/view that we look up.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan lookupRelation (org.apache.spark.sql.catalyst.TableIdentifier name)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan getRelation (org.apache.spark.sql.catalyst.catalog.CatalogTable metadata, org.apache.spark.sql.util.CaseInsensitiveStringMap options)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType getTempViewSchema (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.plans.logical.SubqueryAlias> lookupTempView (java.lang.String table)  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.plans.logical.SubqueryAlias> lookupGlobalTempView (java.lang.String db, java.lang.String table)  { throw new RuntimeException(); }
  /**
   * Return whether the given name parts belong to a temporary or global temporary view.
   * @param nameParts (undocumented)
   * @return (undocumented)
   */
  public  boolean isTempView (scala.collection.Seq<java.lang.String> nameParts)  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> lookupTempView (org.apache.spark.sql.catalyst.TableIdentifier name)  { throw new RuntimeException(); }
  /**
   * Return whether a table with the specified name is a temporary view.
   * <p>
   * Note: The temporary view cache is checked only when database is not
   * explicitly specified.
   * @param name (undocumented)
   * @return (undocumented)
   */
  public  boolean isTempView (org.apache.spark.sql.catalyst.TableIdentifier name)  { throw new RuntimeException(); }
  public  boolean isView (scala.collection.Seq<java.lang.String> nameParts)  { throw new RuntimeException(); }
  /**
   * List all tables in the specified database, including local temporary views.
   * <p>
   * Note that, if the specified database is global temporary view database, we will list global
   * temporary views.
   * @param db (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.TableIdentifier> listTables (java.lang.String db)  { throw new RuntimeException(); }
  /**
   * List all matching tables in the specified database, including local temporary views.
   * <p>
   * Note that, if the specified database is global temporary view database, we will list global
   * temporary views.
   * @param db (undocumented)
   * @param pattern (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.TableIdentifier> listTables (java.lang.String db, java.lang.String pattern)  { throw new RuntimeException(); }
  /**
   * List all matching tables in the specified database, including local temporary views
   * if includeLocalTempViews is enabled.
   * <p>
   * Note that, if the specified database is global temporary view database, we will list global
   * temporary views.
   * @param db (undocumented)
   * @param pattern (undocumented)
   * @param includeLocalTempViews (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.TableIdentifier> listTables (java.lang.String db, java.lang.String pattern, boolean includeLocalTempViews)  { throw new RuntimeException(); }
  /**
   * List all matching views in the specified database, including local temporary views.
   * @param db (undocumented)
   * @param pattern (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.TableIdentifier> listViews (java.lang.String db, java.lang.String pattern)  { throw new RuntimeException(); }
  /**
   * List all matching local temporary views.
   * @param pattern (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.TableIdentifier> listLocalTempViews (java.lang.String pattern)  { throw new RuntimeException(); }
  /**
   * Refresh table entries in structures maintained by the session catalog such as:
   *   - The map of temporary or global temporary view names to their logical plans
   *   - The relation cache which maps table identifiers to their logical plans
   * <p>
   * For temp views, it refreshes their logical plans, and as a consequence of that it can refresh
   * the file indexes of the base relations (<code>HadoopFsRelation</code> for instance) used in the views.
   * The method still keeps the views in the internal lists of session catalog.
   * <p>
   * For tables/views, it removes their entries from the relation cache.
   * <p>
   * The method is supposed to use in the following situations:
   *   1. The logical plan of a table/view was changed, and cached table/view data is cleared
   *      explicitly. For example, like in <code>AlterTableRenameCommand</code> which re-caches the table
   *      itself. Otherwise if you need to refresh cached data, consider using of
   *      <code>CatalogImpl.refreshTable()</code>.
   *   2. A table/view doesn't exist, and need to only remove its entry in the relation cache since
   *      the cached data is invalidated explicitly like in <code>DropTableCommand</code> which uncaches
   *      table/view data itself.
   *   3. Meta-data (such as file indexes) of any relation used in a temporary view should be
   *      updated.
   * @param name (undocumented)
   */
  public  void refreshTable (org.apache.spark.sql.catalyst.TableIdentifier name)  { throw new RuntimeException(); }
  /**
   * Drop all existing temporary views.
   * For testing only.
   */
  public  void clearTempTables ()  { throw new RuntimeException(); }
  /**
   * Create partitions in an existing table, assuming it exists.
   * If no database is specified, assume the table is in the current database.
   * @param tableName (undocumented)
   * @param parts (undocumented)
   * @param ignoreIfExists (undocumented)
   */
  public  void createPartitions (org.apache.spark.sql.catalyst.TableIdentifier tableName, scala.collection.Seq<org.apache.spark.sql.catalyst.catalog.CatalogTablePartition> parts, boolean ignoreIfExists)  { throw new RuntimeException(); }
  /**
   * Drop partitions from a table, assuming they exist.
   * If no database is specified, assume the table is in the current database.
   * @param tableName (undocumented)
   * @param specs (undocumented)
   * @param ignoreIfNotExists (undocumented)
   * @param purge (undocumented)
   * @param retainData (undocumented)
   */
  public  void dropPartitions (org.apache.spark.sql.catalyst.TableIdentifier tableName, scala.collection.Seq<scala.collection.immutable.Map<java.lang.String, java.lang.String>> specs, boolean ignoreIfNotExists, boolean purge, boolean retainData)  { throw new RuntimeException(); }
  /**
   * Override the specs of one or many existing table partitions, assuming they exist.
   * <p>
   * This assumes index i of <code>specs</code> corresponds to index i of <code>newSpecs</code>.
   * If no database is specified, assume the table is in the current database.
   * @param tableName (undocumented)
   * @param specs (undocumented)
   * @param newSpecs (undocumented)
   */
  public  void renamePartitions (org.apache.spark.sql.catalyst.TableIdentifier tableName, scala.collection.Seq<scala.collection.immutable.Map<java.lang.String, java.lang.String>> specs, scala.collection.Seq<scala.collection.immutable.Map<java.lang.String, java.lang.String>> newSpecs)  { throw new RuntimeException(); }
  /**
   * Alter one or many table partitions whose specs that match those specified in <code>parts</code>,
   * assuming the partitions exist.
   * <p>
   * If no database is specified, assume the table is in the current database.
   * <p>
   * Note: If the underlying implementation does not support altering a certain field,
   * this becomes a no-op.
   * @param tableName (undocumented)
   * @param parts (undocumented)
   */
  public  void alterPartitions (org.apache.spark.sql.catalyst.TableIdentifier tableName, scala.collection.Seq<org.apache.spark.sql.catalyst.catalog.CatalogTablePartition> parts)  { throw new RuntimeException(); }
  /**
   * Retrieve the metadata of a table partition, assuming it exists.
   * If no database is specified, assume the table is in the current database.
   * @param tableName (undocumented)
   * @param spec (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.catalog.CatalogTablePartition getPartition (org.apache.spark.sql.catalyst.TableIdentifier tableName, scala.collection.immutable.Map<java.lang.String, java.lang.String> spec)  { throw new RuntimeException(); }
  /**
   * List the names of all partitions that belong to the specified table, assuming it exists.
   * <p>
   * A partial partition spec may optionally be provided to filter the partitions returned.
   * For instance, if there exist partitions (a='1', b='2'), (a='1', b='3') and (a='2', b='4'),
   * then a partial spec of (a='1') will return the first two only.
   * @param tableName (undocumented)
   * @param partialSpec (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<java.lang.String> listPartitionNames (org.apache.spark.sql.catalyst.TableIdentifier tableName, scala.Option<scala.collection.immutable.Map<java.lang.String, java.lang.String>> partialSpec)  { throw new RuntimeException(); }
  /**
   * List the metadata of all partitions that belong to the specified table, assuming it exists.
   * <p>
   * A partial partition spec may optionally be provided to filter the partitions returned.
   * For instance, if there exist partitions (a='1', b='2'), (a='1', b='3') and (a='2', b='4'),
   * then a partial spec of (a='1') will return the first two only.
   * @param tableName (undocumented)
   * @param partialSpec (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.catalog.CatalogTablePartition> listPartitions (org.apache.spark.sql.catalyst.TableIdentifier tableName, scala.Option<scala.collection.immutable.Map<java.lang.String, java.lang.String>> partialSpec)  { throw new RuntimeException(); }
  /**
   * List the metadata of partitions that belong to the specified table, assuming it exists, that
   * satisfy the given partition-pruning predicate expressions.
   * @param tableName (undocumented)
   * @param predicates (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.catalog.CatalogTablePartition> listPartitionsByFilter (org.apache.spark.sql.catalyst.TableIdentifier tableName, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> predicates)  { throw new RuntimeException(); }
  /**
   * Create a function in the database specified in <code>funcDefinition</code>.
   * If no such database is specified, create it in the current database.
   * <p>
   * @param ignoreIfExists: When true, ignore if the function with the specified name exists
   *                        in the specified database.
   * @param funcDefinition (undocumented)
   */
  public  void createFunction (org.apache.spark.sql.catalyst.catalog.CatalogFunction funcDefinition, boolean ignoreIfExists)  { throw new RuntimeException(); }
  /**
   * Drop a metastore function.
   * If no database is specified, assume the function is in the current database.
   * @param name (undocumented)
   * @param ignoreIfNotExists (undocumented)
   */
  public  void dropFunction (org.apache.spark.sql.catalyst.FunctionIdentifier name, boolean ignoreIfNotExists)  { throw new RuntimeException(); }
  /**
   * overwrite a metastore function in the database specified in <code>funcDefinition</code>..
   * If no database is specified, assume the function is in the current database.
   * @param funcDefinition (undocumented)
   */
  public  void alterFunction (org.apache.spark.sql.catalyst.catalog.CatalogFunction funcDefinition)  { throw new RuntimeException(); }
  /**
   * Retrieve the metadata of a metastore function.
   * <p>
   * If a database is specified in <code>name</code>, this will return the function in that database.
   * If no database is specified, this will return the function in the current database.
   * @param name (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.catalog.CatalogFunction getFunctionMetadata (org.apache.spark.sql.catalyst.FunctionIdentifier name)  { throw new RuntimeException(); }
  /**
   * Check if the function with the specified name exists
   * @param name (undocumented)
   * @return (undocumented)
   */
  public  boolean functionExists (org.apache.spark.sql.catalyst.FunctionIdentifier name)  { throw new RuntimeException(); }
  /**
   * Constructs a {@link Expression} based on the provided class that represents a function.
   * <p>
   * This performs reflection to decide what type of {@link Expression} to return in the builder.
   * @param name (undocumented)
   * @param clazz (undocumented)
   * @param input (undocumented)
   * @return (undocumented)
   */
  protected  org.apache.spark.sql.catalyst.expressions.Expression makeFunctionExpression (java.lang.String name, java.lang.Class<?> clazz, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> input)  { throw new RuntimeException(); }
  /**
   * Loads resources such as JARs and Files for a function. Every resource is represented
   * by a tuple (resource type, resource uri).
   * @param resources (undocumented)
   */
  public  void loadFunctionResources (scala.collection.Seq<org.apache.spark.sql.catalyst.catalog.FunctionResource> resources)  { throw new RuntimeException(); }
  /**
   * Registers a temporary or permanent function into a session-specific {@link FunctionRegistry}
   * @param funcDefinition (undocumented)
   * @param overrideIfExists (undocumented)
   * @param functionBuilder (undocumented)
   */
  public  void registerFunction (org.apache.spark.sql.catalyst.catalog.CatalogFunction funcDefinition, boolean overrideIfExists, scala.Option<scala.Function1<scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression>, org.apache.spark.sql.catalyst.expressions.Expression>> functionBuilder)  { throw new RuntimeException(); }
  /**
   * Unregister a temporary or permanent function from a session-specific {@link FunctionRegistry}
   * Return true if function exists.
   * @param name (undocumented)
   * @return (undocumented)
   */
  public  boolean unregisterFunction (org.apache.spark.sql.catalyst.FunctionIdentifier name)  { throw new RuntimeException(); }
  /**
   * Drop a temporary function.
   * @param name (undocumented)
   * @param ignoreIfNotExists (undocumented)
   */
  public  void dropTempFunction (java.lang.String name, boolean ignoreIfNotExists)  { throw new RuntimeException(); }
  /**
   * Returns whether it is a temporary function. If not existed, returns false.
   * @param name (undocumented)
   * @return (undocumented)
   */
  public  boolean isTemporaryFunction (org.apache.spark.sql.catalyst.FunctionIdentifier name)  { throw new RuntimeException(); }
  public  boolean isTempFunction (java.lang.String name)  { throw new RuntimeException(); }
  /**
   * Return whether this function has been registered in the function registry of the current
   * session. If not existed, return false.
   * @param name (undocumented)
   * @return (undocumented)
   */
  public  boolean isRegisteredFunction (org.apache.spark.sql.catalyst.FunctionIdentifier name)  { throw new RuntimeException(); }
  /**
   * Returns whether it is a persistent function. If not existed, returns false.
   * @param name (undocumented)
   * @return (undocumented)
   */
  public  boolean isPersistentFunction (org.apache.spark.sql.catalyst.FunctionIdentifier name)  { throw new RuntimeException(); }
  protected  scala.runtime.Nothing$ failFunctionLookup (org.apache.spark.sql.catalyst.FunctionIdentifier name, scala.Option<java.lang.Throwable> cause)  { throw new RuntimeException(); }
  /**
   * Look up the {@link ExpressionInfo} associated with the specified function, assuming it exists.
   * @param name (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.ExpressionInfo lookupFunctionInfo (org.apache.spark.sql.catalyst.FunctionIdentifier name)  { throw new RuntimeException(); }
  /**
   * Return an {@link Expression} that represents the specified function, assuming it exists.
   * <p>
   * For a temporary function or a permanent function that has been loaded,
   * this method will simply lookup the function through the
   * FunctionRegistry and create an expression based on the builder.
   * <p>
   * For a permanent function that has not been loaded, we will first fetch its metadata
   * from the underlying external catalog. Then, we will load all resources associated
   * with this function (i.e. jars and files). Finally, we create a function builder
   * based on the function class and put the builder into the FunctionRegistry.
   * The name of this function in the FunctionRegistry will be <code>databaseName.functionName</code>.
   * @param name (undocumented)
   * @param children (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Expression lookupFunction (org.apache.spark.sql.catalyst.FunctionIdentifier name, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children)  { throw new RuntimeException(); }
  /**
   * List all functions in the specified database, including temporary functions. This
   * returns the function identifier and the scope in which it was defined (system or user
   * defined).
   * @param db (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<scala.Tuple2<org.apache.spark.sql.catalyst.FunctionIdentifier, java.lang.String>> listFunctions (java.lang.String db)  { throw new RuntimeException(); }
  /**
   * List all matching functions in the specified database, including temporary functions. This
   * returns the function identifier and the scope in which it was defined (system or user
   * defined).
   * @param db (undocumented)
   * @param pattern (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<scala.Tuple2<org.apache.spark.sql.catalyst.FunctionIdentifier, java.lang.String>> listFunctions (java.lang.String db, java.lang.String pattern)  { throw new RuntimeException(); }
  /**
   * Drop all existing databases (except "default"), tables, partitions and functions,
   * and set the current database to "default".
   * <p>
   * This is mainly used for tests.
   */
  public  void reset ()  { throw new RuntimeException(); }
  /**
   * Copy the current state of the catalog to another catalog.
   * <p>
   * This function is synchronized on this {@link SessionCatalog} (the source) to make sure the copied
   * state is consistent. The target {@link SessionCatalog} is not synchronized, and should not be
   * because the target {@link SessionCatalog} should not be published at this point. The caller must
   * synchronize on the target if this assumption does not hold.
   * @param target (undocumented)
   */
    void copyStateTo (org.apache.spark.sql.catalyst.catalog.SessionCatalog target)  { throw new RuntimeException(); }
}
