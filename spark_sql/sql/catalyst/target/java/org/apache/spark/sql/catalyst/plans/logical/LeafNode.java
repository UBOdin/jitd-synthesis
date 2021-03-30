package org.apache.spark.sql.catalyst.plans.logical;
/**
 * A logical plan node with no children.
 */
public abstract class LeafNode extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan {
  public   LeafNode ()  { throw new RuntimeException(); }
  public final  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> children ()  { throw new RuntimeException(); }
  /** Leaf nodes that can survive analysis must define their own statistics. */
  public  org.apache.spark.sql.catalyst.plans.logical.Statistics computeStats ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.AttributeSet producedAttributes ()  { throw new RuntimeException(); }
}
