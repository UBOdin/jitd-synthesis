package org.apache.spark.sql.hive.execution;
public  class HiveOutputWriter extends org.apache.spark.sql.execution.datasources.OutputWriter implements org.apache.spark.sql.hive.HiveInspectors {
  public   HiveOutputWriter (java.lang.String path, org.apache.spark.sql.hive.HiveShim.ShimFileSinkDesc fileSinkConf, org.apache.hadoop.mapred.JobConf jobConf, org.apache.spark.sql.types.StructType dataSchema)  { throw new RuntimeException(); }
  public  void close ()  { throw new RuntimeException(); }
  public  void write (org.apache.spark.sql.catalyst.InternalRow row)  { throw new RuntimeException(); }
}
