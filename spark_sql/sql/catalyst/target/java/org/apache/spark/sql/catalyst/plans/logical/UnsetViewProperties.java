package org.apache.spark.sql.catalyst.plans.logical;
/**
 * The logical plan of the ALTER VIEW ... UNSET TBLPROPERTIES command.
 */
public  class UnsetViewProperties extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.catalyst.plans.logical.Command, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> propertyKeys ()  { throw new RuntimeException(); }
  public  boolean ifExists ()  { throw new RuntimeException(); }
  // not preceding
  public   UnsetViewProperties (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child, scala.collection.Seq<java.lang.String> propertyKeys, boolean ifExists)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> children ()  { throw new RuntimeException(); }
}
