package org.apache.spark.sql.execution.command;
/**
 * A command to change the column for a table, only support changing the comment of a non-partition
 * column for now.
 * <p>
 * The syntax of using this command in SQL is:
 * <pre><code>
 *   ALTER TABLE table_identifier
 *   CHANGE [COLUMN] column_old_name column_new_name column_dataType [COMMENT column_comment]
 *   [FIRST | AFTER column_name];
 * </code></pre>
 */
public  class AlterTableChangeColumnCommand extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.execution.command.RunnableCommand, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.TableIdentifier tableName ()  { throw new RuntimeException(); }
  public  java.lang.String columnName ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructField newColumn ()  { throw new RuntimeException(); }
  // not preceding
  public   AlterTableChangeColumnCommand (org.apache.spark.sql.catalyst.TableIdentifier tableName, java.lang.String columnName, org.apache.spark.sql.types.StructField newColumn)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.Row> run (org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
}
