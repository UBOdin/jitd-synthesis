package org.apache.spark.sql.execution.streaming;
/**
 * Serves metrics from a {@link org.apache.spark.sql.streaming.StreamingQuery} to
 * Codahale/DropWizard metrics
 */
public  class MetricsReporter implements org.apache.spark.metrics.source.Source, org.apache.spark.internal.Logging {
  // not preceding
  public   MetricsReporter (org.apache.spark.sql.execution.streaming.StreamExecution stream, java.lang.String sourceName)  { throw new RuntimeException(); }
  public  com.codahale.metrics.MetricRegistry metricRegistry ()  { throw new RuntimeException(); }
  public  java.lang.String sourceName ()  { throw new RuntimeException(); }
}
