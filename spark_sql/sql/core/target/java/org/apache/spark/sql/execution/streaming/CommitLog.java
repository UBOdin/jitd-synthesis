package org.apache.spark.sql.execution.streaming;
/**
 * Used to write log files that represent batch commit points in structured streaming.
 * A commit log file will be written immediately after the successful completion of a
 * batch, and before processing the next batch. Here is an execution summary:
 * - trigger batch 1
 * - obtain batch 1 offsets and write to offset log
 * - process batch 1
 * - write batch 1 to completion log
 * - trigger batch 2
 * - obtain batch 2 offsets and write to offset log
 * - process batch 2
 * - write batch 2 to completion log
 * ....
 * <p>
 * The current format of the batch completion log is:
 * line 1: version
 * line 2: metadata (optional json string)
 */
public  class CommitLog extends org.apache.spark.sql.execution.streaming.HDFSMetadataLog<org.apache.spark.sql.execution.streaming.CommitMetadata> {
  public   CommitLog (org.apache.spark.sql.SparkSession sparkSession, java.lang.String path)  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.execution.streaming.CommitMetadata deserialize (java.io.InputStream in)  { throw new RuntimeException(); }
  protected  void serialize (org.apache.spark.sql.execution.streaming.CommitMetadata metadata, java.io.OutputStream out)  { throw new RuntimeException(); }
}
