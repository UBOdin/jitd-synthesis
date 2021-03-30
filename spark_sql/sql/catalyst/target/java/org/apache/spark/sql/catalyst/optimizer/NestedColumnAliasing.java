package org.apache.spark.sql.catalyst.optimizer;
/**
 * This aims to handle a nested column aliasing pattern inside the <code>ColumnPruning</code> optimizer rule.
 * If a project or its child references to nested fields, and not all the fields
 * in a nested attribute are used, we can substitute them by alias attributes; then a project
 * of the nested fields as aliases on the children of the child will be created.
 */
public  class NestedColumnAliasing {
  static public  scala.Option<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> unapply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  /**
   * Return a replaced project list.
   * @param projectList (undocumented)
   * @param nestedFieldToAlias (undocumented)
   * @return (undocumented)
   */
  static public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> getNewProjectList (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> projectList, scala.collection.immutable.Map<org.apache.spark.sql.catalyst.expressions.ExtractValue, org.apache.spark.sql.catalyst.expressions.Alias> nestedFieldToAlias)  { throw new RuntimeException(); }
  /**
   * Return a plan with new children replaced with aliases, and expressions replaced with
   * aliased attributes.
   * @param plan (undocumented)
   * @param nestedFieldToAlias (undocumented)
   * @param attrToAliases (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan replaceWithAliases (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan, scala.collection.immutable.Map<org.apache.spark.sql.catalyst.expressions.ExtractValue, org.apache.spark.sql.catalyst.expressions.Alias> nestedFieldToAlias, scala.collection.immutable.Map<org.apache.spark.sql.catalyst.expressions.ExprId, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Alias>> attrToAliases)  { throw new RuntimeException(); }
  /**
   * Return two maps in order to replace nested fields to aliases.
   * <p>
   * If <code>exclusiveAttrs</code> is given, any nested field accessors of these attributes
   * won't be considered in nested fields aliasing.
   * <p>
   * 1. ExtractValue -> Alias: A new alias is created for each nested field.
   * 2. ExprId -> Seq[Alias]: A reference attribute has multiple aliases pointing it.
   * @param exprList (undocumented)
   * @param exclusiveAttrs (undocumented)
   * @return (undocumented)
   */
  static public  scala.Option<scala.Tuple2<scala.collection.immutable.Map<org.apache.spark.sql.catalyst.expressions.ExtractValue, org.apache.spark.sql.catalyst.expressions.Alias>, scala.collection.immutable.Map<org.apache.spark.sql.catalyst.expressions.ExprId, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Alias>>>> getAliasSubMap (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> exprList, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> exclusiveAttrs)  { throw new RuntimeException(); }
}
