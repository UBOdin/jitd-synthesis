package org.apache.spark.sql.execution.ui;
public  class SparkListenerSQLExecutionEnd implements org.apache.spark.scheduler.SparkListenerEvent, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  long executionId ()  { throw new RuntimeException(); }
  public  long time ()  { throw new RuntimeException(); }
  // not preceding
  public   SparkListenerSQLExecutionEnd (long executionId, long time)  { throw new RuntimeException(); }
    scala.Option<java.lang.String> executionName ()  { throw new RuntimeException(); }
    long duration ()  { throw new RuntimeException(); }
    org.apache.spark.sql.execution.QueryExecution qe ()  { throw new RuntimeException(); }
    scala.Option<java.lang.Throwable> executionFailure ()  { throw new RuntimeException(); }
}
