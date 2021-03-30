package org.apache.spark.sql.execution;
public  class PartitionedFileUtil {
  static public  scala.collection.Seq<org.apache.spark.sql.execution.datasources.PartitionedFile> splitFiles (org.apache.spark.sql.SparkSession sparkSession, org.apache.hadoop.fs.FileStatus file, org.apache.hadoop.fs.Path filePath, boolean isSplitable, long maxSplitBytes, org.apache.spark.sql.catalyst.InternalRow partitionValues)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.execution.datasources.PartitionedFile getPartitionedFile (org.apache.hadoop.fs.FileStatus file, org.apache.hadoop.fs.Path filePath, org.apache.spark.sql.catalyst.InternalRow partitionValues)  { throw new RuntimeException(); }
}
