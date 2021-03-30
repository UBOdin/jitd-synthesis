package org.apache.spark.sql.execution.command;
/**
 * The DDL command that creates a function.
 * To create a temporary function, the syntax of using this command in SQL is:
 * <pre><code>
 *    CREATE [OR REPLACE] TEMPORARY FUNCTION functionName
 *    AS className [USING JAR\FILE 'uri' [, JAR|FILE 'uri'}
 * </code></pre>
 * <p>
 * To create a permanent function, the syntax in SQL is:
 * <pre><code>
 *    CREATE [OR REPLACE] FUNCTION [IF NOT EXISTS] [databaseName.]functionName
 *    AS className [USING JAR\FILE 'uri' [, JAR|FILE 'uri'}
 * </code></pre>
 * <p>
 * param:  ignoreIfExists: When true, ignore if the function with the specified name exists
 *                        in the specified database.
 * param:  replace: When true, alter the function with the specified name
 */
public  class CreateFunctionCommand extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.execution.command.RunnableCommand, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6, T7 v7)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> databaseName ()  { throw new RuntimeException(); }
  public  java.lang.String functionName ()  { throw new RuntimeException(); }
  public  java.lang.String className ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.catalog.FunctionResource> resources ()  { throw new RuntimeException(); }
  public  boolean isTemp ()  { throw new RuntimeException(); }
  public  boolean ignoreIfExists ()  { throw new RuntimeException(); }
  public  boolean replace ()  { throw new RuntimeException(); }
  // not preceding
  public   CreateFunctionCommand (scala.Option<java.lang.String> databaseName, java.lang.String functionName, java.lang.String className, scala.collection.Seq<org.apache.spark.sql.catalyst.catalog.FunctionResource> resources, boolean isTemp, boolean ignoreIfExists, boolean replace)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.Row> run (org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
}
