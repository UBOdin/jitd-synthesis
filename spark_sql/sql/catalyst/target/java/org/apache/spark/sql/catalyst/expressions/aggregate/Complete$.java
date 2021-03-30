package org.apache.spark.sql.catalyst.expressions.aggregate;
/**
 * An {@link AggregateFunction} with {@link Complete} mode is used to evaluate this function directly
 * from original input rows without any partial aggregation.
 * This function updates the given aggregation buffer with the original input of this
 * function. When it has processed all input rows, the final result of this function is returned.
 */
public  class Complete$ implements org.apache.spark.sql.catalyst.expressions.aggregate.AggregateMode, scala.Product, scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final Complete$ MODULE$ = null;
  public   Complete$ ()  { throw new RuntimeException(); }
}
