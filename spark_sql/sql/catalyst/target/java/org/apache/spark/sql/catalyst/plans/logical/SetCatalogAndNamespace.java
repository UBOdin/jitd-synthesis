package org.apache.spark.sql.catalyst.plans.logical;
/**
 * The logical plan of the USE/USE NAMESPACE command.
 */
public  class SetCatalogAndNamespace extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements org.apache.spark.sql.catalyst.plans.logical.Command, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.CatalogManager catalogManager ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> catalogName ()  { throw new RuntimeException(); }
  public  scala.Option<scala.collection.Seq<java.lang.String>> namespace ()  { throw new RuntimeException(); }
  // not preceding
  public   SetCatalogAndNamespace (org.apache.spark.sql.connector.catalog.CatalogManager catalogManager, scala.Option<java.lang.String> catalogName, scala.Option<scala.collection.Seq<java.lang.String>> namespace)  { throw new RuntimeException(); }
}
