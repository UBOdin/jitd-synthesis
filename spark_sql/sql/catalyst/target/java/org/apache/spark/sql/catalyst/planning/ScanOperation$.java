package org.apache.spark.sql.catalyst.planning;
/**
 * A variant of {@link PhysicalOperation}. It matches any number of project or filter
 * operations even if they are non-deterministic, as long as they satisfy the
 * requirement of CollapseProject and CombineFilters.
 */
public  class ScanOperation$ implements org.apache.spark.sql.catalyst.planning.OperationHelper, org.apache.spark.sql.catalyst.expressions.PredicateHelper {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final ScanOperation$ MODULE$ = null;
  public   ScanOperation$ ()  { throw new RuntimeException(); }
  public  scala.Option<scala.Tuple3<scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression>, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression>, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan>> unapply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
