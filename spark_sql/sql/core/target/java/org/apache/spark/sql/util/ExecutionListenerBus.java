package org.apache.spark.sql.util;
  class ExecutionListenerBus extends org.apache.spark.scheduler.SparkListener implements org.apache.spark.util.ListenerBus<org.apache.spark.sql.util.QueryExecutionListener, org.apache.spark.sql.execution.ui.SparkListenerSQLExecutionEnd> {
  public   ExecutionListenerBus (java.lang.String sessionUUID)  { throw new RuntimeException(); }
  protected  void doPostEvent (org.apache.spark.sql.util.QueryExecutionListener listener, org.apache.spark.sql.execution.ui.SparkListenerSQLExecutionEnd event)  { throw new RuntimeException(); }
  public  void onOtherEvent (org.apache.spark.scheduler.SparkListenerEvent event)  { throw new RuntimeException(); }
}
