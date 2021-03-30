package org.apache.spark.sql.catalog;
/**
 * Catalog interface for Spark. To access this, use <code>SparkSession.catalog</code>.
 * <p>
 * @since 2.0.0
 */
public abstract class Catalog {
  public   Catalog ()  { throw new RuntimeException(); }
  /**
   * Caches the specified table in-memory.
   * <p>
   * @param tableName is either a qualified or unqualified name that designates a table/view.
   *                  If no database identifier is provided, it refers to a temporary view or
   *                  a table/view in the current database.
   * @since 2.0.0
   */
  public abstract  void cacheTable (java.lang.String tableName)  ;
  /**
   * Caches the specified table with the given storage level.
   * <p>
   * @param tableName is either a qualified or unqualified name that designates a table/view.
   *                  If no database identifier is provided, it refers to a temporary view or
   *                  a table/view in the current database.
   * @param storageLevel storage level to cache table.
   * @since 2.3.0
   */
  public abstract  void cacheTable (java.lang.String tableName, org.apache.spark.storage.StorageLevel storageLevel)  ;
  /**
   * Removes all cached tables from the in-memory cache.
   * <p>
   * @since 2.0.0
   */
  public abstract  void clearCache ()  ;
  /**
   * Creates a table from the given path and returns the corresponding DataFrame.
   * It will use the default data source configured by spark.sql.sources.default.
   * <p>
   * @param tableName is either a qualified or unqualified name that designates a table.
   *                  If no database identifier is provided, it refers to a table in
   *                  the current database.
   * @since 2.0.0
   * @param path (undocumented)
   * @return (undocumented)
   *
   * @deprecated use createTable instead. Since 2.2.0. 
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> createExternalTable (java.lang.String tableName, java.lang.String path)  { throw new RuntimeException(); }
  /**
   * Creates a table from the given path based on a data source and returns the corresponding
   * DataFrame.
   * <p>
   * @param tableName is either a qualified or unqualified name that designates a table.
   *                  If no database identifier is provided, it refers to a table in
   *                  the current database.
   * @since 2.0.0
   * @param path (undocumented)
   * @param source (undocumented)
   * @return (undocumented)
   *
   * @deprecated use createTable instead. Since 2.2.0. 
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> createExternalTable (java.lang.String tableName, java.lang.String path, java.lang.String source)  { throw new RuntimeException(); }
  /**
   * Creates a table from the given path based on a data source and a set of options.
   * Then, returns the corresponding DataFrame.
   * <p>
   * @param tableName is either a qualified or unqualified name that designates a table.
   *                  If no database identifier is provided, it refers to a table in
   *                  the current database.
   * @since 2.0.0
   * @param source (undocumented)
   * @param options (undocumented)
   * @return (undocumented)
   *
   * @deprecated use createTable instead. Since 2.2.0. 
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> createExternalTable (java.lang.String tableName, java.lang.String source, java.util.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  /**
   * (Scala-specific)
   * Creates a table from the given path based on a data source and a set of options.
   * Then, returns the corresponding DataFrame.
   * <p>
   * @param tableName is either a qualified or unqualified name that designates a table.
   *                  If no database identifier is provided, it refers to a table in
   *                  the current database.
   * @since 2.0.0
   * @param source (undocumented)
   * @param options (undocumented)
   * @return (undocumented)
   *
   * @deprecated use createTable instead. Since 2.2.0. 
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> createExternalTable (java.lang.String tableName, java.lang.String source, scala.collection.immutable.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  /**
   * Create a table from the given path based on a data source, a schema and a set of options.
   * Then, returns the corresponding DataFrame.
   * <p>
   * @param tableName is either a qualified or unqualified name that designates a table.
   *                  If no database identifier is provided, it refers to a table in
   *                  the current database.
   * @since 2.0.0
   * @param source (undocumented)
   * @param schema (undocumented)
   * @param options (undocumented)
   * @return (undocumented)
   *
   * @deprecated use createTable instead. Since 2.2.0. 
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> createExternalTable (java.lang.String tableName, java.lang.String source, org.apache.spark.sql.types.StructType schema, java.util.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  /**
   * (Scala-specific)
   * Create a table from the given path based on a data source, a schema and a set of options.
   * Then, returns the corresponding DataFrame.
   * <p>
   * @param tableName is either a qualified or unqualified name that designates a table.
   *                  If no database identifier is provided, it refers to a table in
   *                  the current database.
   * @since 2.0.0
   * @param source (undocumented)
   * @param schema (undocumented)
   * @param options (undocumented)
   * @return (undocumented)
   *
   * @deprecated use createTable instead. Since 2.2.0. 
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> createExternalTable (java.lang.String tableName, java.lang.String source, org.apache.spark.sql.types.StructType schema, scala.collection.immutable.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  /**
   * Creates a table from the given path and returns the corresponding DataFrame.
   * It will use the default data source configured by spark.sql.sources.default.
   * <p>
   * @param tableName is either a qualified or unqualified name that designates a table.
   *                  If no database identifier is provided, it refers to a table in
   *                  the current database.
   * @since 2.2.0
   * @param path (undocumented)
   * @return (undocumented)
   */
  public abstract  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> createTable (java.lang.String tableName, java.lang.String path)  ;
  /**
   * Creates a table from the given path based on a data source and returns the corresponding
   * DataFrame.
   * <p>
   * @param tableName is either a qualified or unqualified name that designates a table.
   *                  If no database identifier is provided, it refers to a table in
   *                  the current database.
   * @since 2.2.0
   * @param path (undocumented)
   * @param source (undocumented)
   * @return (undocumented)
   */
  public abstract  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> createTable (java.lang.String tableName, java.lang.String path, java.lang.String source)  ;
  /**
   * Creates a table based on the dataset in a data source and a set of options.
   * Then, returns the corresponding DataFrame.
   * <p>
   * @param tableName is either a qualified or unqualified name that designates a table.
   *                  If no database identifier is provided, it refers to a table in
   *                  the current database.
   * @since 2.2.0
   * @param source (undocumented)
   * @param options (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> createTable (java.lang.String tableName, java.lang.String source, java.util.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  /**
   * (Scala-specific)
   * Creates a table based on the dataset in a data source and a set of options.
   * Then, returns the corresponding DataFrame.
   * <p>
   * @param tableName is either a qualified or unqualified name that designates a table.
   *                  If no database identifier is provided, it refers to a table in
   *                  the current database.
   * @since 2.2.0
   * @param source (undocumented)
   * @param options (undocumented)
   * @return (undocumented)
   */
  public abstract  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> createTable (java.lang.String tableName, java.lang.String source, scala.collection.immutable.Map<java.lang.String, java.lang.String> options)  ;
  /**
   * Creates a table based on the dataset in a data source and a set of options.
   * Then, returns the corresponding DataFrame.
   * <p>
   * @param tableName is either a qualified or unqualified name that designates a table.
   *                  If no database identifier is provided, it refers to a table in
   *                  the current database.
   * @since 3.1.0
   * @param source (undocumented)
   * @param description (undocumented)
   * @param options (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> createTable (java.lang.String tableName, java.lang.String source, java.lang.String description, java.util.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  /**
   * (Scala-specific)
   * Creates a table based on the dataset in a data source and a set of options.
   * Then, returns the corresponding DataFrame.
   * <p>
   * @param tableName is either a qualified or unqualified name that designates a table.
   *                  If no database identifier is provided, it refers to a table in
   *                  the current database.
   * @since 3.1.0
   * @param source (undocumented)
   * @param description (undocumented)
   * @param options (undocumented)
   * @return (undocumented)
   */
  public abstract  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> createTable (java.lang.String tableName, java.lang.String source, java.lang.String description, scala.collection.immutable.Map<java.lang.String, java.lang.String> options)  ;
  /**
   * Create a table based on the dataset in a data source, a schema and a set of options.
   * Then, returns the corresponding DataFrame.
   * <p>
   * @param tableName is either a qualified or unqualified name that designates a table.
   *                  If no database identifier is provided, it refers to a table in
   *                  the current database.
   * @since 2.2.0
   * @param source (undocumented)
   * @param schema (undocumented)
   * @param options (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> createTable (java.lang.String tableName, java.lang.String source, org.apache.spark.sql.types.StructType schema, java.util.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  /**
   * (Scala-specific)
   * Create a table based on the dataset in a data source, a schema and a set of options.
   * Then, returns the corresponding DataFrame.
   * <p>
   * @param tableName is either a qualified or unqualified name that designates a table.
   *                  If no database identifier is provided, it refers to a table in
   *                  the current database.
   * @since 2.2.0
   * @param source (undocumented)
   * @param schema (undocumented)
   * @param options (undocumented)
   * @return (undocumented)
   */
  public abstract  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> createTable (java.lang.String tableName, java.lang.String source, org.apache.spark.sql.types.StructType schema, scala.collection.immutable.Map<java.lang.String, java.lang.String> options)  ;
  /**
   * Create a table based on the dataset in a data source, a schema and a set of options.
   * Then, returns the corresponding DataFrame.
   * <p>
   * @param tableName is either a qualified or unqualified name that designates a table.
   *                  If no database identifier is provided, it refers to a table in
   *                  the current database.
   * @since 3.1.0
   * @param source (undocumented)
   * @param schema (undocumented)
   * @param description (undocumented)
   * @param options (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> createTable (java.lang.String tableName, java.lang.String source, org.apache.spark.sql.types.StructType schema, java.lang.String description, java.util.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  /**
   * (Scala-specific)
   * Create a table based on the dataset in a data source, a schema and a set of options.
   * Then, returns the corresponding DataFrame.
   * <p>
   * @param tableName is either a qualified or unqualified name that designates a table.
   *                  If no database identifier is provided, it refers to a table in
   *                  the current database.
   * @since 3.1.0
   * @param source (undocumented)
   * @param schema (undocumented)
   * @param description (undocumented)
   * @param options (undocumented)
   * @return (undocumented)
   */
  public abstract  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> createTable (java.lang.String tableName, java.lang.String source, org.apache.spark.sql.types.StructType schema, java.lang.String description, scala.collection.immutable.Map<java.lang.String, java.lang.String> options)  ;
  /**
   * Returns the current default database in this session.
   * <p>
   * @since 2.0.0
   * @return (undocumented)
   */
  public abstract  java.lang.String currentDatabase ()  ;
  /**
   * Check if the database with the specified name exists.
   * <p>
   * @since 2.1.0
   * @param dbName (undocumented)
   * @return (undocumented)
   */
  public abstract  boolean databaseExists (java.lang.String dbName)  ;
  /**
   * Drops the global temporary view with the given view name in the catalog.
   * If the view has been cached before, then it will also be uncached.
   * <p>
   * Global temporary view is cross-session. Its lifetime is the lifetime of the Spark application,
   * i.e. it will be automatically dropped when the application terminates. It's tied to a system
   * preserved database <code>global_temp</code>, and we must use the qualified name to refer a global temp
   * view, e.g. <code>SELECT * FROM global_temp.view1</code>.
   * <p>
   * @param viewName the unqualified name of the temporary view to be dropped.
   * @return true if the view is dropped successfully, false otherwise.
   * @since 2.1.0
   */
  public abstract  boolean dropGlobalTempView (java.lang.String viewName)  ;
  /**
   * Drops the local temporary view with the given view name in the catalog.
   * If the view has been cached before, then it will also be uncached.
   * <p>
   * Local temporary view is session-scoped. Its lifetime is the lifetime of the session that
   * created it, i.e. it will be automatically dropped when the session terminates. It's not
   * tied to any databases, i.e. we can't use <code>db1.view1</code> to reference a local temporary view.
   * <p>
   * Note that, the return type of this method was Unit in Spark 2.0, but changed to Boolean
   * in Spark 2.1.
   * <p>
   * @param viewName the name of the temporary view to be dropped.
   * @return true if the view is dropped successfully, false otherwise.
   * @since 2.0.0
   */
  public abstract  boolean dropTempView (java.lang.String viewName)  ;
  /**
   * Check if the function with the specified name exists. This can either be a temporary function
   * or a function.
   * <p>
   * @param functionName is either a qualified or unqualified name that designates a function.
   *                     If no database identifier is provided, it refers to a function in
   *                     the current database.
   * @since 2.1.0
   * @return (undocumented)
   */
  public abstract  boolean functionExists (java.lang.String functionName)  ;
  /**
   * Check if the function with the specified name exists in the specified database.
   * <p>
   * @param dbName is a name that designates a database.
   * @param functionName is an unqualified name that designates a function.
   * @since 2.1.0
   * @return (undocumented)
   */
  public abstract  boolean functionExists (java.lang.String dbName, java.lang.String functionName)  ;
  /**
   * Get the database with the specified name. This throws an AnalysisException when the database
   * cannot be found.
   * <p>
   * @since 2.1.0
   * @param dbName (undocumented)
   * @return (undocumented)
   */
  public abstract  org.apache.spark.sql.catalog.Database getDatabase (java.lang.String dbName) throws org.apache.spark.sql.AnalysisException ;
  /**
   * Get the function with the specified name. This function can be a temporary function or a
   * function. This throws an AnalysisException when the function cannot be found.
   * <p>
   * @param functionName is either a qualified or unqualified name that designates a function.
   *                     If no database identifier is provided, it refers to a temporary function
   *                     or a function in the current database.
   * @since 2.1.0
   * @return (undocumented)
   */
  public abstract  org.apache.spark.sql.catalog.Function getFunction (java.lang.String functionName) throws org.apache.spark.sql.AnalysisException ;
  /**
   * Get the function with the specified name. This throws an AnalysisException when the function
   * cannot be found.
   * <p>
   * @param dbName is a name that designates a database.
   * @param functionName is an unqualified name that designates a function in the specified database
   * @since 2.1.0
   * @return (undocumented)
   */
  public abstract  org.apache.spark.sql.catalog.Function getFunction (java.lang.String dbName, java.lang.String functionName) throws org.apache.spark.sql.AnalysisException ;
  /**
   * Get the table or view with the specified name. This table can be a temporary view or a
   * table/view. This throws an AnalysisException when no Table can be found.
   * <p>
   * @param tableName is either a qualified or unqualified name that designates a table/view.
   *                  If no database identifier is provided, it refers to a table/view in
   *                  the current database.
   * @since 2.1.0
   * @return (undocumented)
   */
  public abstract  org.apache.spark.sql.catalog.Table getTable (java.lang.String tableName) throws org.apache.spark.sql.AnalysisException ;
  /**
   * Get the table or view with the specified name in the specified database. This throws an
   * AnalysisException when no Table can be found.
   * <p>
   * @since 2.1.0
   * @param dbName (undocumented)
   * @param tableName (undocumented)
   * @return (undocumented)
   */
  public abstract  org.apache.spark.sql.catalog.Table getTable (java.lang.String dbName, java.lang.String tableName) throws org.apache.spark.sql.AnalysisException ;
  /**
   * Returns true if the table is currently cached in-memory.
   * <p>
   * @param tableName is either a qualified or unqualified name that designates a table/view.
   *                  If no database identifier is provided, it refers to a temporary view or
   *                  a table/view in the current database.
   * @since 2.0.0
   * @return (undocumented)
   */
  public abstract  boolean isCached (java.lang.String tableName)  ;
  /**
   * Returns a list of columns for the given table/view or temporary view.
   * <p>
   * @param tableName is either a qualified or unqualified name that designates a table/view.
   *                  If no database identifier is provided, it refers to a temporary view or
   *                  a table/view in the current database.
   * @since 2.0.0
   * @return (undocumented)
   */
  public abstract  org.apache.spark.sql.Dataset<org.apache.spark.sql.catalog.Column> listColumns (java.lang.String tableName) throws org.apache.spark.sql.AnalysisException ;
  /**
   * Returns a list of columns for the given table/view in the specified database.
   * <p>
   * @param dbName is a name that designates a database.
   * @param tableName is an unqualified name that designates a table/view.
   * @since 2.0.0
   * @return (undocumented)
   */
  public abstract  org.apache.spark.sql.Dataset<org.apache.spark.sql.catalog.Column> listColumns (java.lang.String dbName, java.lang.String tableName) throws org.apache.spark.sql.AnalysisException ;
  /**
   * Returns a list of databases available across all sessions.
   * <p>
   * @since 2.0.0
   * @return (undocumented)
   */
  public abstract  org.apache.spark.sql.Dataset<org.apache.spark.sql.catalog.Database> listDatabases ()  ;
  /**
   * Returns a list of functions registered in the current database.
   * This includes all temporary functions
   * <p>
   * @since 2.0.0
   * @return (undocumented)
   */
  public abstract  org.apache.spark.sql.Dataset<org.apache.spark.sql.catalog.Function> listFunctions ()  ;
  /**
   * Returns a list of functions registered in the specified database.
   * This includes all temporary functions
   * <p>
   * @since 2.0.0
   * @param dbName (undocumented)
   * @return (undocumented)
   */
  public abstract  org.apache.spark.sql.Dataset<org.apache.spark.sql.catalog.Function> listFunctions (java.lang.String dbName) throws org.apache.spark.sql.AnalysisException ;
  /**
   * Returns a list of tables/views in the current database.
   * This includes all temporary views.
   * <p>
   * @since 2.0.0
   * @return (undocumented)
   */
  public abstract  org.apache.spark.sql.Dataset<org.apache.spark.sql.catalog.Table> listTables ()  ;
  /**
   * Returns a list of tables/views in the specified database.
   * This includes all temporary views.
   * <p>
   * @since 2.0.0
   * @param dbName (undocumented)
   * @return (undocumented)
   */
  public abstract  org.apache.spark.sql.Dataset<org.apache.spark.sql.catalog.Table> listTables (java.lang.String dbName) throws org.apache.spark.sql.AnalysisException ;
  /**
   * Recovers all the partitions in the directory of a table and update the catalog.
   * Only works with a partitioned table, and not a view.
   * <p>
   * @param tableName is either a qualified or unqualified name that designates a table.
   *                  If no database identifier is provided, it refers to a table in the
   *                  current database.
   * @since 2.1.1
   */
  public abstract  void recoverPartitions (java.lang.String tableName)  ;
  /**
   * Invalidates and refreshes all the cached data (and the associated metadata) for any <code>Dataset</code>
   * that contains the given data source path. Path matching is by prefix, i.e. "/" would invalidate
   * everything that is cached.
   * <p>
   * @since 2.0.0
   * @param path (undocumented)
   */
  public abstract  void refreshByPath (java.lang.String path)  ;
  /**
   * Invalidates and refreshes all the cached data and metadata of the given table. For performance
   * reasons, Spark SQL or the external data source library it uses might cache certain metadata
   * about a table, such as the location of blocks. When those change outside of Spark SQL, users
   * should call this function to invalidate the cache.
   * <p>
   * If this table is cached as an InMemoryRelation, drop the original cached version and make the
   * new version cached lazily.
   * <p>
   * @param tableName is either a qualified or unqualified name that designates a table/view.
   *                  If no database identifier is provided, it refers to a temporary view or
   *                  a table/view in the current database.
   * @since 2.0.0
   */
  public abstract  void refreshTable (java.lang.String tableName)  ;
  /**
   * Sets the current default database in this session.
   * <p>
   * @since 2.0.0
   * @param dbName (undocumented)
   */
  public abstract  void setCurrentDatabase (java.lang.String dbName)  ;
  /**
   * Check if the table or view with the specified name exists. This can either be a temporary
   * view or a table/view.
   * <p>
   * @param tableName is either a qualified or unqualified name that designates a table/view.
   *                  If no database identifier is provided, it refers to a table/view in
   *                  the current database.
   * @since 2.1.0
   * @return (undocumented)
   */
  public abstract  boolean tableExists (java.lang.String tableName)  ;
  /**
   * Check if the table or view with the specified name exists in the specified database.
   * <p>
   * @param dbName is a name that designates a database.
   * @param tableName is an unqualified name that designates a table.
   * @since 2.1.0
   * @return (undocumented)
   */
  public abstract  boolean tableExists (java.lang.String dbName, java.lang.String tableName)  ;
  /**
   * Removes the specified table from the in-memory cache.
   * <p>
   * @param tableName is either a qualified or unqualified name that designates a table/view.
   *                  If no database identifier is provided, it refers to a temporary view or
   *                  a table/view in the current database.
   * @since 2.0.0
   */
  public abstract  void uncacheTable (java.lang.String tableName)  ;
}
