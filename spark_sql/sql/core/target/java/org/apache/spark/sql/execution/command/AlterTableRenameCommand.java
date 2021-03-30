package org.apache.spark.sql.execution.command;
/**
 * A command that renames a table/view.
 * <p>
 * The syntax of this command is:
 * <pre><code>
 *    ALTER TABLE table1 RENAME TO table2;
 *    ALTER VIEW view1 RENAME TO view2;
 * </code></pre>
 */
public  class AlterTableRenameCommand extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.execution.command.RunnableCommand, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.TableIdentifier oldName ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.TableIdentifier newName ()  { throw new RuntimeException(); }
  public  boolean isView ()  { throw new RuntimeException(); }
  // not preceding
  public   AlterTableRenameCommand (org.apache.spark.sql.catalyst.TableIdentifier oldName, org.apache.spark.sql.catalyst.TableIdentifier newName, boolean isView)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.Row> run (org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
}
