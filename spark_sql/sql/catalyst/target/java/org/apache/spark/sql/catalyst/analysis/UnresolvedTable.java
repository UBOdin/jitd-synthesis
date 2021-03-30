package org.apache.spark.sql.catalyst.analysis;
/**
 * Holds the name of a table that has yet to be looked up in a catalog. It will be resolved to
 * {@link ResolvedTable} during analysis.
 */
public  class UnresolvedTable extends org.apache.spark.sql.catalyst.plans.logical.LeafNode implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> multipartIdentifier ()  { throw new RuntimeException(); }
  public  java.lang.String commandName ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> relationTypeMismatchHint ()  { throw new RuntimeException(); }
  // not preceding
  public   UnresolvedTable (scala.collection.Seq<java.lang.String> multipartIdentifier, java.lang.String commandName, scala.Option<java.lang.String> relationTypeMismatchHint)  { throw new RuntimeException(); }
  // not preceding
  public  boolean resolved ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
}
