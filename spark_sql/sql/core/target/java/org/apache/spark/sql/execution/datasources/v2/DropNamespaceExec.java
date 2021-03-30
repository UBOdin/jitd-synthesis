package org.apache.spark.sql.execution.datasources.v2;
/**
 * Physical plan node for dropping a namespace.
 */
public  class DropNamespaceExec extends org.apache.spark.sql.execution.datasources.v2.V2CommandExec implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.CatalogPlugin catalog ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> namespace ()  { throw new RuntimeException(); }
  public  boolean ifExists ()  { throw new RuntimeException(); }
  public  boolean cascade ()  { throw new RuntimeException(); }
  // not preceding
  public   DropNamespaceExec (org.apache.spark.sql.connector.catalog.CatalogPlugin catalog, scala.collection.Seq<java.lang.String> namespace, boolean ifExists, boolean cascade)  { throw new RuntimeException(); }
  protected  scala.collection.Seq<org.apache.spark.sql.catalyst.InternalRow> run ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
}
