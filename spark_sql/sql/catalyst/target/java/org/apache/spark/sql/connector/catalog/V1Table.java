package org.apache.spark.sql.connector.catalog;
/**
 * An implementation of catalog v2 <code>Table</code> to expose v1 table metadata.
 */
  class V1Table implements org.apache.spark.sql.connector.catalog.Table, scala.Product, scala.Serializable {
  public  class IdentifierHelper {
    public   IdentifierHelper (org.apache.spark.sql.catalyst.TableIdentifier identifier)  { throw new RuntimeException(); }
    public  java.lang.String quoted ()  { throw new RuntimeException(); }
  }
  static public abstract  R apply (T1 v1)  ;
  public  org.apache.spark.sql.catalyst.catalog.CatalogTable v1Table ()  { throw new RuntimeException(); }
  // not preceding
  public   V1Table (org.apache.spark.sql.catalyst.catalog.CatalogTable v1Table)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.catalog.CatalogTable catalogTable ()  { throw new RuntimeException(); }
  // not preceding
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> options ()  { throw new RuntimeException(); }
  // not preceding
  public  java.util.Map<java.lang.String, java.lang.String> properties ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.types.StructType schema ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.connector.expressions.Transform[] partitioning ()  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  java.util.Set<org.apache.spark.sql.connector.catalog.TableCapability> capabilities ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
