package org.apache.spark.sql.catalyst.plans.logical;
/**
 * The logical plan of the ALTER [TABLE|VIEW] ... RENAME TO command.
 */
public  class RenameTable extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.catalyst.plans.logical.Command, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> newName ()  { throw new RuntimeException(); }
  public  boolean isView ()  { throw new RuntimeException(); }
  // not preceding
  public   RenameTable (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child, scala.collection.Seq<java.lang.String> newName, boolean isView)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> children ()  { throw new RuntimeException(); }
}
