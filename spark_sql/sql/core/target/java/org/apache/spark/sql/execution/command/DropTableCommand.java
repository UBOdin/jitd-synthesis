package org.apache.spark.sql.execution.command;
/**
 * Drops a table/view from the metastore and removes it if it is cached.
 * <p>
 * The syntax of this command is:
 * <pre><code>
 *   DROP TABLE [IF EXISTS] table_name;
 *   DROP VIEW [IF EXISTS] [db_name.]view_name;
 * </code></pre>
 */
public  class DropTableCommand extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.execution.command.RunnableCommand, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.TableIdentifier tableName ()  { throw new RuntimeException(); }
  public  boolean ifExists ()  { throw new RuntimeException(); }
  public  boolean isView ()  { throw new RuntimeException(); }
  public  boolean purge ()  { throw new RuntimeException(); }
  // not preceding
  public   DropTableCommand (org.apache.spark.sql.catalyst.TableIdentifier tableName, boolean ifExists, boolean isView, boolean purge)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.Row> run (org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
}
