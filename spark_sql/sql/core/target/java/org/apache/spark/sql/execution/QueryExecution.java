package org.apache.spark.sql.execution;
/**
 * The primary workflow for executing relational queries using Spark.  Designed to allow easy
 * access to the intermediate phases of query execution for developers.
 * <p>
 * While this is not a public class, we should avoid changing the function names for the sake of
 * changing them, because a lot of developers use the feature for debugging.
 */
public  class QueryExecution implements org.apache.spark.internal.Logging {
  /** A special namespace for commands that can be used to debug query execution. */
  public  class debug$ {
    public   debug$ ()  { throw new RuntimeException(); }
    /**
     * Prints to stdout all the generated code found in this plan (i.e. the output of each
     * WholeStageCodegen subtree).
     */
    public  void codegen ()  { throw new RuntimeException(); }
    /**
     * Get WholeStageCodegenExec subtrees and the codegen in a query plan
     * <p>
     * @return Sequence of WholeStageCodegen subtrees and corresponding codegen
     */
    public  scala.collection.Seq<scala.Tuple3<java.lang.String, java.lang.String, org.apache.spark.sql.catalyst.expressions.codegen.ByteCodeStats>> codegenToSeq ()  { throw new RuntimeException(); }
    /**
     * Dumps debug information about query execution into the specified file.
     * <p>
     * @param path path of the file the debug info is written to.
     * @param maxFields maximum number of fields converted to string representation.
     * @param explainMode the explain mode to be used to generate the string
     *                    representation of the plan.
     */
    public  void toFile (java.lang.String path, int maxFields, scala.Option<java.lang.String> explainMode)  { throw new RuntimeException(); }
  }
  /**
   * Prepares a planned {@link SparkPlan} for execution by inserting shuffle operations and internal
   * row format conversions as needed.
   * @param preparations (undocumented)
   * @param plan (undocumented)
   * @return (undocumented)
   */
  static   org.apache.spark.sql.execution.SparkPlan prepareForExecution (scala.collection.Seq<org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.execution.SparkPlan>> preparations, org.apache.spark.sql.execution.SparkPlan plan)  { throw new RuntimeException(); }
  /**
   * Transform a {@link LogicalPlan} into a {@link SparkPlan}.
   * <p>
   * Note that the returned physical plan still needs to be prepared for execution.
   * @param sparkSession (undocumented)
   * @param planner (undocumented)
   * @param plan (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.execution.SparkPlan createSparkPlan (org.apache.spark.sql.SparkSession sparkSession, org.apache.spark.sql.execution.SparkPlanner planner, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  /**
   * Prepare the {@link SparkPlan} for execution.
   * @param spark (undocumented)
   * @param plan (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.execution.SparkPlan prepareExecutedPlan (org.apache.spark.sql.SparkSession spark, org.apache.spark.sql.execution.SparkPlan plan)  { throw new RuntimeException(); }
  /**
   * Transform the subquery's {@link LogicalPlan} into a {@link SparkPlan} and prepare the resulting
   * {@link SparkPlan} for execution.
   * @param spark (undocumented)
   * @param plan (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.execution.SparkPlan prepareExecutedPlan (org.apache.spark.sql.SparkSession spark, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  /**
   * Accessor for nested Scala object
   * @return (undocumented)
   */
  public  org.apache.spark.sql.execution.QueryExecution.debug$ debug ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.SparkSession sparkSession ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan logical ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.QueryPlanningTracker tracker ()  { throw new RuntimeException(); }
  // not preceding
  public   QueryExecution (org.apache.spark.sql.SparkSession sparkSession, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan logical, org.apache.spark.sql.catalyst.QueryPlanningTracker tracker)  { throw new RuntimeException(); }
  public  long id ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.execution.SparkPlanner planner ()  { throw new RuntimeException(); }
  public  void assertAnalyzed ()  { throw new RuntimeException(); }
  public  void assertSupported ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan analyzed ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan withCachedData ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan optimizedPlan ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.execution.SparkPlan sparkPlan ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.execution.SparkPlan executedPlan ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> toRdd ()  { throw new RuntimeException(); }
  /** Get the metrics observed during the execution of the query plan. */
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.Row> observedMetrics ()  { throw new RuntimeException(); }
  protected  scala.collection.Seq<org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.execution.SparkPlan>> preparations ()  { throw new RuntimeException(); }
  protected <T extends java.lang.Object> T executePhase (java.lang.String phase, scala.Function0<T> block)  { throw new RuntimeException(); }
  public  java.lang.String simpleString ()  { throw new RuntimeException(); }
  public  java.lang.String explainString (org.apache.spark.sql.execution.ExplainMode mode)  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String stringWithStats ()  { throw new RuntimeException(); }
}
