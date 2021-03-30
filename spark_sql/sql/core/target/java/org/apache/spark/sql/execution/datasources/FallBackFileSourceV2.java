package org.apache.spark.sql.execution.datasources;
/**
 * Replace the File source V2 table in {@link InsertIntoStatement} to V1 {@link FileFormat}.
 * E.g, with temporary view <code>t</code> using
 * {@link org.apache.spark.sql.execution.datasources.v2.FileDataSourceV2}, inserting into view <code>t</code> fails
 * since there is no corresponding physical plan.
 * This is a temporary hack for making current data source V2 work. It should be
 * removed when Catalog support of file data source v2 is finished.
 */
public  class FallBackFileSourceV2 extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  public   FallBackFileSourceV2 (org.apache.spark.sql.SparkSession sparkSession)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
