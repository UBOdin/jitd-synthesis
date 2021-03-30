package org.apache.spark.sql.execution.datasources;
/**
 * Prunes unnecessary physical columns given a {@link PhysicalOperation} over a data source relation.
 * By "physical column", we mean a column as defined in the data source format like Parquet format
 * or ORC format. For example, in Spark SQL, a root-level Parquet column corresponds to a SQL
 * column, and a nested Parquet column corresponds to a {@link StructField}.
 */
public  class SchemaPruning$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final SchemaPruning$ MODULE$ = null;
  public   SchemaPruning$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
