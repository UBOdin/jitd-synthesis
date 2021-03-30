package org.apache.spark.sql.execution.metric;
public  class SQLShuffleWriteMetricsReporter$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final SQLShuffleWriteMetricsReporter$ MODULE$ = null;
  public   SQLShuffleWriteMetricsReporter$ ()  { throw new RuntimeException(); }
  public  java.lang.String SHUFFLE_BYTES_WRITTEN ()  { throw new RuntimeException(); }
  public  java.lang.String SHUFFLE_RECORDS_WRITTEN ()  { throw new RuntimeException(); }
  public  java.lang.String SHUFFLE_WRITE_TIME ()  { throw new RuntimeException(); }
  /**
   * Create all shuffle write relative metrics and return the Map.
   * @param sc (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> createShuffleWriteMetrics (org.apache.spark.SparkContext sc)  { throw new RuntimeException(); }
}
