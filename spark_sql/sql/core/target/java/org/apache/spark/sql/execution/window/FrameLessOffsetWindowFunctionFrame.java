package org.apache.spark.sql.execution.window;
/**
 * The frameless offset window frame is an internal window frame just used to optimize the
 * performance for the window function that returns the value of the input column offset
 * by a number of rows according to the current row. The internal window frame is not a popular
 * window frame cannot be specified and used directly by the users. This window frame
 * calculates frames containing LEAD/LAG statements.
 */
public  class FrameLessOffsetWindowFunctionFrame extends org.apache.spark.sql.execution.window.OffsetWindowFunctionFrameBase {
  public   FrameLessOffsetWindowFunctionFrame (org.apache.spark.sql.catalyst.InternalRow target, int ordinal, org.apache.spark.sql.catalyst.expressions.OffsetWindowFunction[] expressions, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> inputSchema, scala.Function2<scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression>, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute>, org.apache.spark.sql.catalyst.expressions.MutableProjection> newMutableProjection, int offset, boolean ignoreNulls)  { throw new RuntimeException(); }
  public  void prepare (org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray rows)  { throw new RuntimeException(); }
  public  void write (int index, org.apache.spark.sql.catalyst.InternalRow current)  { throw new RuntimeException(); }
}
