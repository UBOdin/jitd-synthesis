package org.apache.spark.sql.execution.datasources;
/** FileFormatWriteTask for empty partitions */
public  class EmptyDirectoryDataWriter extends org.apache.spark.sql.execution.datasources.FileFormatDataWriter {
  public   EmptyDirectoryDataWriter (org.apache.spark.sql.execution.datasources.WriteJobDescription description, org.apache.hadoop.mapreduce.TaskAttemptContext taskAttemptContext, org.apache.spark.internal.io.FileCommitProtocol committer)  { throw new RuntimeException(); }
  public  void write (org.apache.spark.sql.catalyst.InternalRow record)  { throw new RuntimeException(); }
}
