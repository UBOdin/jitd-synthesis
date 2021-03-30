package org.apache.spark.sql.catalyst.catalog;
/**
 * Event fired when a function is created, dropped, altered or renamed.
 */
public  interface FunctionEvent extends org.apache.spark.sql.catalyst.catalog.DatabaseEvent {
  /**
   * Name of the function that was touched.
   * @return (undocumented)
   */
  public  java.lang.String name ()  ;
}
