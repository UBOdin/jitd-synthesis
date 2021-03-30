package org.apache.spark.sql.catalyst.expressions;
/**
 * The DynamicPruningSubquery expression is only used in join operations to prune one side of the
 * join with a filter from the other side of the join. It is inserted in cases where partition
 * pruning can be applied.
 * <p>
 * param:  pruningKey the filtering key of the plan to be pruned.
 * param:  buildQuery the build side of the join.
 * param:  buildKeys the join keys corresponding to the build side of the join
 * param:  onlyInBroadcast when set to false it indicates that the pruning filter is likely to be
 *  beneficial and so it should be executed even if it cannot reuse the results of the
 *  broadcast through ReuseExchange; otherwise, it will use the filter only if it
 *  can reuse the results of the broadcast through ReuseExchange
 * param:  broadcastKeyIndex the index of the filtering key collected from the broadcast
 */
public  class DynamicPruningSubquery extends org.apache.spark.sql.catalyst.expressions.SubqueryExpression implements org.apache.spark.sql.catalyst.expressions.DynamicPruning, org.apache.spark.sql.catalyst.expressions.Unevaluable, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6)  ;
  public  org.apache.spark.sql.catalyst.expressions.Expression pruningKey ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan buildQuery ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> buildKeys ()  { throw new RuntimeException(); }
  public  int broadcastKeyIndex ()  { throw new RuntimeException(); }
  public  boolean onlyInBroadcast ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.ExprId exprId ()  { throw new RuntimeException(); }
  // not preceding
  public   DynamicPruningSubquery (org.apache.spark.sql.catalyst.expressions.Expression pruningKey, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan buildQuery, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> buildKeys, int broadcastKeyIndex, boolean onlyInBroadcast, org.apache.spark.sql.catalyst.expressions.ExprId exprId)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.DynamicPruningSubquery withNewPlan (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  // not preceding
  public  boolean resolved ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.catalyst.expressions.DynamicPruning canonicalized ()  { throw new RuntimeException(); }
}
