package org.apache.spark.sql.execution.datasources.v2;
/**
 * A specialization of {@link DataSourceV2Relation} with the streaming bit set to true.
 * <p>
 * Note that, this plan has a mutable reader, so Spark won't apply operator push-down for this plan,
 * to avoid making the plan mutable. We should consolidate this plan and {@link DataSourceV2Relation}
 * after we figure out how to apply operator push-down for streaming data sources.
 */
public  class StreamingDataSourceV2Relation extends org.apache.spark.sql.catalyst.plans.logical.LeafNode implements org.apache.spark.sql.catalyst.analysis.MultiInstanceRelation, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.Scan scan ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.streaming.SparkDataStream stream ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.connector.read.streaming.Offset> startOffset ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.connector.read.streaming.Offset> endOffset ()  { throw new RuntimeException(); }
  // not preceding
  public   StreamingDataSourceV2Relation (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output, org.apache.spark.sql.connector.read.Scan scan, org.apache.spark.sql.connector.read.streaming.SparkDataStream stream, scala.Option<org.apache.spark.sql.connector.read.streaming.Offset> startOffset, scala.Option<org.apache.spark.sql.connector.read.streaming.Offset> endOffset)  { throw new RuntimeException(); }
  public  boolean isStreaming ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan newInstance ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.Statistics computeStats ()  { throw new RuntimeException(); }
}
