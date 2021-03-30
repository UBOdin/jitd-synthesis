package org.apache.spark.sql.catalyst.plans.logical;
/**
 * A partition-local (non-coordinated) limit. This operator can emit at most <code>limitExpr</code> number
 * of tuples on each physical partition.
 * <p>
 * See {@link Limit} for more information.
 */
public  class LocalLimit extends org.apache.spark.sql.catalyst.plans.logical.OrderPreservingUnaryNode implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression limitExpr ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child ()  { throw new RuntimeException(); }
  // not preceding
  public   LocalLimit (org.apache.spark.sql.catalyst.expressions.Expression limitExpr, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object> maxRowsPerPartition ()  { throw new RuntimeException(); }
}
