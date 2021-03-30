package org.apache.spark.sql.execution.adaptive;
/**
 * A root node to execute the query plan adaptively. It splits the query plan into independent
 * stages and executes them in order according to their dependencies. The query stage
 * materializes its output at the end. When one stage completes, the data statistics of the
 * materialized output will be used to optimize the remainder of the query.
 * <p>
 * To create query stages, we traverse the query tree bottom up. When we hit an exchange node,
 * and if all the child query stages of this exchange node are materialized, we create a new
 * query stage for this exchange node. The new stage is then materialized asynchronously once it
 * is created.
 * <p>
 * When one query stage finishes materialization, the rest query is re-optimized and planned based
 * on the latest statistics provided by all materialized stages. Then we traverse the query plan
 * again and create more stages if possible. After all stages have been materialized, we execute
 * the rest of the plan.
 */
public  class AdaptiveSparkPlanExec extends org.apache.spark.sql.execution.SparkPlan implements org.apache.spark.sql.execution.LeafExecNode, scala.Product, scala.Serializable {
  static   scala.concurrent.ExecutionContextExecutorService executionContext ()  { throw new RuntimeException(); }
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
  static public  org.apache.spark.sql.catalyst.trees.TreeNodeTag<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> TEMP_LOGICAL_PLAN_TAG ()  { throw new RuntimeException(); }
  /**
   * Apply a list of physical operator rules on a {@link SparkPlan}.
   * @param plan (undocumented)
   * @param rules (undocumented)
   * @param loggerAndBatchName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.execution.SparkPlan applyPhysicalRules (org.apache.spark.sql.execution.SparkPlan plan, scala.collection.Seq<org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.execution.SparkPlan>> rules, scala.Option<scala.Tuple2<org.apache.spark.sql.catalyst.rules.PlanChangeLogger<org.apache.spark.sql.execution.SparkPlan>, java.lang.String>> loggerAndBatchName)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan inputPlan ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.adaptive.AdaptiveExecutionContext context ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.execution.SparkPlan>> preprocessingRules ()  { throw new RuntimeException(); }
  public  boolean isSubquery ()  { throw new RuntimeException(); }
  // not preceding
  public   AdaptiveSparkPlanExec (org.apache.spark.sql.execution.SparkPlan inputPlan, org.apache.spark.sql.execution.adaptive.AdaptiveExecutionContext context, scala.collection.Seq<org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.execution.SparkPlan>> preprocessingRules, boolean isSubquery)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan executedPlan ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.internal.SQLConf conf ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan doCanonicalize ()  { throw new RuntimeException(); }
  public  void resetMetrics ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.InternalRow[] executeCollect ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.InternalRow[] executeTake (int n)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.InternalRow[] executeTail (int n)  { throw new RuntimeException(); }
  public  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> doExecute ()  { throw new RuntimeException(); }
  protected  scala.collection.Iterator<java.lang.Object> stringArgs ()  { throw new RuntimeException(); }
  public  void generateTreeString (int depth, scala.collection.Seq<java.lang.Object> lastChildren, scala.Function1<java.lang.String, scala.runtime.BoxedUnit> append, boolean verbose, java.lang.String prefix, boolean addSuffix, int maxFields, boolean printNodeId, int indent)  { throw new RuntimeException(); }
  public  int hashCode ()  { throw new RuntimeException(); }
  public  boolean equals (Object obj)  { throw new RuntimeException(); }
}
