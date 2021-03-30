package org.apache.spark.sql.execution.python;
/**
 * Extracts PythonUDFs in logical aggregate, which are used in grouping keys, evaluate them
 * before aggregate.
 * This must be executed after <code>ExtractPythonUDFFromAggregate</code> rule and before <code>ExtractPythonUDFs</code>.
 */
public  class ExtractGroupingPythonUDFFromAggregate$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final ExtractGroupingPythonUDFFromAggregate$ MODULE$ = null;
  public   ExtractGroupingPythonUDFFromAggregate$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
