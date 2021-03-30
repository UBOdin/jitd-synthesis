package org.apache.spark.sql.catalyst.plans.logical;
/**
 * The logical plan of the DROP FUNCTION command.
 */
public  class DropFunction extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.catalyst.plans.logical.Command, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child ()  { throw new RuntimeException(); }
  public  boolean ifExists ()  { throw new RuntimeException(); }
  public  boolean isTemp ()  { throw new RuntimeException(); }
  // not preceding
  public   DropFunction (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child, boolean ifExists, boolean isTemp)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> children ()  { throw new RuntimeException(); }
}
