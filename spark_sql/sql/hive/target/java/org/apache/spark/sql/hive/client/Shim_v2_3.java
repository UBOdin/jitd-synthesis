package org.apache.spark.sql.hive.client;
  class Shim_v2_3 extends org.apache.spark.sql.hive.client.Shim_v2_1 {
  public   Shim_v2_3 ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> getTablesByType (org.apache.hadoop.hive.ql.metadata.Hive hive, java.lang.String dbName, java.lang.String pattern, org.apache.hadoop.hive.metastore.TableType tableType)  { throw new RuntimeException(); }
}
