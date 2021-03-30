package org.apache.spark.sql.execution.window;
/**
 * This class prepares and manages the processing of a number of {@link AggregateFunction}s within a
 * single frame. The {@link WindowFunctionFrame} takes care of processing the frame in the correct way
 * that reduces the processing of a {@link AggregateWindowFunction} to processing the underlying
 * {@link AggregateFunction}. All {@link AggregateFunction}s are processed in {@link Complete} mode.
 * <p>
 * {@link SizeBasedWindowFunction}s are initialized in a slightly different way. These functions
 * require the size of the partition processed and this value is exposed to them when
 * the processor is constructed.
 * <p>
 * Processing of distinct aggregates is currently not supported.
 * <p>
 * The implementation is split into an object which takes care of construction, and the actual
 * processor class.
 */
public  class AggregateProcessor$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final AggregateProcessor$ MODULE$ = null;
  public   AggregateProcessor$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.window.AggregateProcessor apply (org.apache.spark.sql.catalyst.expressions.Expression[] functions, int ordinal, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> inputAttributes, scala.Function2<scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression>, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute>, org.apache.spark.sql.catalyst.expressions.MutableProjection> newMutableProjection)  { throw new RuntimeException(); }
}
