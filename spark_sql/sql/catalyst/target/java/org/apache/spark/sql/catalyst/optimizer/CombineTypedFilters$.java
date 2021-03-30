package org.apache.spark.sql.catalyst.optimizer;
/**
 * Combines two adjacent {@link TypedFilter}s, which operate on same type object in condition, into one,
 * merging the filter functions into one conjunctive function.
 */
public  class CombineTypedFilters$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final CombineTypedFilters$ MODULE$ = null;
  public   CombineTypedFilters$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
