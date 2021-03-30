package org.apache.spark.sql.execution.adaptive;
/**
 * This rule wraps the query plan with an {@link AdaptiveSparkPlanExec}, which executes the query plan
 * and re-optimize the plan during execution based on runtime data statistics.
 * <p>
 * Note that this rule is stateful and thus should not be reused across query executions.
 */
public  class InsertAdaptiveSparkPlan extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.execution.SparkPlan> implements scala.Product, scala.Serializable {
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.adaptive.AdaptiveExecutionContext adaptiveExecutionContext ()  { throw new RuntimeException(); }
  // not preceding
  public   InsertAdaptiveSparkPlan (org.apache.spark.sql.execution.adaptive.AdaptiveExecutionContext adaptiveExecutionContext)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan apply (org.apache.spark.sql.execution.SparkPlan plan)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan compileSubquery (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
