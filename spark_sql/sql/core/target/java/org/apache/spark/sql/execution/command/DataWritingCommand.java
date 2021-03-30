package org.apache.spark.sql.execution.command;
/**
 * A special <code>Command</code> which writes data out and updates metrics.
 */
public  interface DataWritingCommand extends org.apache.spark.sql.catalyst.plans.logical.Command {
  /**
   * The input query plan that produces the data to be written.
   * IMPORTANT: the input query plan MUST be analyzed, so that we can carry its output columns
   *            to {@link org.apache.spark.sql.execution.datasources.FileFormatWriter}.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan query ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> children ()  ;
  public  scala.collection.Seq<java.lang.String> outputColumnNames ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> outputColumns ()  ;
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  ;
  public  org.apache.spark.sql.execution.datasources.BasicWriteJobStatsTracker basicWriteJobStatsTracker (org.apache.hadoop.conf.Configuration hadoopConf)  ;
  public  scala.collection.Seq<org.apache.spark.sql.Row> run (org.apache.spark.sql.SparkSession sparkSession, org.apache.spark.sql.execution.SparkPlan child)  ;
}
