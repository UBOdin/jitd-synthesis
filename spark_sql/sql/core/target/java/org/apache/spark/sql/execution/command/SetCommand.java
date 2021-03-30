package org.apache.spark.sql.execution.command;
/**
 * Command that runs
 * <pre><code>
 *   set key = value;
 *   set -v;
 *   set;
 * </code></pre>
 */
public  class SetCommand extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.execution.command.RunnableCommand, org.apache.spark.internal.Logging, scala.Product, scala.Serializable {
  static public  scala.util.matching.Regex VariableName ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  scala.Option<scala.Tuple2<java.lang.String, scala.Option<java.lang.String>>> kv ()  { throw new RuntimeException(); }
  // not preceding
  public   SetCommand (scala.Option<scala.Tuple2<java.lang.String, scala.Option<java.lang.String>>> kv)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.Row> run (org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
}
