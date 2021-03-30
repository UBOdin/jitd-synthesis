package org.apache.spark.sql.catalyst.expressions;
public  interface OffsetWindowFunction extends org.apache.spark.sql.catalyst.expressions.WindowFunction {
  /**
   * A fake window frame which is used to hold the offset information. It's used as a key to group
   * by offset window functions in <code>WindowExecBase.windowFrameExpressionFactoryPairs</code>, as offset
   * window functions with the same offset and same window frame can be evaluated together.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.SpecifiedWindowFrame fakeFrame ()  ;
  /**
   * An optional specification that indicates the offset window function should skip null values in
   * the determination of which row to use.
   * @return (undocumented)
   */
  public  boolean ignoreNulls ()  ;
  /**
   * Input expression to evaluate against a row which a number of rows below or above (depending on
   * the value and sign of the offset) the starting row (current row if isRelative=true, or the
   * first row of the window frame otherwise).
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Expression input ()  ;
  /**
   * (Foldable) expression that contains the number of rows between the current row and the row
   * where the input expression is evaluated. If <code>offset</code> is a positive integer, it means that
   * the direction of the <code>offset</code> is from front to back. If it is a negative integer, the direction
   * of the <code>offset</code> is from back to front. If it is zero, it means that the offset is ignored and
   * use current row.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Expression offset ()  ;
}
