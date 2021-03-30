package org.apache.spark.sql.catalyst.analysis;
/**
 * Ignore event time watermark in batch query, which is only supported in Structured Streaming.
 * TODO: add this rule into analyzer rule list.
 */
public  class EliminateEventTimeWatermark$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final EliminateEventTimeWatermark$ MODULE$ = null;
  public   EliminateEventTimeWatermark$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
