package org.apache.spark.sql.execution.command;
/**
 * A command for users to create a new database.
 * <p>
 * It will issue an error message when the database with the same name already exists,
 * unless 'ifNotExists' is true.
 * The syntax of using this command in SQL is:
 * <pre><code>
 *   CREATE (DATABASE|SCHEMA) [IF NOT EXISTS] database_name
 *     [COMMENT database_comment]
 *     [LOCATION database_directory]
 *     [WITH DBPROPERTIES (property_name=property_value, ...)];
 * </code></pre>
 */
public  class CreateDatabaseCommand extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.execution.command.RunnableCommand, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  java.lang.String databaseName ()  { throw new RuntimeException(); }
  public  boolean ifNotExists ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> path ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> comment ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> props ()  { throw new RuntimeException(); }
  // not preceding
  public   CreateDatabaseCommand (java.lang.String databaseName, boolean ifNotExists, scala.Option<java.lang.String> path, scala.Option<java.lang.String> comment, scala.collection.immutable.Map<java.lang.String, java.lang.String> props)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.Row> run (org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
}
