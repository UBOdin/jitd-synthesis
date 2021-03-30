package org.apache.spark.sql.catalyst.catalog;
/**
 * A function defined in the catalog.
 * <p>
 * param:  identifier name of the function
 * param:  className fully qualified class name, e.g. "org.apache.spark.util.MyFunc"
 * param:  resources resource types and Uris used by the function
 */
public  class CatalogFunction implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.FunctionIdentifier identifier ()  { throw new RuntimeException(); }
  public  java.lang.String className ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.catalog.FunctionResource> resources ()  { throw new RuntimeException(); }
  // not preceding
  public   CatalogFunction (org.apache.spark.sql.catalyst.FunctionIdentifier identifier, java.lang.String className, scala.collection.Seq<org.apache.spark.sql.catalyst.catalog.FunctionResource> resources)  { throw new RuntimeException(); }
}
