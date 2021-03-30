package org.apache.spark.sql.catalyst.catalog;
/**
 * Event fired when a database is create or dropped.
 */
public  interface DatabaseEvent extends org.apache.spark.sql.catalyst.catalog.ExternalCatalogEvent {
  /**
   * Database of the object that was touched.
   * @return (undocumented)
   */
  public  java.lang.String database ()  ;
}
