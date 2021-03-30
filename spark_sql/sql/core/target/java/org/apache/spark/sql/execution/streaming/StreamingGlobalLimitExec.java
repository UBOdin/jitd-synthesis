package org.apache.spark.sql.execution.streaming;
/**
 * A physical operator for executing a streaming limit, which makes sure no more than streamLimit
 * rows are returned. This physical operator is only meant for logical limit operations that
 * will get a input stream of rows that are effectively appends. For example,
 * - limit on any query in append mode
 * - limit before the aggregation in a streaming aggregation query complete mode
 */
public  class StreamingGlobalLimitExec extends org.apache.spark.sql.execution.SparkPlan implements org.apache.spark.sql.execution.UnaryExecNode, org.apache.spark.sql.execution.streaming.StateStoreWriter, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  long streamLimit ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan child ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.execution.streaming.StatefulOperatorStateInfo> stateInfo ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.streaming.OutputMode> outputMode ()  { throw new RuntimeException(); }
  // not preceding
  public   StreamingGlobalLimitExec (long streamLimit, org.apache.spark.sql.execution.SparkPlan child, scala.Option<org.apache.spark.sql.execution.streaming.StatefulOperatorStateInfo> stateInfo, scala.Option<org.apache.spark.sql.streaming.OutputMode> outputMode)  { throw new RuntimeException(); }
  protected  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> doExecute ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.physical.Partitioning outputPartitioning ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.physical.Distribution> requiredChildDistribution ()  { throw new RuntimeException(); }
}
