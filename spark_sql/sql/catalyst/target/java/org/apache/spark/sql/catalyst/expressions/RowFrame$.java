package org.apache.spark.sql.catalyst.expressions;
/**
 * RowFrame treats rows in a partition individually. Values used in a row frame are considered
 * to be physical offsets.
 * For example, <code>ROW BETWEEN 1 PRECEDING AND 1 FOLLOWING</code> represents a 3-row frame,
 * from the row that precedes the current row to the row that follows the current row.
 */
public  class RowFrame$ implements org.apache.spark.sql.catalyst.expressions.FrameType, scala.Product, scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final RowFrame$ MODULE$ = null;
  public   RowFrame$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.AbstractDataType inputType ()  { throw new RuntimeException(); }
  public  java.lang.String sql ()  { throw new RuntimeException(); }
}
