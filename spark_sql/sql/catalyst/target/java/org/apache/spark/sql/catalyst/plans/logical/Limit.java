package org.apache.spark.sql.catalyst.plans.logical;
/**
 * A constructor for creating a logical limit, which is split into two separate logical nodes:
 * a {@link LocalLimit}, which is a partition local limit, followed by a {@link GlobalLimit}.
 * <p>
 * This muds the water for clean logical/physical separation, and is done for better limit pushdown.
 * In distributed query processing, a non-terminal global limit is actually an expensive operation
 * because it requires coordination (in Spark this is done using a shuffle).
 * <p>
 * In most cases when we want to push down limit, it is often better to only push some partition
 * local limit. Consider the following:
 * <p>
 *   GlobalLimit(Union(A, B))
 * <p>
 * It is better to do
 *   GlobalLimit(Union(LocalLimit(A), LocalLimit(B)))
 * <p>
 * than
 *   Union(GlobalLimit(A), GlobalLimit(B)).
 * <p>
 * So we introduced LocalLimit and GlobalLimit in the logical plan node for limit pushdown.
 */
public  class Limit {
  static public  org.apache.spark.sql.catalyst.plans.logical.UnaryNode apply (org.apache.spark.sql.catalyst.expressions.Expression limitExpr, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child)  { throw new RuntimeException(); }
  static public  scala.Option<scala.Tuple2<org.apache.spark.sql.catalyst.expressions.Expression, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan>> unapply (org.apache.spark.sql.catalyst.plans.logical.GlobalLimit p)  { throw new RuntimeException(); }
}
