package org.apache.spark.sql.catalyst.plans.logical;
/**
 * The logical plan of the ALTER TABLE ... RENAME TO PARTITION command.
 */
public  class RenamePartitions extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.catalyst.plans.logical.V2PartitionCommand, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan table ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.PartitionSpec from ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.PartitionSpec to ()  { throw new RuntimeException(); }
  // not preceding
  public   RenamePartitions (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan table, org.apache.spark.sql.catalyst.analysis.PartitionSpec from, org.apache.spark.sql.catalyst.analysis.PartitionSpec to)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> children ()  { throw new RuntimeException(); }
}
