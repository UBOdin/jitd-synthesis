package org.apache.spark.sql.execution;
public  class QueryExecution$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final QueryExecution$ MODULE$ = null;
  public   QueryExecution$ ()  { throw new RuntimeException(); }
  /**
   * Construct a sequence of rules that are used to prepare a planned {@link SparkPlan} for execution.
   * These rules will make sure subqueries are planned, make use the data partitioning and ordering
   * are correct, insert whole stage code gen, and try to reduce the work done by reusing exchanges
   * and subqueries.
   * @param sparkSession (undocumented)
   * @param adaptiveExecutionRule (undocumented)
   * @return (undocumented)
   */
    scala.collection.Seq<org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.execution.SparkPlan>> preparations (org.apache.spark.sql.SparkSession sparkSession, scala.Option<org.apache.spark.sql.execution.adaptive.InsertAdaptiveSparkPlan> adaptiveExecutionRule)  { throw new RuntimeException(); }
  /**
   * Prepares a planned {@link SparkPlan} for execution by inserting shuffle operations and internal
   * row format conversions as needed.
   * @param preparations (undocumented)
   * @param plan (undocumented)
   * @return (undocumented)
   */
    org.apache.spark.sql.execution.SparkPlan prepareForExecution (scala.collection.Seq<org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.execution.SparkPlan>> preparations, org.apache.spark.sql.execution.SparkPlan plan)  { throw new RuntimeException(); }
  /**
   * Transform a {@link LogicalPlan} into a {@link SparkPlan}.
   * <p>
   * Note that the returned physical plan still needs to be prepared for execution.
   * @param sparkSession (undocumented)
   * @param planner (undocumented)
   * @param plan (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.execution.SparkPlan createSparkPlan (org.apache.spark.sql.SparkSession sparkSession, org.apache.spark.sql.execution.SparkPlanner planner, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  /**
   * Prepare the {@link SparkPlan} for execution.
   * @param spark (undocumented)
   * @param plan (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.execution.SparkPlan prepareExecutedPlan (org.apache.spark.sql.SparkSession spark, org.apache.spark.sql.execution.SparkPlan plan)  { throw new RuntimeException(); }
  /**
   * Transform the subquery's {@link LogicalPlan} into a {@link SparkPlan} and prepare the resulting
   * {@link SparkPlan} for execution.
   * @param spark (undocumented)
   * @param plan (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.execution.SparkPlan prepareExecutedPlan (org.apache.spark.sql.SparkSession spark, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
