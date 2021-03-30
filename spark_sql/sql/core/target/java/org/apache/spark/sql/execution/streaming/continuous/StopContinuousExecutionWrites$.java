package org.apache.spark.sql.execution.streaming.continuous;
/**
 * The RpcEndpoint stop() will wait to clear out the message queue before terminating the
 * object. This can lead to a race condition where the query restarts at epoch n, a new
 * EpochCoordinator starts at epoch n, and then the old epoch coordinator commits epoch n + 1.
 * The framework doesn't provide a handle to wait on the message queue, so we use a synchronous
 * message to stop any writes to the ContinuousExecution object.
 */
public  class StopContinuousExecutionWrites$ implements org.apache.spark.sql.execution.streaming.continuous.EpochCoordinatorMessage, scala.Product, scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final StopContinuousExecutionWrites$ MODULE$ = null;
  public   StopContinuousExecutionWrites$ ()  { throw new RuntimeException(); }
}
