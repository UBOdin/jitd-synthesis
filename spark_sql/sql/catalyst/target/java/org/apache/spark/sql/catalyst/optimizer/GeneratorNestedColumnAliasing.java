package org.apache.spark.sql.catalyst.optimizer;
/**
 * This prunes unnecessary nested columns from <code>Generate</code> and optional <code>Project</code> on top
 * of it.
 */
public  class GeneratorNestedColumnAliasing {
  static public  scala.Option<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> unapply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  /**
   * This is a while-list for pruning nested fields at <code>Generator</code>.
   * @param g (undocumented)
   * @return (undocumented)
   */
  static public  boolean canPruneGenerator (org.apache.spark.sql.catalyst.expressions.Generator g)  { throw new RuntimeException(); }
}
