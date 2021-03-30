package org.apache.spark.sql.execution.command;
/**
 * A command to list the info for a column, including name, data type, comment and column stats.
 * <p>
 * The syntax of using this command in SQL is:
 * <pre><code>
 *   DESCRIBE [EXTENDED|FORMATTED] table_name column_name;
 * </code></pre>
 */
public  class DescribeColumnCommand extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.execution.command.RunnableCommand, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.TableIdentifier table ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> colNameParts ()  { throw new RuntimeException(); }
  public  boolean isExtended ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  // not preceding
  public   DescribeColumnCommand (org.apache.spark.sql.catalyst.TableIdentifier table, scala.collection.Seq<java.lang.String> colNameParts, boolean isExtended, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.Row> run (org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
}
