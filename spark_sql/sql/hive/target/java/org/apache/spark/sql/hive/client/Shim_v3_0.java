package org.apache.spark.sql.hive.client;
  class Shim_v3_0 extends org.apache.spark.sql.hive.client.Shim_v2_3 {
  public   Shim_v3_0 ()  { throw new RuntimeException(); }
  // not preceding
  protected  java.lang.Boolean isAcidIUDoperation ()  { throw new RuntimeException(); }
  // not preceding
  protected  java.lang.Integer listBucketingLevel ()  { throw new RuntimeException(); }
  public  void loadDynamicPartitions (org.apache.hadoop.hive.ql.metadata.Hive hive, org.apache.hadoop.fs.Path loadPath, java.lang.String tableName, java.util.Map<java.lang.String, java.lang.String> partSpec, boolean replace, int numDP, boolean listBucketingEnabled)  { throw new RuntimeException(); }
  public  void loadPartition (org.apache.hadoop.hive.ql.metadata.Hive hive, org.apache.hadoop.fs.Path loadPath, java.lang.String tableName, java.util.Map<java.lang.String, java.lang.String> partSpec, boolean replace, boolean inheritTableSpecs, boolean isSkewedStoreAsSubdir, boolean isSrcLocal)  { throw new RuntimeException(); }
  public  void loadTable (org.apache.hadoop.hive.ql.metadata.Hive hive, org.apache.hadoop.fs.Path loadPath, java.lang.String tableName, boolean replace, boolean isSrcLocal)  { throw new RuntimeException(); }
  // not preceding
  protected  java.lang.Integer stmtIdInLoadTableOrPartition ()  { throw new RuntimeException(); }
  // not preceding
  protected  java.lang.Long writeIdInLoadTableOrPartition ()  { throw new RuntimeException(); }
}
