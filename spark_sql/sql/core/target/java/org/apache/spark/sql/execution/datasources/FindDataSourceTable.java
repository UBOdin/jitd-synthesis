package org.apache.spark.sql.execution.datasources;
/**
 * Replaces {@link UnresolvedCatalogRelation} with concrete relation logical plans.
 * <p>
 * TODO: we should remove the special handling for hive tables after completely making hive as a
 * data source.
 */
public  class FindDataSourceTable extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  public   FindDataSourceTable (org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
