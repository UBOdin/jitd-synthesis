package org.apache.spark.sql.execution.command;
/**
 * A command for users to refresh the persistent function.
 * The syntax of using this command in SQL is:
 * <pre><code>
 *    REFRESH FUNCTION functionName
 * </code></pre>
 */
public  class RefreshFunctionCommand extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.execution.command.RunnableCommand, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> databaseName ()  { throw new RuntimeException(); }
  public  java.lang.String functionName ()  { throw new RuntimeException(); }
  // not preceding
  public   RefreshFunctionCommand (scala.Option<java.lang.String> databaseName, java.lang.String functionName)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.Row> run (org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
}
