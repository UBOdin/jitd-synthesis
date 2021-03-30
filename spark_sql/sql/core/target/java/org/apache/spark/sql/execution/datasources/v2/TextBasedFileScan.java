package org.apache.spark.sql.execution.datasources.v2;
public abstract class TextBasedFileScan implements org.apache.spark.sql.execution.datasources.v2.FileScan {
  public   TextBasedFileScan (org.apache.spark.sql.SparkSession sparkSession, org.apache.spark.sql.util.CaseInsensitiveStringMap options)  { throw new RuntimeException(); }
  public  java.lang.String getFileUnSplittableReason (org.apache.hadoop.fs.Path path)  { throw new RuntimeException(); }
  public  boolean isSplitable (org.apache.hadoop.fs.Path path)  { throw new RuntimeException(); }
  public  int maxMetadataValueLength ()  { throw new RuntimeException(); }
}
