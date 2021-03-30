package org.apache.spark.sql.execution.datasources;
/**
 * Simple {@link WriteTaskStatsTracker} implementation that produces {@link BasicWriteTaskStats}.
 */
public  class BasicWriteTaskStatsTracker implements org.apache.spark.sql.execution.datasources.WriteTaskStatsTracker, org.apache.spark.internal.Logging {
  public   BasicWriteTaskStatsTracker (org.apache.hadoop.conf.Configuration hadoopConf)  { throw new RuntimeException(); }
  /**
   * Get the size of the file expected to have been written by a worker.
   * This supports the XAttr in HADOOP-17414 when the "magic committer" adds
   * a custom HTTP header to the a zero byte marker.
   * If the output file as returned by getFileStatus > 0 then the length if
   * returned. For zero-byte files, the (optional) Hadoop FS API getXAttr() is
   * invoked. If a parseable, non-negative length can be retrieved, this
   * is returned instead of the length.
   * @return the file size or None if the file was not found.
   * @param fs (undocumented)
   * @param path (undocumented)
   */
    scala.Option<java.lang.Object> getFileSize (org.apache.hadoop.fs.FileSystem fs, org.apache.hadoop.fs.Path path)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.datasources.WriteTaskStats getFinalStats ()  { throw new RuntimeException(); }
  public  void newBucket (int bucketId)  { throw new RuntimeException(); }
  public  void newFile (java.lang.String filePath)  { throw new RuntimeException(); }
  public  void newPartition (org.apache.spark.sql.catalyst.InternalRow partitionValues)  { throw new RuntimeException(); }
  public  void newRow (org.apache.spark.sql.catalyst.InternalRow row)  { throw new RuntimeException(); }
}
