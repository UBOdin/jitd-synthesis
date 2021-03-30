package org.apache.spark.sql.catalyst.analysis;
/**
 * Resolves catalogs from the multi-part identifiers in SQL statements, and convert the statements
 * to the corresponding v1 or v2 commands if the resolved catalog is the session catalog.
 * <p>
 * We can remove this rule once we implement all the catalog functionality in <code>V2SessionCatalog</code>.
 */
public  class ResolveSessionCatalog extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> implements org.apache.spark.sql.connector.catalog.LookupCatalog {
  public  class SessionCatalogAndTable {
    static public  scala.Option<scala.Tuple2<org.apache.spark.sql.connector.catalog.CatalogPlugin, scala.collection.Seq<java.lang.String>>> unapply (scala.collection.Seq<java.lang.String> nameParts)  { throw new RuntimeException(); }
  }
  public  class SessionCatalogAndTable$ {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final SessionCatalogAndTable$ MODULE$ = null;
    public   SessionCatalogAndTable$ ()  { throw new RuntimeException(); }
    public  scala.Option<scala.Tuple2<org.apache.spark.sql.connector.catalog.CatalogPlugin, scala.collection.Seq<java.lang.String>>> unapply (scala.collection.Seq<java.lang.String> nameParts)  { throw new RuntimeException(); }
  }
  public  class ResolvedViewIdentifier {
    static public  scala.Option<org.apache.spark.sql.connector.catalog.Identifier> unapply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan resolved)  { throw new RuntimeException(); }
  }
  public  class ResolvedViewIdentifier$ {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final ResolvedViewIdentifier$ MODULE$ = null;
    public   ResolvedViewIdentifier$ ()  { throw new RuntimeException(); }
    public  scala.Option<org.apache.spark.sql.connector.catalog.Identifier> unapply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan resolved)  { throw new RuntimeException(); }
  }
  public  class ResolvedV1TableIdentifier {
    static public  scala.Option<org.apache.spark.sql.connector.catalog.Identifier> unapply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan resolved)  { throw new RuntimeException(); }
  }
  public  class ResolvedV1TableIdentifier$ {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final ResolvedV1TableIdentifier$ MODULE$ = null;
    public   ResolvedV1TableIdentifier$ ()  { throw new RuntimeException(); }
    public  scala.Option<org.apache.spark.sql.connector.catalog.Identifier> unapply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan resolved)  { throw new RuntimeException(); }
  }
  public  class ResolvedV1TableOrViewIdentifier {
    static public  scala.Option<org.apache.spark.sql.connector.catalog.Identifier> unapply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan resolved)  { throw new RuntimeException(); }
  }
  public  class ResolvedV1TableOrViewIdentifier$ {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final ResolvedV1TableOrViewIdentifier$ MODULE$ = null;
    public   ResolvedV1TableOrViewIdentifier$ ()  { throw new RuntimeException(); }
    public  scala.Option<org.apache.spark.sql.connector.catalog.Identifier> unapply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan resolved)  { throw new RuntimeException(); }
  }
  public  org.apache.spark.sql.connector.catalog.LookupCatalog.AsTableIdentifier$ AsTableIdentifier ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.LookupCatalog.CatalogAndIdentifier$ CatalogAndIdentifier ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.LookupCatalog.CatalogAndNamespace$ CatalogAndNamespace ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.LookupCatalog.NonSessionCatalogAndIdentifier$ NonSessionCatalogAndIdentifier ()  { throw new RuntimeException(); }
  // not preceding
  public   ResolveSessionCatalog (org.apache.spark.sql.connector.catalog.CatalogManager catalogManager)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.ResolveSessionCatalog.ResolvedV1TableIdentifier$ ResolvedV1TableIdentifier ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.ResolveSessionCatalog.ResolvedV1TableOrViewIdentifier$ ResolvedV1TableOrViewIdentifier ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.ResolveSessionCatalog.ResolvedViewIdentifier$ ResolvedViewIdentifier ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.LookupCatalog.SessionCatalogAndIdentifier$ SessionCatalogAndIdentifier ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.ResolveSessionCatalog.SessionCatalogAndTable$ SessionCatalogAndTable ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.CatalogManager catalogManager ()  { throw new RuntimeException(); }
}
