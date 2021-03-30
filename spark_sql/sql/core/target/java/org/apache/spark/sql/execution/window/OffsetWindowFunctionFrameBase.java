package org.apache.spark.sql.execution.window;
/**
 * The offset window frame calculates frames containing LEAD/LAG statements.
 * <p>
 * param:  target to write results to.
 * param:  ordinal the ordinal is the starting offset at which the results of the window frame get
 *                written into the (shared) target row. The result of the frame expression with
 *                index 'i' will be written to the 'ordinal' + 'i' position in the target row.
 * param:  expressions to shift a number of rows.
 * param:  inputSchema required for creating a projection.
 * param:  newMutableProjection function used to create the projection.
 * param:  offset by which rows get moved within a partition.
 */
public abstract class OffsetWindowFunctionFrameBase extends org.apache.spark.sql.execution.window.WindowFunctionFrame {
  public   OffsetWindowFunctionFrameBase (org.apache.spark.sql.catalyst.InternalRow target, int ordinal, org.apache.spark.sql.catalyst.expressions.OffsetWindowFunction[] expressions, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> inputSchema, scala.Function2<scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression>, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute>, org.apache.spark.sql.catalyst.expressions.MutableProjection> newMutableProjection, int offset)  { throw new RuntimeException(); }
  public  int currentLowerBound ()  { throw new RuntimeException(); }
  public  int currentUpperBound ()  { throw new RuntimeException(); }
  /** Create the projection used when the offset row DOES NOT exists. */
  protected  org.apache.spark.sql.catalyst.expressions.MutableProjection fillDefaultValue ()  { throw new RuntimeException(); }
  /** find the offset row whose input is not null */
  protected  void findNextRowWithNonNullInput ()  { throw new RuntimeException(); }
  /** Rows of the partition currently being processed. */
  protected  org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray input ()  { throw new RuntimeException(); }
  /** Attributes of the input row currently used for output. */
  protected  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> inputAttrs ()  { throw new RuntimeException(); }
  /** Index of the input row currently used for output. */
  protected  int inputIndex ()  { throw new RuntimeException(); }
  /**
   * An iterator over the {@link input}
   * @return (undocumented)
   */
  protected  scala.collection.Iterator<org.apache.spark.sql.catalyst.expressions.UnsafeRow> inputIterator ()  { throw new RuntimeException(); }
  /** Holder the UnsafeRow where the input operator by function is not null. */
  protected  org.apache.spark.sql.catalyst.InternalRow nextSelectedRow ()  { throw new RuntimeException(); }
  /** Check if the output value of the first index is null. */
  protected  boolean nullCheck (org.apache.spark.sql.catalyst.InternalRow row)  { throw new RuntimeException(); }
  /** Create the projection to determine whether input is null. */
  protected  org.apache.spark.sql.catalyst.expressions.UnsafeProjection project ()  { throw new RuntimeException(); }
  /**
   * Create the projection used when the offset row exists.
   * Please note that this project always respect null input values (like PostgreSQL).
   * @return (undocumented)
   */
  protected  org.apache.spark.sql.catalyst.expressions.MutableProjection projection ()  { throw new RuntimeException(); }
  protected  void resetStates (org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray rows)  { throw new RuntimeException(); }
  protected  int skippedNonNullCount ()  { throw new RuntimeException(); }
}
