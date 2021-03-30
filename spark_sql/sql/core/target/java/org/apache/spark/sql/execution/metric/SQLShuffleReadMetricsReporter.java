package org.apache.spark.sql.execution.metric;
/**
 * A shuffle metrics reporter for SQL exchange operators.
 * param:  tempMetrics {@link TempShuffleReadMetrics} created in TaskContext.
 * param:  metrics All metrics in current SparkPlan. This param should not empty and
 *   contains all shuffle metrics defined in createShuffleReadMetrics.
 */
public  class SQLShuffleReadMetricsReporter extends org.apache.spark.executor.TempShuffleReadMetrics {
  static public  java.lang.String REMOTE_BLOCKS_FETCHED ()  { throw new RuntimeException(); }
  static public  java.lang.String LOCAL_BLOCKS_FETCHED ()  { throw new RuntimeException(); }
  static public  java.lang.String REMOTE_BYTES_READ ()  { throw new RuntimeException(); }
  static public  java.lang.String REMOTE_BYTES_READ_TO_DISK ()  { throw new RuntimeException(); }
  static public  java.lang.String LOCAL_BYTES_READ ()  { throw new RuntimeException(); }
  static public  java.lang.String FETCH_WAIT_TIME ()  { throw new RuntimeException(); }
  static public  java.lang.String RECORDS_READ ()  { throw new RuntimeException(); }
  /**
   * Create all shuffle read relative metrics and return the Map.
   * @param sc (undocumented)
   * @return (undocumented)
   */
  static public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> createShuffleReadMetrics (org.apache.spark.SparkContext sc)  { throw new RuntimeException(); }
  public   SQLShuffleReadMetricsReporter (org.apache.spark.executor.TempShuffleReadMetrics tempMetrics, scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics)  { throw new RuntimeException(); }
  public  void incRemoteBlocksFetched (long v)  { throw new RuntimeException(); }
  public  void incLocalBlocksFetched (long v)  { throw new RuntimeException(); }
  public  void incRemoteBytesRead (long v)  { throw new RuntimeException(); }
  public  void incRemoteBytesReadToDisk (long v)  { throw new RuntimeException(); }
  public  void incLocalBytesRead (long v)  { throw new RuntimeException(); }
  public  void incFetchWaitTime (long v)  { throw new RuntimeException(); }
  public  void incRecordsRead (long v)  { throw new RuntimeException(); }
}
