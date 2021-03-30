package org.apache.spark.sql.catalyst.plans.logical;
/**
 * A relation with one row. This is used in "SELECT ..." without a from clause.
 */
public  class OneRowRelation extends org.apache.spark.sql.catalyst.plans.logical.LeafNode implements scala.Product, scala.Serializable {
  static public abstract  R apply ()  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public   OneRowRelation ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object> maxRows ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.Statistics computeStats ()  { throw new RuntimeException(); }
  /** {@link org.apache.spark.sql.catalyst.trees.TreeNode.makeCopy()} does not support 0-arg ctor. */
  public  org.apache.spark.sql.catalyst.plans.logical.OneRowRelation makeCopy (java.lang.Object[] newArgs)  { throw new RuntimeException(); }
}
