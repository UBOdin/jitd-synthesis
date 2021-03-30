package org.apache.spark.sql.execution.command;
/**
 * A command for users to get the usage of a registered function.
 * The syntax of using this command in SQL is
 * <pre><code>
 *   DESCRIBE FUNCTION [EXTENDED] upper;
 * </code></pre>
 */
public  class DescribeFunctionCommand extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.execution.command.RunnableCommand, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.FunctionIdentifier functionName ()  { throw new RuntimeException(); }
  public  boolean isExtended ()  { throw new RuntimeException(); }
  // not preceding
  public   DescribeFunctionCommand (org.apache.spark.sql.catalyst.FunctionIdentifier functionName, boolean isExtended)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.Row> run (org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
}
