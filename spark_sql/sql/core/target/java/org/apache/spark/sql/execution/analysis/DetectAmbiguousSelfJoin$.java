package org.apache.spark.sql.execution.analysis;
/**
 * Detects ambiguous self-joins, so that we can fail the query instead of returning confusing
 * results.
 * <p>
 * Dataset column reference is simply an {@link AttributeReference} that is returned by <code>Dataset#col</code>.
 * Most of time we don't need to do anything special, as {@link AttributeReference} can point to
 * the column precisely. However, in case of self-join, the analyzer generates
 * {@link AttributeReference} with new expr IDs for the right side plan of the join. If the Dataset
 * column reference points to a column in the right side plan of a self-join, users will get
 * unexpected result because the column reference can't match the newly generated
 * {@link AttributeReference}.
 * <p>
 * Note that, this rule removes all the Dataset id related metadata from <code>AttributeReference</code>, so
 * that they don't exist after analyzer.
 */
public  class DetectAmbiguousSelfJoin$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final DetectAmbiguousSelfJoin$ MODULE$ = null;
  public   DetectAmbiguousSelfJoin$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
