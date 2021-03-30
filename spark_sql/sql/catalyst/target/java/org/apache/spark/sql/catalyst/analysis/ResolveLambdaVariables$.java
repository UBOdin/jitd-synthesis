package org.apache.spark.sql.catalyst.analysis;
/**
 * Resolve the lambda variables exposed by a higher order functions.
 * <p>
 * This rule works in two steps:
 * [1]. Bind the anonymous variables exposed by the higher order function to the lambda function's
 *      arguments; this creates named and typed lambda variables. The argument names are checked
 *      for duplicates and the number of arguments are checked during this step.
 * [2]. Resolve the used lambda variables used in the lambda function's function expression tree.
 *      Note that we allow the use of variables from outside the current lambda, this can either
 *      be a lambda function defined in an outer scope, or a attribute in produced by the plan's
 *      child. If names are duplicate, the name defined in the most inner scope is used.
 */
public  class ResolveLambdaVariables$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final ResolveLambdaVariables$ MODULE$ = null;
  public   ResolveLambdaVariables$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
