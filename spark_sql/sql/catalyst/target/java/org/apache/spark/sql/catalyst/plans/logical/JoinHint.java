package org.apache.spark.sql.catalyst.plans.logical;
/**
 * Hint that is associated with a {@link Join} node, with {@link HintInfo} on its left child and on its
 * right child respectively.
 */
public  class JoinHint implements scala.Product, scala.Serializable {
  static public  org.apache.spark.sql.catalyst.plans.logical.JoinHint NONE ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.plans.logical.HintInfo> leftHint ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.plans.logical.HintInfo> rightHint ()  { throw new RuntimeException(); }
  // not preceding
  public   JoinHint (scala.Option<org.apache.spark.sql.catalyst.plans.logical.HintInfo> leftHint, scala.Option<org.apache.spark.sql.catalyst.plans.logical.HintInfo> rightHint)  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
