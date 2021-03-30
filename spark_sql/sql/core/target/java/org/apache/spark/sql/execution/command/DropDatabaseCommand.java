package org.apache.spark.sql.execution.command;
/**
 * A command for users to remove a database from the system.
 * <p>
 * 'ifExists':
 * - true, if database_name doesn't exist, no action
 * - false (default), if database_name doesn't exist, a warning message will be issued
 * 'cascade':
 * - true, the dependent objects are automatically dropped before dropping database.
 * - false (default), it is in the Restrict mode. The database cannot be dropped if
 * it is not empty. The inclusive tables must be dropped at first.
 * <p>
 * The syntax of using this command in SQL is:
 * <pre><code>
 *    DROP DATABASE [IF EXISTS] database_name [RESTRICT|CASCADE];
 * </code></pre>
 */
public  class DropDatabaseCommand extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.execution.command.RunnableCommand, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  java.lang.String databaseName ()  { throw new RuntimeException(); }
  public  boolean ifExists ()  { throw new RuntimeException(); }
  public  boolean cascade ()  { throw new RuntimeException(); }
  // not preceding
  public   DropDatabaseCommand (java.lang.String databaseName, boolean ifExists, boolean cascade)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.Row> run (org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
}
