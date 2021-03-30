package org.apache.spark.sql.catalyst.optimizer;
/**
 * PythonUDF in join condition can't be evaluated if it refers to attributes from both join sides.
 * See <code>ExtractPythonUDFs</code> for details. This rule will detect un-evaluable PythonUDF and pull them
 * out from join condition.
 */
public  class ExtractPythonUDFFromJoinCondition$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> implements org.apache.spark.sql.catalyst.expressions.PredicateHelper {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final ExtractPythonUDFFromJoinCondition$ MODULE$ = null;
  public   ExtractPythonUDFFromJoinCondition$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
