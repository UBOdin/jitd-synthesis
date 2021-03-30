package org.apache.spark.sql.execution.streaming;
/**
 * A trigger executor that runs a single batch only, then terminates.
 */
public  class OneTimeExecutor implements org.apache.spark.sql.execution.streaming.TriggerExecutor, scala.Product, scala.Serializable {
  static public abstract  R apply ()  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public   OneTimeExecutor ()  { throw new RuntimeException(); }
  /**
   * Execute a single batch using <code>batchRunner</code>.
   * @param batchRunner (undocumented)
   */
  public  void execute (scala.Function0<java.lang.Object> batchRunner)  { throw new RuntimeException(); }
}
