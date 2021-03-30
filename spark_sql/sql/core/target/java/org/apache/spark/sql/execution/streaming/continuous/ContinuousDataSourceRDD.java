package org.apache.spark.sql.execution.streaming.continuous;
/**
 * The bottom-most RDD of a continuous processing read task. Wraps a {@link ContinuousQueuedDataReader}
 * to read from the remote source, and polls that queue for incoming rows.
 * <p>
 * Note that continuous processing calls compute() multiple times, and the same
 * {@link ContinuousQueuedDataReader} instance will/must be shared between each call for the same split.
 */
public  class ContinuousDataSourceRDD extends org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> {
  // not preceding
  public   ContinuousDataSourceRDD (org.apache.spark.SparkContext sc, int dataQueueSize, long epochPollIntervalMs, scala.collection.Seq<org.apache.spark.sql.connector.read.InputPartition> inputPartitions, org.apache.spark.sql.types.StructType schema, org.apache.spark.sql.connector.read.streaming.ContinuousPartitionReaderFactory partitionReaderFactory)  { throw new RuntimeException(); }
  /**
   * Initialize the shared reader for this partition if needed, then read rows from it until
   * it returns null to signal the end of the epoch.
   * @param split (undocumented)
   * @param context (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> compute (org.apache.spark.Partition split, org.apache.spark.TaskContext context)  { throw new RuntimeException(); }
  protected  org.apache.spark.Partition[] getPartitions ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> getPreferredLocations (org.apache.spark.Partition split)  { throw new RuntimeException(); }
}
