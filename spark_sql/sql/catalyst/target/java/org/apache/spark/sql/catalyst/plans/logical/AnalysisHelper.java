package org.apache.spark.sql.catalyst.plans.logical;
/**
 * {@link AnalysisHelper} defines some infrastructure for the query analyzer. In particular, in query
 * analysis we don't want to repeatedly re-analyze sub-plans that have previously been analyzed.
 * <p>
 * This trait defines a flag <code>analyzed</code> that can be set to true once analysis is done on the tree.
 * This also provides a set of resolve methods that do not recurse down to sub-plans that have the
 * analyzed flag set to true.
 * <p>
 * The analyzer rules should use the various resolve methods, in lieu of the various transform
 * methods defined in {@link org.apache.spark.sql.catalyst.trees.TreeNode} and {@link QueryPlan}.
 * <p>
 * To prevent accidental use of the transform methods, this trait also overrides the transform
 * methods to throw exceptions in test mode, if they are used in the analyzer.
 */
public  interface AnalysisHelper {
  /**
   * Recursively marks all nodes in this plan tree as analyzed.
   * This should only be called by
   * {@link org.apache.spark.sql.catalyst.analysis.CheckAnalysis}.
   */
    void setAnalyzed ()  ;
  /**
   * Returns true if this node and its children have already been gone through analysis and
   * verification.  Note that this is only an optimization used to avoid analyzing trees that
   * have already been analyzed, and can be reset by transformations.
   * @return (undocumented)
   */
  public  boolean analyzed ()  ;
  /**
   * Returns a copy of this node where <code>rule</code> has been recursively applied to the tree. When
   * <code>rule</code> does not apply to a given node, it is left unchanged. This function is similar to
   * <code>transform</code>, but skips sub-trees that have already been marked as analyzed.
   * Users should not expect a specific directionality. If a specific directionality is needed,
   * {@link resolveOperatorsUp} or {@link resolveOperatorsDown} should be used.
   * <p>
   * @param rule the function use to transform this nodes children
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan resolveOperators (scala.PartialFunction<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> rule)  ;
  /**
   * Returns a copy of this node where <code>rule</code> has been recursively applied first to all of its
   * children and then itself (post-order, bottom-up). When <code>rule</code> does not apply to a given node,
   * it is left unchanged.  This function is similar to <code>transformUp</code>, but skips sub-trees that
   * have already been marked as analyzed.
   * <p>
   * @param rule the function use to transform this nodes children
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan resolveOperatorsUp (scala.PartialFunction<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> rule)  ;
  /** Similar to {@link resolveOperatorsUp}, but does it top-down. */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan resolveOperatorsDown (scala.PartialFunction<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> rule)  ;
  /**
   * A variant of <code>transformUpWithNewOutput</code>, which skips touching already analyzed plan.
   * @param rule (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan resolveOperatorsUpWithNewOutput (scala.PartialFunction<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan, scala.Tuple2<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan, scala.collection.Seq<scala.Tuple2<org.apache.spark.sql.catalyst.expressions.Attribute, org.apache.spark.sql.catalyst.expressions.Attribute>>>> rule)  ;
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan transformUpWithNewOutput (scala.PartialFunction<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan, scala.Tuple2<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan, scala.collection.Seq<scala.Tuple2<org.apache.spark.sql.catalyst.expressions.Attribute, org.apache.spark.sql.catalyst.expressions.Attribute>>>> rule, scala.Function1<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan, java.lang.Object> skipCond, scala.Function1<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan, java.lang.Object> canGetOutput)  ;
  /**
   * Recursively transforms the expressions of a tree, skipping nodes that have already
   * been analyzed.
   * @param r (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan resolveExpressions (scala.PartialFunction<org.apache.spark.sql.catalyst.expressions.Expression, org.apache.spark.sql.catalyst.expressions.Expression> r)  ;
  public  void assertNotAnalysisRule ()  ;
  /**
   * In analyzer, use {@link resolveOperatorsDown()} instead. If this is used in the analyzer,
   * an exception will be thrown in test mode. It is however OK to call this function within
   * the scope of a {@link resolveOperatorsDown()} call.
   * @see {@link org.apache.spark.sql.catalyst.trees.TreeNode.transformDown()}.
   * @param rule (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan transformDown (scala.PartialFunction<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> rule)  ;
  /**
   * Use {@link resolveOperators()} in the analyzer.
   * @see org.apache.spark.sql.catalyst.trees.TreeNode.transformUp()
   * @param rule (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan transformUp (scala.PartialFunction<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> rule)  ;
  /**
   * Use {@link resolveExpressions()} in the analyzer.
   * @see QueryPlan.transformAllExpressions()
   * @param rule (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.AnalysisHelper transformAllExpressions (scala.PartialFunction<org.apache.spark.sql.catalyst.expressions.Expression, org.apache.spark.sql.catalyst.expressions.Expression> rule)  ;
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan clone ()  ;
}
