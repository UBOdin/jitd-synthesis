package org.apache.spark.sql.catalyst.catalog;
/**
 * A wrapper to store the temporary view info, will be kept in <code>SessionCatalog</code>
 * and will be transformed to <code>View</code> during analysis. If the temporary view is
 * storing an analyzed plan, <code>plan</code> is set to the analyzed plan for the view.
 */
public  class TemporaryViewRelation extends org.apache.spark.sql.catalyst.plans.logical.LeafNode implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.catalog.CatalogTable tableMeta ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> plan ()  { throw new RuntimeException(); }
  // not preceding
  public   TemporaryViewRelation (org.apache.spark.sql.catalyst.catalog.CatalogTable tableMeta, scala.Option<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> plan)  { throw new RuntimeException(); }
  // not preceding
  public  boolean resolved ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
}
