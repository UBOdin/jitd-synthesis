package org.apache.spark.sql.execution.ui;
public  class SQLPlanMetric implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  long accumulatorId ()  { throw new RuntimeException(); }
  public  java.lang.String metricType ()  { throw new RuntimeException(); }
  // not preceding
  public   SQLPlanMetric (java.lang.String name, long accumulatorId, java.lang.String metricType)  { throw new RuntimeException(); }
}
