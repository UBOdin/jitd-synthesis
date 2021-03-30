package org.apache.spark.sql.catalyst.analysis;
public  interface TypeCoercionRule extends org.apache.spark.internal.Logging {
  /**
   * Applies any changes to {@link AttributeReference} data types that are made by the transform method
   * to instances higher in the query tree.
   * @param plan (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  ;
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan coerceTypes (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  ;
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan propagateTypes (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  ;
}
