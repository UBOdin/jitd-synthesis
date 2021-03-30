package org.apache.spark.sql.catalyst.analysis;
/**
 * Helper object for stream joins. See {@link StreamingSymmetricHashJoinExec} in SQL for more details.
 */
public  class StreamingJoinHelper$ implements org.apache.spark.sql.catalyst.expressions.PredicateHelper, org.apache.spark.internal.Logging {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final StreamingJoinHelper$ MODULE$ = null;
  public   StreamingJoinHelper$ ()  { throw new RuntimeException(); }
  /**
   * Check the provided logical plan to see if its join keys contain a watermark attribute.
   * <p>
   * Will return false if the plan is not an equijoin.
   * @param plan the logical plan to check
   * @return (undocumented)
   */
  public  boolean isWatermarkInJoinKeys (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  /**
   * Get state value watermark (see {@link StreamingSymmetricHashJoinExec} for context about it)
   * given the join condition and the event time watermark. This is how it works.
   * - The condition is split into conjunctive predicates, and we find the predicates of the
   *   form <code>leftTime + c1 < rightTime + c2</code>   (or <=, >, >=).
   * - We canonicalize the predicate and solve it with the event time watermark value to find the
   *  value of the state watermark.
   * This function is supposed to make best-effort attempt to get the state watermark. If there is
   * any error, it will return None.
   * <p>
   * @param attributesToFindStateWatermarkFor attributes of the side whose state watermark
   *                                         is to be calculated
   * @param attributesWithEventWatermark  attributes of the other side which has a watermark column
   * @param joinCondition                 join condition
   * @param eventWatermark                watermark defined on the input event data
   * @return state value watermark in milliseconds, is possible.
   */
  public  scala.Option<java.lang.Object> getStateValueWatermark (org.apache.spark.sql.catalyst.expressions.AttributeSet attributesToFindStateWatermarkFor, org.apache.spark.sql.catalyst.expressions.AttributeSet attributesWithEventWatermark, scala.Option<org.apache.spark.sql.catalyst.expressions.Expression> joinCondition, scala.Option<java.lang.Object> eventWatermark)  { throw new RuntimeException(); }
}
