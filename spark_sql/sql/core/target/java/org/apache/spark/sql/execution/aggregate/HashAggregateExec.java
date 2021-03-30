package org.apache.spark.sql.execution.aggregate;
/**
 * Hash-based aggregate operator that can also fallback to sorting when data exceeds memory size.
 */
public  class HashAggregateExec extends org.apache.spark.sql.execution.SparkPlan implements org.apache.spark.sql.execution.aggregate.BaseAggregateExec, org.apache.spark.sql.execution.BlockingOperatorWithCodegen, org.apache.spark.sql.execution.GeneratePredicateHelper, scala.Product, scala.Serializable {
  static public  boolean supportsAggregate (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> aggregateBufferAttributes)  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.execution.CodegenSupport parent ()  { throw new RuntimeException(); }
  protected  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.AttributeReference> aggregateBufferAttributes ()  { throw new RuntimeException(); }
  public  scala.Option<scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression>> requiredChildDistributionExpressions ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> groupingExpressions ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.aggregate.AggregateExpression> aggregateExpressions ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> aggregateAttributes ()  { throw new RuntimeException(); }
  public  int initialInputBufferOffset ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> resultExpressions ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan child ()  { throw new RuntimeException(); }
  // not preceding
  public   HashAggregateExec (scala.Option<scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression>> requiredChildDistributionExpressions, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> groupingExpressions, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.aggregate.AggregateExpression> aggregateExpressions, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> aggregateAttributes, int initialInputBufferOffset, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> resultExpressions, org.apache.spark.sql.execution.SparkPlan child)  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.catalyst.expressions.AttributeSeq allAttributes ()  { throw new RuntimeException(); }
  // not preceding
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  protected  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> doExecute ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.AttributeSet usedInputs ()  { throw new RuntimeException(); }
  public  boolean supportCodegen ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow>> inputRDDs ()  { throw new RuntimeException(); }
  protected  java.lang.String doProduce (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx)  { throw new RuntimeException(); }
  public  java.lang.String doConsume (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.codegen.ExprCode> input, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode row)  { throw new RuntimeException(); }
  /**
   * This is called by generated Java class, should be public.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap createHashMap ()  { throw new RuntimeException(); }
  public  org.apache.spark.memory.TaskMemoryManager getTaskMemoryManager ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.InternalRow getEmptyAggregationBuffer ()  { throw new RuntimeException(); }
  /**
   * This is called by generated Java class, should be public.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner createUnsafeJoiner ()  { throw new RuntimeException(); }
  /**
   * Called by generated Java class to finish the aggregate and return a KVIterator.
   * @param hashMap (undocumented)
   * @param sorter (undocumented)
   * @param peakMemory (undocumented)
   * @param spillSize (undocumented)
   * @param avgHashProbe (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.unsafe.KVIterator<org.apache.spark.sql.catalyst.expressions.UnsafeRow, org.apache.spark.sql.catalyst.expressions.UnsafeRow> finishAggregate (org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap hashMap, org.apache.spark.sql.execution.UnsafeKVExternalSorter sorter, org.apache.spark.sql.execution.metric.SQLMetric peakMemory, org.apache.spark.sql.execution.metric.SQLMetric spillSize, org.apache.spark.sql.execution.metric.SQLMetric avgHashProbe)  { throw new RuntimeException(); }
  public  java.lang.String verboseString (int maxFields)  { throw new RuntimeException(); }
  public  java.lang.String simpleString (int maxFields)  { throw new RuntimeException(); }
}
