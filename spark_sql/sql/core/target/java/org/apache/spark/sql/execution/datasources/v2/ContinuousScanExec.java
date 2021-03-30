package org.apache.spark.sql.execution.datasources.v2;
/**
 * Physical plan node for scanning data from a streaming data source with continuous mode.
 */
public  class ContinuousScanExec extends org.apache.spark.sql.execution.SparkPlan implements org.apache.spark.sql.execution.datasources.v2.DataSourceV2ScanExecBase, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.Scan scan ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.streaming.ContinuousStream stream ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.streaming.Offset start ()  { throw new RuntimeException(); }
  // not preceding
  public   ContinuousScanExec (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output, org.apache.spark.sql.connector.read.Scan scan, org.apache.spark.sql.connector.read.streaming.ContinuousStream stream, org.apache.spark.sql.connector.read.streaming.Offset start)  { throw new RuntimeException(); }
  public  boolean equals (Object other)  { throw new RuntimeException(); }
  public  int hashCode ()  { throw new RuntimeException(); }
  // not preceding
  public  scala.collection.Seq<org.apache.spark.sql.connector.read.InputPartition> partitions ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.connector.read.streaming.ContinuousPartitionReaderFactory readerFactory ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> inputRDD ()  { throw new RuntimeException(); }
}
