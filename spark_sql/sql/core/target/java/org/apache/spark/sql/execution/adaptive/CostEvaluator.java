package org.apache.spark.sql.execution.adaptive;
/**
 * Evaluates the cost of a physical plan.
 */
public  interface CostEvaluator {
  public  org.apache.spark.sql.execution.adaptive.Cost evaluateCost (org.apache.spark.sql.execution.SparkPlan plan)  ;
}
