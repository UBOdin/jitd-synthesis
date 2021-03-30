package org.apache.spark.sql.catalyst.catalog;
/**
 * A placeholder for a table relation, which will be replaced by concrete relation like
 * <code>LogicalRelation</code> or <code>HiveTableRelation</code>, during analysis.
 */
public  class UnresolvedCatalogRelation extends org.apache.spark.sql.catalyst.plans.logical.LeafNode implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.catalog.CatalogTable tableMeta ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.util.CaseInsensitiveStringMap options ()  { throw new RuntimeException(); }
  public  boolean isStreaming ()  { throw new RuntimeException(); }
  // not preceding
  public   UnresolvedCatalogRelation (org.apache.spark.sql.catalyst.catalog.CatalogTable tableMeta, org.apache.spark.sql.util.CaseInsensitiveStringMap options, boolean isStreaming)  { throw new RuntimeException(); }
  // not preceding
  public  boolean resolved ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
}
