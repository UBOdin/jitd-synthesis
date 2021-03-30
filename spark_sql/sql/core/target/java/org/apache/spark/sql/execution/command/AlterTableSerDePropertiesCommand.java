package org.apache.spark.sql.execution.command;
/**
 * A command that sets the serde class and/or serde properties of a table/view.
 * <p>
 * The syntax of this command is:
 * <pre><code>
 *   ALTER TABLE table [PARTITION spec] SET SERDE serde_name [WITH SERDEPROPERTIES props];
 *   ALTER TABLE table [PARTITION spec] SET SERDEPROPERTIES serde_properties;
 * </code></pre>
 */
public  class AlterTableSerDePropertiesCommand extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.execution.command.RunnableCommand, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.TableIdentifier tableName ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> serdeClassName ()  { throw new RuntimeException(); }
  public  scala.Option<scala.collection.immutable.Map<java.lang.String, java.lang.String>> serdeProperties ()  { throw new RuntimeException(); }
  public  scala.Option<scala.collection.immutable.Map<java.lang.String, java.lang.String>> partSpec ()  { throw new RuntimeException(); }
  // not preceding
  public   AlterTableSerDePropertiesCommand (org.apache.spark.sql.catalyst.TableIdentifier tableName, scala.Option<java.lang.String> serdeClassName, scala.Option<scala.collection.immutable.Map<java.lang.String, java.lang.String>> serdeProperties, scala.Option<scala.collection.immutable.Map<java.lang.String, java.lang.String>> partSpec)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.Row> run (org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
}
