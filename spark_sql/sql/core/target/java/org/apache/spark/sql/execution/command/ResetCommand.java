package org.apache.spark.sql.execution.command;
/**
 * This command is for resetting SQLConf to the default values. Any configurations that were set
 * via {@link SetCommand} will get reset to default value. Command that runs
 * <pre><code>
 *   reset;
 *   reset spark.sql.session.timeZone;
 * </code></pre>
 */
public  class ResetCommand extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.execution.command.RunnableCommand, org.apache.spark.sql.catalyst.plans.logical.IgnoreCachedData, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> config ()  { throw new RuntimeException(); }
  // not preceding
  public   ResetCommand (scala.Option<java.lang.String> config)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.Row> run (org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
}
