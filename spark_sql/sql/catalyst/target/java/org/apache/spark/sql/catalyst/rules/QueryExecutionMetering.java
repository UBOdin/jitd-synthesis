package org.apache.spark.sql.catalyst.rules;
public  class QueryExecutionMetering implements scala.Product, scala.Serializable {
  static public abstract  R apply ()  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public   QueryExecutionMetering ()  { throw new RuntimeException(); }
  /** Resets statistics about time spent running specific rules */
  public  void resetMetrics ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.rules.QueryExecutionMetrics getMetrics ()  { throw new RuntimeException(); }
  public  long totalTime ()  { throw new RuntimeException(); }
  public  long totalNumRuns ()  { throw new RuntimeException(); }
  public  long totalNumEffectiveRuns ()  { throw new RuntimeException(); }
  public  long totalEffectiveTime ()  { throw new RuntimeException(); }
  public  void incExecutionTimeBy (java.lang.String ruleName, long delta)  { throw new RuntimeException(); }
  public  void incTimeEffectiveExecutionBy (java.lang.String ruleName, long delta)  { throw new RuntimeException(); }
  public  void incNumEffectiveExecution (java.lang.String ruleName)  { throw new RuntimeException(); }
  public  void incNumExecution (java.lang.String ruleName)  { throw new RuntimeException(); }
  /** Dump statistics about time spent running specific rules. */
  public  java.lang.String dumpTimeSpent ()  { throw new RuntimeException(); }
}
