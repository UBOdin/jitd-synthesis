package org.apache.spark.sql.execution.adaptive;
/**
 * The materialization of a query stage completed with success.
 */
public  class StageSuccess implements org.apache.spark.sql.execution.adaptive.StageMaterializationEvent, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.adaptive.QueryStageExec stage ()  { throw new RuntimeException(); }
  public  Object result ()  { throw new RuntimeException(); }
  // not preceding
  public   StageSuccess (org.apache.spark.sql.execution.adaptive.QueryStageExec stage, Object result)  { throw new RuntimeException(); }
}
