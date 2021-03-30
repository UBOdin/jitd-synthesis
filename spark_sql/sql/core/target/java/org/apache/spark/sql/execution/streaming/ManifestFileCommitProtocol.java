package org.apache.spark.sql.execution.streaming;
/**
 * A {@link FileCommitProtocol} that tracks the list of valid files in a manifest file, used in
 * structured streaming.
 * <p>
 * param:  path path to write the final output to.
 */
public  class ManifestFileCommitProtocol extends org.apache.spark.internal.io.FileCommitProtocol implements scala.Serializable, org.apache.spark.internal.Logging {
  public   ManifestFileCommitProtocol (java.lang.String jobId, java.lang.String path)  { throw new RuntimeException(); }
  public  void abortJob (org.apache.hadoop.mapreduce.JobContext jobContext)  { throw new RuntimeException(); }
  public  void abortTask (org.apache.hadoop.mapreduce.TaskAttemptContext taskContext)  { throw new RuntimeException(); }
  public  void commitJob (org.apache.hadoop.mapreduce.JobContext jobContext, scala.collection.Seq<org.apache.spark.internal.io.FileCommitProtocol.TaskCommitMessage> taskCommits)  { throw new RuntimeException(); }
  public  org.apache.spark.internal.io.FileCommitProtocol.TaskCommitMessage commitTask (org.apache.hadoop.mapreduce.TaskAttemptContext taskContext)  { throw new RuntimeException(); }
  public  java.lang.String newTaskTempFile (org.apache.hadoop.mapreduce.TaskAttemptContext taskContext, scala.Option<java.lang.String> dir, java.lang.String ext)  { throw new RuntimeException(); }
  public  java.lang.String newTaskTempFileAbsPath (org.apache.hadoop.mapreduce.TaskAttemptContext taskContext, java.lang.String absoluteDir, java.lang.String ext)  { throw new RuntimeException(); }
  public  void onTaskCommit (org.apache.spark.internal.io.FileCommitProtocol.TaskCommitMessage taskCommit)  { throw new RuntimeException(); }
  public  void setupJob (org.apache.hadoop.mapreduce.JobContext jobContext)  { throw new RuntimeException(); }
  /**
   * Sets up the manifest log output and the batch id for this job.
   * Must be called before any other function.
   * @param fileLog (undocumented)
   * @param batchId (undocumented)
   */
  public  void setupManifestOptions (org.apache.spark.sql.execution.streaming.FileStreamSinkLog fileLog, long batchId)  { throw new RuntimeException(); }
  public  void setupTask (org.apache.hadoop.mapreduce.TaskAttemptContext taskContext)  { throw new RuntimeException(); }
}
