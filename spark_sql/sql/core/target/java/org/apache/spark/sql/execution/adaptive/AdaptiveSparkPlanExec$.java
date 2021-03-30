package org.apache.spark.sql.execution.adaptive;
public  class AdaptiveSparkPlanExec$ implements scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final AdaptiveSparkPlanExec$ MODULE$ = null;
  public   AdaptiveSparkPlanExec$ ()  { throw new RuntimeException(); }
    scala.concurrent.ExecutionContextExecutorService executionContext ()  { throw new RuntimeException(); }
  /**
   * The temporary {@link LogicalPlan} link for query stages.
   * <p>
   * Physical nodes wrapped in a {@link LogicalQueryStage} can be shared among different physical plans
   * and thus their usual logical links can be overwritten during query planning, leading to
   * situations where those nodes point to a new logical plan and the rest point to the current
   * logical plan. In this case we use temp logical links to make sure we can always trace back to
   * the original logical links until a new physical plan is adopted, by which time we can clear up
   * the temp logical links.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.trees.TreeNodeTag<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> TEMP_LOGICAL_PLAN_TAG ()  { throw new RuntimeException(); }
  /**
   * Apply a list of physical operator rules on a {@link SparkPlan}.
   * @param plan (undocumented)
   * @param rules (undocumented)
   * @param loggerAndBatchName (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.execution.SparkPlan applyPhysicalRules (org.apache.spark.sql.execution.SparkPlan plan, scala.collection.Seq<org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.execution.SparkPlan>> rules, scala.Option<scala.Tuple2<org.apache.spark.sql.catalyst.rules.PlanChangeLogger<org.apache.spark.sql.execution.SparkPlan>, java.lang.String>> loggerAndBatchName)  { throw new RuntimeException(); }
}
