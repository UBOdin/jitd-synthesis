package org.apache.spark.sql.catalyst.analysis;
public  class FakeV2SessionCatalog$ implements org.apache.spark.sql.connector.catalog.TableCatalog {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final FakeV2SessionCatalog$ MODULE$ = null;
  public   FakeV2SessionCatalog$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.Identifier[] listTables (java.lang.String[] namespace)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.Table loadTable (org.apache.spark.sql.connector.catalog.Identifier ident)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.Table createTable (org.apache.spark.sql.connector.catalog.Identifier ident, org.apache.spark.sql.types.StructType schema, org.apache.spark.sql.connector.expressions.Transform[] partitions, java.util.Map<java.lang.String, java.lang.String> properties)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.Table alterTable (org.apache.spark.sql.connector.catalog.Identifier ident, scala.collection.Seq<org.apache.spark.sql.connector.catalog.TableChange> changes)  { throw new RuntimeException(); }
  public  boolean dropTable (org.apache.spark.sql.connector.catalog.Identifier ident)  { throw new RuntimeException(); }
  public  void renameTable (org.apache.spark.sql.connector.catalog.Identifier oldIdent, org.apache.spark.sql.connector.catalog.Identifier newIdent)  { throw new RuntimeException(); }
  public  void initialize (java.lang.String name, org.apache.spark.sql.util.CaseInsensitiveStringMap options)  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.connector.catalog.Table alterTable (org.apache.spark.sql.connector.catalog.Identifier ident, org.apache.spark.sql.connector.catalog.TableChange[] changes)  { throw new RuntimeException(); }
}
