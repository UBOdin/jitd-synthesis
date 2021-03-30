package org.apache.spark.sql.execution.command;
/**
 * Analyzes a given set of partitions to generate per-partition statistics, which will be used in
 * query optimizations.
 * <p>
 * When <code>partitionSpec</code> is empty, statistics for all partitions are collected and stored in
 * Metastore.
 * <p>
 * When <code>partitionSpec</code> mentions only some of the partition columns, all partitions with
 * matching values for specified columns are processed.
 * <p>
 * If <code>partitionSpec</code> mentions unknown partition column, an <code>AnalysisException</code> is raised.
 * <p>
 * By default, total number of rows and total size in bytes are calculated. When <code>noscan</code>
 * is <code>true</code>, only total size in bytes is computed.
 */
public  class AnalyzePartitionCommand extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.execution.command.RunnableCommand, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.TableIdentifier tableIdent ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, scala.Option<java.lang.String>> partitionSpec ()  { throw new RuntimeException(); }
  public  boolean noscan ()  { throw new RuntimeException(); }
  // not preceding
  public   AnalyzePartitionCommand (org.apache.spark.sql.catalyst.TableIdentifier tableIdent, scala.collection.immutable.Map<java.lang.String, scala.Option<java.lang.String>> partitionSpec, boolean noscan)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.Row> run (org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
}
