package org.apache.spark.sql.catalyst.expressions.aggregate;
/**
 * An {@link AggregateFunction} with {@link Final} mode is used to merge aggregation buffers
 * containing intermediate results for this function and then generate final result.
 * This function updates the given aggregation buffer by merging multiple aggregation buffers.
 * When it has processed all input rows, the final result of this function is returned.
 */
public  class Final$ implements org.apache.spark.sql.catalyst.expressions.aggregate.AggregateMode, scala.Product, scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final Final$ MODULE$ = null;
  public   Final$ ()  { throw new RuntimeException(); }
}
