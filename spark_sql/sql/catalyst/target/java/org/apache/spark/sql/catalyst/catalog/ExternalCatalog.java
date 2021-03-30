package org.apache.spark.sql.catalyst.catalog;
/**
 * Interface for the system catalog (of functions, partitions, tables, and databases).
 * <p>
 * This is only used for non-temporary items, and implementations must be thread-safe as they
 * can be accessed in multiple threads. This is an external catalog because it is expected to
 * interact with external systems.
 * <p>
 * Implementations should throw {@link NoSuchDatabaseException} when databases don't exist.
 */
public  interface ExternalCatalog {
  /**
   * Alter a database whose name matches the one specified in <code>dbDefinition</code>,
   * assuming the database exists.
   * <p>
   * Note: If the underlying implementation does not support altering a certain field,
   * this becomes a no-op.
   * @param dbDefinition (undocumented)
   */
  public  void alterDatabase (org.apache.spark.sql.catalyst.catalog.CatalogDatabase dbDefinition)  ;
  public  void alterFunction (java.lang.String db, org.apache.spark.sql.catalyst.catalog.CatalogFunction funcDefinition)  ;
  /**
   * Alter one or many table partitions whose specs that match those specified in <code>parts</code>,
   * assuming the partitions exist.
   * <p>
   * Note: If the underlying implementation does not support altering a certain field,
   * this becomes a no-op.
   * @param db (undocumented)
   * @param table (undocumented)
   * @param parts (undocumented)
   */
  public  void alterPartitions (java.lang.String db, java.lang.String table, scala.collection.Seq<org.apache.spark.sql.catalyst.catalog.CatalogTablePartition> parts)  ;
  /**
   * Alter a table whose database and name match the ones specified in <code>tableDefinition</code>, assuming
   * the table exists. Note that, even though we can specify database in <code>tableDefinition</code>, it's
   * used to identify the table, not to alter the table's database, which is not allowed.
   * <p>
   * Note: If the underlying implementation does not support altering a certain field,
   * this becomes a no-op.
   * @param tableDefinition (undocumented)
   */
  public  void alterTable (org.apache.spark.sql.catalyst.catalog.CatalogTable tableDefinition)  ;
  /**
   * Alter the data schema of a table identified by the provided database and table name. The new
   * data schema should not have conflict column names with the existing partition columns, and
   * should still contain all the existing data columns.
   * <p>
   * @param db Database that table to alter schema for exists in
   * @param table Name of table to alter schema for
   * @param newDataSchema Updated data schema to be used for the table.
   */
  public  void alterTableDataSchema (java.lang.String db, java.lang.String table, org.apache.spark.sql.types.StructType newDataSchema)  ;
  /** Alter the statistics of a table. If `stats` is None, then remove all existing statistics. */
  public  void alterTableStats (java.lang.String db, java.lang.String table, scala.Option<org.apache.spark.sql.catalyst.catalog.CatalogStatistics> stats)  ;
  public  void createDatabase (org.apache.spark.sql.catalyst.catalog.CatalogDatabase dbDefinition, boolean ignoreIfExists)  ;
  public  void createFunction (java.lang.String db, org.apache.spark.sql.catalyst.catalog.CatalogFunction funcDefinition)  ;
  public  void createPartitions (java.lang.String db, java.lang.String table, scala.collection.Seq<org.apache.spark.sql.catalyst.catalog.CatalogTablePartition> parts, boolean ignoreIfExists)  ;
  public  void createTable (org.apache.spark.sql.catalyst.catalog.CatalogTable tableDefinition, boolean ignoreIfExists)  ;
  public  boolean databaseExists (java.lang.String db)  ;
  public  void dropDatabase (java.lang.String db, boolean ignoreIfNotExists, boolean cascade)  ;
  public  void dropFunction (java.lang.String db, java.lang.String funcName)  ;
  public  void dropPartitions (java.lang.String db, java.lang.String table, scala.collection.Seq<scala.collection.immutable.Map<java.lang.String, java.lang.String>> parts, boolean ignoreIfNotExists, boolean purge, boolean retainData)  ;
  public  void dropTable (java.lang.String db, java.lang.String table, boolean ignoreIfNotExists, boolean purge)  ;
  public  boolean functionExists (java.lang.String db, java.lang.String funcName)  ;
  public  org.apache.spark.sql.catalyst.catalog.CatalogDatabase getDatabase (java.lang.String db)  ;
  public  org.apache.spark.sql.catalyst.catalog.CatalogFunction getFunction (java.lang.String db, java.lang.String funcName)  ;
  public  org.apache.spark.sql.catalyst.catalog.CatalogTablePartition getPartition (java.lang.String db, java.lang.String table, scala.collection.immutable.Map<java.lang.String, java.lang.String> spec)  ;
  /**
   * Returns the specified partition or None if it does not exist.
   * @param db (undocumented)
   * @param table (undocumented)
   * @param spec (undocumented)
   * @return (undocumented)
   */
  public  scala.Option<org.apache.spark.sql.catalyst.catalog.CatalogTablePartition> getPartitionOption (java.lang.String db, java.lang.String table, scala.collection.immutable.Map<java.lang.String, java.lang.String> spec)  ;
  public  org.apache.spark.sql.catalyst.catalog.CatalogTable getTable (java.lang.String db, java.lang.String table)  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.catalog.CatalogTable> getTablesByName (java.lang.String db, scala.collection.Seq<java.lang.String> tables)  ;
  public  scala.collection.Seq<java.lang.String> listDatabases ()  ;
  public  scala.collection.Seq<java.lang.String> listDatabases (java.lang.String pattern)  ;
  public  scala.collection.Seq<java.lang.String> listFunctions (java.lang.String db, java.lang.String pattern)  ;
  /**
   * List the names of all partitions that belong to the specified table, assuming it exists.
   * <p>
   * For a table with partition columns p1, p2, p3, each partition name is formatted as
   * <code>p1=v1/p2=v2/p3=v3</code>. Each partition column name and value is an escaped path name, and can be
   * decoded with the <code>ExternalCatalogUtils.unescapePathName</code> method.
   * <p>
   * The returned sequence is sorted as strings.
   * <p>
   * A partial partition spec may optionally be provided to filter the partitions returned, as
   * described in the <code>listPartitions</code> method.
   * <p>
   * @param db database name
   * @param table table name
   * @param partialSpec partition spec
   * @return (undocumented)
   */
  public  scala.collection.Seq<java.lang.String> listPartitionNames (java.lang.String db, java.lang.String table, scala.Option<scala.collection.immutable.Map<java.lang.String, java.lang.String>> partialSpec)  ;
  /**
   * List the metadata of all partitions that belong to the specified table, assuming it exists.
   * <p>
   * A partial partition spec may optionally be provided to filter the partitions returned.
   * For instance, if there exist partitions (a='1', b='2'), (a='1', b='3') and (a='2', b='4'),
   * then a partial spec of (a='1') will return the first two only.
   * <p>
   * @param db database name
   * @param table table name
   * @param partialSpec partition spec
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.catalog.CatalogTablePartition> listPartitions (java.lang.String db, java.lang.String table, scala.Option<scala.collection.immutable.Map<java.lang.String, java.lang.String>> partialSpec)  ;
  /**
   * List the metadata of partitions that belong to the specified table, assuming it exists, that
   * satisfy the given partition-pruning predicate expressions.
   * <p>
   * @param db database name
   * @param table table name
   * @param predicates partition-pruning predicates
   * @param defaultTimeZoneId default timezone id to parse partition values of TimestampType
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.catalog.CatalogTablePartition> listPartitionsByFilter (java.lang.String db, java.lang.String table, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> predicates, java.lang.String defaultTimeZoneId)  ;
  public  scala.collection.Seq<java.lang.String> listTables (java.lang.String db)  ;
  public  scala.collection.Seq<java.lang.String> listTables (java.lang.String db, java.lang.String pattern)  ;
  public  scala.collection.Seq<java.lang.String> listViews (java.lang.String db, java.lang.String pattern)  ;
  public  void loadDynamicPartitions (java.lang.String db, java.lang.String table, java.lang.String loadPath, scala.collection.immutable.Map<java.lang.String, java.lang.String> partition, boolean replace, int numDP)  ;
  /**
   * Loads data into a partition.
   * <p>
   * @param isSrcLocal Whether the source data is local, as defined by the "LOAD DATA LOCAL"
   *                   HiveQL command.
   * @param db (undocumented)
   * @param table (undocumented)
   * @param loadPath (undocumented)
   * @param partition (undocumented)
   * @param isOverwrite (undocumented)
   * @param inheritTableSpecs (undocumented)
   */
  public  void loadPartition (java.lang.String db, java.lang.String table, java.lang.String loadPath, scala.collection.immutable.Map<java.lang.String, java.lang.String> partition, boolean isOverwrite, boolean inheritTableSpecs, boolean isSrcLocal)  ;
  /**
   * Loads data into a table.
   * <p>
   * @param isSrcLocal Whether the source data is local, as defined by the "LOAD DATA LOCAL"
   *                   HiveQL command.
   * @param db (undocumented)
   * @param table (undocumented)
   * @param loadPath (undocumented)
   * @param isOverwrite (undocumented)
   */
  public  void loadTable (java.lang.String db, java.lang.String table, java.lang.String loadPath, boolean isOverwrite, boolean isSrcLocal)  ;
  public  void renameFunction (java.lang.String db, java.lang.String oldName, java.lang.String newName)  ;
  /**
   * Override the specs of one or many existing table partitions, assuming they exist.
   * This assumes index i of <code>specs</code> corresponds to index i of <code>newSpecs</code>.
   * @param db (undocumented)
   * @param table (undocumented)
   * @param specs (undocumented)
   * @param newSpecs (undocumented)
   */
  public  void renamePartitions (java.lang.String db, java.lang.String table, scala.collection.Seq<scala.collection.immutable.Map<java.lang.String, java.lang.String>> specs, scala.collection.Seq<scala.collection.immutable.Map<java.lang.String, java.lang.String>> newSpecs)  ;
  public  void renameTable (java.lang.String db, java.lang.String oldName, java.lang.String newName)  ;
  public  void requireDbExists (java.lang.String db)  ;
  public  void requireFunctionExists (java.lang.String db, java.lang.String funcName)  ;
  public  void requireFunctionNotExists (java.lang.String db, java.lang.String funcName)  ;
  public  void requireTableExists (java.lang.String db, java.lang.String table)  ;
  public  void setCurrentDatabase (java.lang.String db)  ;
  public  boolean tableExists (java.lang.String db, java.lang.String table)  ;
}
