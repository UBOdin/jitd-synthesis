package org.apache.spark.sql.execution.command;
/**
 * Command that looks like
 * <pre><code>
 *   DESCRIBE [EXTENDED|FORMATTED] table_name partitionSpec?;
 * </code></pre>
 */
public  class DescribeTableCommand extends org.apache.spark.sql.execution.command.DescribeCommandBase implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.TableIdentifier table ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> partitionSpec ()  { throw new RuntimeException(); }
  public  boolean isExtended ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  // not preceding
  public   DescribeTableCommand (org.apache.spark.sql.catalyst.TableIdentifier table, scala.collection.immutable.Map<java.lang.String, java.lang.String> partitionSpec, boolean isExtended, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.Row> run (org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
}
