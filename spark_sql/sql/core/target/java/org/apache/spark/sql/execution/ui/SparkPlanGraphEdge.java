package org.apache.spark.sql.execution.ui;
/**
 * Represent an edge in the SparkPlan tree. <code>fromId</code> is the child node id, and <code>toId</code> is the parent
 * node id.
 */
public  class SparkPlanGraphEdge implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  long fromId ()  { throw new RuntimeException(); }
  public  long toId ()  { throw new RuntimeException(); }
  // not preceding
  public   SparkPlanGraphEdge (long fromId, long toId)  { throw new RuntimeException(); }
  public  java.lang.String makeDotEdge ()  { throw new RuntimeException(); }
}
