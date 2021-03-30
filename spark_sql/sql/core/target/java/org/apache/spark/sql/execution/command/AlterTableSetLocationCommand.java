package org.apache.spark.sql.execution.command;
/**
 * A command that sets the location of a table or a partition.
 * <p>
 * For normal tables, this just sets the location URI in the table/partition's storage format.
 * For datasource tables, this sets a "path" parameter in the table/partition's serde properties.
 * <p>
 * The syntax of this command is:
 * <pre><code>
 *    ALTER TABLE table_name [PARTITION partition_spec] SET LOCATION "loc";
 * </code></pre>
 */
public  class AlterTableSetLocationCommand extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.execution.command.RunnableCommand, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.TableIdentifier tableName ()  { throw new RuntimeException(); }
  public  scala.Option<scala.collection.immutable.Map<java.lang.String, java.lang.String>> partitionSpec ()  { throw new RuntimeException(); }
  public  java.lang.String location ()  { throw new RuntimeException(); }
  // not preceding
  public   AlterTableSetLocationCommand (org.apache.spark.sql.catalyst.TableIdentifier tableName, scala.Option<scala.collection.immutable.Map<java.lang.String, java.lang.String>> partitionSpec, java.lang.String location)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.Row> run (org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
}
