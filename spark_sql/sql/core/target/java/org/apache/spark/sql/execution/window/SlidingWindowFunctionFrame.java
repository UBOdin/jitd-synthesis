package org.apache.spark.sql.execution.window;
/**
 * The sliding window frame calculates frames with the following SQL form:
 * ... BETWEEN 1 PRECEDING AND 1 FOLLOWING
 * <p>
 * param:  target to write results to.
 * param:  processor to calculate the row values with.
 * param:  lbound comparator used to identify the lower bound of an output row.
 * param:  ubound comparator used to identify the upper bound of an output row.
 */
public final class SlidingWindowFunctionFrame extends org.apache.spark.sql.execution.window.WindowFunctionFrame {
  public   SlidingWindowFunctionFrame (org.apache.spark.sql.catalyst.InternalRow target, org.apache.spark.sql.execution.window.AggregateProcessor processor, org.apache.spark.sql.execution.window.BoundOrdering lbound, org.apache.spark.sql.execution.window.BoundOrdering ubound)  { throw new RuntimeException(); }
  public  int currentLowerBound ()  { throw new RuntimeException(); }
  public  int currentUpperBound ()  { throw new RuntimeException(); }
  /** Prepare the frame for calculating a new partition. Reset all variables. */
  public  void prepare (org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray rows)  { throw new RuntimeException(); }
  /** Write the frame columns for the current row to the given target row. */
  public  void write (int index, org.apache.spark.sql.catalyst.InternalRow current)  { throw new RuntimeException(); }
}
