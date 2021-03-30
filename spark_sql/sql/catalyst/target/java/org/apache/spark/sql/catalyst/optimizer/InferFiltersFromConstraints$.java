package org.apache.spark.sql.catalyst.optimizer;
/**
 * Generate a list of additional filters from an operator's existing constraint but remove those
 * that are either already part of the operator's condition or are part of the operator's child
 * constraints. These filters are currently inserted to the existing conditions in the Filter
 * operators and on either side of Join operators.
 * <p>
 * Note: While this optimization is applicable to a lot of types of join, it primarily benefits
 * Inner and LeftSemi joins.
 */
public  class InferFiltersFromConstraints$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> implements org.apache.spark.sql.catalyst.expressions.PredicateHelper, org.apache.spark.sql.catalyst.plans.logical.ConstraintHelper {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final InferFiltersFromConstraints$ MODULE$ = null;
  public   InferFiltersFromConstraints$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
