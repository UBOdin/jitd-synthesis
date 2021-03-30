package org.apache.spark.sql.catalyst.plans.logical;
/**
 * {@link PlanHelper} contains utility methods that can be used by Analyzer and Optimizer.
 * It can also be container of methods that are common across multiple rules in Analyzer
 * and Optimizer.
 */
public  class PlanHelper$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final PlanHelper$ MODULE$ = null;
  public   PlanHelper$ ()  { throw new RuntimeException(); }
  /**
   * Check if there's any expression in this query plan operator that is
   * - A WindowExpression but the plan is not Window
   * - An AggregateExpression but the plan is not Aggregate or Window
   * - A Generator but the plan is not Generate
   * Returns the list of invalid expressions that this operator hosts. This can happen when
   * 1. The input query from users contain invalid expressions.
   *    Example : SELECT * FROM tab WHERE max(c1) > 0
   * 2. Query rewrites inadvertently produce plans that are invalid.
   * @param plan (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> specialExpressionsInUnsupportedOperator (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
