package org.apache.spark.sql.catalyst.optimizer;
/**
 * This rule rewrites correlated {@link ScalarSubquery} expressions into LEFT OUTER joins.
 */
public  class RewriteCorrelatedScalarSubquery$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> implements org.apache.spark.sql.catalyst.expressions.AliasHelper {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final RewriteCorrelatedScalarSubquery$ MODULE$ = null;
  public   RewriteCorrelatedScalarSubquery$ ()  { throw new RuntimeException(); }
  public  java.lang.String ALWAYS_TRUE_COLNAME ()  { throw new RuntimeException(); }
  /**
   * Rewrite {@link Filter}, {@link Project} and {@link Aggregate} plans containing correlated scalar
   * subqueries.
   * @param plan (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
