package org.apache.spark.sql.catalyst.plans.logical;
/**
 * The logical plan of the MERGE INTO command.
 */
public  class MergeIntoTable extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.catalyst.plans.logical.Command, org.apache.spark.sql.catalyst.plans.logical.SupportsSubquery, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan targetTable ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan sourceTable ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression mergeCondition ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.MergeAction> matchedActions ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.MergeAction> notMatchedActions ()  { throw new RuntimeException(); }
  // not preceding
  public   MergeIntoTable (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan targetTable, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan sourceTable, org.apache.spark.sql.catalyst.expressions.Expression mergeCondition, scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.MergeAction> matchedActions, scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.MergeAction> notMatchedActions)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> children ()  { throw new RuntimeException(); }
  public  boolean duplicateResolved ()  { throw new RuntimeException(); }
}
