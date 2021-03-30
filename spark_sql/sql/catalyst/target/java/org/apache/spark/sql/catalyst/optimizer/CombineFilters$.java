package org.apache.spark.sql.catalyst.optimizer;
/**
 * Combines two adjacent {@link Filter} operators into one, merging the non-redundant conditions into
 * one conjunctive predicate.
 */
public  class CombineFilters$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> implements org.apache.spark.sql.catalyst.expressions.PredicateHelper {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final CombineFilters$ MODULE$ = null;
  public   CombineFilters$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  public  scala.PartialFunction<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> applyLocally ()  { throw new RuntimeException(); }
}
