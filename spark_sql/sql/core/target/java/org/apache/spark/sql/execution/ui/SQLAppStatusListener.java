package org.apache.spark.sql.execution.ui;
public  class SQLAppStatusListener extends org.apache.spark.scheduler.SparkListener implements org.apache.spark.internal.Logging {
  static public  int UNKNOWN_INDEX ()  { throw new RuntimeException(); }
  public   SQLAppStatusListener (org.apache.spark.SparkConf conf, org.apache.spark.status.ElementTrackingStore kvstore, boolean live)  { throw new RuntimeException(); }
    boolean noLiveData ()  { throw new RuntimeException(); }
  public  void onJobStart (org.apache.spark.scheduler.SparkListenerJobStart event)  { throw new RuntimeException(); }
  public  void onStageSubmitted (org.apache.spark.scheduler.SparkListenerStageSubmitted event)  { throw new RuntimeException(); }
  public  void onJobEnd (org.apache.spark.scheduler.SparkListenerJobEnd event)  { throw new RuntimeException(); }
  public  void onExecutorMetricsUpdate (org.apache.spark.scheduler.SparkListenerExecutorMetricsUpdate event)  { throw new RuntimeException(); }
  public  void onTaskStart (org.apache.spark.scheduler.SparkListenerTaskStart event)  { throw new RuntimeException(); }
  public  void onTaskEnd (org.apache.spark.scheduler.SparkListenerTaskEnd event)  { throw new RuntimeException(); }
  public  scala.Option<scala.collection.immutable.Map<java.lang.Object, java.lang.String>> liveExecutionMetrics (long executionId)  { throw new RuntimeException(); }
  public  void onOtherEvent (org.apache.spark.scheduler.SparkListenerEvent event)  { throw new RuntimeException(); }
}
