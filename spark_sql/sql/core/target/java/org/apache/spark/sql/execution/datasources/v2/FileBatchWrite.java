package org.apache.spark.sql.execution.datasources.v2;
public  class FileBatchWrite implements org.apache.spark.sql.connector.write.BatchWrite, org.apache.spark.internal.Logging {
  public   FileBatchWrite (org.apache.hadoop.mapreduce.Job job, org.apache.spark.sql.execution.datasources.WriteJobDescription description, org.apache.spark.internal.io.FileCommitProtocol committer)  { throw new RuntimeException(); }
  public  void abort (org.apache.spark.sql.connector.write.WriterCommitMessage[] messages)  { throw new RuntimeException(); }
  public  void commit (org.apache.spark.sql.connector.write.WriterCommitMessage[] messages)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.write.DataWriterFactory createBatchWriterFactory (org.apache.spark.sql.connector.write.PhysicalWriteInfo info)  { throw new RuntimeException(); }
  public  boolean useCommitCoordinator ()  { throw new RuntimeException(); }
}
