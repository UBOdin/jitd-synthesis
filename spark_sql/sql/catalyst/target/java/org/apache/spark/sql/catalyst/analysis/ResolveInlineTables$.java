package org.apache.spark.sql.catalyst.analysis;
/**
 * An analyzer rule that replaces {@link UnresolvedInlineTable} with {@link LocalRelation}.
 */
public  class ResolveInlineTables$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> implements org.apache.spark.sql.catalyst.analysis.CastSupport {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final ResolveInlineTables$ MODULE$ = null;
  public   ResolveInlineTables$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  /**
   * Validates the input data dimension:
   * 1. All rows have the same cardinality.
   * 2. The number of column aliases defined is consistent with the number of columns in data.
   * <p>
   * This is package visible for unit testing.
   * @param table (undocumented)
   */
    void validateInputDimension (org.apache.spark.sql.catalyst.analysis.UnresolvedInlineTable table)  { throw new RuntimeException(); }
  /**
   * Validates that all inline table data are valid expressions that can be evaluated
   * (in this they must be foldable).
   * <p>
   * This is package visible for unit testing.
   * @param table (undocumented)
   */
    void validateInputEvaluable (org.apache.spark.sql.catalyst.analysis.UnresolvedInlineTable table)  { throw new RuntimeException(); }
  /**
   * Convert a valid (with right shape and foldable inputs) {@link UnresolvedInlineTable}
   * into a {@link LocalRelation}.
   * <p>
   * This function attempts to coerce inputs into consistent types.
   * <p>
   * This is package visible for unit testing.
   * @param table (undocumented)
   * @return (undocumented)
   */
    org.apache.spark.sql.catalyst.plans.logical.LocalRelation convert (org.apache.spark.sql.catalyst.analysis.UnresolvedInlineTable table)  { throw new RuntimeException(); }
}
