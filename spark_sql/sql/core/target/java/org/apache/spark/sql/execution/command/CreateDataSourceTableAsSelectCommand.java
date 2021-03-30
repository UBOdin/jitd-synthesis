package org.apache.spark.sql.execution.command;
/**
 * A command used to create a data source table using the result of a query.
 * <p>
 * Note: This is different from <code>CreateHiveTableAsSelectCommand</code>. Please check the syntax for
 * difference. This is not intended for temporary tables.
 * <p>
 * The syntax of using this command in SQL is:
 * <pre><code>
 *   CREATE TABLE [IF NOT EXISTS] [db_name.]table_name
 *   USING format OPTIONS ([option1_name "option1_value", option2_name "option2_value", ...])
 *   AS SELECT ...
 * </code></pre>
 */
public  class CreateDataSourceTableAsSelectCommand extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.execution.command.DataWritingCommand, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.catalog.CatalogTable table ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.SaveMode mode ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan query ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> outputColumnNames ()  { throw new RuntimeException(); }
  // not preceding
  public   CreateDataSourceTableAsSelectCommand (org.apache.spark.sql.catalyst.catalog.CatalogTable table, org.apache.spark.sql.SaveMode mode, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan query, scala.collection.Seq<java.lang.String> outputColumnNames)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.Row> run (org.apache.spark.sql.SparkSession sparkSession, org.apache.spark.sql.execution.SparkPlan child)  { throw new RuntimeException(); }
}
