package org.apache.spark.sql.hive.client;
  class Shim_v2_1 extends org.apache.spark.sql.hive.client.Shim_v2_0 {
  public   Shim_v2_1 ()  { throw new RuntimeException(); }
  public  void alterPartitions (org.apache.hadoop.hive.ql.metadata.Hive hive, java.lang.String tableName, java.util.List<org.apache.hadoop.hive.ql.metadata.Partition> newParts)  { throw new RuntimeException(); }
  public  void alterTable (org.apache.hadoop.hive.ql.metadata.Hive hive, java.lang.String tableName, org.apache.hadoop.hive.ql.metadata.Table table)  { throw new RuntimeException(); }
  // not preceding
  protected  scala.runtime.Null$ environmentContextInAlterTable ()  { throw new RuntimeException(); }
  // not preceding
  protected  java.lang.Boolean hasFollowingStatsTask ()  { throw new RuntimeException(); }
  public  void loadDynamicPartitions (org.apache.hadoop.hive.ql.metadata.Hive hive, org.apache.hadoop.fs.Path loadPath, java.lang.String tableName, java.util.Map<java.lang.String, java.lang.String> partSpec, boolean replace, int numDP, boolean listBucketingEnabled)  { throw new RuntimeException(); }
  public  void loadPartition (org.apache.hadoop.hive.ql.metadata.Hive hive, org.apache.hadoop.fs.Path loadPath, java.lang.String tableName, java.util.Map<java.lang.String, java.lang.String> partSpec, boolean replace, boolean inheritTableSpecs, boolean isSkewedStoreAsSubdir, boolean isSrcLocal)  { throw new RuntimeException(); }
  public  void loadTable (org.apache.hadoop.hive.ql.metadata.Hive hive, org.apache.hadoop.fs.Path loadPath, java.lang.String tableName, boolean replace, boolean isSrcLocal)  { throw new RuntimeException(); }
}
