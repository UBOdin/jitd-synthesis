package org.apache.spark.sql.execution.command;
/**
 * A command for users to get tables in the given database.
 * If a databaseName is not given, the current database will be used.
 * The syntax of using this command in SQL is:
 * <pre><code>
 *   SHOW TABLES [(IN|FROM) database_name] {&#64;link LIKE] 'identifier_with_wildcards'];
 *   SHOW TABLE EXTENDED [(IN|FROM) database_name] LIKE 'identifier_with_wildcards'
 *   [PARTITION(partition_spec)];
 * </code></pre>
 */
public  class ShowTablesCommand extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.execution.command.RunnableCommand, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> databaseName ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> tableIdentifierPattern ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  boolean isExtended ()  { throw new RuntimeException(); }
  public  scala.Option<scala.collection.immutable.Map<java.lang.String, java.lang.String>> partitionSpec ()  { throw new RuntimeException(); }
  // not preceding
  public   ShowTablesCommand (scala.Option<java.lang.String> databaseName, scala.Option<java.lang.String> tableIdentifierPattern, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output, boolean isExtended, scala.Option<scala.collection.immutable.Map<java.lang.String, java.lang.String>> partitionSpec)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.Row> run (org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
}
