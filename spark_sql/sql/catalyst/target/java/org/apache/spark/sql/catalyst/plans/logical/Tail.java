package org.apache.spark.sql.catalyst.plans.logical;
/**
 * This is similar with {@link Limit} except:
 * <p>
 * - It does not have plans for global/local separately because currently there is only single
 *   implementation which initially mimics both global/local tails. See
 *   <code>org.apache.spark.sql.execution.CollectTailExec</code> and
 *   <code>org.apache.spark.sql.execution.CollectLimitExec</code>
 * <p>
 * - Currently, this plan can only be a root node.
 */
public  class Tail extends org.apache.spark.sql.catalyst.plans.logical.OrderPreservingUnaryNode implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression limitExpr ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child ()  { throw new RuntimeException(); }
  // not preceding
  public   Tail (org.apache.spark.sql.catalyst.expressions.Expression limitExpr, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object> maxRows ()  { throw new RuntimeException(); }
}
