package org.apache.spark.sql.execution.streaming;
/**
 * For each input tuple, the key is calculated and the value from the {@link StateStore} is added
 * to the stream (in addition to the input tuple) if present.
 */
public  class StateStoreRestoreExec extends org.apache.spark.sql.execution.SparkPlan implements org.apache.spark.sql.execution.UnaryExecNode, org.apache.spark.sql.execution.streaming.StateStoreReader, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> keyExpressions ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.execution.streaming.StatefulOperatorStateInfo> stateInfo ()  { throw new RuntimeException(); }
  public  int stateFormatVersion ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan child ()  { throw new RuntimeException(); }
  // not preceding
  public   StateStoreRestoreExec (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> keyExpressions, scala.Option<org.apache.spark.sql.execution.streaming.StatefulOperatorStateInfo> stateInfo, int stateFormatVersion, org.apache.spark.sql.execution.SparkPlan child)  { throw new RuntimeException(); }
    org.apache.spark.sql.execution.streaming.state.StreamingAggregationStateManager stateManager ()  { throw new RuntimeException(); }
  protected  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> doExecute ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.physical.Partitioning outputPartitioning ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.physical.Distribution> requiredChildDistribution ()  { throw new RuntimeException(); }
}
