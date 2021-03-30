package org.apache.spark.sql.execution.aggregate;
/**
 * The base class of {@link SortBasedAggregationIterator}, {@link TungstenAggregationIterator} and
 * {@link ObjectAggregationIterator}.
 * It mainly contains two parts:
 * 1. It initializes aggregate functions.
 * 2. It creates two functions, <code>processRow</code> and <code>generateOutput</code> based on {@link AggregateMode} of
 *    its aggregate functions. <code>processRow</code> is the function to handle an input. <code>generateOutput</code>
 *    is used to generate result.
 */
public abstract class AggregationIterator implements scala.collection.Iterator<org.apache.spark.sql.catalyst.expressions.UnsafeRow>, org.apache.spark.internal.Logging {
  public   AggregationIterator (int partIndex, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> groupingExpressions, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> inputAttributes, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.aggregate.AggregateExpression> aggregateExpressions, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> aggregateAttributes, int initialInputBufferOffset, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> resultExpressions, scala.Function2<scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression>, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute>, org.apache.spark.sql.catalyst.expressions.MutableProjection> newMutableProjection)  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.aggregate.AggregateFunction[] aggregateFunctions ()  { throw new RuntimeException(); }
  protected  int[] allImperativeAggregateFunctionPositions ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.aggregate.ImperativeAggregate[] allImperativeAggregateFunctions ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.MutableProjection expressionAggInitialProjection ()  { throw new RuntimeException(); }
  protected  scala.Function2<org.apache.spark.sql.catalyst.expressions.UnsafeRow, org.apache.spark.sql.catalyst.InternalRow, org.apache.spark.sql.catalyst.expressions.UnsafeRow> generateOutput ()  { throw new RuntimeException(); }
  protected  scala.Function2<org.apache.spark.sql.catalyst.InternalRow, org.apache.spark.sql.catalyst.InternalRow, scala.runtime.BoxedUnit> generateProcessRow (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.aggregate.AggregateExpression> expressions, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.aggregate.AggregateFunction> functions, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> inputAttributes)  { throw new RuntimeException(); }
  protected  scala.Function2<org.apache.spark.sql.catalyst.expressions.UnsafeRow, org.apache.spark.sql.catalyst.InternalRow, org.apache.spark.sql.catalyst.expressions.UnsafeRow> generateResultProjection ()  { throw new RuntimeException(); }
  protected  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> groupingAttributes ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.UnsafeProjection groupingProjection ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.aggregate.AggregateFunction[] initializeAggregateFunctions (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.aggregate.AggregateExpression> expressions, int startingInputBufferOffset)  { throw new RuntimeException(); }
  /** Initializes buffer values for all aggregate functions. */
  protected  void initializeBuffer (org.apache.spark.sql.catalyst.InternalRow buffer)  { throw new RuntimeException(); }
  protected  scala.Function2<org.apache.spark.sql.catalyst.InternalRow, org.apache.spark.sql.catalyst.InternalRow, scala.runtime.BoxedUnit> processRow ()  { throw new RuntimeException(); }
}
