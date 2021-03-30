package org.apache.spark.sql.catalyst.plans.logical;
/**
 * The logical plan of the ALTER TABLE DROP PARTITION command.
 * This may remove the data and metadata for this partition.
 * <p>
 * If the <code>PURGE</code> option is set, the table catalog must remove partition data by skipping the trash
 * even when the catalog has configured one. The option is applicable only for managed tables.
 * <p>
 * The syntax of this command is:
 * <pre><code>
 *     ALTER TABLE table DROP [IF EXISTS] PARTITION spec1[, PARTITION spec2, ...] [PURGE];
 * </code></pre>
 */
public  class DropPartitions extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.catalyst.plans.logical.V2PartitionCommand, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan table ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.analysis.PartitionSpec> parts ()  { throw new RuntimeException(); }
  public  boolean ifExists ()  { throw new RuntimeException(); }
  public  boolean purge ()  { throw new RuntimeException(); }
  // not preceding
  public   DropPartitions (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan table, scala.collection.Seq<org.apache.spark.sql.catalyst.analysis.PartitionSpec> parts, boolean ifExists, boolean purge)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> children ()  { throw new RuntimeException(); }
}
