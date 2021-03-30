package org.apache.spark.sql.execution.streaming;
/**
 * Physical operator for executing <code>FlatMapGroupsWithState</code>
 * <p>
 * param:  func function called on each group
 * param:  keyDeserializer used to extract the key object for each group.
 * param:  valueDeserializer used to extract the items in the iterator from an input row.
 * param:  groupingAttributes used to group the data
 * param:  dataAttributes used to read the data
 * param:  outputObjAttr Defines the output object
 * param:  stateEncoder used to serialize/deserialize state before calling <code>func</code>
 * param:  outputMode the output mode of <code>func</code>
 * param:  timeoutConf used to timeout groups that have not received data in a while
 * param:  batchTimestampMs processing timestamp of the current batch.
 */
public  class FlatMapGroupsWithStateExec extends org.apache.spark.sql.execution.SparkPlan implements org.apache.spark.sql.execution.UnaryExecNode, org.apache.spark.sql.execution.ObjectProducerExec, org.apache.spark.sql.execution.streaming.StateStoreWriter, org.apache.spark.sql.execution.streaming.WatermarkSupport, scala.Product, scala.Serializable {
  /** Helper class to update the state store */
  public  class InputProcessor {
    public   InputProcessor (org.apache.spark.sql.execution.streaming.state.StateStore store)  { throw new RuntimeException(); }
    /**
     * For every group, get the key, values and corresponding state and call the function,
     * and return an iterator of rows
     * @param dataIter (undocumented)
     * @return (undocumented)
     */
    public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> processNewData (scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> dataIter)  { throw new RuntimeException(); }
    /** Find the groups that have timeout set and are timing out right now, and call the function */
    public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> processTimedOutState ()  { throw new RuntimeException(); }
  }
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6, T7 v7, T8 v8, T9 v9, T10 v10, T11 v11, T12 v12, T13 v13, T14 v14)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.expressions.Expression> watermarkExpression ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.expressions.BasePredicate> watermarkPredicateForKeys ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.expressions.BasePredicate> watermarkPredicateForData ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  scala.Function3<java.lang.Object, scala.collection.Iterator<java.lang.Object>, org.apache.spark.sql.catalyst.plans.logical.LogicalGroupState<java.lang.Object>, scala.collection.Iterator<java.lang.Object>> func ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression keyDeserializer ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression valueDeserializer ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> groupingAttributes ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> dataAttributes ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Attribute outputObjAttr ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.execution.streaming.StatefulOperatorStateInfo> stateInfo ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<java.lang.Object> stateEncoder ()  { throw new RuntimeException(); }
  public  int stateFormatVersion ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.streaming.OutputMode outputMode ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.streaming.GroupStateTimeout timeoutConf ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object> batchTimestampMs ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object> eventTimeWatermark ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan child ()  { throw new RuntimeException(); }
  // not preceding
  public   FlatMapGroupsWithStateExec (scala.Function3<java.lang.Object, scala.collection.Iterator<java.lang.Object>, org.apache.spark.sql.catalyst.plans.logical.LogicalGroupState<java.lang.Object>, scala.collection.Iterator<java.lang.Object>> func, org.apache.spark.sql.catalyst.expressions.Expression keyDeserializer, org.apache.spark.sql.catalyst.expressions.Expression valueDeserializer, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> groupingAttributes, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> dataAttributes, org.apache.spark.sql.catalyst.expressions.Attribute outputObjAttr, scala.Option<org.apache.spark.sql.execution.streaming.StatefulOperatorStateInfo> stateInfo, org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<java.lang.Object> stateEncoder, int stateFormatVersion, org.apache.spark.sql.streaming.OutputMode outputMode, org.apache.spark.sql.streaming.GroupStateTimeout timeoutConf, scala.Option<java.lang.Object> batchTimestampMs, scala.Option<java.lang.Object> eventTimeWatermark, org.apache.spark.sql.execution.SparkPlan child)  { throw new RuntimeException(); }
    org.apache.spark.sql.execution.streaming.state.FlatMapGroupsWithStateExecHelper.StateManager stateManager ()  { throw new RuntimeException(); }
  /** Distribute by grouping attributes */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.physical.Distribution> requiredChildDistribution ()  { throw new RuntimeException(); }
  /** Ordering needed for using GroupingIterator */
  public  scala.collection.Seq<scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder>> requiredChildOrdering ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> keyExpressions ()  { throw new RuntimeException(); }
  public  boolean shouldRunAnotherBatch (org.apache.spark.sql.execution.streaming.OffsetSeqMetadata newMetadata)  { throw new RuntimeException(); }
  protected  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> doExecute ()  { throw new RuntimeException(); }
}
