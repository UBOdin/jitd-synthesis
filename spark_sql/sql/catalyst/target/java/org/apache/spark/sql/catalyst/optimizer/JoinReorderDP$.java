package org.apache.spark.sql.catalyst.optimizer;
/**
 * Reorder the joins using a dynamic programming algorithm. This implementation is based on the
 * paper: Access Path Selection in a Relational Database Management System.
 * https://dl.acm.org/doi/10.1145/582095.582099
 * <p>
 * First we put all items (basic joined nodes) into level 0, then we build all two-way joins
 * at level 1 from plans at level 0 (single items), then build all 3-way joins from plans
 * at previous levels (two-way joins and single items), then 4-way joins ... etc, until we
 * build all n-way joins and pick the best plan among them.
 * <p>
 * When building m-way joins, we only keep the best plan (with the lowest cost) for the same set
 * of m items. E.g., for 3-way joins, we keep only the best plan for items {A, B, C} among
 * plans (A J B) J C, (A J C) J B and (B J C) J A.
 * We also prune cartesian product candidates when building a new plan if there exists no join
 * condition involving references from both left and right. This pruning strategy significantly
 * reduces the search space.
 * E.g., given A J B J C J D with join conditions A.k1 = B.k1 and B.k2 = C.k2 and C.k3 = D.k3,
 * plans maintained for each level are as follows:
 * level 0: p({A}), p({B}), p({C}), p({D})
 * level 1: p({A, B}), p({B, C}), p({C, D})
 * level 2: p({A, B, C}), p({B, C, D})
 * level 3: p({A, B, C, D})
 * where p({A, B, C, D}) is the final output plan.
 * <p>
 * For cost evaluation, since physical costs for operators are not available currently, we use
 * cardinalities and sizes to compute costs.
 */
public  class JoinReorderDP$ implements org.apache.spark.sql.catalyst.expressions.PredicateHelper, org.apache.spark.internal.Logging {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final JoinReorderDP$ MODULE$ = null;
  public   JoinReorderDP$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan search (org.apache.spark.sql.internal.SQLConf conf, scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> items, org.apache.spark.sql.catalyst.expressions.ExpressionSet conditions, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output)  { throw new RuntimeException(); }
}
