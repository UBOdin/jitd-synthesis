package org.apache.spark.sql.connector.catalog;
/**
 * A trait to encapsulate catalog lookup function and helpful extractors.
 */
public  interface LookupCatalog extends org.apache.spark.internal.Logging {
  /**
   * Extract session catalog and identifier from a multi-part identifier.
   */
  public  class SessionCatalogAndIdentifier {
    static public  scala.Option<scala.Tuple2<org.apache.spark.sql.connector.catalog.CatalogPlugin, org.apache.spark.sql.connector.catalog.Identifier>> unapply (scala.collection.Seq<java.lang.String> parts)  { throw new RuntimeException(); }
  }
  /**
   * Extract session catalog and identifier from a multi-part identifier.
   */
  public  class SessionCatalogAndIdentifier$ {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final SessionCatalogAndIdentifier$ MODULE$ = null;
    public   SessionCatalogAndIdentifier$ ()  { throw new RuntimeException(); }
    public  scala.Option<scala.Tuple2<org.apache.spark.sql.connector.catalog.CatalogPlugin, org.apache.spark.sql.connector.catalog.Identifier>> unapply (scala.collection.Seq<java.lang.String> parts)  { throw new RuntimeException(); }
  }
  /**
   * Extract non-session catalog and identifier from a multi-part identifier.
   */
  public  class NonSessionCatalogAndIdentifier {
    static public  scala.Option<scala.Tuple2<org.apache.spark.sql.connector.catalog.CatalogPlugin, org.apache.spark.sql.connector.catalog.Identifier>> unapply (scala.collection.Seq<java.lang.String> parts)  { throw new RuntimeException(); }
  }
  /**
   * Extract non-session catalog and identifier from a multi-part identifier.
   */
  public  class NonSessionCatalogAndIdentifier$ {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final NonSessionCatalogAndIdentifier$ MODULE$ = null;
    public   NonSessionCatalogAndIdentifier$ ()  { throw new RuntimeException(); }
    public  scala.Option<scala.Tuple2<org.apache.spark.sql.connector.catalog.CatalogPlugin, org.apache.spark.sql.connector.catalog.Identifier>> unapply (scala.collection.Seq<java.lang.String> parts)  { throw new RuntimeException(); }
  }
  /**
   * Extract catalog and namespace from a multi-part name with the current catalog if needed.
   * Catalog name takes precedence over namespaces.
   */
  public  class CatalogAndNamespace {
    static public  scala.Some<scala.Tuple2<org.apache.spark.sql.connector.catalog.CatalogPlugin, scala.collection.Seq<java.lang.String>>> unapply (scala.collection.Seq<java.lang.String> nameParts)  { throw new RuntimeException(); }
  }
  /**
   * Extract catalog and namespace from a multi-part name with the current catalog if needed.
   * Catalog name takes precedence over namespaces.
   */
  public  class CatalogAndNamespace$ {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final CatalogAndNamespace$ MODULE$ = null;
    public   CatalogAndNamespace$ ()  { throw new RuntimeException(); }
    public  scala.Some<scala.Tuple2<org.apache.spark.sql.connector.catalog.CatalogPlugin, scala.collection.Seq<java.lang.String>>> unapply (scala.collection.Seq<java.lang.String> nameParts)  { throw new RuntimeException(); }
  }
  /**
   * Extract catalog and identifier from a multi-part name with the current catalog if needed.
   * Catalog name takes precedence over identifier, but for a single-part name, identifier takes
   * precedence over catalog name.
   * <p>
   * Note that, this pattern is used to look up permanent catalog objects like table, view,
   * function, etc. If you need to look up temp objects like temp view, please do it separately
   * before calling this pattern, as temp objects don't belong to any catalog.
   */
  public  class CatalogAndIdentifier {
    static public  scala.Option<scala.Tuple2<org.apache.spark.sql.connector.catalog.CatalogPlugin, org.apache.spark.sql.connector.catalog.Identifier>> unapply (scala.collection.Seq<java.lang.String> nameParts)  { throw new RuntimeException(); }
  }
  /**
   * Extract catalog and identifier from a multi-part name with the current catalog if needed.
   * Catalog name takes precedence over identifier, but for a single-part name, identifier takes
   * precedence over catalog name.
   * <p>
   * Note that, this pattern is used to look up permanent catalog objects like table, view,
   * function, etc. If you need to look up temp objects like temp view, please do it separately
   * before calling this pattern, as temp objects don't belong to any catalog.
   */
  public  class CatalogAndIdentifier$ {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final CatalogAndIdentifier$ MODULE$ = null;
    public   CatalogAndIdentifier$ ()  { throw new RuntimeException(); }
    public  scala.Option<scala.Tuple2<org.apache.spark.sql.connector.catalog.CatalogPlugin, org.apache.spark.sql.connector.catalog.Identifier>> unapply (scala.collection.Seq<java.lang.String> nameParts)  { throw new RuntimeException(); }
  }
  /**
   * Extract legacy table identifier from a multi-part identifier.
   * <p>
   * For legacy support only. Please use {@link CatalogAndIdentifier} instead on DSv2 code paths.
   */
  public  class AsTableIdentifier {
    static public  scala.Option<org.apache.spark.sql.catalyst.TableIdentifier> unapply (scala.collection.Seq<java.lang.String> parts)  { throw new RuntimeException(); }
  }
  /**
   * Extract legacy table identifier from a multi-part identifier.
   * <p>
   * For legacy support only. Please use {@link CatalogAndIdentifier} instead on DSv2 code paths.
   */
  public  class AsTableIdentifier$ {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final AsTableIdentifier$ MODULE$ = null;
    public   AsTableIdentifier$ ()  { throw new RuntimeException(); }
    public  scala.Option<org.apache.spark.sql.catalyst.TableIdentifier> unapply (scala.collection.Seq<java.lang.String> parts)  { throw new RuntimeException(); }
  }
  public  org.apache.spark.sql.connector.catalog.LookupCatalog.AsTableIdentifier$ AsTableIdentifier ()  ;
  public  org.apache.spark.sql.connector.catalog.LookupCatalog.CatalogAndIdentifier$ CatalogAndIdentifier ()  ;
  public  org.apache.spark.sql.connector.catalog.LookupCatalog.CatalogAndMultipartIdentifier$ CatalogAndMultipartIdentifier ()  ;
  public  org.apache.spark.sql.connector.catalog.LookupCatalog.CatalogAndNamespace$ CatalogAndNamespace ()  ;
  public  org.apache.spark.sql.connector.catalog.LookupCatalog.NonSessionCatalogAndIdentifier$ NonSessionCatalogAndIdentifier ()  ;
  public  org.apache.spark.sql.connector.catalog.LookupCatalog.SessionCatalogAndIdentifier$ SessionCatalogAndIdentifier ()  ;
  public  org.apache.spark.sql.connector.catalog.CatalogManager catalogManager ()  ;
  /**
   * Returns the current catalog set.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.connector.catalog.CatalogPlugin currentCatalog ()  ;
  public  org.apache.spark.sql.catalyst.FunctionIdentifier parseSessionCatalogFunctionIdentifier (scala.collection.Seq<java.lang.String> nameParts)  ;
}
