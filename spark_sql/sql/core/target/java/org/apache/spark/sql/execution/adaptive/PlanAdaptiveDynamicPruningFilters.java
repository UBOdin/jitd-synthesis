package org.apache.spark.sql.execution.adaptive;
/**
 * A rule to insert dynamic pruning predicates in order to reuse the results of broadcast.
 */
public  class PlanAdaptiveDynamicPruningFilters extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.execution.SparkPlan> implements scala.Product, scala.Serializable {
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.concurrent.TrieMap<org.apache.spark.sql.execution.SparkPlan, org.apache.spark.sql.execution.adaptive.QueryStageExec> stageCache ()  { throw new RuntimeException(); }
  // not preceding
  public   PlanAdaptiveDynamicPruningFilters (scala.collection.concurrent.TrieMap<org.apache.spark.sql.execution.SparkPlan, org.apache.spark.sql.execution.adaptive.QueryStageExec> stageCache)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan apply (org.apache.spark.sql.execution.SparkPlan plan)  { throw new RuntimeException(); }
}
