package org.apache.spark.sql.execution.datasources;
/**
 * Replaces {@link UnresolvedRelation}s if the plan is for direct query on files.
 */
public  class ResolveSQLOnFile extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  public   ResolveSQLOnFile (org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
