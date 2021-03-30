package org.apache.spark.sql.catalyst.analysis;
/**
 * Holds the name of a view that has yet to be looked up in a catalog. It will be resolved to
 * {@link ResolvedView} during analysis.
 */
public  class UnresolvedView extends org.apache.spark.sql.catalyst.plans.logical.LeafNode implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> multipartIdentifier ()  { throw new RuntimeException(); }
  public  java.lang.String commandName ()  { throw new RuntimeException(); }
  public  boolean allowTemp ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> relationTypeMismatchHint ()  { throw new RuntimeException(); }
  // not preceding
  public   UnresolvedView (scala.collection.Seq<java.lang.String> multipartIdentifier, java.lang.String commandName, boolean allowTemp, scala.Option<java.lang.String> relationTypeMismatchHint)  { throw new RuntimeException(); }
  // not preceding
  public  boolean resolved ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
}
