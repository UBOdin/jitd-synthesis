package org.apache.spark.sql.execution.window;
public  interface WindowExecBase extends org.apache.spark.sql.execution.UnaryExecNode {
  /**
   * Create a bound ordering object for a given frame type and offset. A bound ordering object is
   * used to determine which input row lies within the frame boundaries of an output row.
   * <p>
   * This method uses Code Generation. It can only be used on the executor side.
   * <p>
   * @param frame to evaluate. This can either be a Row or Range frame.
   * @param bound with respect to the row.
   * @param timeZone the session local timezone for time related calculations.
   * @return a bound ordering object.
   */
  public  org.apache.spark.sql.execution.window.BoundOrdering createBoundOrdering (org.apache.spark.sql.catalyst.expressions.FrameType frame, org.apache.spark.sql.catalyst.expressions.Expression bound, java.lang.String timeZone)  ;
  /**
   * Create the resulting projection.
   * <p>
   * This method uses Code Generation. It can only be used on the executor side.
   * <p>
   * @param expressions unbound ordered function expressions.
   * @return the final resulting projection.
   */
  public  org.apache.spark.sql.catalyst.expressions.UnsafeProjection createResultProjection (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> expressions)  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> orderSpec ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> partitionSpec ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> windowExpression ()  ;
  /**
   * Collection containing an entry for each window frame to process. Each entry contains a frame's
   * {@link WindowExpression}s and factory function for the {@link WindowFrameFunction}.
   * @return (undocumented)
   */
  public  scala.collection.Seq<scala.Tuple2<scala.collection.mutable.Buffer<org.apache.spark.sql.catalyst.expressions.Expression>, scala.Function1<org.apache.spark.sql.catalyst.InternalRow, org.apache.spark.sql.execution.window.WindowFunctionFrame>>> windowFrameExpressionFactoryPairs ()  ;
}
