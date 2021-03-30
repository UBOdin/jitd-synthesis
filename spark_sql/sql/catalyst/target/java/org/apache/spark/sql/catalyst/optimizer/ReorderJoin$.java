package org.apache.spark.sql.catalyst.optimizer;
/**
 * Reorder the joins and push all the conditions into join, so that the bottom ones have at least
 * one condition.
 * <p>
 * The order of joins will not be changed if all of them already have at least one condition.
 * <p>
 * If star schema detection is enabled, reorder the star join plans based on heuristics.
 */
public  class ReorderJoin$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> implements org.apache.spark.sql.catalyst.expressions.PredicateHelper {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final ReorderJoin$ MODULE$ = null;
  public   ReorderJoin$ ()  { throw new RuntimeException(); }
  /**
   * Join a list of plans together and push down the conditions into them.
   * <p>
   * The joined plan are picked from left to right, prefer those has at least one join condition.
   * <p>
   * @param input a list of LogicalPlans to inner join and the type of inner join.
   * @param conditions a list of condition for join.
   * @return (undocumented)
   */
  public final  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan createOrderedJoin (scala.collection.Seq<scala.Tuple2<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan, org.apache.spark.sql.catalyst.plans.InnerLike>> input, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> conditions)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
