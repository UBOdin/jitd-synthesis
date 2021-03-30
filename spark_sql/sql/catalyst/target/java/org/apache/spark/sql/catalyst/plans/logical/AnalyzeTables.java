package org.apache.spark.sql.catalyst.plans.logical;
/**
 * The logical plan of the ANALYZE TABLES command.
 */
public  class AnalyzeTables extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.catalyst.plans.logical.Command, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan namespace ()  { throw new RuntimeException(); }
  public  boolean noScan ()  { throw new RuntimeException(); }
  // not preceding
  public   AnalyzeTables (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan namespace, boolean noScan)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> children ()  { throw new RuntimeException(); }
}
