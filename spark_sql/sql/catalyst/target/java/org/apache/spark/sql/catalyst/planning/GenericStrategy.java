package org.apache.spark.sql.catalyst.planning;
/**
 * Given a {@link LogicalPlan}, returns a list of <code>PhysicalPlan</code>s that can
 * be used for execution. If this strategy does not apply to the given logical operation then an
 * empty list should be returned.
 */
public abstract class GenericStrategy<PhysicalPlan extends org.apache.spark.sql.catalyst.trees.TreeNode<PhysicalPlan>> implements org.apache.spark.internal.Logging {
  public   GenericStrategy ()  { throw new RuntimeException(); }
  public abstract  scala.collection.Seq<PhysicalPlan> apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  ;
  /**
   * Returns a placeholder for a physical plan that executes <code>plan</code>. This placeholder will be
   * filled in automatically by the QueryPlanner using the other execution strategies that are
   * available.
   * @param plan (undocumented)
   * @return (undocumented)
   */
  protected abstract  PhysicalPlan planLater (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  ;
}
