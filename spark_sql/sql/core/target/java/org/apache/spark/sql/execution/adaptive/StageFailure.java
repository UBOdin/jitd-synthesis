package org.apache.spark.sql.execution.adaptive;
/**
 * The materialization of a query stage hit an error and failed.
 */
public  class StageFailure implements org.apache.spark.sql.execution.adaptive.StageMaterializationEvent, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.adaptive.QueryStageExec stage ()  { throw new RuntimeException(); }
  public  java.lang.Throwable error ()  { throw new RuntimeException(); }
  // not preceding
  public   StageFailure (org.apache.spark.sql.execution.adaptive.QueryStageExec stage, java.lang.Throwable error)  { throw new RuntimeException(); }
}
