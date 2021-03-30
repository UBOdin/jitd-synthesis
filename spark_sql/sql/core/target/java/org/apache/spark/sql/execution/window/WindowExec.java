package org.apache.spark.sql.execution.window;
/**
 * This class calculates and outputs (windowed) aggregates over the rows in a single (sorted)
 * partition. The aggregates are calculated for each row in the group. Special processing
 * instructions, frames, are used to calculate these aggregates. Frames are processed in the order
 * specified in the window specification (the ORDER BY ... clause). There are four different frame
 * types:
 * - Entire partition: The frame is the entire partition, i.e.
 *   UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING. For this case, window function will take all
 *   rows as inputs and be evaluated once.
 * - Growing frame: We only add new rows into the frame, Examples are:
 *     1. UNBOUNDED PRECEDING AND 1 PRECEDING
 *     2. UNBOUNDED PRECEDING AND CURRENT ROW
 *     3. UNBOUNDED PRECEDING AND 1 FOLLOWING
 *   Every time we move to a new row to process, we add some rows to the frame. We do not remove
 *   rows from this frame.
 * - Shrinking frame: We only remove rows from the frame, Examples are:
 *     1. 1 PRECEDING AND UNBOUNDED FOLLOWING
 *     2. CURRENT ROW AND UNBOUNDED FOLLOWING
 *     3. 1 FOLLOWING AND UNBOUNDED FOLLOWING
 *   Every time we move to a new row to process, we remove some rows from the frame. We do not add
 *   rows to this frame.
 * - Moving frame: Every time we move to a new row to process, we remove some rows from the frame
 *   and we add some rows to the frame. Examples are:
 *     1. 2 PRECEDING AND 1 PRECEDING
 *     2. 1 PRECEDING AND CURRENT ROW
 *     3. CURRENT ROW AND 1 FOLLOWING
 *     4. 1 PRECEDING AND 1 FOLLOWING
 *     5. 1 FOLLOWING AND 2 FOLLOWING
 * - Offset frame: The frame consist of one row, which is an offset number of rows away from the
 *   current row. Only {@link OffsetWindowFunction}s can be processed in an offset frame. There are
 *   three implements of offset frame: {@link FrameLessOffsetWindowFunctionFrame},
 *   {@link UnboundedOffsetWindowFunctionFrame} and {@link UnboundedPrecedingOffsetWindowFunctionFrame}.
 * <p>
 * Different frame boundaries can be used in Growing, Shrinking and Moving frames. A frame
 * boundary can be either Row or Range based:
 * - Row Based: A row based boundary is based on the position of the row within the partition.
 *   An offset indicates the number of rows above or below the current row, the frame for the
 *   current row starts or ends. For instance, given a row based sliding frame with a lower bound
 *   offset of -1 and a upper bound offset of +2. The frame for row with index 5 would range from
 *   index 4 to index 6.
 * - Range based: A range based boundary is based on the actual value of the ORDER BY
 *   expression(s). An offset is used to alter the value of the ORDER BY expression, for
 *   instance if the current order by expression has a value of 10 and the lower bound offset
 *   is -3, the resulting lower bound for the current row will be 10 - 3 = 7. This however puts a
 *   number of constraints on the ORDER BY expressions: there can be only one expression and this
 *   expression must have a numerical data type. An exception can be made when the offset is 0,
 *   because no value modification is needed, in this case multiple and non-numeric ORDER BY
 *   expression are allowed.
 * <p>
 * This is quite an expensive operator because every row for a single group must be in the same
 * partition and partitions must be sorted according to the grouping and sort order. The operator
 * requires the planner to take care of the partitioning and sorting.
 * <p>
 * The operator is semi-blocking. The window functions and aggregates are calculated one group at
 * a time, the result will only be made available after the processing for the entire group has
 * finished. The operator is able to process different frame configurations at the same time. This
 * is done by delegating the actual frame processing (i.e. calculation of the window functions) to
 * specialized classes, see {@link WindowFunctionFrame}, which take care of their own frame type:
 * Entire Partition, Sliding, Growing &amp; Shrinking. Boundary evaluation is also delegated to a pair
 * of specialized classes: {@link RowBoundOrdering} &amp; {@link RangeBoundOrdering}.
 */
public  class WindowExec extends org.apache.spark.sql.execution.SparkPlan implements org.apache.spark.sql.execution.window.WindowExecBase, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  protected  scala.collection.Seq<scala.Tuple2<scala.collection.mutable.Buffer<org.apache.spark.sql.catalyst.expressions.Expression>, scala.Function1<org.apache.spark.sql.catalyst.InternalRow, org.apache.spark.sql.execution.window.WindowFunctionFrame>>> windowFrameExpressionFactoryPairs ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> windowExpression ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> partitionSpec ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> orderSpec ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan child ()  { throw new RuntimeException(); }
  // not preceding
  public   WindowExec (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> windowExpression, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> partitionSpec, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> orderSpec, org.apache.spark.sql.execution.SparkPlan child)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.physical.Distribution> requiredChildDistribution ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder>> requiredChildOrdering ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> outputOrdering ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.physical.Partitioning outputPartitioning ()  { throw new RuntimeException(); }
  protected  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> doExecute ()  { throw new RuntimeException(); }
}
