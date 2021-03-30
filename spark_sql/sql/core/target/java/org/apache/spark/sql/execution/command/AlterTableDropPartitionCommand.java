package org.apache.spark.sql.execution.command;
/**
 * Drop Partition in ALTER TABLE: to drop a particular partition for a table.
 * <p>
 * This removes the data and metadata for this partition.
 * The data is actually moved to the .Trash/Current directory if Trash is configured,
 * unless 'purge' is true, but the metadata is completely lost.
 * An error message will be issued if the partition does not exist, unless 'ifExists' is true.
 * Note: purge is always false when the target is a view.
 * <p>
 * The syntax of this command is:
 * <pre><code>
 *   ALTER TABLE table DROP [IF EXISTS] PARTITION spec1[, PARTITION spec2, ...] [PURGE];
 * </code></pre>
 */
public  class AlterTableDropPartitionCommand extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.execution.command.RunnableCommand, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.TableIdentifier tableName ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<scala.collection.immutable.Map<java.lang.String, java.lang.String>> specs ()  { throw new RuntimeException(); }
  public  boolean ifExists ()  { throw new RuntimeException(); }
  public  boolean purge ()  { throw new RuntimeException(); }
  public  boolean retainData ()  { throw new RuntimeException(); }
  // not preceding
  public   AlterTableDropPartitionCommand (org.apache.spark.sql.catalyst.TableIdentifier tableName, scala.collection.Seq<scala.collection.immutable.Map<java.lang.String, java.lang.String>> specs, boolean ifExists, boolean purge, boolean retainData)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.Row> run (org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
}
