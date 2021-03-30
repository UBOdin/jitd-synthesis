package org.apache.spark.sql.execution.datasources;
/**
 * Preprocess the {@link InsertIntoStatement} plan. Throws exception if the number of columns mismatch,
 * or specified partition columns are different from the existing partition columns in the target
 * table. It also does data type casting and field renaming, to make sure that the columns to be
 * inserted have the correct data type and fields have the correct names.
 */
public  class PreprocessTableInsertion$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final PreprocessTableInsertion$ MODULE$ = null;
  public   PreprocessTableInsertion$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
