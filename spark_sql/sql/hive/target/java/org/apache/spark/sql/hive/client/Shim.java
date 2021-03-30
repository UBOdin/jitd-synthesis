package org.apache.spark.sql.hive.client;
/**
 * A shim that defines the interface between {@link HiveClientImpl} and the underlying Hive library used
 * to talk to the metastore. Each Hive version has its own implementation of this class, defining
 * version-specific version of needed functions.
 * <p>
 * The guideline for writing shims is:
 * - always extend from the previous version unless really not possible
 * - initialize methods in lazy vals, both for quicker access for multiple invocations, and to
 *   avoid runtime errors due to the above guideline.
 */
 abstract class Shim {
  public   Shim ()  { throw new RuntimeException(); }
  public abstract  void alterFunction (org.apache.hadoop.hive.ql.metadata.Hive hive, java.lang.String db, org.apache.spark.sql.catalyst.catalog.CatalogFunction func)  ;
  public abstract  void alterPartitions (org.apache.hadoop.hive.ql.metadata.Hive hive, java.lang.String tableName, java.util.List<org.apache.hadoop.hive.ql.metadata.Partition> newParts)  ;
  public abstract  void alterTable (org.apache.hadoop.hive.ql.metadata.Hive hive, java.lang.String tableName, org.apache.hadoop.hive.ql.metadata.Table table)  ;
  public abstract  void createFunction (org.apache.hadoop.hive.ql.metadata.Hive hive, java.lang.String db, org.apache.spark.sql.catalyst.catalog.CatalogFunction func)  ;
  public abstract  void createPartitions (org.apache.hadoop.hive.ql.metadata.Hive hive, java.lang.String db, java.lang.String table, scala.collection.Seq<org.apache.spark.sql.catalyst.catalog.CatalogTablePartition> parts, boolean ignoreIfExists)  ;
  public abstract  void dropFunction (org.apache.hadoop.hive.ql.metadata.Hive hive, java.lang.String db, java.lang.String name)  ;
  public abstract  void dropIndex (org.apache.hadoop.hive.ql.metadata.Hive hive, java.lang.String dbName, java.lang.String tableName, java.lang.String indexName)  ;
  public abstract  void dropPartition (org.apache.hadoop.hive.ql.metadata.Hive hive, java.lang.String dbName, java.lang.String tableName, java.util.List<java.lang.String> part, boolean deleteData, boolean purge)  ;
  public abstract  void dropTable (org.apache.hadoop.hive.ql.metadata.Hive hive, java.lang.String dbName, java.lang.String tableName, boolean deleteData, boolean ignoreIfNotExists, boolean purge)  ;
  protected  java.lang.reflect.Method findMethod (java.lang.Class<?> klass, java.lang.String name, scala.collection.Seq<java.lang.Class<?>> args)  { throw new RuntimeException(); }
  protected  java.lang.reflect.Method findStaticMethod (java.lang.Class<?> klass, java.lang.String name, scala.collection.Seq<java.lang.Class<?>> args)  { throw new RuntimeException(); }
  public abstract  scala.collection.Seq<org.apache.hadoop.hive.ql.metadata.Partition> getAllPartitions (org.apache.hadoop.hive.ql.metadata.Hive hive, org.apache.hadoop.hive.ql.metadata.Table table)  ;
  public abstract  org.apache.hadoop.hive.ql.processors.CommandProcessor getCommandProcessor (java.lang.String token, org.apache.hadoop.hive.conf.HiveConf conf)  ;
  /**
   * This shim is necessary because the return type is different on different versions of Hive.
   * All parameters are the same, though.
   * @param table (undocumented)
   * @return (undocumented)
   */
  public abstract  scala.Option<java.lang.String> getDataLocation (org.apache.hadoop.hive.ql.metadata.Table table)  ;
  public abstract  java.lang.String getDatabaseOwnerName (org.apache.hadoop.hive.metastore.api.Database db)  ;
  public abstract  scala.collection.Seq<java.lang.String> getDriverResults (org.apache.hadoop.hive.ql.Driver driver)  ;
  public abstract  scala.Option<org.apache.spark.sql.catalyst.catalog.CatalogFunction> getFunctionOption (org.apache.hadoop.hive.ql.metadata.Hive hive, java.lang.String db, java.lang.String name)  ;
  public abstract  org.apache.hadoop.hive.metastore.IMetaStoreClient getMSC (org.apache.hadoop.hive.ql.metadata.Hive hive)  ;
  public abstract  long getMetastoreClientConnectRetryDelayMillis (org.apache.hadoop.hive.conf.HiveConf conf)  ;
  public abstract  scala.collection.Seq<org.apache.hadoop.hive.ql.metadata.Partition> getPartitionsByFilter (org.apache.hadoop.hive.ql.metadata.Hive hive, org.apache.hadoop.hive.ql.metadata.Table table, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> predicates, java.lang.String timeZoneId)  ;
  public abstract  scala.collection.Seq<java.lang.String> getTablesByType (org.apache.hadoop.hive.ql.metadata.Hive hive, java.lang.String dbName, java.lang.String pattern, org.apache.hadoop.hive.metastore.TableType tableType)  ;
  public abstract  scala.collection.Seq<java.lang.String> listFunctions (org.apache.hadoop.hive.ql.metadata.Hive hive, java.lang.String db, java.lang.String pattern)  ;
  public abstract  void loadDynamicPartitions (org.apache.hadoop.hive.ql.metadata.Hive hive, org.apache.hadoop.fs.Path loadPath, java.lang.String tableName, java.util.Map<java.lang.String, java.lang.String> partSpec, boolean replace, int numDP, boolean listBucketingEnabled)  ;
  public abstract  void loadPartition (org.apache.hadoop.hive.ql.metadata.Hive hive, org.apache.hadoop.fs.Path loadPath, java.lang.String tableName, java.util.Map<java.lang.String, java.lang.String> partSpec, boolean replace, boolean inheritTableSpecs, boolean isSkewedStoreAsSubdir, boolean isSrcLocal)  ;
  public abstract  void loadTable (org.apache.hadoop.hive.ql.metadata.Hive hive, org.apache.hadoop.fs.Path loadPath, java.lang.String tableName, boolean replace, boolean isSrcLocal)  ;
  public abstract  void renameFunction (org.apache.hadoop.hive.ql.metadata.Hive hive, java.lang.String db, java.lang.String oldName, java.lang.String newName)  ;
  /**
   * Set the current SessionState to the given SessionState. Also, set the context classloader of
   * the current thread to the one set in the HiveConf of this given <code>state</code>.
   * @param state (undocumented)
   */
  public abstract  void setCurrentSessionState (org.apache.hadoop.hive.ql.session.SessionState state)  ;
  public abstract  void setDataLocation (org.apache.hadoop.hive.ql.metadata.Table table, java.lang.String loc)  ;
  public abstract  void setDatabaseOwnerName (org.apache.hadoop.hive.metastore.api.Database db, java.lang.String owner)  ;
}
