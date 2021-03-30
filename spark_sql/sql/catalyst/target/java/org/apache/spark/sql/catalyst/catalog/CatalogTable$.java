package org.apache.spark.sql.catalyst.catalog;
public  class CatalogTable$ implements scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final CatalogTable$ MODULE$ = null;
  public   CatalogTable$ ()  { throw new RuntimeException(); }
  public  java.lang.String VIEW_PREFIX ()  { throw new RuntimeException(); }
  public  java.lang.String VIEW_DEFAULT_DATABASE ()  { throw new RuntimeException(); }
  public  java.lang.String VIEW_CATALOG_AND_NAMESPACE ()  { throw new RuntimeException(); }
  public  java.lang.String VIEW_CATALOG_AND_NAMESPACE_PART_PREFIX ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> catalogAndNamespaceToProps (java.lang.String currentCatalog, scala.collection.Seq<java.lang.String> currentNamespace)  { throw new RuntimeException(); }
  public  java.lang.String VIEW_SQL_CONFIG_PREFIX ()  { throw new RuntimeException(); }
  public  java.lang.String VIEW_QUERY_OUTPUT_PREFIX ()  { throw new RuntimeException(); }
  public  java.lang.String VIEW_QUERY_OUTPUT_NUM_COLUMNS ()  { throw new RuntimeException(); }
  public  java.lang.String VIEW_QUERY_OUTPUT_COLUMN_NAME_PREFIX ()  { throw new RuntimeException(); }
  public  java.lang.String VIEW_REFERRED_TEMP_VIEW_NAMES ()  { throw new RuntimeException(); }
  public  java.lang.String VIEW_REFERRED_TEMP_FUNCTION_NAMES ()  { throw new RuntimeException(); }
  public  java.lang.String VIEW_STORING_ANALYZED_PLAN ()  { throw new RuntimeException(); }
  public  void splitLargeTableProp (java.lang.String key, java.lang.String value, scala.Function2<java.lang.String, java.lang.String, scala.runtime.BoxedUnit> addProp, int defaultThreshold)  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> readLargeTableProp (scala.collection.immutable.Map<java.lang.String, java.lang.String> props, java.lang.String key)  { throw new RuntimeException(); }
  public  boolean isLargeTableProp (java.lang.String originalKey, java.lang.String propKey)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.catalog.CatalogTable normalize (org.apache.spark.sql.catalyst.catalog.CatalogTable table)  { throw new RuntimeException(); }
}
