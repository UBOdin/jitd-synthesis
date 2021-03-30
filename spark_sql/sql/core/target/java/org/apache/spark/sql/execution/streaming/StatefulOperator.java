package org.apache.spark.sql.execution.streaming;
/**
 * An operator that reads or writes state from the {@link StateStore}.
 * The {@link StatefulOperatorStateInfo} should be filled in by <code>prepareForExecution</code> in
 * {@link IncrementalExecution}.
 */
public  interface StatefulOperator {
  public  org.apache.spark.sql.execution.streaming.StatefulOperatorStateInfo getStateInfo ()  ;
  public  scala.Option<org.apache.spark.sql.execution.streaming.StatefulOperatorStateInfo> stateInfo ()  ;
}
