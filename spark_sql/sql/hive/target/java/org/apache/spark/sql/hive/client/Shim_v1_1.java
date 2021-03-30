package org.apache.spark.sql.hive.client;
  class Shim_v1_1 extends org.apache.spark.sql.hive.client.Shim_v1_0 {
  public   Shim_v1_1 ()  { throw new RuntimeException(); }
  public  void dropIndex (org.apache.hadoop.hive.ql.metadata.Hive hive, java.lang.String dbName, java.lang.String tableName, java.lang.String indexName)  { throw new RuntimeException(); }
  // not preceding
  protected  java.lang.Boolean throwExceptionInDropIndex ()  { throw new RuntimeException(); }
}
