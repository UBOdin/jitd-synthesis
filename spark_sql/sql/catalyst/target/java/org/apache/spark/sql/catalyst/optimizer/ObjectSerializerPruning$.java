package org.apache.spark.sql.catalyst.optimizer;
/**
 * Prunes unnecessary object serializers from query plan. This rule prunes both individual
 * serializer and nested fields in serializers.
 */
public  class ObjectSerializerPruning$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final ObjectSerializerPruning$ MODULE$ = null;
  public   ObjectSerializerPruning$ ()  { throw new RuntimeException(); }
  /**
   * Visible for testing.
   * Collects all struct types from given data type object, recursively.
   * @param dt (undocumented)
   * @param structs (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.mutable.ArrayBuffer<org.apache.spark.sql.types.StructType> collectStructType (org.apache.spark.sql.types.DataType dt, scala.collection.mutable.ArrayBuffer<org.apache.spark.sql.types.StructType> structs)  { throw new RuntimeException(); }
  /**
   * This method prunes given serializer expression by given pruned data type. For example,
   * given a serializer creating struct(a int, b int) and pruned data type struct(a int),
   * this method returns pruned serializer creating struct(a int).
   * @param serializer (undocumented)
   * @param prunedDataType (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.NamedExpression pruneSerializer (org.apache.spark.sql.catalyst.expressions.NamedExpression serializer, org.apache.spark.sql.types.DataType prunedDataType)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
