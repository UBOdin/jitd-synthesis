package org.apache.spark.sql.execution.metric;
public  class SQLShuffleReadMetricsReporter$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final SQLShuffleReadMetricsReporter$ MODULE$ = null;
  public   SQLShuffleReadMetricsReporter$ ()  { throw new RuntimeException(); }
  public  java.lang.String REMOTE_BLOCKS_FETCHED ()  { throw new RuntimeException(); }
  public  java.lang.String LOCAL_BLOCKS_FETCHED ()  { throw new RuntimeException(); }
  public  java.lang.String REMOTE_BYTES_READ ()  { throw new RuntimeException(); }
  public  java.lang.String REMOTE_BYTES_READ_TO_DISK ()  { throw new RuntimeException(); }
  public  java.lang.String LOCAL_BYTES_READ ()  { throw new RuntimeException(); }
  public  java.lang.String FETCH_WAIT_TIME ()  { throw new RuntimeException(); }
  public  java.lang.String RECORDS_READ ()  { throw new RuntimeException(); }
  /**
   * Create all shuffle read relative metrics and return the Map.
   * @param sc (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> createShuffleReadMetrics (org.apache.spark.SparkContext sc)  { throw new RuntimeException(); }
}
