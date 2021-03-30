package org.apache.spark.sql.expressions;
/**
 * A <code>Row</code> representing a mutable aggregation buffer.
 * <p>
 * This is not meant to be extended outside of Spark.
 * <p>
 * @since 1.5.0
 */
public abstract class MutableAggregationBuffer implements org.apache.spark.sql.Row {
  public   MutableAggregationBuffer ()  { throw new RuntimeException(); }
  /** Update the ith value of this buffer. */
  public abstract  void update (int i, Object value)  ;
}
