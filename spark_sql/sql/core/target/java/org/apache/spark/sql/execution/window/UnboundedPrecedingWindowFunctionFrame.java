package org.apache.spark.sql.execution.window;
/**
 * The UnboundPreceding window frame calculates frames with the following SQL form:
 * ... BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW
 * <p>
 * There is only an upper bound. Very common use cases are for instance running sums or counts
 * (row_number). Technically this is a special case of a sliding window. However a sliding window
 * has to maintain a buffer, and it must do a full evaluation everytime the buffer changes. This
 * is not the case when there is no lower bound, given the additive nature of most aggregates
 * streaming updates and partial evaluation suffice and no buffering is needed.
 * <p>
 * param:  target to write results to.
 * param:  processor to calculate the row values with.
 * param:  ubound comparator used to identify the upper bound of an output row.
 */
public final class UnboundedPrecedingWindowFunctionFrame extends org.apache.spark.sql.execution.window.WindowFunctionFrame {
  public   UnboundedPrecedingWindowFunctionFrame (org.apache.spark.sql.catalyst.InternalRow target, org.apache.spark.sql.execution.window.AggregateProcessor processor, org.apache.spark.sql.execution.window.BoundOrdering ubound)  { throw new RuntimeException(); }
  public  int currentLowerBound ()  { throw new RuntimeException(); }
  public  int currentUpperBound ()  { throw new RuntimeException(); }
  /** Prepare the frame for calculating a new partition. */
  public  void prepare (org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray rows)  { throw new RuntimeException(); }
  /** Write the frame columns for the current row to the given target row. */
  public  void write (int index, org.apache.spark.sql.catalyst.InternalRow current)  { throw new RuntimeException(); }
}
