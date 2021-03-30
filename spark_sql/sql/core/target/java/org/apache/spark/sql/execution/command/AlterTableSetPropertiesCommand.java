package org.apache.spark.sql.execution.command;
/**
 * A command that sets table/view properties.
 * <p>
 * The syntax of this command is:
 * <pre><code>
 *   ALTER TABLE table1 SET TBLPROPERTIES ('key1' = 'val1', 'key2' = 'val2', ...);
 *   ALTER VIEW view1 SET TBLPROPERTIES ('key1' = 'val1', 'key2' = 'val2', ...);
 * </code></pre>
 */
public  class AlterTableSetPropertiesCommand extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.execution.command.RunnableCommand, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.TableIdentifier tableName ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> properties ()  { throw new RuntimeException(); }
  public  boolean isView ()  { throw new RuntimeException(); }
  // not preceding
  public   AlterTableSetPropertiesCommand (org.apache.spark.sql.catalyst.TableIdentifier tableName, scala.collection.immutable.Map<java.lang.String, java.lang.String> properties, boolean isView)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.Row> run (org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
}
