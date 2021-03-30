package org.apache.spark.sql.execution.command;
/** An explain command for users to see how a streaming batch is executed. */
public  class StreamingExplainCommand extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.execution.command.RunnableCommand, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.streaming.IncrementalExecution queryExecution ()  { throw new RuntimeException(); }
  public  boolean extended ()  { throw new RuntimeException(); }
  // not preceding
  public   StreamingExplainCommand (org.apache.spark.sql.execution.streaming.IncrementalExecution queryExecution, boolean extended)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.Row> run (org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
}
