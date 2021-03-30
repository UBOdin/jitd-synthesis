package org.apache.spark.sql.catalyst.analysis;
/**
 * An inline table that has not been resolved yet. Once resolved, it is turned by the analyzer into
 * a {@link org.apache.spark.sql.catalyst.plans.logical.LocalRelation}.
 * <p>
 * param:  names list of column names
 * param:  rows expressions for the data
 */
public  class UnresolvedInlineTable extends org.apache.spark.sql.catalyst.plans.logical.LeafNode implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> names ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression>> rows ()  { throw new RuntimeException(); }
  // not preceding
  public   UnresolvedInlineTable (scala.collection.Seq<java.lang.String> names, scala.collection.Seq<scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression>> rows)  { throw new RuntimeException(); }
  // not preceding
  public  boolean expressionsResolved ()  { throw new RuntimeException(); }
  // not preceding
  public  boolean resolved ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
}
