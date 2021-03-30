package org.apache.spark.sql.execution.streaming;
/** Physical operator for executing streaming Deduplicate. */
public  class StreamingDeduplicateExec extends org.apache.spark.sql.execution.SparkPlan implements org.apache.spark.sql.execution.UnaryExecNode, org.apache.spark.sql.execution.streaming.StateStoreWriter, org.apache.spark.sql.execution.streaming.WatermarkSupport, scala.Product, scala.Serializable {
  public  scala.Option<org.apache.spark.sql.catalyst.expressions.Expression> watermarkExpression ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.expressions.BasePredicate> watermarkPredicateForKeys ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.expressions.BasePredicate> watermarkPredicateForData ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> keyExpressions ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan child ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.execution.streaming.StatefulOperatorStateInfo> stateInfo ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object> eventTimeWatermark ()  { throw new RuntimeException(); }
  // not preceding
  public   StreamingDeduplicateExec (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> keyExpressions, org.apache.spark.sql.execution.SparkPlan child, scala.Option<org.apache.spark.sql.execution.streaming.StatefulOperatorStateInfo> stateInfo, scala.Option<java.lang.Object> eventTimeWatermark)  { throw new RuntimeException(); }
  /** Distribute by grouping attributes */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.physical.Distribution> requiredChildDistribution ()  { throw new RuntimeException(); }
  protected  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> doExecute ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.physical.Partitioning outputPartitioning ()  { throw new RuntimeException(); }
  public  boolean shouldRunAnotherBatch (org.apache.spark.sql.execution.streaming.OffsetSeqMetadata newMetadata)  { throw new RuntimeException(); }
}
