package org.apache.spark.sql.execution.datasources.v2;
/**
 * Physical plan node for setting the current catalog and/or namespace.
 */
public  class SetCatalogAndNamespaceExec extends org.apache.spark.sql.execution.datasources.v2.V2CommandExec implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.CatalogManager catalogManager ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> catalogName ()  { throw new RuntimeException(); }
  public  scala.Option<scala.collection.Seq<java.lang.String>> namespace ()  { throw new RuntimeException(); }
  // not preceding
  public   SetCatalogAndNamespaceExec (org.apache.spark.sql.connector.catalog.CatalogManager catalogManager, scala.Option<java.lang.String> catalogName, scala.Option<scala.collection.Seq<java.lang.String>> namespace)  { throw new RuntimeException(); }
  protected  scala.collection.Seq<org.apache.spark.sql.catalyst.InternalRow> run ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
}
