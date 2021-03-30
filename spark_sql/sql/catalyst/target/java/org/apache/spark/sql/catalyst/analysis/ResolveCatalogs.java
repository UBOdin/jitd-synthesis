package org.apache.spark.sql.catalyst.analysis;
/**
 * Resolves catalogs from the multi-part identifiers in SQL statements, and convert the statements
 * to the corresponding v2 commands if the resolved catalog is not the session catalog.
 */
public  class ResolveCatalogs extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> implements org.apache.spark.sql.connector.catalog.LookupCatalog {
  public  class NonSessionCatalogAndTable {
    static public  scala.Option<scala.Tuple2<org.apache.spark.sql.connector.catalog.CatalogPlugin, scala.collection.Seq<java.lang.String>>> unapply (scala.collection.Seq<java.lang.String> nameParts)  { throw new RuntimeException(); }
  }
  public  class NonSessionCatalogAndTable$ {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final NonSessionCatalogAndTable$ MODULE$ = null;
    public   NonSessionCatalogAndTable$ ()  { throw new RuntimeException(); }
    public  scala.Option<scala.Tuple2<org.apache.spark.sql.connector.catalog.CatalogPlugin, scala.collection.Seq<java.lang.String>>> unapply (scala.collection.Seq<java.lang.String> nameParts)  { throw new RuntimeException(); }
  }
  public  org.apache.spark.sql.connector.catalog.LookupCatalog.AsTableIdentifier$ AsTableIdentifier ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.LookupCatalog.CatalogAndIdentifier$ CatalogAndIdentifier ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.LookupCatalog.CatalogAndNamespace$ CatalogAndNamespace ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.LookupCatalog.NonSessionCatalogAndIdentifier$ NonSessionCatalogAndIdentifier ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.ResolveCatalogs.NonSessionCatalogAndTable$ NonSessionCatalogAndTable ()  { throw new RuntimeException(); }
  // not preceding
  public   ResolveCatalogs (org.apache.spark.sql.connector.catalog.CatalogManager catalogManager)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.LookupCatalog.SessionCatalogAndIdentifier$ SessionCatalogAndIdentifier ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.CatalogManager catalogManager ()  { throw new RuntimeException(); }
}
