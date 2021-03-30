package org.apache.spark.sql.catalyst.analysis;
/**
 * Throws user facing errors when passed invalid queries that fail to analyze.
 */
public  interface CheckAnalysis extends org.apache.spark.sql.catalyst.expressions.PredicateHelper, org.apache.spark.sql.connector.catalog.LookupCatalog {
  public  void checkAlterTablePartition (org.apache.spark.sql.connector.catalog.Table table, scala.collection.Seq<org.apache.spark.sql.catalyst.analysis.PartitionSpec> parts)  ;
  public  void checkAnalysis (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  ;
  /**
   * Validate that collected metrics names are unique. The same name cannot be used for metrics
   * with different results. However multiple instances of metrics with with same result and name
   * are allowed (e.g. self-joins).
   * @param plan (undocumented)
   */
  public  void checkCollectedMetrics (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  ;
  /**
   * Validates to make sure the outer references appearing inside the subquery
   * are allowed.
   * @param sub (undocumented)
   */
  public  void checkCorrelationsInSubquery (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan sub)  ;
  public  void checkLimitLikeClause (java.lang.String name, org.apache.spark.sql.catalyst.expressions.Expression limitExpr)  ;
  /**
   * Validates subquery expressions in the plan. Upon failure, returns an user facing error.
   * @param plan (undocumented)
   * @param expr (undocumented)
   */
  public  void checkSubqueryExpression (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan, org.apache.spark.sql.catalyst.expressions.SubqueryExpression expr)  ;
  public  boolean containsMultipleGenerators (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> exprs)  ;
  /**
   * Override to provide additional checks for correct analysis.
   * These rules will be evaluated after our built-in check rules.
   * @return (undocumented)
   */
  public  scala.collection.Seq<scala.Function1<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan, scala.runtime.BoxedUnit>> extendedCheckRules ()  ;
  public  scala.runtime.Nothing$ failAnalysis (java.lang.String msg)  ;
  public  boolean hasMapType (org.apache.spark.sql.types.DataType dt)  ;
  public  boolean isView (scala.collection.Seq<java.lang.String> nameParts)  ;
  public  scala.Option<org.apache.spark.sql.catalyst.expressions.Attribute> mapColumnInSetOperation (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  ;
}
