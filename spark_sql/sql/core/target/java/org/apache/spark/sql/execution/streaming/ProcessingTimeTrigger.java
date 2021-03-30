package org.apache.spark.sql.execution.streaming;
/**
 * A {@link Trigger} that runs a query periodically based on the processing time. If <code>interval</code> is 0,
 * the query will run as fast as possible.
 */
public  class ProcessingTimeTrigger extends org.apache.spark.sql.streaming.Trigger implements scala.Product, scala.Serializable {
  static public  org.apache.spark.sql.execution.streaming.ProcessingTimeTrigger apply (java.lang.String interval)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.execution.streaming.ProcessingTimeTrigger apply (scala.concurrent.duration.Duration interval)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.execution.streaming.ProcessingTimeTrigger create (java.lang.String interval)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.execution.streaming.ProcessingTimeTrigger create (long interval, java.util.concurrent.TimeUnit unit)  { throw new RuntimeException(); }
  public  long intervalMs ()  { throw new RuntimeException(); }
  // not preceding
  public   ProcessingTimeTrigger (long intervalMs)  { throw new RuntimeException(); }
}
