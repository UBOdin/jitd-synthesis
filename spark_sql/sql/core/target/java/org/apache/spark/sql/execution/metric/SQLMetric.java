package org.apache.spark.sql.execution.metric;
/**
 * A metric used in a SQL query plan. This is implemented as an {@link AccumulatorV2}. Updates on
 * the executor side are automatically propagated and shown in the SQL UI through metrics. Updates
 * on the driver side must be explicitly posted using {@link SQLMetrics.postDriverMetricUpdates()}.
 */
public  class SQLMetric extends org.apache.spark.util.AccumulatorV2<java.lang.Object, java.lang.Object> {
  public  java.lang.String metricType ()  { throw new RuntimeException(); }
  // not preceding
  public   SQLMetric (java.lang.String metricType, long initValue)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.metric.SQLMetric copy ()  { throw new RuntimeException(); }
  public  void reset ()  { throw new RuntimeException(); }
  public  void merge (org.apache.spark.util.AccumulatorV2<java.lang.Object, java.lang.Object> other)  { throw new RuntimeException(); }
  public  boolean isZero ()  { throw new RuntimeException(); }
  public  void add (long v)  { throw new RuntimeException(); }
  public  void set (double v)  { throw new RuntimeException(); }
  public  void set (long v)  { throw new RuntimeException(); }
  public  long value ()  { throw new RuntimeException(); }
  public  org.apache.spark.scheduler.AccumulableInfo toInfo (scala.Option<java.lang.Object> update, scala.Option<java.lang.Object> value)  { throw new RuntimeException(); }
}
