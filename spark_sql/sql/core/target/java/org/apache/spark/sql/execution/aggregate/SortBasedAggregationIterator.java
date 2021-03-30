package org.apache.spark.sql.execution.aggregate;
/**
 * An iterator used to evaluate
 * {@link org.apache.spark.sql.catalyst.expressions.aggregate.AggregateFunction}.
 * It assumes the input rows have been sorted by values of {@link groupingExpressions}.
 */
public  class SortBasedAggregationIterator extends org.apache.spark.sql.execution.aggregate.AggregationIterator {
  public   SortBasedAggregationIterator (int partIndex, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> groupingExpressions, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> valueAttributes, scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> inputIterator, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.aggregate.AggregateExpression> aggregateExpressions, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> aggregateAttributes, int initialInputBufferOffset, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> resultExpressions, scala.Function2<scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression>, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute>, org.apache.spark.sql.catalyst.expressions.MutableProjection> newMutableProjection, org.apache.spark.sql.execution.metric.SQLMetric numOutputRows)  { throw new RuntimeException(); }
  public final  boolean hasNext ()  { throw new RuntimeException(); }
  protected  void initialize ()  { throw new RuntimeException(); }
  public final  org.apache.spark.sql.catalyst.expressions.UnsafeRow next ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.UnsafeRow outputForEmptyGroupingKeyWithoutInput ()  { throw new RuntimeException(); }
  /** Processes rows in the current group. It will stop when it find a new group. */
  protected  void processCurrentSortedGroup ()  { throw new RuntimeException(); }
}
