package org.apache.spark.sql.execution.streaming;
/**
 * A {@link Trigger} that continuously processes streaming data, asynchronously checkpointing at
 * the specified interval.
 */
public  class ContinuousTrigger extends org.apache.spark.sql.streaming.Trigger implements scala.Product, scala.Serializable {
  static public  org.apache.spark.sql.execution.streaming.ContinuousTrigger apply (java.lang.String interval)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.execution.streaming.ContinuousTrigger apply (scala.concurrent.duration.Duration interval)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.execution.streaming.ContinuousTrigger create (java.lang.String interval)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.execution.streaming.ContinuousTrigger create (long interval, java.util.concurrent.TimeUnit unit)  { throw new RuntimeException(); }
  public  long intervalMs ()  { throw new RuntimeException(); }
  // not preceding
  public   ContinuousTrigger (long intervalMs)  { throw new RuntimeException(); }
}
