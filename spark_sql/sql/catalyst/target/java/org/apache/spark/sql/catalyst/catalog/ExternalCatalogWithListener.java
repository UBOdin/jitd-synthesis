package org.apache.spark.sql.catalyst.catalog;
/**
 * Wraps an ExternalCatalog to provide listener events.
 */
public  class ExternalCatalogWithListener implements org.apache.spark.sql.catalyst.catalog.ExternalCatalog, org.apache.spark.util.ListenerBus<org.apache.spark.sql.catalyst.catalog.ExternalCatalogEventListener, org.apache.spark.sql.catalyst.catalog.ExternalCatalogEvent> {
  public   ExternalCatalogWithListener (org.apache.spark.sql.catalyst.catalog.ExternalCatalog delegate)  { throw new RuntimeException(); }
  public  void alterDatabase (org.apache.spark.sql.catalyst.catalog.CatalogDatabase dbDefinition)  { throw new RuntimeException(); }
  public  void alterFunction (java.lang.String db, org.apache.spark.sql.catalyst.catalog.CatalogFunction funcDefinition)  { throw new RuntimeException(); }
  public  void alterPartitions (java.lang.String db, java.lang.String table, scala.collection.Seq<org.apache.spark.sql.catalyst.catalog.CatalogTablePartition> parts)  { throw new RuntimeException(); }
  public  void alterTable (org.apache.spark.sql.catalyst.catalog.CatalogTable tableDefinition)  { throw new RuntimeException(); }
  public  void alterTableDataSchema (java.lang.String db, java.lang.String table, org.apache.spark.sql.types.StructType newDataSchema)  { throw new RuntimeException(); }
  public  void alterTableStats (java.lang.String db, java.lang.String table, scala.Option<org.apache.spark.sql.catalyst.catalog.CatalogStatistics> stats)  { throw new RuntimeException(); }
  public  void createDatabase (org.apache.spark.sql.catalyst.catalog.CatalogDatabase dbDefinition, boolean ignoreIfExists)  { throw new RuntimeException(); }
  public  void createFunction (java.lang.String db, org.apache.spark.sql.catalyst.catalog.CatalogFunction funcDefinition)  { throw new RuntimeException(); }
  public  void createPartitions (java.lang.String db, java.lang.String table, scala.collection.Seq<org.apache.spark.sql.catalyst.catalog.CatalogTablePartition> parts, boolean ignoreIfExists)  { throw new RuntimeException(); }
  public  void createTable (org.apache.spark.sql.catalyst.catalog.CatalogTable tableDefinition, boolean ignoreIfExists)  { throw new RuntimeException(); }
  public  boolean databaseExists (java.lang.String db)  { throw new RuntimeException(); }
  protected  void doPostEvent (org.apache.spark.sql.catalyst.catalog.ExternalCatalogEventListener listener, org.apache.spark.sql.catalyst.catalog.ExternalCatalogEvent event)  { throw new RuntimeException(); }
  public  void dropDatabase (java.lang.String db, boolean ignoreIfNotExists, boolean cascade)  { throw new RuntimeException(); }
  public  void dropFunction (java.lang.String db, java.lang.String funcName)  { throw new RuntimeException(); }
  public  void dropPartitions (java.lang.String db, java.lang.String table, scala.collection.Seq<scala.collection.immutable.Map<java.lang.String, java.lang.String>> partSpecs, boolean ignoreIfNotExists, boolean purge, boolean retainData)  { throw new RuntimeException(); }
  public  void dropTable (java.lang.String db, java.lang.String table, boolean ignoreIfNotExists, boolean purge)  { throw new RuntimeException(); }
  public  boolean functionExists (java.lang.String db, java.lang.String funcName)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.catalog.CatalogDatabase getDatabase (java.lang.String db)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.catalog.CatalogFunction getFunction (java.lang.String db, java.lang.String funcName)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.catalog.CatalogTablePartition getPartition (java.lang.String db, java.lang.String table, scala.collection.immutable.Map<java.lang.String, java.lang.String> spec)  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.catalog.CatalogTablePartition> getPartitionOption (java.lang.String db, java.lang.String table, scala.collection.immutable.Map<java.lang.String, java.lang.String> spec)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.catalog.CatalogTable getTable (java.lang.String db, java.lang.String table)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.catalog.CatalogTable> getTablesByName (java.lang.String db, scala.collection.Seq<java.lang.String> tables)  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> listDatabases ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> listDatabases (java.lang.String pattern)  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> listFunctions (java.lang.String db, java.lang.String pattern)  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> listPartitionNames (java.lang.String db, java.lang.String table, scala.Option<scala.collection.immutable.Map<java.lang.String, java.lang.String>> partialSpec)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.catalog.CatalogTablePartition> listPartitions (java.lang.String db, java.lang.String table, scala.Option<scala.collection.immutable.Map<java.lang.String, java.lang.String>> partialSpec)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.catalog.CatalogTablePartition> listPartitionsByFilter (java.lang.String db, java.lang.String table, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> predicates, java.lang.String defaultTimeZoneId)  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> listTables (java.lang.String db)  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> listTables (java.lang.String db, java.lang.String pattern)  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> listViews (java.lang.String db, java.lang.String pattern)  { throw new RuntimeException(); }
  public  void loadDynamicPartitions (java.lang.String db, java.lang.String table, java.lang.String loadPath, scala.collection.immutable.Map<java.lang.String, java.lang.String> partition, boolean replace, int numDP)  { throw new RuntimeException(); }
  public  void loadPartition (java.lang.String db, java.lang.String table, java.lang.String loadPath, scala.collection.immutable.Map<java.lang.String, java.lang.String> partition, boolean isOverwrite, boolean inheritTableSpecs, boolean isSrcLocal)  { throw new RuntimeException(); }
  public  void loadTable (java.lang.String db, java.lang.String table, java.lang.String loadPath, boolean isOverwrite, boolean isSrcLocal)  { throw new RuntimeException(); }
  public  void renameFunction (java.lang.String db, java.lang.String oldName, java.lang.String newName)  { throw new RuntimeException(); }
  public  void renamePartitions (java.lang.String db, java.lang.String table, scala.collection.Seq<scala.collection.immutable.Map<java.lang.String, java.lang.String>> specs, scala.collection.Seq<scala.collection.immutable.Map<java.lang.String, java.lang.String>> newSpecs)  { throw new RuntimeException(); }
  public  void renameTable (java.lang.String db, java.lang.String oldName, java.lang.String newName)  { throw new RuntimeException(); }
  public  void setCurrentDatabase (java.lang.String db)  { throw new RuntimeException(); }
  public  boolean tableExists (java.lang.String db, java.lang.String table)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.catalog.ExternalCatalog unwrapped ()  { throw new RuntimeException(); }
}
