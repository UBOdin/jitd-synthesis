package org.apache.spark.sql.catalyst.analysis;
/**
 * A plan containing resolved namespace.
 */
public  class ResolvedNamespace extends org.apache.spark.sql.catalyst.plans.logical.LeafNode implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.CatalogPlugin catalog ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> namespace ()  { throw new RuntimeException(); }
  // not preceding
  public   ResolvedNamespace (org.apache.spark.sql.connector.catalog.CatalogPlugin catalog, scala.collection.Seq<java.lang.String> namespace)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
}
