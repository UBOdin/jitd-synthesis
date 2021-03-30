package org.apache.spark.sql.catalyst.analysis;
public  class FakeV2SessionCatalog {
  static public  org.apache.spark.sql.connector.catalog.Identifier[] listTables (java.lang.String[] namespace)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.connector.catalog.Table loadTable (org.apache.spark.sql.connector.catalog.Identifier ident)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.connector.catalog.Table createTable (org.apache.spark.sql.connector.catalog.Identifier ident, org.apache.spark.sql.types.StructType schema, org.apache.spark.sql.connector.expressions.Transform[] partitions, java.util.Map<java.lang.String, java.lang.String> properties)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.connector.catalog.Table alterTable (org.apache.spark.sql.connector.catalog.Identifier ident, scala.collection.Seq<org.apache.spark.sql.connector.catalog.TableChange> changes)  { throw new RuntimeException(); }
  static public  boolean dropTable (org.apache.spark.sql.connector.catalog.Identifier ident)  { throw new RuntimeException(); }
  static public  void renameTable (org.apache.spark.sql.connector.catalog.Identifier oldIdent, org.apache.spark.sql.connector.catalog.Identifier newIdent)  { throw new RuntimeException(); }
  static public  void initialize (java.lang.String name, org.apache.spark.sql.util.CaseInsensitiveStringMap options)  { throw new RuntimeException(); }
  static public  java.lang.String name ()  { throw new RuntimeException(); }
  // not preceding
  static public  org.apache.spark.sql.connector.catalog.Table alterTable (org.apache.spark.sql.connector.catalog.Identifier ident, org.apache.spark.sql.connector.catalog.TableChange[] changes)  { throw new RuntimeException(); }
  static public  java.lang.String[] defaultNamespace ()  { throw new RuntimeException(); }
  static public  void invalidateTable (org.apache.spark.sql.connector.catalog.Identifier x$1)  { throw new RuntimeException(); }
  static public  boolean tableExists (org.apache.spark.sql.connector.catalog.Identifier x$1)  { throw new RuntimeException(); }
  static public  boolean purgeTable (org.apache.spark.sql.connector.catalog.Identifier x$1) throws java.lang.UnsupportedOperationException { throw new RuntimeException(); }
}
