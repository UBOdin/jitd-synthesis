package org.apache.spark.sql.execution.command;
/**
 * A command that shows the Spark DDL syntax that can be used to create a given table.
 * For Hive serde table, this command will generate Spark DDL that can be used to
 * create corresponding Spark table.
 * <p>
 * The syntax of using this command in SQL is:
 * <pre><code>
 *   SHOW CREATE TABLE [db_name.]table_name
 * </code></pre>
 */
public  class ShowCreateTableCommand extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.execution.command.RunnableCommand, org.apache.spark.sql.execution.command.ShowCreateTableCommandBase, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.TableIdentifier table ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  // not preceding
  public   ShowCreateTableCommand (org.apache.spark.sql.catalyst.TableIdentifier table, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.Row> run (org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
}
