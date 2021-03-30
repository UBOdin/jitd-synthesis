package org.apache.spark.sql.execution.ui;
public  class SparkListenerSQLExecutionStart implements org.apache.spark.scheduler.SparkListenerEvent, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  long executionId ()  { throw new RuntimeException(); }
  public  java.lang.String description ()  { throw new RuntimeException(); }
  public  java.lang.String details ()  { throw new RuntimeException(); }
  public  java.lang.String physicalPlanDescription ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlanInfo sparkPlanInfo ()  { throw new RuntimeException(); }
  public  long time ()  { throw new RuntimeException(); }
  // not preceding
  public   SparkListenerSQLExecutionStart (long executionId, java.lang.String description, java.lang.String details, java.lang.String physicalPlanDescription, org.apache.spark.sql.execution.SparkPlanInfo sparkPlanInfo, long time)  { throw new RuntimeException(); }
}
