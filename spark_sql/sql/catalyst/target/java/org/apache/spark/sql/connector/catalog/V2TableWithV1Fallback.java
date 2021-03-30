package org.apache.spark.sql.connector.catalog;
/**
 * A V2 table with V1 fallback support. This is used to fallback to V1 table when the V2 one
 * doesn't implement specific capabilities but V1 already has.
 */
public  interface V2TableWithV1Fallback extends org.apache.spark.sql.connector.catalog.Table {
  public  org.apache.spark.sql.catalyst.catalog.CatalogTable v1Table ()  ;
}
