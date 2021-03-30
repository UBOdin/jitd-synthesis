package org.apache.spark.sql.catalyst.optimizer;
/**
 * Replaces {@link ResolvedHint} operators from the plan. Move the {@link HintInfo} to associated {@link Join}
 * operators, otherwise remove it if no {@link Join} operator is matched.
 */
public  class EliminateResolvedHint$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final EliminateResolvedHint$ MODULE$ = null;
  public   EliminateResolvedHint$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  /**
   * Extract all hints from the plan, returning a list of extracted hints and the transformed plan
   * with {@link ResolvedHint} nodes removed. The returned hint list comes in top-down order.
   * Note that hints can only be extracted from under certain nodes. Those that cannot be extracted
   * in this method will be cleaned up later by this rule, and may emit warnings depending on the
   * configurations.
   * @param plan (undocumented)
   * @return (undocumented)
   */
    scala.Tuple2<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan, scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.HintInfo>> extractHintsFromPlan (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
