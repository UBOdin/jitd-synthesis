package org.apache.spark.sql.execution.command;
/**
 * A command for users to add new (key, value) pairs into DBPROPERTIES
 * If the database does not exist, an error message will be issued to indicate the database
 * does not exist.
 * The syntax of using this command in SQL is:
 * <pre><code>
 *    ALTER (DATABASE|SCHEMA) database_name SET DBPROPERTIES (property_name=property_value, ...)
 * </code></pre>
 */
public  class AlterDatabasePropertiesCommand extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.execution.command.RunnableCommand, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  java.lang.String databaseName ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> props ()  { throw new RuntimeException(); }
  // not preceding
  public   AlterDatabasePropertiesCommand (java.lang.String databaseName, scala.collection.immutable.Map<java.lang.String, java.lang.String> props)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.Row> run (org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
}
