package org.apache.spark.sql.execution.streaming.continuous;
/**
 * An exception thrown when a continuous processing task runs with a nonzero attempt ID.
 */
public  class ContinuousTaskRetryException extends org.apache.spark.SparkException {
  public   ContinuousTaskRetryException ()  { throw new RuntimeException(); }
}
