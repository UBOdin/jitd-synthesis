package org.apache.spark.sql.execution.aggregate;
/**
 * An iterator used to evaluate aggregate functions. It operates on {@link UnsafeRow}s.
 * <p>
 * This iterator first uses hash-based aggregation to process input rows. It uses
 * a hash map to store groups and their corresponding aggregation buffers. If
 * this map cannot allocate memory from memory manager, it spills the map into disk
 * and creates a new one. After processed all the input, then merge all the spills
 * together using external sorter, and do sort-based aggregation.
 * <p>
 * The process has the following step:
 *  - Step 0: Do hash-based aggregation.
 *  - Step 1: Sort all entries of the hash map based on values of grouping expressions and
 *            spill them to disk.
 *  - Step 2: Create an external sorter based on the spilled sorted map entries and reset the map.
 *  - Step 3: Get a sorted {@link KVIterator} from the external sorter.
 *  - Step 4: Repeat step 0 until no more input.
 *  - Step 5: Initialize sort-based aggregation on the sorted iterator.
 * Then, this iterator works in the way of sort-based aggregation.
 * <p>
 * The code of this class is organized as follows:
 *  - Part 1: Initializing aggregate functions.
 *  - Part 2: Methods and fields used by setting aggregation buffer values,
 *            processing input rows from inputIter, and generating output
 *            rows.
 *  - Part 3: Methods and fields used by hash-based aggregation.
 *  - Part 4: Methods and fields used when we switch to sort-based aggregation.
 *  - Part 5: Methods and fields used by sort-based aggregation.
 *  - Part 6: Loads input and process input rows.
 *  - Part 7: Public methods of this iterator.
 *  - Part 8: A utility function used to generate a result when there is no
 *            input and there is no grouping expression.
 * <p>
 * param:  partIndex
 *   index of the partition
 * param:  groupingExpressions
 *   expressions for grouping keys
 * param:  aggregateExpressions
 * {@link AggregateExpression} containing {@link AggregateFunction}s with mode {@link Partial},
 * {@link PartialMerge}, or {@link Final}.
 * param:  aggregateAttributes the attributes of the aggregateExpressions'
 *   outputs when they are stored in the final aggregation buffer.
 * param:  resultExpressions
 *   expressions for generating output rows.
 * param:  newMutableProjection
 *   the function used to create mutable projections.
 * param:  originalInputAttributes
 *   attributes of representing input rows from <code>inputIter</code>.
 * param:  inputIter
 *   the iterator containing input {@link UnsafeRow}s.
 */
public  class TungstenAggregationIterator extends org.apache.spark.sql.execution.aggregate.AggregationIterator implements org.apache.spark.internal.Logging {
  public   TungstenAggregationIterator (int partIndex, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> groupingExpressions, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.aggregate.AggregateExpression> aggregateExpressions, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> aggregateAttributes, int initialInputBufferOffset, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> resultExpressions, scala.Function2<scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression>, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute>, org.apache.spark.sql.catalyst.expressions.MutableProjection> newMutableProjection, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> originalInputAttributes, scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> inputIter, scala.Option<scala.Tuple2<java.lang.Object, java.lang.Object>> testFallbackStartsAt, org.apache.spark.sql.execution.metric.SQLMetric numOutputRows, org.apache.spark.sql.execution.metric.SQLMetric peakMemory, org.apache.spark.sql.execution.metric.SQLMetric spillSize, org.apache.spark.sql.execution.metric.SQLMetric avgHashProbe)  { throw new RuntimeException(); }
  protected  scala.Function2<org.apache.spark.sql.catalyst.expressions.UnsafeRow, org.apache.spark.sql.catalyst.InternalRow, org.apache.spark.sql.catalyst.expressions.UnsafeRow> generateResultProjection ()  { throw new RuntimeException(); }
  public final  boolean hasNext ()  { throw new RuntimeException(); }
  public final  org.apache.spark.sql.catalyst.expressions.UnsafeRow next ()  { throw new RuntimeException(); }
  /**
   * Generate an output row when there is no input and there is no grouping expression.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.UnsafeRow outputForEmptyGroupingKeyWithoutInput ()  { throw new RuntimeException(); }
}
