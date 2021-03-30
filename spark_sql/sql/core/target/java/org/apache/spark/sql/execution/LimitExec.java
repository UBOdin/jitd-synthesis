package org.apache.spark.sql.execution;
/**
 * The operator takes limited number of elements from its child operator.
 */
public  interface LimitExec extends org.apache.spark.sql.execution.UnaryExecNode {
  /** Number of element should be taken from child operator */
  public  int limit ()  ;
}
