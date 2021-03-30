package org.apache.spark.sql.catalyst.expressions.aggregate;
/**
 * An {@link AggregateFunction} with {@link Partial} mode is used for partial aggregation.
 * This function updates the given aggregation buffer with the original input of this
 * function. When it has processed all input rows, the aggregation buffer is returned.
 */
public  class Partial$ implements org.apache.spark.sql.catalyst.expressions.aggregate.AggregateMode, scala.Product, scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final Partial$ MODULE$ = null;
  public   Partial$ ()  { throw new RuntimeException(); }
}
