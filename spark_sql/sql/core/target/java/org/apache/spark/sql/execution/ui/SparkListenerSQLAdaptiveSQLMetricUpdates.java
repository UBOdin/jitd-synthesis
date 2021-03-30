package org.apache.spark.sql.execution.ui;
public  class SparkListenerSQLAdaptiveSQLMetricUpdates implements org.apache.spark.scheduler.SparkListenerEvent, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  long executionId ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.execution.ui.SQLPlanMetric> sqlPlanMetrics ()  { throw new RuntimeException(); }
  // not preceding
  public   SparkListenerSQLAdaptiveSQLMetricUpdates (long executionId, scala.collection.Seq<org.apache.spark.sql.execution.ui.SQLPlanMetric> sqlPlanMetrics)  { throw new RuntimeException(); }
}
