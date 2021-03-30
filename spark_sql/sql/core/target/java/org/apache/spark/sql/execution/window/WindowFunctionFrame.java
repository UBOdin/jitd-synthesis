package org.apache.spark.sql.execution.window;
/**
 * A window function calculates the results of a number of window functions for a window frame.
 * Before use a frame must be prepared by passing it all the rows in the current partition. After
 * preparation the update method can be called to fill the output rows.
 * <p>
 * Note: <code>WindowFunctionFrame</code> instances are reused during window execution. The <code>prepare</code> method
 * will be called before processing the next partition, and must reset the states.
 */
public abstract class WindowFunctionFrame {
  static public  org.apache.spark.sql.catalyst.expressions.UnsafeRow getNextOrNull (scala.collection.Iterator<org.apache.spark.sql.catalyst.expressions.UnsafeRow> iterator)  { throw new RuntimeException(); }
  public   WindowFunctionFrame ()  { throw new RuntimeException(); }
  /**
   * Prepare the frame for calculating the results for a partition.
   * <p>
   * @param rows to calculate the frame results for.
   */
  public abstract  void prepare (org.apache.spark.sql.execution.ExternalAppendOnlyUnsafeRowArray rows)  ;
  /**
   * Write the current results to the target row.
   * @param index (undocumented)
   * @param current (undocumented)
   */
  public abstract  void write (int index, org.apache.spark.sql.catalyst.InternalRow current)  ;
  /**
   * The current lower window bound in the row array (inclusive).
   * <p>
   * This should be called after the current row is updated via <code>write</code>.
   * @return (undocumented)
   */
  public abstract  int currentLowerBound ()  ;
  /**
   * The current row index of the upper window bound in the row array (exclusive)
   * <p>
   * This should be called after the current row is updated via <code>write</code>.
   * @return (undocumented)
   */
  public abstract  int currentUpperBound ()  ;
}
