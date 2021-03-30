package org.apache.spark.sql.catalyst.analysis;
/**
 * Holds the name of a table or view that has yet to be looked up in a catalog. It will
 * be resolved to {@link ResolvedTable} or {@link ResolvedView} during analysis.
 */
public  class UnresolvedTableOrView extends org.apache.spark.sql.catalyst.plans.logical.LeafNode implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> multipartIdentifier ()  { throw new RuntimeException(); }
  public  java.lang.String commandName ()  { throw new RuntimeException(); }
  public  boolean allowTempView ()  { throw new RuntimeException(); }
  // not preceding
  public   UnresolvedTableOrView (scala.collection.Seq<java.lang.String> multipartIdentifier, java.lang.String commandName, boolean allowTempView)  { throw new RuntimeException(); }
  // not preceding
  public  boolean resolved ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
}
