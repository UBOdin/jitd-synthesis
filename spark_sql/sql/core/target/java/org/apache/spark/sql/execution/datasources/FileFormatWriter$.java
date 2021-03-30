package org.apache.spark.sql.execution.datasources;
/** A helper object for writing FileFormat data out to a location. */
public  class FileFormatWriter$ implements org.apache.spark.internal.Logging {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final FileFormatWriter$ MODULE$ = null;
  public   FileFormatWriter$ ()  { throw new RuntimeException(); }
  /**
   * Basic work flow of this command is:
   * 1. Driver side setup, including output committer initialization and data source specific
   *    preparation work for the write job to be issued.
   * 2. Issues a write job consists of one or more executor side tasks, each of which writes all
   *    rows within an RDD partition.
   * 3. If no exception is thrown in a task, commits that task, otherwise aborts that task;  If any
   *    exception is thrown during task commitment, also aborts that task.
   * 4. If all tasks are committed, commit the job, otherwise aborts the job;  If any exception is
   *    thrown during job commitment, also aborts the job.
   * 5. If the job is successfully committed, perform post-commit operations such as
   *    processing statistics.
   * @return The set of all partition paths that were updated during this write job.
   * @param sparkSession (undocumented)
   * @param plan (undocumented)
   * @param fileFormat (undocumented)
   * @param committer (undocumented)
   * @param outputSpec (undocumented)
   * @param hadoopConf (undocumented)
   * @param partitionColumns (undocumented)
   * @param bucketSpec (undocumented)
   * @param statsTrackers (undocumented)
   * @param options (undocumented)
   */
  public  scala.collection.immutable.Set<java.lang.String> write (org.apache.spark.sql.SparkSession sparkSession, org.apache.spark.sql.execution.SparkPlan plan, org.apache.spark.sql.execution.datasources.FileFormat fileFormat, org.apache.spark.internal.io.FileCommitProtocol committer, org.apache.spark.sql.execution.datasources.FileFormatWriter.OutputSpec outputSpec, org.apache.hadoop.conf.Configuration hadoopConf, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> partitionColumns, scala.Option<org.apache.spark.sql.catalyst.catalog.BucketSpec> bucketSpec, scala.collection.Seq<org.apache.spark.sql.execution.datasources.WriteJobStatsTracker> statsTrackers, scala.collection.immutable.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  /**
   * For every registered {@link WriteJobStatsTracker}, call <code>processStats()</code> on it, passing it
   * the corresponding {@link WriteTaskStats} from all executors.
   * @param statsTrackers (undocumented)
   * @param statsPerTask (undocumented)
   */
    void processStats (scala.collection.Seq<org.apache.spark.sql.execution.datasources.WriteJobStatsTracker> statsTrackers, scala.collection.Seq<scala.collection.Seq<org.apache.spark.sql.execution.datasources.WriteTaskStats>> statsPerTask)  { throw new RuntimeException(); }
}
