package org.apache.spark.sql.execution.command;
/**
 * A command that add columns to a table
 * The syntax of using this command in SQL is:
 * <pre><code>
 *   ALTER TABLE table_identifier
 *   ADD COLUMNS (col_name data_type [COMMENT col_comment], ...);
 * </code></pre>
 */
public  class AlterTableAddColumnsCommand extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.execution.command.RunnableCommand, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.TableIdentifier table ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.StructField> colsToAdd ()  { throw new RuntimeException(); }
  // not preceding
  public   AlterTableAddColumnsCommand (org.apache.spark.sql.catalyst.TableIdentifier table, scala.collection.Seq<org.apache.spark.sql.types.StructField> colsToAdd)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.Row> run (org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
}
