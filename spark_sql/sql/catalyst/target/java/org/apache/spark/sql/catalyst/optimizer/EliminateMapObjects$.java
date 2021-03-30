package org.apache.spark.sql.catalyst.optimizer;
/**
 * Removes MapObjects when the following conditions are satisfied
 *   1. Mapobject(... lambdavariable(..., false) ...), which means types for input and output
 *      are primitive types with non-nullable
 *   2. no custom collection class specified representation of data item.
 */
public  class EliminateMapObjects$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final EliminateMapObjects$ MODULE$ = null;
  public   EliminateMapObjects$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
