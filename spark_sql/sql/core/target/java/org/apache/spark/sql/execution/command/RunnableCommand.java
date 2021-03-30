package org.apache.spark.sql.execution.command;
/**
 * A logical command that is executed for its side-effects.  <code>RunnableCommand</code>s are
 * wrapped in <code>ExecutedCommand</code> during execution.
 */
public  interface RunnableCommand extends org.apache.spark.sql.catalyst.plans.logical.Command {
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.Row> run (org.apache.spark.sql.SparkSession sparkSession)  ;
}
