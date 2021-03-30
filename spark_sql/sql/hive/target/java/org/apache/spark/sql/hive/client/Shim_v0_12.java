package org.apache.spark.sql.hive.client;
  class Shim_v0_12 extends org.apache.spark.sql.hive.client.Shim implements org.apache.spark.internal.Logging {
  public   Shim_v0_12 ()  { throw new RuntimeException(); }
  public  void alterFunction (org.apache.hadoop.hive.ql.metadata.Hive hive, java.lang.String db, org.apache.spark.sql.catalyst.catalog.CatalogFunction func)  { throw new RuntimeException(); }
  public  void alterPartitions (org.apache.hadoop.hive.ql.metadata.Hive hive, java.lang.String tableName, java.util.List<org.apache.hadoop.hive.ql.metadata.Partition> newParts)  { throw new RuntimeException(); }
  public  void alterTable (org.apache.hadoop.hive.ql.metadata.Hive hive, java.lang.String tableName, org.apache.hadoop.hive.ql.metadata.Table table)  { throw new RuntimeException(); }
  public  void createFunction (org.apache.hadoop.hive.ql.metadata.Hive hive, java.lang.String db, org.apache.spark.sql.catalyst.catalog.CatalogFunction func)  { throw new RuntimeException(); }
  public  void createPartitions (org.apache.hadoop.hive.ql.metadata.Hive hive, java.lang.String database, java.lang.String tableName, scala.collection.Seq<org.apache.spark.sql.catalyst.catalog.CatalogTablePartition> parts, boolean ignoreIfExists)  { throw new RuntimeException(); }
  // not preceding
  protected  java.lang.Boolean deleteDataInDropIndex ()  { throw new RuntimeException(); }
  public  void dropFunction (org.apache.hadoop.hive.ql.metadata.Hive hive, java.lang.String db, java.lang.String name)  { throw new RuntimeException(); }
  public  void dropIndex (org.apache.hadoop.hive.ql.metadata.Hive hive, java.lang.String dbName, java.lang.String tableName, java.lang.String indexName)  { throw new RuntimeException(); }
  public  void dropPartition (org.apache.hadoop.hive.ql.metadata.Hive hive, java.lang.String dbName, java.lang.String tableName, java.util.List<java.lang.String> part, boolean deleteData, boolean purge)  { throw new RuntimeException(); }
  public  void dropTable (org.apache.hadoop.hive.ql.metadata.Hive hive, java.lang.String dbName, java.lang.String tableName, boolean deleteData, boolean ignoreIfNotExists, boolean purge)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.hadoop.hive.ql.metadata.Partition> getAllPartitions (org.apache.hadoop.hive.ql.metadata.Hive hive, org.apache.hadoop.hive.ql.metadata.Table table)  { throw new RuntimeException(); }
  public  org.apache.hadoop.hive.ql.processors.CommandProcessor getCommandProcessor (java.lang.String token, org.apache.hadoop.hive.conf.HiveConf conf)  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> getDataLocation (org.apache.hadoop.hive.ql.metadata.Table table)  { throw new RuntimeException(); }
  public  java.lang.String getDatabaseOwnerName (org.apache.hadoop.hive.metastore.api.Database db)  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> getDriverResults (org.apache.hadoop.hive.ql.Driver driver)  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.catalog.CatalogFunction> getFunctionOption (org.apache.hadoop.hive.ql.metadata.Hive hive, java.lang.String db, java.lang.String name)  { throw new RuntimeException(); }
  public  org.apache.hadoop.hive.metastore.IMetaStoreClient getMSC (org.apache.hadoop.hive.ql.metadata.Hive hive)  { throw new RuntimeException(); }
  // not preceding
  protected  java.lang.reflect.Method getMSCMethod ()  { throw new RuntimeException(); }
  public  long getMetastoreClientConnectRetryDelayMillis (org.apache.hadoop.hive.conf.HiveConf conf)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.hadoop.hive.ql.metadata.Partition> getPartitionsByFilter (org.apache.hadoop.hive.ql.metadata.Hive hive, org.apache.hadoop.hive.ql.metadata.Table table, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> predicates, java.lang.String timeZoneId)  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> getTablesByType (org.apache.hadoop.hive.ql.metadata.Hive hive, java.lang.String dbName, java.lang.String pattern, org.apache.hadoop.hive.metastore.TableType tableType)  { throw new RuntimeException(); }
  // not preceding
  protected  java.lang.Boolean holdDDLTime ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> listFunctions (org.apache.hadoop.hive.ql.metadata.Hive hive, java.lang.String db, java.lang.String pattern)  { throw new RuntimeException(); }
  public  void loadDynamicPartitions (org.apache.hadoop.hive.ql.metadata.Hive hive, org.apache.hadoop.fs.Path loadPath, java.lang.String tableName, java.util.Map<java.lang.String, java.lang.String> partSpec, boolean replace, int numDP, boolean listBucketingEnabled)  { throw new RuntimeException(); }
  public  void loadPartition (org.apache.hadoop.hive.ql.metadata.Hive hive, org.apache.hadoop.fs.Path loadPath, java.lang.String tableName, java.util.Map<java.lang.String, java.lang.String> partSpec, boolean replace, boolean inheritTableSpecs, boolean isSkewedStoreAsSubdir, boolean isSrcLocal)  { throw new RuntimeException(); }
  public  void loadTable (org.apache.hadoop.hive.ql.metadata.Hive hive, org.apache.hadoop.fs.Path loadPath, java.lang.String tableName, boolean replace, boolean isSrcLocal)  { throw new RuntimeException(); }
  public  void renameFunction (org.apache.hadoop.hive.ql.metadata.Hive hive, java.lang.String db, java.lang.String oldName, java.lang.String newName)  { throw new RuntimeException(); }
  public  void setCurrentSessionState (org.apache.hadoop.hive.ql.session.SessionState state)  { throw new RuntimeException(); }
  public  void setDataLocation (org.apache.hadoop.hive.ql.metadata.Table table, java.lang.String loc)  { throw new RuntimeException(); }
  public  void setDatabaseOwnerName (org.apache.hadoop.hive.metastore.api.Database db, java.lang.String owner)  { throw new RuntimeException(); }
}
