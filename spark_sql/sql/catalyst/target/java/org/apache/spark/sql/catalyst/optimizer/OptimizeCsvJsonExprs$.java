package org.apache.spark.sql.catalyst.optimizer;
/**
 * Simplify redundant csv/json related expressions.
 * <p>
 * The optimization includes:
 * 1. JsonToStructs(StructsToJson(child)) =&gt; child.
 * 2. Prune unnecessary columns from GetStructField/GetArrayStructFields + JsonToStructs.
 * 3. CreateNamedStruct(JsonToStructs(json).col1, JsonToStructs(json).col2, ...) =&gt;
 *      If(IsNull(json), nullStruct, KnownNotNull(JsonToStructs(prunedSchema, ..., json)))
 *      if JsonToStructs(json) is shared among all fields of CreateNamedStruct. <code>prunedSchema</code>
 *      contains all accessed fields in original CreateNamedStruct.
 * 4. Prune unnecessary columns from GetStructField + CsvToStructs.
 */
public  class OptimizeCsvJsonExprs$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final OptimizeCsvJsonExprs$ MODULE$ = null;
  public   OptimizeCsvJsonExprs$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
