package org.apache.spark.sql.streaming.ui;
/**
 * A customized StreamingQueryListener used in structured streaming UI, which contains all
 * UI data for both active and inactive query.
 */
  class StreamingQueryStatusListener extends org.apache.spark.sql.streaming.StreamingQueryListener {
  public   StreamingQueryStatusListener (org.apache.spark.SparkConf conf, org.apache.spark.status.ElementTrackingStore store)  { throw new RuntimeException(); }
  public  void onQueryProgress (org.apache.spark.sql.streaming.StreamingQueryListener.QueryProgressEvent event)  { throw new RuntimeException(); }
  public  void onQueryStarted (org.apache.spark.sql.streaming.StreamingQueryListener.QueryStartedEvent event)  { throw new RuntimeException(); }
  public  void onQueryTerminated (org.apache.spark.sql.streaming.StreamingQueryListener.QueryTerminatedEvent event)  { throw new RuntimeException(); }
}
