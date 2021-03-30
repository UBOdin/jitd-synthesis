package org.apache.spark.sql.catalyst.optimizer;
/**
 * Finds all the expressions that are unevaluable and replace/rewrite them with semantically
 * equivalent expressions that can be evaluated. Currently we replace two kinds of expressions:
 * 1) {@link RuntimeReplaceable} expressions
 * 2) {@link UnevaluableAggregate} expressions such as Every, Some, Any, CountIf
 * This is mainly used to provide compatibility with other databases.
 * Few examples are:
 *   we use this to support "nvl" by replacing it with "coalesce".
 *   we use this to replace Every and Any with Min and Max respectively.
 * <p>
 * TODO: In future, explore an option to replace aggregate functions similar to
 * how RuntimeReplaceable does.
 */
public  class ReplaceExpressions$ extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final ReplaceExpressions$ MODULE$ = null;
  public   ReplaceExpressions$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
