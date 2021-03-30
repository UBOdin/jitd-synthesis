package org.apache.spark.sql.execution.adaptive;
/**
 * The LogicalPlan wrapper for a {@link QueryStageExec}, or a snippet of physical plan containing
 * a {@link QueryStageExec}, in which all ancestor nodes of the {@link QueryStageExec} are linked to
 * the same logical node.
 * <p>
 * For example, a logical Aggregate can be transformed into FinalAgg - Shuffle - PartialAgg, in
 * which the Shuffle will be wrapped into a {@link QueryStageExec}, thus the {@link LogicalQueryStage}
 * will have FinalAgg - QueryStageExec as its physical plan.
 */
public  class LogicalQueryStage extends org.apache.spark.sql.catalyst.plans.logical.LeafNode implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan logicalPlan ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan physicalPlan ()  { throw new RuntimeException(); }
  // not preceding
  public   LogicalQueryStage (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan logicalPlan, org.apache.spark.sql.execution.SparkPlan physicalPlan)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  boolean isStreaming ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> outputOrdering ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.Statistics computeStats ()  { throw new RuntimeException(); }
}
