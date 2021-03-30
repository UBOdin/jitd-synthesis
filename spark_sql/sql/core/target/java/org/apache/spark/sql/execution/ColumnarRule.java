package org.apache.spark.sql.execution;
/**
 * Holds a user defined rule that can be used to inject columnar implementations of various
 * operators in the plan. The {@link preColumnarTransitions} {@link Rule} can be used to replace
 * {@link SparkPlan} instances with versions that support a columnar implementation. After this
 * Spark will insert any transitions necessary. This includes transitions from row to columnar
 * {@link RowToColumnarExec} and from columnar to row {@link ColumnarToRowExec}. At this point the
 * {@link postColumnarTransitions} {@link Rule} is called to allow replacing any of the implementations
 * of the transitions or doing cleanup of the plan, like inserting stages to build larger batches
 * for more efficient processing, or stages that transition the data to/from an accelerator's
 * memory.
 */
public  class ColumnarRule {
  public   ColumnarRule ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.execution.SparkPlan> postColumnarTransitions ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.execution.SparkPlan> preColumnarTransitions ()  { throw new RuntimeException(); }
}
