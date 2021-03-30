package org.apache.spark.sql.execution.streaming.continuous;
/**
 * The RpcEndpoint stop() will wait to clear out the message queue before terminating the
 * object. This can lead to a race condition where the query restarts at epoch n, a new
 * EpochCoordinator starts at epoch n, and then the old epoch coordinator commits epoch n + 1.
 * The framework doesn't provide a handle to wait on the message queue, so we use a synchronous
 * message to stop any writes to the ContinuousExecution object.
 */
public  class StopContinuousExecutionWrites {
  static public abstract  boolean canEqual (Object that)  ;
  static public abstract  boolean equals (Object that)  ;
  static public abstract  Object productElement (int n)  ;
  static public abstract  int productArity ()  ;
  static public  scala.collection.Iterator<java.lang.Object> productIterator ()  { throw new RuntimeException(); }
  static public  java.lang.String productPrefix ()  { throw new RuntimeException(); }
}
