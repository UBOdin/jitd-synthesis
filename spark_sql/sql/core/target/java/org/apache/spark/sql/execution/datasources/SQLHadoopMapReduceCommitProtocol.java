package org.apache.spark.sql.execution.datasources;
/**
 * A variant of {@link HadoopMapReduceCommitProtocol} that allows specifying the actual
 * Hadoop output committer using an option specified in SQLConf.
 */
public  class SQLHadoopMapReduceCommitProtocol extends org.apache.spark.internal.io.HadoopMapReduceCommitProtocol implements scala.Serializable, org.apache.spark.internal.Logging {
  public   SQLHadoopMapReduceCommitProtocol (java.lang.String jobId, java.lang.String path, boolean dynamicPartitionOverwrite)  { throw new RuntimeException(); }
  protected  org.apache.hadoop.mapreduce.OutputCommitter setupCommitter (org.apache.hadoop.mapreduce.TaskAttemptContext context)  { throw new RuntimeException(); }
}
