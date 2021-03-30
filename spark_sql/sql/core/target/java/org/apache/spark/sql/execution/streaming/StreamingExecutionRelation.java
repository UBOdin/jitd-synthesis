package org.apache.spark.sql.execution.streaming;
/**
 * Used to link a streaming {@link Source} of data into a
 * {@link org.apache.spark.sql.catalyst.plans.logical.LogicalPlan}.
 */
public  class StreamingExecutionRelation extends org.apache.spark.sql.catalyst.plans.logical.LeafNode implements org.apache.spark.sql.catalyst.analysis.MultiInstanceRelation, scala.Product, scala.Serializable {
  static public  org.apache.spark.sql.execution.streaming.StreamingExecutionRelation apply (org.apache.spark.sql.execution.streaming.Source source, org.apache.spark.sql.SparkSession session)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.streaming.SparkDataStream source ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  // not preceding
  public   StreamingExecutionRelation (org.apache.spark.sql.connector.read.streaming.SparkDataStream source, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output, org.apache.spark.sql.SparkSession session)  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.Object> otherCopyArgs ()  { throw new RuntimeException(); }
  public  boolean isStreaming ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.Statistics computeStats ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan newInstance ()  { throw new RuntimeException(); }
}
