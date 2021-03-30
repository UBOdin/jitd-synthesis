package org.apache.spark.sql.catalyst.expressions.aggregate;
/**
 * An {@link AggregateFunction} with {@link PartialMerge} mode is used to merge aggregation buffers
 * containing intermediate results for this function.
 * This function updates the given aggregation buffer by merging multiple aggregation buffers.
 * When it has processed all input rows, the aggregation buffer is returned.
 */
public  class PartialMerge$ implements org.apache.spark.sql.catalyst.expressions.aggregate.AggregateMode, scala.Product, scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final PartialMerge$ MODULE$ = null;
  public   PartialMerge$ ()  { throw new RuntimeException(); }
}
