package org.apache.spark.sql.catalyst.plans.logical;
public  class LogicalPlanIntegrity {
  /**
   * Since some logical plans (e.g., <code>Union</code>) can build <code>AttributeReference</code>s in their <code>output</code>,
   * this method checks if the same <code>ExprId</code> refers to attributes having the same data type
   * in plan output.
   * @param plan (undocumented)
   * @return (undocumented)
   */
  static public  boolean hasUniqueExprIdsForOutput (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  /**
   * This method checks if reference <code>ExprId</code>s are not reused when assigning a new <code>ExprId</code>.
   * For example, it returns false if plan transformers create an alias having the same <code>ExprId</code>
   * with one of reference attributes, e.g., <code>a#1 + 1 AS a#1</code>.
   * @param plan (undocumented)
   * @return (undocumented)
   */
  static public  boolean checkIfSameExprIdNotReused (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  /**
   * This method checks if the same <code>ExprId</code> refers to an unique attribute in a plan tree.
   * Some plan transformers (e.g., <code>RemoveNoopOperators</code>) rewrite logical
   * plans based on this assumption.
   * @param plan (undocumented)
   * @return (undocumented)
   */
  static public  boolean checkIfExprIdsAreGloballyUnique (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
