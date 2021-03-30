package org.apache.spark.sql.execution.metric;
/**
 * A shuffle write metrics reporter for SQL exchange operators.
 * param:  metricsReporter Other reporter need to be updated in this SQLShuffleWriteMetricsReporter.
 * param:  metrics Shuffle write metrics in current SparkPlan.
 */
public  class SQLShuffleWriteMetricsReporter implements org.apache.spark.shuffle.ShuffleWriteMetricsReporter {
  static public  java.lang.String SHUFFLE_BYTES_WRITTEN ()  { throw new RuntimeException(); }
  static public  java.lang.String SHUFFLE_RECORDS_WRITTEN ()  { throw new RuntimeException(); }
  static public  java.lang.String SHUFFLE_WRITE_TIME ()  { throw new RuntimeException(); }
  /**
   * Create all shuffle write relative metrics and return the Map.
   * @param sc (undocumented)
   * @return (undocumented)
   */
  static public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> createShuffleWriteMetrics (org.apache.spark.SparkContext sc)  { throw new RuntimeException(); }
  public   SQLShuffleWriteMetricsReporter (org.apache.spark.shuffle.ShuffleWriteMetricsReporter metricsReporter, scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics)  { throw new RuntimeException(); }
  public  void incBytesWritten (long v)  { throw new RuntimeException(); }
  public  void decRecordsWritten (long v)  { throw new RuntimeException(); }
  public  void incRecordsWritten (long v)  { throw new RuntimeException(); }
  public  void incWriteTime (long v)  { throw new RuntimeException(); }
  public  void decBytesWritten (long v)  { throw new RuntimeException(); }
}
