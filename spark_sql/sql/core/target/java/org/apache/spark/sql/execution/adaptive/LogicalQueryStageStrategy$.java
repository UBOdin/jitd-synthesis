package org.apache.spark.sql.execution.adaptive;
/**
 * Strategy for plans containing {@link LogicalQueryStage} nodes:
 * 1. Transforms {@link LogicalQueryStage} to its corresponding physical plan that is either being
 *    executed or has already completed execution.
 * 2. Transforms {@link Join} which has one child relation already planned and executed as a
 *    {@link BroadcastQueryStageExec}. This is to prevent reversing a broadcast stage into a shuffle
 *    stage in case of the larger join child relation finishes before the smaller relation. Note
 *    that this rule needs to applied before regular join strategies.
 */
public  class LogicalQueryStageStrategy$ extends org.apache.spark.sql.execution.SparkStrategy implements org.apache.spark.sql.catalyst.expressions.PredicateHelper {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final LogicalQueryStageStrategy$ MODULE$ = null;
  public   LogicalQueryStageStrategy$ ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.execution.SparkPlan> apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
