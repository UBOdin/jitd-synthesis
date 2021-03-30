package org.apache.spark.sql.catalyst.plans.logical;
/**
 * The logical plan of the LOAD DATA INTO TABLE command.
 */
public  class LoadData extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.catalyst.plans.logical.Command, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child ()  { throw new RuntimeException(); }
  public  java.lang.String path ()  { throw new RuntimeException(); }
  public  boolean isLocal ()  { throw new RuntimeException(); }
  public  boolean isOverwrite ()  { throw new RuntimeException(); }
  public  scala.Option<scala.collection.immutable.Map<java.lang.String, java.lang.String>> partition ()  { throw new RuntimeException(); }
  // not preceding
  public   LoadData (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child, java.lang.String path, boolean isLocal, boolean isOverwrite, scala.Option<scala.collection.immutable.Map<java.lang.String, java.lang.String>> partition)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> children ()  { throw new RuntimeException(); }
}
