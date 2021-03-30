package org.apache.spark.sql.execution.window;
/**
 * The unbounded preceding offset window frame is an internal window frame just used to optimize
 * the performance for the window function that returns the value of the input column offset
 * by a number of rows within the frame and has specified ROWS BETWEEN UNBOUNDED PRECEDING
 * AND CURRENT ROW. The internal window frame is not a popular window frame cannot be specified
 * and used directly by the users.
 * The unbounded preceding offset window frame calculates frames containing NTH_VALUE statements.
 * The unbounded preceding offset window frame return the same value for rows which index
 * (starting from 1) equal to or greater than offset in the window partition.
 */
public  class UnboundedPrecedingOffsetWindowFunctionFrame extends org.apache.spark.sql.execution.window.OffsetWindowFunctionFrameBase {
  public   UnboundedPrecedingOffsetWindowFunctionFrame (org.apache.spark.sql.catalyst.InternalRow target, int ordinal, org.apache.spark.sql.catalyst.expressions.OffsetWindowFunction[] expressions, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> inputSchema, scala.Function2<scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression>, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute>, org.apache.spark.sql.catalyst.expressions.MutableProjection> newMutableProjection, int offset, boolean ignoreNulls)  { throw new RuntimeException(); }
  public  void prepare (org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray rows)  { throw new RuntimeException(); }
  public  void write (int index, org.apache.spark.sql.catalyst.InternalRow current)  { throw new RuntimeException(); }
}
