package org.apache.spark.sql.hive.execution;
/**
 * Prune hive table partitions using partition filters on {@link HiveTableRelation}. The pruned
 * partitions will be kept in {@link HiveTableRelation.prunedPartitions}, and the statistics of
 * the hive table relation will be updated based on pruned partitions.
 * <p>
 * This rule is executed in optimization phase, so the statistics can be updated before physical
 * planning, which is useful for some spark strategy, e.g.
 * {@link org.apache.spark.sql.execution.SparkStrategies.JoinSelection}.
 * <p>
 * TODO: merge this with PruneFileSourcePartitions after we completely make hive as a data source.
 */
  class PruneHiveTablePartitions extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> implements org.apache.spark.sql.catalyst.analysis.CastSupport, org.apache.spark.sql.catalyst.expressions.PredicateHelper {
  public   PruneHiveTablePartitions (org.apache.spark.sql.SparkSession session)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
