package org.apache.spark.sql.catalyst.plans.logical;
/**
 * A resolved hint node. The analyzer should convert all {@link UnresolvedHint} into {@link ResolvedHint}.
 * This node will be eliminated before optimization starts.
 */
public  class ResolvedHint extends org.apache.spark.sql.catalyst.plans.logical.UnaryNode implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.HintInfo hints ()  { throw new RuntimeException(); }
  // not preceding
  public   ResolvedHint (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child, org.apache.spark.sql.catalyst.plans.logical.HintInfo hints)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan doCanonicalize ()  { throw new RuntimeException(); }
}
