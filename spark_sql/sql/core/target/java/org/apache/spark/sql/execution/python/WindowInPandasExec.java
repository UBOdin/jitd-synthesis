package org.apache.spark.sql.execution.python;
/**
 * This class calculates and outputs windowed aggregates over the rows in a single partition.
 * <p>
 * This is similar to {@link WindowExec}. The main difference is that this node does not compute
 * any window aggregation values. Instead, it computes the lower and upper bound for each window
 * (i.e. window bounds) and pass the data and indices to Python worker to do the actual window
 * aggregation.
 * <p>
 * It currently materializes all data associated with the same partition key and passes them to
 * Python worker. This is not strictly necessary for sliding windows and can be improved (by
 * possibly slicing data into overlapping chunks and stitching them together).
 * <p>
 * This class groups window expressions by their window boundaries so that window expressions
 * with the same window boundaries can share the same window bounds. The window bounds are
 * prepended to the data passed to the python worker.
 * <p>
 * For example, if we have:
 *     avg(v) over specifiedwindowframe(RowFrame, -5, 5),
 *     avg(v) over specifiedwindowframe(RowFrame, UnboundedPreceding, UnboundedFollowing),
 *     avg(v) over specifiedwindowframe(RowFrame, -3, 3),
 *     max(v) over specifiedwindowframe(RowFrame, -3, 3)
 * <p>
 * The python input will look like:
 * (lower_bound_w1, upper_bound_w1, lower_bound_w3, upper_bound_w3, v)
 * <p>
 * where w1 is specifiedwindowframe(RowFrame, -5, 5)
 *       w2 is specifiedwindowframe(RowFrame, UnboundedPreceding, UnboundedFollowing)
 *       w3 is specifiedwindowframe(RowFrame, -3, 3)
 * <p>
 * Note that w2 doesn't have bound indices in the python input because it's unbounded window
 * so it's bound indices will always be the same.
 * <p>
 * Bounded window and Unbounded window are evaluated differently in Python worker:
 * (1) Bounded window takes the window bound indices in addition to the input columns.
 *     Unbounded window takes only input columns.
 * (2) Bounded window evaluates the udf once per input row.
 *     Unbounded window evaluates the udf once per window partition.
 * This is controlled by Python runner conf "pandas_window_bound_types"
 * <p>
 * The logic to compute window bounds is delegated to {@link WindowFunctionFrame} and shared with
 * {@link WindowExec}
 * <p>
 * Note this doesn't support partial aggregation and all aggregation is computed from the entire
 * window.
 */
public  class WindowInPandasExec extends org.apache.spark.sql.execution.SparkPlan implements org.apache.spark.sql.execution.window.WindowExecBase, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  protected  scala.collection.Seq<scala.Tuple2<scala.collection.mutable.Buffer<org.apache.spark.sql.catalyst.expressions.Expression>, scala.Function1<org.apache.spark.sql.catalyst.InternalRow, org.apache.spark.sql.execution.window.WindowFunctionFrame>>> windowFrameExpressionFactoryPairs ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> windowExpression ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> partitionSpec ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> orderSpec ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan child ()  { throw new RuntimeException(); }
  // not preceding
  public   WindowInPandasExec (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> windowExpression, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> partitionSpec, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> orderSpec, org.apache.spark.sql.execution.SparkPlan child)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.physical.Distribution> requiredChildDistribution ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder>> requiredChildOrdering ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> outputOrdering ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.physical.Partitioning outputPartitioning ()  { throw new RuntimeException(); }
  protected  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> doExecute ()  { throw new RuntimeException(); }
}
