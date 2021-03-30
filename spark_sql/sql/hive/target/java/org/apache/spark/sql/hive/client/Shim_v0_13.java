package org.apache.spark.sql.hive.client;
  class Shim_v0_13 extends org.apache.spark.sql.hive.client.Shim_v0_12 {
  public   Shim_v0_13 ()  { throw new RuntimeException(); }
  public  void alterFunction (org.apache.hadoop.hive.ql.metadata.Hive hive, java.lang.String db, org.apache.spark.sql.catalyst.catalog.CatalogFunction func)  { throw new RuntimeException(); }
  /**
   * Converts catalyst expression to the format that Hive's getPartitionsByFilter() expects, i.e.
   * a string that represents partition predicates like "str_key=\"value\" and int_key=1 ...".
   * <p>
   * Unsupported predicates are skipped.
   * @param table (undocumented)
   * @param filters (undocumented)
   * @param timeZoneId (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String convertFilters (org.apache.hadoop.hive.ql.metadata.Table table, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> filters, java.lang.String timeZoneId)  { throw new RuntimeException(); }
  public  void createFunction (org.apache.hadoop.hive.ql.metadata.Hive hive, java.lang.String db, org.apache.spark.sql.catalyst.catalog.CatalogFunction func)  { throw new RuntimeException(); }
  public  void createPartitions (org.apache.hadoop.hive.ql.metadata.Hive hive, java.lang.String db, java.lang.String table, scala.collection.Seq<org.apache.spark.sql.catalyst.catalog.CatalogTablePartition> parts, boolean ignoreIfExists)  { throw new RuntimeException(); }
  public  void dropFunction (org.apache.hadoop.hive.ql.metadata.Hive hive, java.lang.String db, java.lang.String name)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.hadoop.hive.ql.metadata.Partition> getAllPartitions (org.apache.hadoop.hive.ql.metadata.Hive hive, org.apache.hadoop.hive.ql.metadata.Table table)  { throw new RuntimeException(); }
  public  org.apache.hadoop.hive.ql.processors.CommandProcessor getCommandProcessor (java.lang.String token, org.apache.hadoop.hive.conf.HiveConf conf)  { throw new RuntimeException(); }
  public  java.lang.String getDatabaseOwnerName (org.apache.hadoop.hive.metastore.api.Database db)  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> getDriverResults (org.apache.hadoop.hive.ql.Driver driver)  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.catalog.CatalogFunction> getFunctionOption (org.apache.hadoop.hive.ql.metadata.Hive hive, java.lang.String db, java.lang.String name)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.hadoop.hive.ql.metadata.Partition> getPartitionsByFilter (org.apache.hadoop.hive.ql.metadata.Hive hive, org.apache.hadoop.hive.ql.metadata.Table table, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> predicates, java.lang.String timeZoneId)  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> listFunctions (org.apache.hadoop.hive.ql.metadata.Hive hive, java.lang.String db, java.lang.String pattern)  { throw new RuntimeException(); }
  public  void renameFunction (org.apache.hadoop.hive.ql.metadata.Hive hive, java.lang.String db, java.lang.String oldName, java.lang.String newName)  { throw new RuntimeException(); }
  public  void setCurrentSessionState (org.apache.hadoop.hive.ql.session.SessionState state)  { throw new RuntimeException(); }
  public  void setDataLocation (org.apache.hadoop.hive.ql.metadata.Table table, java.lang.String loc)  { throw new RuntimeException(); }
  public  void setDatabaseOwnerName (org.apache.hadoop.hive.metastore.api.Database db, java.lang.String owner)  { throw new RuntimeException(); }
}
