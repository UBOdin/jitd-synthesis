package org.apache.spark.sql.execution.adaptive;
/**
 * This class provides utility methods related to tree traversal of an {@link AdaptiveSparkPlanExec}
 * plan. Unlike their counterparts in {@link org.apache.spark.sql.catalyst.trees.TreeNode} or
 * {@link org.apache.spark.sql.catalyst.plans.QueryPlan}, these methods traverse down leaf nodes of
 * adaptive plans, i.e., {@link AdaptiveSparkPlanExec} and {@link QueryStageExec}.
 */
public  interface AdaptiveSparkPlanHelper {
  public  scala.collection.Seq<org.apache.spark.sql.execution.SparkPlan> allChildren (org.apache.spark.sql.execution.SparkPlan p)  ;
  /**
   * Returns a Seq containing the result of applying a partial function to all elements in this
   * tree on which the function is defined.
   * @param p (undocumented)
   * @param pf (undocumented)
   * @return (undocumented)
   */
  public <B extends java.lang.Object> scala.collection.Seq<B> collect (org.apache.spark.sql.execution.SparkPlan p, scala.PartialFunction<org.apache.spark.sql.execution.SparkPlan, B> pf)  ;
  /**
   * Finds and returns the first {@link SparkPlan} of the tree for which the given partial function
   * is defined (pre-order), and applies the partial function to it.
   * @param p (undocumented)
   * @param pf (undocumented)
   * @return (undocumented)
   */
  public <B extends java.lang.Object> scala.Option<B> collectFirst (org.apache.spark.sql.execution.SparkPlan p, scala.PartialFunction<org.apache.spark.sql.execution.SparkPlan, B> pf)  ;
  /**
   * Returns a Seq containing the leaves in this tree.
   * @param p (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.execution.SparkPlan> collectLeaves (org.apache.spark.sql.execution.SparkPlan p)  ;
  /**
   * Returns a sequence containing the result of applying a partial function to all elements in this
   * plan, also considering all the plans in its (nested) subqueries
   * @param p (undocumented)
   * @param f (undocumented)
   * @return (undocumented)
   */
  public <B extends java.lang.Object> scala.collection.Seq<B> collectWithSubqueries (org.apache.spark.sql.execution.SparkPlan p, scala.PartialFunction<org.apache.spark.sql.execution.SparkPlan, B> f)  ;
  /**
   * Find the first {@link SparkPlan} that satisfies the condition specified by <code>f</code>.
   * The condition is recursively applied to this node and all of its children (pre-order).
   * @param p (undocumented)
   * @param f (undocumented)
   * @return (undocumented)
   */
  public  scala.Option<org.apache.spark.sql.execution.SparkPlan> find (org.apache.spark.sql.execution.SparkPlan p, scala.Function1<org.apache.spark.sql.execution.SparkPlan, java.lang.Object> f)  ;
  /**
   * Returns a Seq by applying a function to all nodes in this tree and using the elements of the
   * resulting collections.
   * @param p (undocumented)
   * @param f (undocumented)
   * @return (undocumented)
   */
  public <A extends java.lang.Object> scala.collection.Seq<A> flatMap (org.apache.spark.sql.execution.SparkPlan p, scala.Function1<org.apache.spark.sql.execution.SparkPlan, scala.collection.TraversableOnce<A>> f)  ;
  /**
   * Runs the given function on this node and then recursively on children.
   * @param f the function to be applied to each node in the tree.
   * @param p (undocumented)
   */
  public  void foreach (org.apache.spark.sql.execution.SparkPlan p, scala.Function1<org.apache.spark.sql.execution.SparkPlan, scala.runtime.BoxedUnit> f)  ;
  /**
   * Runs the given function recursively on children then on this node.
   * @param f the function to be applied to each node in the tree.
   * @param p (undocumented)
   */
  public  void foreachUp (org.apache.spark.sql.execution.SparkPlan p, scala.Function1<org.apache.spark.sql.execution.SparkPlan, scala.runtime.BoxedUnit> f)  ;
  /**
   * Returns a Seq containing the result of applying the given function to each
   * node in this tree in a preorder traversal.
   * @param f the function to be applied.
   * @param p (undocumented)
   * @return (undocumented)
   */
  public <A extends java.lang.Object> scala.collection.Seq<A> mapPlans (org.apache.spark.sql.execution.SparkPlan p, scala.Function1<org.apache.spark.sql.execution.SparkPlan, A> f)  ;
  /**
   * Strip the executePlan of AdaptiveSparkPlanExec leaf node.
   * @param p (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.execution.SparkPlan stripAQEPlan (org.apache.spark.sql.execution.SparkPlan p)  ;
  /**
   * Returns a sequence containing the subqueries in this plan, also including the (nested)
   * subqueries in its children
   * @param p (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.execution.SparkPlan> subqueriesAll (org.apache.spark.sql.execution.SparkPlan p)  ;
}
