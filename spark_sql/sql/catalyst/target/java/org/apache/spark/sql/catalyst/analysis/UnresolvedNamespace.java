package org.apache.spark.sql.catalyst.analysis;
/**
 * Holds the name of a namespace that has yet to be looked up in a catalog. It will be resolved to
 * {@link ResolvedNamespace} during analysis.
 */
public  class UnresolvedNamespace extends org.apache.spark.sql.catalyst.plans.logical.LeafNode implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> multipartIdentifier ()  { throw new RuntimeException(); }
  // not preceding
  public   UnresolvedNamespace (scala.collection.Seq<java.lang.String> multipartIdentifier)  { throw new RuntimeException(); }
  // not preceding
  public  boolean resolved ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
}
