package org.apache.spark.sql.execution.dynamicpruning;
/**
 * Dynamic partition pruning optimization is performed based on the type and
 * selectivity of the join operation. During query optimization, we insert a
 * predicate on the partitioned table using the filter from the other side of
 * the join and a custom wrapper called DynamicPruning.
 * <p>
 * The basic mechanism for DPP inserts a duplicated subquery with the filter from the other side,
 * when the following conditions are met:
 *    (1) the table to prune is partitioned by the JOIN key
 *    (2) the join operation is one of the following types: INNER, LEFT SEMI,
 *    LEFT OUTER (partitioned on right), or RIGHT OUTER (partitioned on left)
 * <p>
 * In order to enable partition pruning directly in broadcasts, we use a custom DynamicPruning
 * clause that incorporates the In clause with the subquery and the benefit estimation.
 * During query planning, when the join type is known, we use the following mechanism:
 *    (1) if the join is a broadcast hash join, we replace the duplicated subquery with the reused
 *    results of the broadcast,
 *    (2) else if the estimated benefit of partition pruning outweighs the overhead of running the
 *    subquery query twice, we keep the duplicated subquery
 *    (3) otherwise, we drop the subquery.
 */
public  class PartitionPruning$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> implements org.apache.spark.sql.catalyst.expressions.PredicateHelper {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final PartitionPruning$ MODULE$ = null;
  public   PartitionPruning$ ()  { throw new RuntimeException(); }
  /**
   * Search the partitioned table scan for a given partition column in a logical plan
   * @param a (undocumented)
   * @param plan (undocumented)
   * @return (undocumented)
   */
  public  scala.Option<org.apache.spark.sql.execution.datasources.LogicalRelation> getPartitionTableScan (org.apache.spark.sql.catalyst.expressions.Expression a, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
