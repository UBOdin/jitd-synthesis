package org.apache.spark.sql.execution.adaptive;
/**
 * The optimizer for re-optimizing the logical plan used by AdaptiveSparkPlanExec.
 */
public  class AQEOptimizer extends org.apache.spark.sql.catalyst.rules.RuleExecutor<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  public   AQEOptimizer (org.apache.spark.sql.internal.SQLConf conf)  { throw new RuntimeException(); }
  protected final  scala.collection.Seq<org.apache.spark.sql.catalyst.rules.RuleExecutor<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan>.Batch> batches ()  { throw new RuntimeException(); }
  protected  boolean isPlanIntegral (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
