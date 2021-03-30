package org.apache.spark.sql.execution.command;
/**
 * Add Partition in ALTER TABLE: add the table partitions.
 * <p>
 * An error message will be issued if the partition exists, unless 'ifNotExists' is true.
 * <p>
 * The syntax of this command is:
 * <pre><code>
 *   ALTER TABLE table ADD [IF NOT EXISTS] PARTITION spec1 [LOCATION 'loc1']
 *                                         PARTITION spec2 [LOCATION 'loc2']
 * </code></pre>
 */
public  class AlterTableAddPartitionCommand extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.execution.command.RunnableCommand, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.TableIdentifier tableName ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<scala.Tuple2<scala.collection.immutable.Map<java.lang.String, java.lang.String>, scala.Option<java.lang.String>>> partitionSpecsAndLocs ()  { throw new RuntimeException(); }
  public  boolean ifNotExists ()  { throw new RuntimeException(); }
  // not preceding
  public   AlterTableAddPartitionCommand (org.apache.spark.sql.catalyst.TableIdentifier tableName, scala.collection.Seq<scala.Tuple2<scala.collection.immutable.Map<java.lang.String, java.lang.String>, scala.Option<java.lang.String>>> partitionSpecsAndLocs, boolean ifNotExists)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.Row> run (org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
}
