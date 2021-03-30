package org.apache.spark.sql.catalyst.expressions;
/**
 * RangeFrame treats rows in a partition as groups of peers. All rows having the same <code>ORDER BY</code>
 * ordering are considered as peers. Values used in a range frame are considered to be logical
 * offsets.
 * For example, assuming the value of the current row's <code>ORDER BY</code> expression <code>expr</code> is <code>v</code>,
 * <code>RANGE BETWEEN 1 PRECEDING AND 1 FOLLOWING</code> represents a frame containing rows whose values
 * <code>expr</code> are in the range of [v-1, v+1].
 * <p>
 * If <code>ORDER BY</code> clause is not defined, all rows in the partition are considered as peers
 * of the current row.
 */
public  class RangeFrame$ implements org.apache.spark.sql.catalyst.expressions.FrameType, scala.Product, scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final RangeFrame$ MODULE$ = null;
  public   RangeFrame$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.AbstractDataType inputType ()  { throw new RuntimeException(); }
  public  java.lang.String sql ()  { throw new RuntimeException(); }
}
