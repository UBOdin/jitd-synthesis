package org.apache.spark.sql.execution.command;
/**
 * A command used to write the result of a query to a directory.
 * <p>
 * The syntax of using this command in SQL is:
 * <pre><code>
 *   INSERT OVERWRITE DIRECTORY (path=STRING)?
 *   USING format OPTIONS ([option1_name "option1_value", option2_name "option2_value", ...])
 *   SELECT ...
 * </code></pre>
 * <p>
 * param:  storage storage format used to describe how the query result is stored.
 * param:  provider the data source type to be used
 * param:  query the logical plan representing data to write to
 * param:  overwrite whether overwrites existing directory
 */
public  class InsertIntoDataSourceDirCommand extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.execution.command.RunnableCommand, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.catalog.CatalogStorageFormat storage ()  { throw new RuntimeException(); }
  public  java.lang.String provider ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan query ()  { throw new RuntimeException(); }
  public  boolean overwrite ()  { throw new RuntimeException(); }
  // not preceding
  public   InsertIntoDataSourceDirCommand (org.apache.spark.sql.catalyst.catalog.CatalogStorageFormat storage, java.lang.String provider, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan query, boolean overwrite)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> innerChildren ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.Row> run (org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
}
