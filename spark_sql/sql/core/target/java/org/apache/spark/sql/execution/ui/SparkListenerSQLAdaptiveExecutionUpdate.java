package org.apache.spark.sql.execution.ui;
public  class SparkListenerSQLAdaptiveExecutionUpdate implements org.apache.spark.scheduler.SparkListenerEvent, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  long executionId ()  { throw new RuntimeException(); }
  public  java.lang.String physicalPlanDescription ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlanInfo sparkPlanInfo ()  { throw new RuntimeException(); }
  // not preceding
  public   SparkListenerSQLAdaptiveExecutionUpdate (long executionId, java.lang.String physicalPlanDescription, org.apache.spark.sql.execution.SparkPlanInfo sparkPlanInfo)  { throw new RuntimeException(); }
}
