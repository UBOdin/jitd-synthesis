package org.apache.spark.sql.connector.catalog;
/**
 * Conversion helpers for working with v2 {@link CatalogPlugin}.
 */
public  class CatalogV2Implicits {
  static public  class PartitionTypeHelper {
    public   PartitionTypeHelper (scala.collection.Seq<java.lang.String> colNames)  { throw new RuntimeException(); }
    public  org.apache.spark.sql.connector.expressions.Transform[] asTransforms ()  { throw new RuntimeException(); }
  }
  static public  class BucketSpecHelper {
    public   BucketSpecHelper (org.apache.spark.sql.catalyst.catalog.BucketSpec spec)  { throw new RuntimeException(); }
    public  org.apache.spark.sql.connector.expressions.BucketTransform asTransform ()  { throw new RuntimeException(); }
  }
  static public  class TransformHelper {
    public   TransformHelper (scala.collection.Seq<org.apache.spark.sql.connector.expressions.Transform> transforms)  { throw new RuntimeException(); }
    public  scala.collection.Seq<java.lang.String> asPartitionColumns ()  { throw new RuntimeException(); }
  }
  static public  class CatalogHelper {
    public   CatalogHelper (org.apache.spark.sql.connector.catalog.CatalogPlugin plugin)  { throw new RuntimeException(); }
    public  org.apache.spark.sql.connector.catalog.SupportsNamespaces asNamespaceCatalog ()  { throw new RuntimeException(); }
    public  org.apache.spark.sql.connector.catalog.TableCatalog asTableCatalog ()  { throw new RuntimeException(); }
  }
  static public  class NamespaceHelper {
    public   NamespaceHelper (java.lang.String[] namespace)  { throw new RuntimeException(); }
    public  java.lang.String quoted ()  { throw new RuntimeException(); }
  }
  static public  class IdentifierHelper {
    public   IdentifierHelper (org.apache.spark.sql.connector.catalog.Identifier ident)  { throw new RuntimeException(); }
    public  org.apache.spark.sql.catalyst.FunctionIdentifier asFunctionIdentifier ()  { throw new RuntimeException(); }
    public  scala.collection.Seq<java.lang.String> asMultipartIdentifier ()  { throw new RuntimeException(); }
    public  org.apache.spark.sql.catalyst.TableIdentifier asTableIdentifier ()  { throw new RuntimeException(); }
    public  java.lang.String quoted ()  { throw new RuntimeException(); }
  }
  static public  class MultipartIdentifierHelper {
    public   MultipartIdentifierHelper (scala.collection.Seq<java.lang.String> parts)  { throw new RuntimeException(); }
    public  org.apache.spark.sql.connector.catalog.Identifier asIdentifier ()  { throw new RuntimeException(); }
    public  org.apache.spark.sql.catalyst.TableIdentifier asTableIdentifier ()  { throw new RuntimeException(); }
    public  java.lang.String quoted ()  { throw new RuntimeException(); }
  }
  static public  scala.collection.Seq<java.lang.String> parseColumnPath (java.lang.String name)  { throw new RuntimeException(); }
}
