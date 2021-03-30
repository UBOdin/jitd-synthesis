package org.apache.spark.sql.catalyst.catalog;
/**
 * Event fired when a table is created, dropped or renamed.
 */
public  interface TableEvent extends org.apache.spark.sql.catalyst.catalog.DatabaseEvent {
  /**
   * Name of the table that was touched.
   * @return (undocumented)
   */
  public  java.lang.String name ()  ;
}
