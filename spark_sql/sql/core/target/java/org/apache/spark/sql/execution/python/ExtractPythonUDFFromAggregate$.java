package org.apache.spark.sql.execution.python;
/**
 * Extracts all the Python UDFs in logical aggregate, which depends on aggregate expression or
 * grouping key, or doesn't depend on any above expressions, evaluate them after aggregate.
 */
public  class ExtractPythonUDFFromAggregate$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final ExtractPythonUDFFromAggregate$ MODULE$ = null;
  public   ExtractPythonUDFFromAggregate$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
