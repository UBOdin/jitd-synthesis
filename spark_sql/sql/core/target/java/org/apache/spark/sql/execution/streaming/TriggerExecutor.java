package org.apache.spark.sql.execution.streaming;
public  interface TriggerExecutor {
  /**
   * Execute batches using <code>batchRunner</code>. If <code>batchRunner</code> runs <code>false</code>, terminate the execution.
   * @param batchRunner (undocumented)
   */
  public  void execute (scala.Function0<java.lang.Object> batchRunner)  ;
}
