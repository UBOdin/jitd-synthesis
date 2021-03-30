package org.apache.spark.sql.catalyst.plans.logical;
/**
 * The logical plan of the ALTER TABLE ADD PARTITION command.
 * <p>
 * The syntax of this command is:
 * <pre><code>
 *     ALTER TABLE table ADD [IF NOT EXISTS]
 *                 PARTITION spec1 [LOCATION 'loc1'][, PARTITION spec2 [LOCATION 'loc2'], ...];
 * </code></pre>
 */
public  class AddPartitions extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.catalyst.plans.logical.V2PartitionCommand, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan table ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.analysis.PartitionSpec> parts ()  { throw new RuntimeException(); }
  public  boolean ifNotExists ()  { throw new RuntimeException(); }
  // not preceding
  public   AddPartitions (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan table, scala.collection.Seq<org.apache.spark.sql.catalyst.analysis.PartitionSpec> parts, boolean ifNotExists)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> children ()  { throw new RuntimeException(); }
}
