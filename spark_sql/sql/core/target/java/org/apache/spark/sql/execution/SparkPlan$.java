package org.apache.spark.sql.execution;
public  class SparkPlan$ implements scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final SparkPlan$ MODULE$ = null;
  public   SparkPlan$ ()  { throw new RuntimeException(); }
  /** The original {@link LogicalPlan} from which this {@link SparkPlan} is converted. */
  public  org.apache.spark.sql.catalyst.trees.TreeNodeTag<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> LOGICAL_PLAN_TAG ()  { throw new RuntimeException(); }
  /** The {@link LogicalPlan} inherited from its ancestor. */
  public  org.apache.spark.sql.catalyst.trees.TreeNodeTag<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> LOGICAL_PLAN_INHERITED_TAG ()  { throw new RuntimeException(); }
  /** Register a new SparkPlan, returning its SparkPlan ID */
    int newPlanId ()  { throw new RuntimeException(); }
}
