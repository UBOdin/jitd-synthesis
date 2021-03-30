package org.apache.spark.sql.catalyst.optimizer;
/**
 * Simplifies binary comparisons with semantically-equal expressions:
 * 1) Replace '<=&gt;' with 'true' literal.
 * 2) Replace '=', '<=', and '>=' with 'true' literal if both operands are non-nullable.
 * 3) Replace '<' and '>' with 'false' literal if both operands are non-nullable.
 */
public  class SimplifyBinaryComparison$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> implements org.apache.spark.sql.catalyst.expressions.PredicateHelper, org.apache.spark.sql.catalyst.plans.logical.ConstraintHelper {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final SimplifyBinaryComparison$ MODULE$ = null;
  public   SimplifyBinaryComparison$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
