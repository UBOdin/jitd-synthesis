package org.apache.spark.sql.execution.streaming;
/**
 * A trigger executor that runs a batch every <code>intervalMs</code> milliseconds.
 */
public  class ProcessingTimeExecutor implements org.apache.spark.sql.execution.streaming.TriggerExecutor, org.apache.spark.internal.Logging, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.streaming.ProcessingTimeTrigger processingTimeTrigger ()  { throw new RuntimeException(); }
  public  org.apache.spark.util.Clock clock ()  { throw new RuntimeException(); }
  // not preceding
  public   ProcessingTimeExecutor (org.apache.spark.sql.execution.streaming.ProcessingTimeTrigger processingTimeTrigger, org.apache.spark.util.Clock clock)  { throw new RuntimeException(); }
  public  void execute (scala.Function0<java.lang.Object> triggerHandler)  { throw new RuntimeException(); }
  /** Called when a batch falls behind */
  public  void notifyBatchFallingBehind (long realElapsedTimeMs)  { throw new RuntimeException(); }
  /**
   * Returns the start time in milliseconds for the next batch interval, given the current time.
   * Note that a batch interval is inclusive with respect to its start time, and thus calling
   * <code>nextBatchTime</code> with the result of a previous call should return the next interval. (i.e. given
   * an interval of <code>100 ms</code>, <code>nextBatchTime(nextBatchTime(0)) = 200</code> rather than <code>0</code>).
   * @param now (undocumented)
   * @return (undocumented)
   */
  public  long nextBatchTime (long now)  { throw new RuntimeException(); }
}
