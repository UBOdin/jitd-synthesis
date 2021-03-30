package org.apache.spark.sql.execution.command;
/**
 * A command to refresh all cached entries associated with the table.
 * <p>
 * The syntax of using this command in SQL is:
 * <pre><code>
 *   REFRESH TABLE [db_name.]table_name
 * </code></pre>
 */
public  class RefreshTableCommand extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.execution.command.RunnableCommand, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.TableIdentifier tableIdent ()  { throw new RuntimeException(); }
  // not preceding
  public   RefreshTableCommand (org.apache.spark.sql.catalyst.TableIdentifier tableIdent)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.Row> run (org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
}
