package org.apache.spark.sql.execution;
public  class ExplainUtils$ implements org.apache.spark.sql.execution.adaptive.AdaptiveSparkPlanHelper {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final ExplainUtils$ MODULE$ = null;
  public   ExplainUtils$ ()  { throw new RuntimeException(); }
  /**
   * Given a input physical plan, performs the following tasks.
   *   1. Generates the explain output for the input plan excluding the subquery plans.
   *   2. Generates the explain output for each subquery referenced in the plan.
   * @param plan (undocumented)
   * @param append (undocumented)
   */
  public <T extends org.apache.spark.sql.catalyst.plans.QueryPlan<T>> void processPlan (scala.Function0<org.apache.spark.sql.catalyst.plans.QueryPlan<T>> plan, scala.Function1<java.lang.String, scala.runtime.BoxedUnit> append)  { throw new RuntimeException(); }
  /**
   * Generate detailed field string with different format based on type of input value
   * @param fieldName (undocumented)
   * @param values (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String generateFieldString (java.lang.String fieldName, Object values)  { throw new RuntimeException(); }
  /**
   * Returns the operator identifier for the supplied plan by retrieving the
   * <code>operationId</code> tag value.
   * @param plan (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String getOpId (org.apache.spark.sql.catalyst.plans.QueryPlan<?> plan)  { throw new RuntimeException(); }
  public  void removeTags (org.apache.spark.sql.catalyst.plans.QueryPlan<?> plan)  { throw new RuntimeException(); }
}
