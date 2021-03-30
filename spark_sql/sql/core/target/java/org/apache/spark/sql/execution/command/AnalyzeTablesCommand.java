package org.apache.spark.sql.execution.command;
/**
 * Analyzes all tables in the given database to generate statistics.
 */
public  class AnalyzeTablesCommand extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.execution.command.RunnableCommand, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> databaseName ()  { throw new RuntimeException(); }
  public  boolean noScan ()  { throw new RuntimeException(); }
  // not preceding
  public   AnalyzeTablesCommand (scala.Option<java.lang.String> databaseName, boolean noScan)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.Row> run (org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
}
