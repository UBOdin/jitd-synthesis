package org.apache.spark.sql.catalyst.plans.logical;
/**
 * The logical plan of the UNCACHE TABLE command.
 */
public  class UncacheTable extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.catalyst.plans.logical.Command, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan table ()  { throw new RuntimeException(); }
  public  boolean ifExists ()  { throw new RuntimeException(); }
  public  boolean isTempView ()  { throw new RuntimeException(); }
  // not preceding
  public   UncacheTable (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan table, boolean ifExists, boolean isTempView)  { throw new RuntimeException(); }
}
