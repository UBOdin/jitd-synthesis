package org.apache.spark.sql.execution.command;
/**
 * A command to list the partition names of a table. If the partition spec is specified,
 * partitions that match the spec are returned. {@link AnalysisException} exception is thrown under
 * the following conditions:
 * <p>
 * 1. If the command is called for a non partitioned table.
 * 2. If the partition spec refers to the columns that are not defined as partitioning columns.
 * <p>
 * The syntax of using this command in SQL is:
 * <pre><code>
 *   SHOW PARTITIONS [db_name.]table_name [PARTITION(partition_spec)]
 * </code></pre>
 */
public  class ShowPartitionsCommand extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.execution.command.RunnableCommand, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.TableIdentifier tableName ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  scala.Option<scala.collection.immutable.Map<java.lang.String, java.lang.String>> spec ()  { throw new RuntimeException(); }
  // not preceding
  public   ShowPartitionsCommand (org.apache.spark.sql.catalyst.TableIdentifier tableName, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output, scala.Option<scala.collection.immutable.Map<java.lang.String, java.lang.String>> spec)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.Row> run (org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
}
