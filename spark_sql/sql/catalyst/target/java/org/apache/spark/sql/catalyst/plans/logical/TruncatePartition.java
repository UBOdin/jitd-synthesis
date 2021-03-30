package org.apache.spark.sql.catalyst.plans.logical;
/**
 * The logical plan of the TRUNCATE TABLE ... PARTITION command.
 */
public  class TruncatePartition extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.catalyst.plans.logical.V2PartitionCommand, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan table ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.PartitionSpec partitionSpec ()  { throw new RuntimeException(); }
  // not preceding
  public   TruncatePartition (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan table, org.apache.spark.sql.catalyst.analysis.PartitionSpec partitionSpec)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> children ()  { throw new RuntimeException(); }
  public  boolean allowPartialPartitionSpec ()  { throw new RuntimeException(); }
}
