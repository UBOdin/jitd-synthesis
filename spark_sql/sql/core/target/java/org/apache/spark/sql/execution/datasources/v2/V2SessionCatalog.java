package org.apache.spark.sql.execution.datasources.v2;
/**
 * A {@link TableCatalog} that translates calls to the v1 SessionCatalog.
 */
public  class V2SessionCatalog implements org.apache.spark.sql.connector.catalog.TableCatalog, org.apache.spark.sql.connector.catalog.SupportsNamespaces, org.apache.spark.sql.catalyst.SQLConfHelper {
  public  class TableIdentifierHelper {
    public   TableIdentifierHelper (org.apache.spark.sql.connector.catalog.Identifier ident)  { throw new RuntimeException(); }
    public  org.apache.spark.sql.catalyst.TableIdentifier asTableIdentifier ()  { throw new RuntimeException(); }
  }
  public   V2SessionCatalog (org.apache.spark.sql.catalyst.catalog.SessionCatalog catalog)  { throw new RuntimeException(); }
  public  java.lang.String[] defaultNamespace ()  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  void initialize (java.lang.String name, org.apache.spark.sql.util.CaseInsensitiveStringMap options)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.Identifier[] listTables (java.lang.String[] namespace)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.Table loadTable (org.apache.spark.sql.connector.catalog.Identifier ident)  { throw new RuntimeException(); }
  public  void invalidateTable (org.apache.spark.sql.connector.catalog.Identifier ident)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.Table createTable (org.apache.spark.sql.connector.catalog.Identifier ident, org.apache.spark.sql.types.StructType schema, org.apache.spark.sql.connector.expressions.Transform[] partitions, java.util.Map<java.lang.String, java.lang.String> properties)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.Table alterTable (org.apache.spark.sql.connector.catalog.Identifier ident, scala.collection.Seq<org.apache.spark.sql.connector.catalog.TableChange> changes)  { throw new RuntimeException(); }
  public  boolean dropTable (org.apache.spark.sql.connector.catalog.Identifier ident)  { throw new RuntimeException(); }
  public  void renameTable (org.apache.spark.sql.connector.catalog.Identifier oldIdent, org.apache.spark.sql.connector.catalog.Identifier newIdent)  { throw new RuntimeException(); }
  public  boolean namespaceExists (java.lang.String[] namespace)  { throw new RuntimeException(); }
  public  java.lang.String[][] listNamespaces ()  { throw new RuntimeException(); }
  public  java.lang.String[][] listNamespaces (java.lang.String[] namespace)  { throw new RuntimeException(); }
  public  java.util.Map<java.lang.String, java.lang.String> loadNamespaceMetadata (java.lang.String[] namespace)  { throw new RuntimeException(); }
  public  void createNamespace (java.lang.String[] namespace, java.util.Map<java.lang.String, java.lang.String> metadata)  { throw new RuntimeException(); }
  public  void alterNamespace (java.lang.String[] namespace, scala.collection.Seq<org.apache.spark.sql.connector.catalog.NamespaceChange> changes)  { throw new RuntimeException(); }
  public  boolean dropNamespace (java.lang.String[] namespace)  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  // not preceding
  public  void alterNamespace (java.lang.String[] namespace, org.apache.spark.sql.connector.catalog.NamespaceChange[] changes)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.Table alterTable (org.apache.spark.sql.connector.catalog.Identifier ident, org.apache.spark.sql.connector.catalog.TableChange[] changes)  { throw new RuntimeException(); }
}
