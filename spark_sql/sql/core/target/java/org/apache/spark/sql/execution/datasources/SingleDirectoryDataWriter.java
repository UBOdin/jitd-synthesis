package org.apache.spark.sql.execution.datasources;
/** Writes data to a single directory (used for non-dynamic-partition writes). */
public  class SingleDirectoryDataWriter extends org.apache.spark.sql.execution.datasources.FileFormatDataWriter {
  public   SingleDirectoryDataWriter (org.apache.spark.sql.execution.datasources.WriteJobDescription description, org.apache.hadoop.mapreduce.TaskAttemptContext taskAttemptContext, org.apache.spark.internal.io.FileCommitProtocol committer)  { throw new RuntimeException(); }
  public  void write (org.apache.spark.sql.catalyst.InternalRow record)  { throw new RuntimeException(); }
}
