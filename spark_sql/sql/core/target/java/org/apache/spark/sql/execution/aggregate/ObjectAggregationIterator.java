package org.apache.spark.sql.execution.aggregate;
public  class ObjectAggregationIterator extends org.apache.spark.sql.execution.aggregate.AggregationIterator implements org.apache.spark.internal.Logging {
  public   ObjectAggregationIterator (int partIndex, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> outputAttributes, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> groupingExpressions, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.aggregate.AggregateExpression> aggregateExpressions, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> aggregateAttributes, int initialInputBufferOffset, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> resultExpressions, scala.Function2<scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression>, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute>, org.apache.spark.sql.catalyst.expressions.MutableProjection> newMutableProjection, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> originalInputAttributes, scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> inputRows, int fallbackCountThreshold, org.apache.spark.sql.execution.metric.SQLMetric numOutputRows, org.apache.spark.sql.execution.metric.SQLMetric spillSize, org.apache.spark.sql.execution.metric.SQLMetric numTasksFallBacked)  { throw new RuntimeException(); }
  public final  boolean hasNext ()  { throw new RuntimeException(); }
  public final  org.apache.spark.sql.catalyst.expressions.UnsafeRow next ()  { throw new RuntimeException(); }
  /**
   * Generate an output row when there is no input and there is no grouping expression.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.UnsafeRow outputForEmptyGroupingKeyWithoutInput ()  { throw new RuntimeException(); }
}
